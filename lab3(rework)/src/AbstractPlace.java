public class AbstractPlace {
    String place;
    void SetPlace(String place){
        this.place = place;
    }
    String GetPlace(){
        return place;
    }

    public AbstractPlace(String place) {
        SetPlace(place);
    }
}
