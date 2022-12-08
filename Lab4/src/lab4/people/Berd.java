package lab4.people;

import lab3.Human;
import lab4.SnowCylinders;

public class Berd implements Human {
    String name,action,sawWhat;
    @Override
    public void SetName(String name) {
        this.name=name;
    }

    @Override
    public String GetName() {
        return name;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }
    void SetSawWhat(String saw, SnowCylinders what, String when){
        sawWhat = saw+" "+what.GetType()+" "+when;
    }
    public void SawWhat(){
        System.out.println(name +" "+sawWhat);
    }
    public Berd(String name, String saw, SnowCylinders what,String when){
        SetName(name);
        setAction(saw);
        SetSawWhat(saw,what,when);
        SawWhat();
    }
}
