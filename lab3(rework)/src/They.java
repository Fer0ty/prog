public class They implements Human{
    String name,move1,move2;

    public String getMove1() {
        return move1;
    }

    public void setMove1(String move1) {
        this.move1 = move1;
    }

    public String getMove2() {
        return move2;
    }

    public void setMove2(String move2) {
        this.move2 = move2;
    }

    @Override
    public void SetName(String name) {
        this.name = name;
    }

    @Override
    public String GetName() {
        return name;
    }

    public They(String name, String move1, String move2) {
        SetName(name);
        setMove1(move1);
        setMove2(move2);
    }
}
