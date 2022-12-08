package server.commands;

import client.models.CommandHistory;
import client.models.SMCollection;
import client.net.Response;
import server.net.ClientConnection;

import java.io.IOException;
import java.io.Serializable;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public abstract class CommandAbstract implements Command {
    protected static CommandHistory commandHistory = new CommandHistory();
    protected SMCollection smCollection;
    protected ClientConnection clientConnection;

    public CommandAbstract(SMCollection smCollection, ClientConnection clientConnection) {
        this.smCollection = smCollection;
        this.clientConnection = clientConnection;
    }

    protected void printMessage(String messageCode) {
        Response response = new Response(messageCode, true);
        clientConnection.sendResponse(response);
    }

    protected void printObject(Serializable object) {
        Response response = new Response(object);
        clientConnection.sendResponse(response);
    }

    protected void addSelfInCommandHistory() {
        commandHistory.add(getCommandName());
    }

    protected String getCommandName() {
        String className = this.getClass().getTypeName();
        Matcher matcher = Pattern.compile("([\\d\\w]+)Command$").matcher(className);
        if (!matcher.find()) {
            throw new RuntimeException("Rename command class or override getCommandName() method");
        }
        String commandName = matcher.group(1);
        commandName = commandName.replaceAll(
                "(?<=[A-Z])(?=[A-Z][a-z])|(?<=[^A-Z])(?=[A-Z])|(?<=[A-Za-z])(?=[^A-Za-z])", "_");
        return commandName.toLowerCase();
    }

    public abstract void execute() throws IOException;
}
