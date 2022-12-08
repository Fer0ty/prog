package server.commands;

import client.models.SMCollection;
import client.models.SpaceMarine;
import client.net.Request;
import client.net.Response;
import server.net.ClientConnection;

public class InsertCommand extends CommandAbstract {
    final Request request;

    public InsertCommand(SMCollection smCollection, ClientConnection clientConnection, Request request) {
        super(smCollection, clientConnection);
        this.request = request;
    }

    public void execute() {
        addSelfInCommandHistory();
        if (request.getAttr(1).isEmpty()) {
            printMessage("incorrectAttr");
        } else {
            SpaceMarine spaceMarine = request.getSM();
            if (spaceMarine != null) {
                spaceMarine.setId();
                spaceMarine.setCurrentDateAsCreationDate();
                smCollection.put(request.getAttr(1), spaceMarine);
                printMessage("insertCommandText");
            } else {
                printMessage("spaceMarineForm_isInvalid");
            }
        }
    }
}
