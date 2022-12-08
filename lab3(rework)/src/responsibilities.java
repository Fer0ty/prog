import jdk.nashorn.internal.ir.ReturnNode;

public enum responsibilities {
    KASSIR("Кассир"),
    KAZNACHEY("Казначей"),
    PREDSEDATEL("Председатель");
    private String value;
    responsibilities(String s){
        value = s;
    }
    public String GetValue(){
        return value;
    }
}
