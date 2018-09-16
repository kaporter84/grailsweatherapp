package weatherapp

import groovy.transform.CompileStatic

@CompileStatic
class Sys {
    
    Integer type;
    Integer id;
    Double message;
    String country;
    Integer sunrise;
    Integer sunset;

    static constraints = {
    }
}
