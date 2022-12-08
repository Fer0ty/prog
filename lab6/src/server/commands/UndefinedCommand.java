package server.commands;

import client.models.SMCollection;
import server.net.ClientConnection;

public class UndefinedCommand extends CommandAbstract {
    public UndefinedCommand(SMCollection smCollection, ClientConnection clientConnection) {
        super(smCollection, clientConnection);
    }

    @Override
    public void execute() {
        printMessage("unavailableCommand");
    }
}
