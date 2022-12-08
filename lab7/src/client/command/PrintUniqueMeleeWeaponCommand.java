package client.command;

import client.io.InputHandler;
import client.io.OutputHandler;
import client.transfer.Transfer;
import common.command.CommandType;
import common.models.SpaceMarine;
import common.transfer.Request;
import common.transfer.Response;
import server.database.UserData;

import java.util.HashSet;
import java.util.Set;

public class PrintUniqueMeleeWeaponCommand extends CommandAbstract{
    public PrintUniqueMeleeWeaponCommand(OutputHandler outputHandler, Transfer transfer, UserData userData, InputHandler inputHandler) {
        super(outputHandler, transfer, userData, inputHandler);
    }

    @Override
    public void execute() {
        Request request = new Request(userData, CommandType.GET_SPACEMARINES);
        serverConnection.send(request);
        Response response = serverConnection.receive();
        if (response.getObject() == null) {
            output.print(response.getMessage());
        } else {
            try {
                Set<SpaceMarine> spaceMarineSet= (Set<SpaceMarine>) response.getObject();

            Set<String> meleeWeapons = new HashSet<>();
            for (SpaceMarine spaceMarine : spaceMarineSet){
                meleeWeapons.add(spaceMarine.getMeleeWeapon().toString());
            }
            prettyPrint.print(meleeWeapons);
            } catch (NullPointerException ignore){

            }
    }
    }
}
