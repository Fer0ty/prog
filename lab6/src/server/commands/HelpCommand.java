package server.commands;

import client.models.SMCollection;
import server.net.ClientConnection;

public class HelpCommand extends CommandAbstract {
    public HelpCommand(SMCollection smCollection, ClientConnection clientConnection) {
        super(smCollection, clientConnection);
    }

    public void execute() {
        addSelfInCommandHistory();
        printMessage("helpCommandText");
    }
}