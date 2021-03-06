package weatherapp

import grails.config.Config
import grails.core.support.GrailsConfigurationAware
import groovy.transform.CompileDynamic
import groovy.transform.CompileStatic
import grails.plugins.rest.client.RestBuilder
import grails.plugins.rest.client.RestResponse
import weatherapp.ZipDomain

@CompileStatic
class WeatherService implements GrailsConfigurationAware {
    String appid
    Integer zipCode
    String countryCode
    String openWeatherUrl
    
    @Override
    void setConfiguration(Config co) {
        openWeatherUrl = co.getProperty('openweather.url', String, 'http://api.openweathermap.org')
        appid = co.getProperty('openweather.appid', String)
        countryCode = co.getProperty('openweather.countryCode', String)
    }
    
    @CompileDynamic
    CurrentWeather currentWeather(ZipDomain zip, Unit units) {
        currentWeather(zip, countryCode, units)
    }
    
    @CompileDynamic
    CurrentWeather currentWeather(ZipDomain zip, String countryCode, Unit unit) {
        try {
            if(zip && unit){ //check if ZipDomain or Unit is null
                log.info "Checking current weather for zip code: " + zip.zipCode
                RestBuilder rest = new RestBuilder()
                String url = "${openWeatherUrl}/data/2.5/weather?zip={zipCode},{countryCode}&appid={appid}"
                Map params = [zipCode: zip.zipCode, countryCode: countryCode, appid: appid]
                String unitParam = unitParameter(unit) //to take the input from the UI, validate it, and return proper String
                if ( unitParam ) { //check String and populate parameters as well as the URL
                    params.units = unitParam
                    url += "&units={units}"
                    log.info "Unit Type selected: " + unitParam
                }
        
                RestResponse restResponse = rest.get(url) { //execute HTTP GET command against URL with the mapped data
                    urlVariables params
                }

                //check response and if valid return currentWeather object
                if ( restResponse.statusCode.value() == 200 && restResponse.json ) {
                    return WeatherParser.currentWeatherFromJSONElement(restResponse.json)
                }
            } else {
                log.error "Zip or Unit is null"
            }
        } catch(Exception e) {
            log.error "Error ${e.message}", e
        }
        null 
    }
    
    //unitParameter is used to test if the unit passed equals one of the proper options
    String unitParameter(Unit unit)  {
        switch ( unit ) {
        case Unit.Metric:
            return 'metric'
        case Unit.Imperial:
            return 'imperial'
        default:
            return null
        }
    }

    
}
