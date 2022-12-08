package lab4;

import lab3.Things;


public class SnowCylinders implements Things {
    String type;
    @Override
    public void SetType(String type) {
        this.type = type;
    }

    @Override
    public String GetType() {
        return type;
    }
    public SnowCylinders(String type){
        SetType(type);
    }
}
