package weatherapp

import groovy.transform.CompileStatic

@CompileStatic
class Weather {
    
    Integer id;
    String main;
    String description;
    String icon;

    static constraints = {
    }
}
