package weatherapp

class ZipCodeService {
    
    //Method to check to see if currentWeather is null or not before returning to view
    boolean isRealZipCode(CurrentWeather currentWeather) {
        try {
            if(currentWeather){
                return true
            } else {
                log.error "Zip code returned invalid."
                return false
            }
        } catch(Exception e) {
            log.error "Error ${e.message}", e
        }
    }
    
    //Method to properly update ZipDomain with the new status of the zipCode before returning to the view
    ZipDomain updateZipValidStatus(ZipDomain zip, boolean status) {
        try {
            if(zip){
                zip.invalidZipCode = status
                return zip;
            }
        } catch(Exception e) {
            log.error "Error ${e.message}", e
        }
    }
}
