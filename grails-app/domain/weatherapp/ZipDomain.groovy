package weatherapp

class ZipDomain {
    
    String zipCode;
    boolean invalidZipCode = false; //To store if the zip code is invalid or not. Default is false as assumed it's always valid to proven otherwise

    static constraints = {
        zipCode size: 5..5 //makes sure that zipCode is submitted as at 5 digits.
    }
}
