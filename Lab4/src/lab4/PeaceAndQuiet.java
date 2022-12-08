package lab4;


public class PeaceAndQuiet {

    public void IsLost(boolean Peace, boolean Quiet){
        try {
            int a = 1/0;

        } catch (Exception e){
            System.out.println("Утрачены мир и покой");
        }
    }
    public PeaceAndQuiet (){
        boolean Peace = false;
        boolean Quiet = false;
        IsLost(Peace,Quiet);
    }
}
