package server.commands;

import client.models.SMCollection;
import server.net.ClientConnection;

public class ShowCommand extends CommandAbstract {
    public ShowCommand(SMCollection smCollection, ClientConnection clientConnection) {
        super(smCollection, clientConnection);
    }

    public void execute() {
        addSelfInCommandHistory();
        if (smCollection.getSpaceMarines().isEmpty()) {
            printMessage("showCommand_emptyCollection");
        } else {
            printObject(smCollection.getSpaceMarines());
        }
    }
}
