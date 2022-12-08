package lab3;

public abstract class AbstractPlace {
    String place;
    public void SetPlace(String place){
        this.place = place;
    }
    public String GetPlace(){
        return place;
    }

    public AbstractPlace(String place) {
        SetPlace(place);
    }
}
