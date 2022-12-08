package lab4;

import lab4.Places.Background;
import lab4.Places.Giaints;

import javax.swing.*;

public class Light {
    String light,action;

    public String getLight() {
        return light;
    }

    public void setLight(String light) {
        this.light = light;
    }

    public String getAction() {
        return action;
    }
    public void setAction(String action) {
        this.action = action;
    }
    void Action(Giaints giaints){
        System.out.println(getLight()+" "+getAction()+" "+giaints.getPlace());
    }
    void Action(Giaints giaints, Background background){
        System.out.println(getLight()+" "+ getAction()+" " + giaints.getPlace()+ " на " + background.GetBackground());
    }
    public Light(String light, String action, Giaints giaints, Background background){
        setAction(action);
        setLight(light);
        Action(giaints,background);
    }


}
