package weatherapp

import weatherapp.CurrentWeather
import weatherapp.WeatherService
import weatherapp.ZipDomain
import weatherapp.ZipCodeService

class HomeController {
    ZipCodeService zipCodeService
    WeatherService weatherService
    
    def index() {
        render(view: "weatherForm", model: [zipdomain: new ZipDomain()])
    }

    def weatherByZip() {
        ZipDomain zip = new ZipDomain(zipCode: params.zipCode) //create ZipDomain from user provided zip code       
        if(zip.validate()) { //validate the ZipDomain against its constraints, if fails return it back to the default view
            Unit unitEnum = Unit.unitWithString(params.unitRange) //create Unit from user selected input
            CurrentWeather currentWeather = weatherService.currentWeather(zip, unitEnum) //create currentWeather object from weatherService
            if(zipCodeService.isRealZipCode(currentWeather)){ //validate if ZipCode is valid based on if openweather returned null or not
                render(view: "currentWeather", model: [currentWeather: currentWeather,  unit: unitEnum]) //return if valid zip
            } else {
                render(view: "weatherForm", model: [zipdomain: zipCodeService.updateZipValidStatus(zip, true)]) //return if invalid zip
            }
        } else {
            render(view: "weatherForm", model: [zipdomain: zip]) //return if ZipDomain fails validation
        }
    }
}
