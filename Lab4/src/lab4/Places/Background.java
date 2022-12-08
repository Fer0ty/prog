package lab4.Places;

import lab3.AbstractPlace;
import lab4.Dust;

public class Background {
    String place;
    String background;
    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }
    void SetBackgroud(Dust dust){
        background = getPlace()+" из "+dust.GetType();
    }
    public String GetBackground(){
        return background;
    }
    public Background(String place, Dust dust) {
        setPlace(place);
        SetBackgroud(dust);
    }
}
