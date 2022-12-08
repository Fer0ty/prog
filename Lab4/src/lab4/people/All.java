package lab4.people;

import lab3.Human;
import lab4.Places.Illuminator;

public class All implements Human {
    String name;
    String action;
    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }


    @Override
    public void SetName(String name) {
        this.name = name;
    }

    @Override
    public String GetName() {
        return name;
    }
    void Vivod(Illuminator illuminator){
        System.out.println(GetName()+" "+getAction()+" к " + illuminator.GetPlace());
    }
    public All(String name, String action, Illuminator illuminator){
        SetName(name);
        setAction(action);
        Vivod(illuminator);
    }
}
