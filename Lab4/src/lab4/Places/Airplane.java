package lab4.Places;

import lab3.AbstractPlace;

public class Airplane extends AbstractPlace {
    String action;

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }
    public void Action(){
        System.out.println(GetPlace()+" "+getAction());
    }
    public Airplane BoardAction(){
        class AirplaneBoard extends Airplane{
            public AirplaneBoard(String place) {
                super(place);
            }
            public String GetBoard(){
                return GetPlace();
            }
        }
        return new AirplaneBoard("Борт самолета");
    }
    public Airplane(String place,String action) {
        super(place);
        setAction(action);
    }
    public Airplane(String place){
        super(place);
    }
}
