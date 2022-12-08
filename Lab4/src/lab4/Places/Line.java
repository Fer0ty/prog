package lab4.Places;

import lab3.AbstractPlace;

public class Line extends AbstractPlace {
    String lineOfWhat;
    public void LineOfWhat(Craters craters, Tops tops){
        lineOfWhat= GetPlace()+" состоящая из "+craters.GetPlace()+" и "+tops.GetPlace();
    }
    public String GetLine(){
        return lineOfWhat;
    }
    public Line(String place, Craters craters, Tops tops) {
        super(place);
        LineOfWhat(craters,tops);
    }
}
