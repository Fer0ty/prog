package lab4.Places;

public class Tops extends Mountains{
    String description1="голые", description2="лишенные растительности",description3="незащищенные",description4 = "темные";

    public String getDescription1() {
        return description1;
    }

    public String getDescription2() {
        return description2;
    }

    public String getDescription3() {
        return description3;
    }

    public String getDescription4() {
        return description4;
    }
    public void GetDescription(){
        System.out.println(GetPlace()+" "+getDescription1()+", "+getDescription2()+", "+
                getDescription3()+", "+getDescription4());
    }
    public Tops(String place) {
        super(place);
    }
}
