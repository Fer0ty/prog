package client.net;

import client.models.SpaceMarine;
import java.io.Serializable;

public class Request implements Serializable {
    private String[] command;
    private SpaceMarine spaceMarine;

    public Request(String userInput) {
        this.command = userInput.split("\\s+");
    }

    public Request(String userInput, SpaceMarine spaceMarine) {
        this.command = userInput.split("\\s+");
        this.spaceMarine = spaceMarine;
    }

    public SpaceMarine getSM() {
        return spaceMarine;
    }

    public String getCommand() {
        return command[0];
    }

    public String getAttr(int position) {
        if (position < command.length) {
            return command[position];
        } else {
            return "";
        }
    }
}
