package server.commands;

import client.models.SMCollection;
import client.net.Request;
import jdk.jfr.Frequency;
import server.net.ClientConnection;

import java.util.HashSet;
import java.util.Set;

public class RemoveAllByMeleeWeaponCommand extends CommandAbstract{
    final Request request;
    public RemoveAllByMeleeWeaponCommand(SMCollection smCollection, ClientConnection clientConnection, Request request) {
        super(smCollection, clientConnection);
        this.request = request;
    }

    @Override
    public void execute() {
        Set<String > toDelete = new HashSet<>();
        if(!request.getAttr(1).isEmpty()){
            addSelfInCommandHistory();
            for (String key : smCollection.keySet()){
                if(request.getAttr(1).toString().equals(smCollection.getSpaceMarine(key).getMeleeWeapon().toString())){
                   toDelete.add(key);
                }
            }
            for (String key : toDelete){
                smCollection.remove(key);
            }
            printMessage("removeCommandText");
        } else {
            printMessage("incorrectAttr");
        }
    }
}
