package lab4.people;

import lab3.Human;
import lab4.Places.Line;

public class Larsen implements Human {
    String name, action1,action2;

    public String getAction1() {
        return action1;
    }

    public void setAction1(String action) {
        action1 = action;
    }
    public void setAction2(String action) {
        action2 = action;
    }
    public String getAction2() {
        return action2;
    }
    @Override
    public void SetName(String name) {
        this.name = name;
    }

    @Override
    public String GetName() {
        return name;
    }
    void SawWhat(Line line){
        System.out.println(GetName()+" "+ getAction1()+" "+ line.GetLine());
    }
    void Action2(){
        System.out.println(GetName()+" "+getAction2());
    }
    public Larsen(String name, String action1, String action2, Line line){
        SetName(name);
        setAction1(action1);
        setAction2(action2);
        SawWhat(line);
        Action2();
    }
}
