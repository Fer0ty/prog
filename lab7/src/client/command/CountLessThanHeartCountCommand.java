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


public class CountLessThanHeartCountCommand extends CommandAbstract {
    Long heartCount;
    public CountLessThanHeartCountCommand(OutputHandler outputHandler, Transfer transfer, UserData userData, InputHandler inputHandler) {
        super(outputHandler, transfer, userData, inputHandler);
    }

    public void setHealth(String command) {
        String[] c = command.trim().split("\\s+");
        if (c.length == 2) {
            try {
                heartCount = Long.parseLong(c[1]);
            } catch (NumberFormatException ignore) {}
        }
    }

    @Override
    public void execute() {
        if (heartCount != null) {
            Request request = new Request(userData, CommandType.GET_SPACEMARINES);
            serverConnection.send(request);
            Response response = serverConnection.receive();
            if (response.getObject() == null) {
                output.print(response.getMessage());
            } else {
                Set<SpaceMarine> spaceMarineSet = (Set<SpaceMarine>) response.getObject();
                Set<SpaceMarine> countedSpaceMarines = spaceMarineSet.stream().filter(spaceMarine -> spaceMarine.getHeartCount() != null)
                        .filter(spaceMarine -> spaceMarine.getHeartCount() < heartCount).collect(Collectors.toSet());
                output.print(countedSpaceMarines.size() + "\n");
            }
        } else {
            output.print("Не верно передан аргумент.");
        }
    }
}