public class President implements Profession{
    private String profession;
    private String move;
    @Override
    public void SetProfession(String profession) {
        this.profession = profession;
    }
    public String GetType(responsibilities obj){
        return obj.GetValue();
    }
    @Override
    public String GetProfession() {
        return profession;
    }

    public String getMove() {
        return move;
    }

    public void setMove(String move) {
        this.move = move;
    }

    public President(String profession, String move) {
        setMove(move);
        SetProfession(profession);
    }
}
