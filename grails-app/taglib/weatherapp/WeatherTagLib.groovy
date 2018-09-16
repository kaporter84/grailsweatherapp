package weatherapp

class WeatherTagLib {
    static namespace = "openweather"

    def image = { attrs ->
        out << "<img src=\"http://openweathermap.org/img/w/${attrs.icon}.png\"/>"
    }

    def temperatureSymbol = { attrs ->
        if ( attrs.unit == Unit.Imperial ) {
            out << '°F'
        } else if ( attrs.unit == Unit.Metric ) {
            out << '°C'
        }
    }
    
    def unitSelect = { attrs ->
        attrs.from = UnitRange.values()
        attrs.optionKey = 'key'
        out << g.select(attrs)
    }

}
