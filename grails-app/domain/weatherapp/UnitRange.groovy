package weatherapp

enum UnitRange {

    Imperial ("Imperial"),
    Metric ("Metric"),

    final String value

    UnitRange(String value) { this.value = value }

    String toString() { value } 
    String getKey() { name() }
}
