package server.commands;

import client.models.FileException;
import client.models.SMCollection;
import client.net.Request;
import server.net.ClientConnection;

import java.io.Serializable;

public class CountLessThanHeartCountCommand extends CommandAbstract{
    Request request;
    public CountLessThanHeartCountCommand(SMCollection smCollection, ClientConnection clientConnection, Request request) {
        super(smCollection, clientConnection);
        this.request = request;
    }

    @Override
    public void execute() {
        long counter = 0;

           if(!request.getAttr(1).isEmpty()){
               for (String key : smCollection.keySet()){
                   if(smCollection.getSpaceMarine(key).getHeartCount() < Long.parseLong(request.getAttr(1))){
                       counter++;
                   }
               }
               printObject((Serializable) "количество spacemarines со значением heartcount меньше, чем " + request.getAttr(1)+": "+counter);
           }else{
               printMessage("incorrectAttr");
           }

    }
}
