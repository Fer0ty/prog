package lab4;



public class GustsOfWind {
    String wind;
    public void SetWind(String wind){
        this.wind = wind;
    }
    public String GetWind(){
        return wind;
    }
    public GustsOfWind(String wind){
        SetWind(wind);
    }
}
