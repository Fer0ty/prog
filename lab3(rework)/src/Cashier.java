public class Cashier implements Profession{
    private String profession;
    private String move1,move2;
    @Override
    public void SetProfession(String profession) {
        this.profession = profession;
    }

    @Override
    public String GetProfession() {
        return profession;
    }

    public String getMove1() {
        return move1;
    }

    public void setMove1(String move1) {
        this.move1 = move1;
    }
    public String GetType(responsibilities obj){
        return obj.GetValue();
    }
    public String getMove2() {
        return move2;
    }

    public void setMove2(String move2) {
        this.move2 = move2;
    }

    public Cashier(String profession, String move1, String move2) {
        SetProfession(profession);
        setMove1(move1);
        setMove2(move2);
    }
}
