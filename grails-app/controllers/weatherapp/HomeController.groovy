package weatherapp

import weatherapp.CurrentWeather
import weatherapp.WeatherService
import weatherapp.ZipDomain

class HomeController {
    WeatherService weatherService
    
     def index() {  // index is the default action for any controller
        def zipDomain = new ZipDomain()
        render(view: "weatherForm", model: [zipdomain: zipDomain])
    }

    def weatherByZip() {
        
        def ZipDomain zip = new ZipDomain(zipCode: params.zipCode)       
        if(zip.validate()){
        String unit = params.unitRange
        Unit unitEnum = Unit.unitWithString(unit)
        CurrentWeather currentWeather = weatherService.currentWeather(zip, unitEnum)
        render(view: "currentWeather", model: [currentWeather: currentWeather,  unit: unitEnum])
        } else {
           render(view: "weatherForm", model: [zipdomain: zip]) 
        }
    }
}
