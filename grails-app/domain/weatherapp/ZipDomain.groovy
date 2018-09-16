package weatherapp

class ZipDomain {
    
    String zipCode;

    static constraints = {
        zipCode size: 5..5
    }
}
