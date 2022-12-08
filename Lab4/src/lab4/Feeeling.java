package lab4;

import lab4.people.Us;


public class Feeeling{
    String feeling,action;

    public String getFeeling() {
        return feeling;
    }

    public void setFeeling(String feeling) {
        this.feeling = feeling;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }
    public void Action(Us us){
        System.out.println(getFeeling()+" "+getAction()+" "+us.GetName());
    }
    public Feeeling(String feeling, String action, Us us) {
        setAction(action);
        setFeeling(feeling);
        Action(us);
    }
}
