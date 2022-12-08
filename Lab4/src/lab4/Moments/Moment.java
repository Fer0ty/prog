package lab4.Moments;

public class Moment {
    String moment;
    String action1="", action2="";
    public void SetMomentName(String moment){
        this.moment = moment;
    }
    public String GetMomentName(){
        return moment;
    }
    public void SetMomenAction(String action){
        action1 = action;
    }
    public void SetMomenActions(String action1, String action2){
        this.action1 = action1;
        this.action2 = action2;
    }
    public String GetMomentAction(){
        if(!action1.equals("")&& !action2.equals("")){
            return action1 + " и " + action2;
        }else{
            return action1;
        }
    }
    void vivod(){
        System.out.println(GetMomentName()+" "+GetMomentAction());
    }
    public Moment(String moment, String action){
        SetMomentName(moment);
        SetMomenAction(action);
        vivod();
    }
    public Moment (String moment,String action1, String action2){
        SetMomentName(moment);
        SetMomenActions(action1,action2);
        vivod();
    }
    public Moment(String moment){
        SetMomentName(moment);
        vivod();
    }
}
