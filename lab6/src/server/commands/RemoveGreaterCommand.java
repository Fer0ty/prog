package server.commands;

import client.models.SMCollection;
import client.models.SpaceMarine;
import client.net.Request;
import server.net.ClientConnection;

import java.util.HashSet;
import java.util.Set;

public class RemoveGreaterCommand extends CommandAbstract {
    final Request request;

    public RemoveGreaterCommand(SMCollection smCollection, ClientConnection clientConnection, Request request) {
        super(smCollection, clientConnection);
        this.request = request;
    }

    public void execute() {
        if(!request.getAttr(1).isEmpty()){
            addSelfInCommandHistory();
            Set<String > toDelete = new HashSet();
            for (String key : smCollection.keySet()){
                if(smCollection.getSpaceMarine(key).getHealth()>Double.parseDouble(request.getAttr(1))){
                    toDelete.add(key);
                }
            }
            for(String key : toDelete){
                smCollection.remove(key);
            }
            printMessage("removeCommandText");
        } else {
            printMessage("incorrectAttr");
        }
    }
}
