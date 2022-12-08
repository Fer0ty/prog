package server.commands;

import client.models.SMCollection;
import server.net.ClientConnection;

import java.util.LinkedHashMap;

public class InfoCommand extends CommandAbstract {
    public InfoCommand(SMCollection smCollection, ClientConnection clientConnection) {
        super(smCollection, clientConnection);
    }

    public void execute() {
        addSelfInCommandHistory();
        LinkedHashMap<String, String> info = new LinkedHashMap<>();
        info.put("Количество элементов", ((Integer) smCollection.getSize()).toString());
        printObject(info);
    }
}
