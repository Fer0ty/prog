package server.commands;

import client.models.SMCollection;
import server.net.ClientConnection;

public class ClearCommand extends CommandAbstract {
    public ClearCommand(SMCollection smCollection, ClientConnection clientConnection) {
        super(smCollection, clientConnection);
    }

    public void execute() {
        addSelfInCommandHistory();
        smCollection.clear();
        printMessage("clearCommandText");
    }
}
