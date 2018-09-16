package weatherapp

enum Unit {
    
    Imperial, Metric

    static Unit unitWithString(String str) {
        if ( str ) {
            if ( str.toLowerCase() == 'metric' ) {
                return Unit.Metric
            } else if ( str.toLowerCase() == 'imperial' ) {
                return Unit.Imperial
            }
        }
        Unit.Imperial
    }

}
