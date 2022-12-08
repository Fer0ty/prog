package lab4;

public class Phantoms {
    String name;
    String action;
    String actionWhere;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public String getActionWhere() {
        return actionWhere;
    }

    public void setActionWhere(String actionWhere) {
        this.actionWhere = actionWhere;
    }

    public Phantoms (String name, String action, String actionWhere){
        setName(name);
        setAction(action);
        setActionWhere(actionWhere);
    }
}
