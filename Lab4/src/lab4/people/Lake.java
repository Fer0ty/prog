package lab4.people;

import lab3.Human;
import lab4.Places.Mine;

public class Lake implements Human {
    String name, when, action;

    public String getWhen() {
        return when;
    }

    public void setWhen(String when) {
        this.when = when;
    }

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
    void Vivod(Mine what){
        System.out.println(GetName()+" "+getAction()+" "+ what.GetPlace()+" "+getWhen());
    }
    public Lake(String name, String action, Mine what, String when){
        SetName(name);
        setAction(action);
        setWhen(when);
        Vivod(what);
    }
}
