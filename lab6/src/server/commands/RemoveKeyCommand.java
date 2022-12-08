package server.commands;

import client.models.SMCollection;
import client.models.SpaceMarine;
import client.net.Request;
import client.net.Response;
import server.net.ClientConnection;

public class RemoveKeyCommand extends CommandAbstract {
    final Request request;

    public RemoveKeyCommand(SMCollection smCollection, ClientConnection clientConnection, Request request) {
        super(smCollection, clientConnection);
        this.request = request;
    }

    public void execute() {
        addSelfInCommandHistory();
        if (request.getAttr(1).isEmpty()) {
            printMessage("incorrectAttr");
        } else {
            smCollection.remove(request.getAttr(1));
            printMessage("removeCommandText");
        }
    }
}
