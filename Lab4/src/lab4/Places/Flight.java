package lab4.Places;

import lab3.AbstractPlace;

public class Flight extends AbstractPlace {
    String flight = GetPlace();

    public String getFlight() {
        return flight;
    }

    public Flight(String flight){
        super(flight);
    }
}
