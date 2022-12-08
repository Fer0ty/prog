package lab4;

import lab4.Places.Flatland;
import lab4.people.Amundsen;
import lab4.people.Berd;

public class Wind {
    String wind,droveWho,droveWhere;

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    String action;

    public String getWind() {
        return wind;
    }

    public void setWind(String wind) {
        this.wind = wind;
    }
    public void DroveWho(Amundsen amundsen, Berd berd){
        droveWho = amundsen.GetName()+" и " + berd.GetName();
    }
    void Action(String when){
        System.out.println(droveWhere+" "+when);
    }
    public void Drove(Flatland where){
        droveWhere = wind+" "+ action+" "+droveWho + " по "+where.GetPlace();
    }
    public Wind(String wind, String action, Amundsen amundsen, Berd berd, Flatland Where, String when) {
        setWind(wind);
        setAction(action);
        DroveWho(amundsen,berd);
        Drove(Where);
        Action(when);
    }
}
