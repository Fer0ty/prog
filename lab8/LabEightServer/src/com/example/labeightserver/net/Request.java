package com.example.labeightserver.net;

import com.example.labeightserver.models.Ticket;
import com.example.labeightserver.models.UserData;

import java.io.Serializable;
import java.net.SocketAddress;

public class Request implements Serializable {
    private UserData userData;
    private CommandType commandType;
    private Ticket ticket;
    private SocketAddress from;

    public Request(UserData userData, CommandType commandType) {
        this.userData = userData;
        this.commandType = commandType;
    }

    public Request(UserData userData, CommandType commandType, Ticket transferredObject) {
        this(userData, commandType);
        this.ticket = transferredObject;
    }

    public UserData getUserData() {
        return userData;
    }

    public CommandType getCommandType() {
        return commandType;
    }

    public Ticket getTicket() {
        return ticket;
    }

    public SocketAddress getClientAddress() {
        return from;
    }

    public void setClientAddress(SocketAddress from) {
        this.from = from;
    }
}
