package weatherapp

//This class is to faciliate the need to populate the Unit Type drop down menu
enum UnitRange {

    Imperial ("Imperial"),
    Metric ("Metric"),

    final String value

    UnitRange(String value) { this.value = value }

    String toString() { value } 
    String getKey() { name() }
}
