package weatherapp

import groovy.transform.CompileStatic

@CompileStatic
class CurrentWeather {
    
    Coord coord;
    Sys sys;
    List<Weather> weather = null;
    String base;
    Main main;
    Wind wind;
    Clouds clouds;
    Integer dt;
    Integer id;
    String name;
    Integer cod;
    Integer visibility;

    static constraints = {
    }
}
