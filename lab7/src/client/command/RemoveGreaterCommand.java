package client.command;

import client.io.InputHandler;
import client.io.OutputHandler;
import client.transfer.Transfer;
import common.command.CommandType;
import common.models.SpaceMarine;
import common.transfer.Request;
import common.transfer.Response;
import server.database.UserData;

import java.util.Set;
import java.util.stream.Collectors;

public class RemoveGreaterCommand extends CommandAbstract{
    public RemoveGreaterCommand(OutputHandler outputHandler, Transfer transfer, UserData userData, InputHandler inputHandler) {
        super(outputHandler, transfer, userData, inputHandler);
    }

    Float health;
    public void setHealth(String command) {
        String[] c = command.trim().split("\\s+");
        if (c.length == 2) {
            try {
                health = Float.parseFloat(c[1]);
            } catch (NumberFormatException ignore) {}
        }
    }

    @Override
    public void execute() {
        if(health != null){
            Request request = new Request(userData, CommandType.GET_SPACEMARINES);
            serverConnection.send(request);
            Response response = serverConnection.receive();
            if (response.getObject() == null) {
                output.print(response.getMessage());
            } else {
                Set<SpaceMarine> spaceMarineSet = (Set<SpaceMarine>) response.getObject();
                Set<SpaceMarine> spaceMarinesToDelete = spaceMarineSet.stream().filter(spaceMarine -> spaceMarine.getHealth() != null)
                        .filter(spaceMarine -> spaceMarine.getHealth() > health).collect(Collectors.toSet());
                for (SpaceMarine spaceMarine : spaceMarinesToDelete){
                    Request request1 = new Request(userData, CommandType.DELETE, spaceMarine);
                    serverConnection.send(request1);
                    Response response1 = serverConnection.receive();
//                    output.print(response1.getMessage());
                }
            }
        } else {
            output.print("Не верно передан аргумент.");
        }
    }
}
