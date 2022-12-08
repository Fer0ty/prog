package lab4.Places;

import lab3.AbstractPlace;
import lab4.High;
import lab4.people.We;

public class Mountains extends AbstractPlace {
    String action1;
    String action2;
    String action3;
    String action4;
    String where;
    public String getWhere() {
        return where;
    }

    public void setWhere(String where) {
        this.where = where;
    }



    public String getAction1() {
        return action1;
    }

    public void setAction1(String action1) {
        this.action1 = action1;
    }

    public String getAction2() {
        return action2;
    }

    public void setAction2(String action2) {
        this.action2 = action2;
    }

    public String getAction3() {
        return action3;
    }

    public void setAction3(String action3) {
        this.action3 = action3;
    }

    public String getAction4() {
        return action4;
    }

    public void setAction4(String action4) {
        this.action4 = action4;
    }
    void FirstAction(High high){
        System.out.println(GetPlace()+" "+getWhere());
        System.out.println(GetPlace()+" "+getAction1());
        System.out.println(GetPlace()+" "+getAction2()+" из-за "+high.GetPlace());
    }
    void SecondAction(We we,PartOfSky sky){
        System.out.println(GetPlace()+" "+getAction3()+" перед "+ we.GetName());
        System.out.println(GetPlace()+" "+getAction4()+" "+sky.GetPlace());
    }
    public Mountains(String place, String where, String firstAction, String secondAction, String thirdAction, String fourthAction, High dueTo, We we,PartOfSky sky) {
        super(place);
        setAction1(firstAction);
        setAction2(secondAction);
        setAction3(thirdAction);
        setAction4(fourthAction);
        setWhere(where);
        FirstAction(dueTo);
        SecondAction(we,sky);
    }
    public Mountains(String place){
        super(place);
    }
}
