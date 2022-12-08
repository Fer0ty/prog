package lab4.News;

import lab3.Things;


public class NewsPapers implements Things {
    String type,abstractAction;
    public void SetAbstractAction(String abstractAction){
        this.abstractAction = abstractAction;
    }

    public String GetAbstractAction(){
        return abstractAction;
    }
    @Override
    public void SetType(String type) {
        this.type=type;
    }
    public void Action(Bulletens bulletens){
        System.out.println(type+" "+abstractAction+" "+ bulletens.GetType());
    }
    @Override
    public String GetType() {
        return type;
    }
    public NewsPapers(String type, String abstractAction, Bulletens bulletens){
        SetType(type);
        SetAbstractAction(abstractAction);
        Action(bulletens);
    }
}
