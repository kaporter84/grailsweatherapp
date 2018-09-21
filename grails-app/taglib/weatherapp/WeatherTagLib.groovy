package weatherapp

class WeatherTagLib {
    static namespace = "openweather"

    // fetches the appropiate image based on data from openweather api
    def image = { attrs ->
        out << "<img src=\"http://openweathermap.org/img/w/${attrs.icon}.png\"/>"
    }

    //determine the proper temp symbol based on the Unit Type selected by the user
    def temperatureSymbol = { attrs ->
        if ( attrs.unit == Unit.Imperial ) {
            out << '°F'
        } else if ( attrs.unit == Unit.Metric ) {
            out << '°C'
        }
    }
    
    //return a select drop down menu populated with the Unit Type values
    def unitSelect = { attrs ->
        attrs.from = UnitRange.values()
        attrs.optionKey = 'key'
        out << g.select(attrs)
    }

}
