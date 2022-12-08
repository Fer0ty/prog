package server.commands;

import client.models.SMCollection;
import server.net.ClientConnection;

public class HistoryCommand extends CommandAbstract {
    public HistoryCommand(SMCollection smCollection, ClientConnection clientConnection) {
        super(smCollection, clientConnection);
    }

    @Override
    public void execute() {
        addSelfInCommandHistory();
        printObject(commandHistory.getStack());
    }
}
