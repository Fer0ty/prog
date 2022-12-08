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


public class RemoveGreaterKeyCommand extends CommandAbstract{
    Long id;
    public RemoveGreaterKeyCommand(OutputHandler outputHandler, Transfer transfer, UserData userData, InputHandler inputHandler) {
        super(outputHandler, transfer, userData, inputHandler);
    }

    public void setId(String command) {
        String[] c = command.trim().split("\\s+");
        if (c.length == 2) {
            try {
                id = Long.parseLong(c[1]);
            } catch (NumberFormatException ignore) {}
        }
    }

    @Override
    public void execute() {
        if (id != null) {
            Request spaceMarines = new Request(userData, CommandType.GET_SPACEMARINES);
            serverConnection.send(spaceMarines);
            Response response = serverConnection.receive();

            if (response.getObject() == null) {
                output.print(response.getMessage());
            } else {
                Set<SpaceMarine> spaceMarineSet = (Set<SpaceMarine>) response.getObject();
                Set<SpaceMarine> spaceMarinesToDelete = spaceMarineSet.stream().filter(
                        spaceMarine -> spaceMarine.getId() > id).collect(Collectors.toSet());
                for (SpaceMarine spaceMarine : spaceMarinesToDelete){
                    Request request = new Request(userData, CommandType.DELETE, spaceMarine);
                    serverConnection.send(request);
                    Response response1 = serverConnection.receive();
//                    output.print(response1.getMessage());
                }
            }
        } else {
            output.printMessage("no_id");
        }
    }
}
