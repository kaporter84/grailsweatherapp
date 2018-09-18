package weatherapp

import weatherapp.CurrentWeather
import weatherapp.WeatherService
import weatherapp.ZipDomain
import weatherapp.ZipCodeService

class HomeController {
    ZipCodeService zipCodeService
    WeatherService weatherService
    
    def index() {
        def zipDomain = new ZipDomain()
        render(view: "weatherForm", model: [zipdomain: zipDomain])
    }

    def weatherByZip() {
        
        def ZipDomain zip = new ZipDomain(zipCode: params.zipCode)       
        if(zip.validate()){
            Unit unitEnum = Unit.unitWithString(params.unitRange)
            CurrentWeather currentWeather = weatherService.currentWeather(zip, unitEnum)
            if(zipCodeService.isRealZipCode(currentWeather)){
                render(view: "currentWeather", model: [currentWeather: currentWeather,  unit: unitEnum])
            } else {
                render(view: "weatherForm", model: [zipdomain: zipCodeService.updateZipValidStatus(zip, true)])
            }
        } else {
            render(view: "weatherForm", model: [zipdomain: zip]) 
        }
    }
}
