package weatherapp

class ZipCodeService {
    
    boolean isRealZipCode(CurrentWeather currentWeather) {
        if(currentWeather == null){
            return false
        }
        return true
    }
    
   
    ZipDomain updateZipValidStatus(ZipDomain zip, boolean status) {
        zip.invalidZipCode = status
        return zip;
    }
}
