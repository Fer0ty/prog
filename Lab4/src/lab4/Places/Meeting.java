package lab4.Places;

import lab3.AbstractPlace;
import lab4.GustsOfWind;

public class Meeting extends AbstractPlace {
    String meeting=GetPlace();
    String Where;
    public String getMeeting() {
        return meeting;
    }
    public void SetWhere(UpperAtmosphere where, GustsOfWind with){
        Where= getMeeting() +" в "+ where.GetPlace()+ " c "+ with.GetWind();
    }
    public String MeetingWhere(){
        return Where;
    }
    public Meeting(String meeting, UpperAtmosphere Where, GustsOfWind With){
        super(meeting);
        SetWhere(Where,With);
    }
}