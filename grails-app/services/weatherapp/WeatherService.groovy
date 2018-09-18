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
        RestBuilder rest = new RestBuilder()
        String url = "${openWeatherUrl}/data/2.5/weather?zip={zipCode},{countryCode}&appid={appid}"
        Map params = [zipCode: zip.zipCode, countryCode: countryCode, appid: appid]
        String unitParam = unitParameter(unit)
        if ( unitParam ) {
            params.units = unitParam
            url += "&units={units}"
        }
        
        RestResponse restResponse = rest.get(url) { 
            urlVariables params
        }

        if ( restResponse.statusCode.value() == 200 && restResponse.json ) {
            return WeatherParser.currentWeatherFromJSONElement(restResponse.json)
        }
        null 
    }
    
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
