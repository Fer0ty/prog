package com.example.labeightserver.net;

import java.io.Serializable;
import java.net.SocketAddress;

public class Response implements Serializable {
    public final static int DENIED = 403;
    public final static int SUCCESS = 200;
    public final static int UPDATE_COLLECTION = 101;
    public final static int UPDATE_TICKET = 102;
    public final static int DELETE_TICKET = 103;
    public final static int ADD_TICKET = 104;
    public final static int CLEAN = 105;
    public final static int FAIL = 300;
    
    private SocketAddress clientAddress;
    private Object object;
    private String message;
    private int status = 666;

    public Response(SocketAddress clientAddress) {
        this.clientAddress = clientAddress;
    }

    public Response(SocketAddress clientAddress, int status) {
        this.clientAddress = clientAddress;
        this.status = status;
    }

    public Response(SocketAddress clientAddress, String message) {
        this.clientAddress = clientAddress;
        this.message = message;
    }

    public Response(SocketAddress clientAddress, String message, Object object) {
        this.clientAddress = clientAddress;
        this.message = message;
        this.object = object;
    }
    
    public Response(SocketAddress clientAddress, int status, Object object) {
        this.clientAddress = clientAddress;
        this.status = status;
        this.object = object;
    }

    public SocketAddress getClientAddress() {
        return clientAddress;
    }

    public int getStatus() {
        return status;
    }

    public String getMessage() {
        return message;
    }

    public Object getObject() {
        return object;
    }
}
