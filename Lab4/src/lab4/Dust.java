package lab4;

import lab3.Things;

public class Dust implements Things {
    String type,action;
    public void SetAction(String action){
        this.action = action;
    }
    public String GetAction(){
        return action;
    }
    @Override
    public void SetType(String type) {
        this.type = type;
    }

    @Override
    public String GetType() {
        return type;
    }
    void Action(){
        System.out.println(GetType()+" "+GetAction());
    }
    public Dust(String type, String action){
        SetType(type);
        SetAction(action);
        Action();
    }
}
