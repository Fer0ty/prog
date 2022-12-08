package lab4.people;

import lab3.Human;


public class Us implements Human {
        String name;
    @Override
    public void SetName(String name) {
        this.name = name;
    }

    @Override
    public String GetName() {
        return name;
    }
    public Us(String name){
        SetName(name);
    }
}
