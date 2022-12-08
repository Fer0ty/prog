package lab3;

public class Seeds<count> implements Things{
    String type;
    int count;
    public void SetCount(int count){
        this.count = count;
    }
    public int GetCount(){
        return count;
    }
    @Override
    public void SetType(String type) {
        this.type = type;
    }

    @Override
    public String GetType() {
        return type;
    }

    public Seeds(String type,int count) {
        SetType(type);
        SetCount(count);
    }
    boolean IsEmpty(int count){
        if(count >= 1){
            return false;
        }
        return true;
    }
}
