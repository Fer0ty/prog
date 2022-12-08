package lab3;

public class Shorty implements Human {
    String name,move;

    public String getMove() {
        return move;
    }

    public void setMove(String move) {
        this.move = move;
    }

    @Override
    public void SetName(String name) {
        this.name = name;
    }

    @Override
    public String GetName() {
        return name;
    }

    public Shorty(String name, String move) {
        SetName(name);
        setMove(move);
    }
}
