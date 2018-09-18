package weatherapp

class ZipDomain {
    
    String zipCode;
    boolean invalidZipCode = false;

    static constraints = {
        zipCode size: 5..5
    }
}
