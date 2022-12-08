package lab4.people;

import lab3.Human;
import lab4.Phantoms;
import lab4.Places.Tops;


public class We implements Human {
    String name="";
    String action="";
    String abstractAction="";
    public String getAbstractAction() {
        return abstractAction;
    }

    public void setAbstractAction(String abstractAction) {
        this.abstractAction = abstractAction;
    }
    public void SetAction(String action){
        this.action = action;
    }
    public String GetAction(){
        return action;
    }
    @Override
    public void SetName(String name) {
        this.name = name;
    }

    @Override
    public String GetName() {
        return name;
    }
    void Vivod(Phantoms s){
        System.out.println(GetName()+ " "+ GetAction()+" за " + s.getName()+", "+s.getAction()+" "+s.getActionWhere());
    }
    void Vivod(){
        System.out.println(GetName()+" "+ GetAction());
        if(!abstractAction.equals(""))
        System.out.println(GetName()+" "+ getAbstractAction());
    }

    public We(String name, String action, Phantoms a){
        SetName(name);
        SetAction(action);
        Vivod(a);
    }
    public We(String name, String action, String abstractAction){
        SetName(name);
        SetAction(action);
        setAbstractAction(abstractAction);
        Vivod();
    }
    public void ClassicVivod(){
        System.out.println("Мы не могли передавать чувства");
    }
    public We(){
        ClassicVivod();
    }
}
