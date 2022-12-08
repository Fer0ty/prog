package common.transfer;

import common.command.CommandType;
import common.models.SpaceMarine;
import server.database.UserData;


import java.io.Serializable;
import java.net.SocketAddress;

public class Request implements Serializable {
    private UserData userData;
    private CommandType commandType;
    private SpaceMarine spaceMarine;
    private SocketAddress from;

    public Request(UserData userData, CommandType commandType) {
        this.userData = userData;
        this.commandType = commandType;
    }

    public Request(UserData userData, CommandType commandType, SpaceMarine transferredObject) {
        this(userData, commandType);
        this.spaceMarine = transferredObject;
    }

    public UserData getUserData() {
        return userData;
    }

    public CommandType getCommandType() {
        return commandType;
    }

    public SpaceMarine getSpaceMarine() {
        return spaceMarine;
    }

    public SocketAddress getClientAddress() {
        return from;
    }

    public void setClientAddress(SocketAddress from) {
        this.from = from;
    }
}
