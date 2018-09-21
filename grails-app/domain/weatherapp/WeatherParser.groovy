package weatherapp

import groovy.transform.CompileStatic
import org.grails.web.json.JSONElement
import groovy.transform.CompileDynamic


//Parser to handle converting the json data from openweather to java objects
@CompileStatic
class WeatherParser {

    @CompileDynamic
    static Coord coordinateFromJsonElement(JSONElement json) {
        Coord coordinate = new Coord()
        if ( json.long ) {
            coordinate.lon = json.long as BigDecimal
        }
        if ( json.lat ) {
            coordinate.lat = json.lat as BigDecimal
        }
        coordinate
    }

    @CompileDynamic
    static Main mainFromJsonElement(JSONElement json) {
        Main main = new Main()
        if ( json.temp ) {
            main.temp = json.temp as BigDecimal
        }
        if ( json.pressure ) {
            main.pressure = json.pressure as BigDecimal
        }
        if ( json.humidity ) {
            main.humidity = json.humidity as Integer
        }
        if ( json.temp_min ) {
            main.tempMin = json.temp_min as BigDecimal
        }
        if ( json.temp_max ) {
            main.tempMax = json.temp_max as BigDecimal
        }
        if ( json.seaLevel ) {
            main.seaLevel = json.seaLevel as BigDecimal
        }
        if ( json.groundLevel ) {
            main.groundLevel = json.groundLevel as BigDecimal
        }
        main
    }

    @CompileDynamic
    static Wind windFromJsonElement(JSONElement json) {
        Wind wind = new Wind()
        if ( json.speed ) {
            wind.speed = json.speed as BigDecimal
        }
        if ( json.deg ) {
            wind.deg = json.deg as BigDecimal
        }
        wind
    }

    @CompileDynamic
    static Sys sysFromJsonElement(JSONElement json) {
        Sys sys = new Sys()
        if ( json.id ) {
            sys.id = json.id as Long
        }
        if ( json.type ) {
            sys.type = json.type
        }
        if ( json.message ) {
            sys.message = json.message
        }
        if ( json.country ) {
            sys.country = json.country
        }
        if ( json.sunrise ) {
            sys.sunrise = json.sunrise as Integer
        }
        if ( json.sunset ) {
            sys.sunset = json.sunset as Integer
        }
        sys
    }

    @CompileDynamic
    static Weather weatherFromJsonElement(JSONElement json) {
        Weather weather = new Weather()
        if ( json.id ) {
            weather.id = json.id as Long
        }
        if ( json.main ) {
            weather.main = json.main
        }
        if ( json.description ) {
            weather.description = json.description
        }
        if ( json.icon ) {
            weather.icon = json.icon
        }
        weather
    }
    
    @CompileDynamic
    static CurrentWeather currentWeatherFromJSONElement(JSONElement json) {
        CurrentWeather currentWeather = new CurrentWeather()

        if ( json.coord ) {
            currentWeather.coord = coordinateFromJsonElement(json.coord)
        }
        if ( json.main ) {
            currentWeather.main = mainFromJsonElement(json.main)
        }
        if ( json.wind ) {
            currentWeather.wind = windFromJsonElement(json.wind)
        }
        if ( json.clouds ) {
            currentWeather.clouds = new Clouds()
            if ( json.clouds.all ) {
                currentWeather.clouds.all = json.clouds.all as Integer
            }
        }
        if ( json.sys ) {
            currentWeather.sys = sysFromJsonElement(json.sys)
        }
        if ( json.id ) {
            currentWeather.id = json.id as Long
        }
        if ( json.base ) {
            currentWeather.base = json.base
        }
        if ( json.name ) {
            currentWeather.name = json.name
        }
        if ( json.cod ) {
            currentWeather.cod = json.cod as Integer
        }
        if ( json.visibility ) {
            currentWeather.visibility = json.visibility
        }
        if ( json.dt ) {
            currentWeather.dt = json.dt as Integer
        }

        if ( json.weather ) {
            currentWeather.weather = []
            for ( Object obj : json.weather ) {
                Weather weather = weatherFromJsonElement(obj)
                currentWeather.weather << weather
            }
        }
        currentWeather
    }
}
