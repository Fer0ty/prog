package server.commands;

import client.models.SMCollection;
import client.net.Request;
import server.net.ClientConnection;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class RemoveGreaterKeyCommand extends CommandAbstract{
    final Request request;
    public RemoveGreaterKeyCommand(SMCollection smCollection, ClientConnection clientConnection, Request request) {
        super(smCollection, clientConnection);
        this.request = request;
    }

    @Override
    public void execute() {
        if (request.getAttr(1).isEmpty()) {
            printMessage("incorrectAttr");
        } else {
            Set<String> set = new HashSet<>();
            addSelfInCommandHistory();
            for (String key : smCollection.keySet()){
                if (compare(request.getAttr(1), key)){
                 set.add(key);
                }
            }
            for (String key : set){
                smCollection.remove(key);
            }
            printMessage("removeCommandText");
        }
    }
    private boolean compare(String s1, String s2){
        return s1.compareTo(s2) < 0;
    }
}
