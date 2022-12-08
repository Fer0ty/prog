package com.example.labeightserver.commands;

import com.example.labeightserver.database.TicketsDBManager;
import com.example.labeightserver.database.UserDBManager;
import com.example.labeightserver.models.Ticket;
import com.example.labeightserver.net.Request;
import com.example.labeightserver.net.Response;
import com.example.labeightserver.transfer.ClientAddressSet;
import com.example.labeightserver.transfer.RequestQueue;
import com.example.labeightserver.transfer.ResponseQueue;

import java.net.SocketAddress;
import java.util.ArrayList;
import java.util.List;

public class CommandExecutor implements Runnable {
    RequestQueue requestQueue;
    ResponseQueue responseQueue;
    UserDBManager userDBManager;
    TicketsDBManager ticketsDBManager;
    ClientAddressSet clientAddressSet;

    public CommandExecutor(RequestQueue requestQueue, ResponseQueue responseQueue,
                           UserDBManager userDBManager, TicketsDBManager ticketsDBManager,
                           ClientAddressSet clientAddressSet) {
        this.requestQueue = requestQueue;
        this.responseQueue = responseQueue;
        this.userDBManager = userDBManager;
        this.ticketsDBManager = ticketsDBManager;
        this.clientAddressSet = clientAddressSet;
    }

    @Override
    public void run() {
        while (true) {
            Request request = requestQueue.pollFirst();
            if (request != null) {
                responseQueue.addAllLast(executeCommand(request));
            }
        }
    }

    public List<Response> executeCommand(Request request) {
        switch (request.getCommandType()) {
            case INSERT: return insertCommand(request);
            case CLEAN: return cleanCommand(request);
            case DELETE: return deleteCommand(request);
            case UPDATE: return updateCommand(request);
            case REGISTER: return registerCommand(request);
            case GET_TICKETS: return getTicketCommand(request);
            case AUTH: return authCommand(request);
            case ADD_LISTENER: return addListenerCommand(request);
            case REMOVE_LISTENER: return removeListenerCommand(request);
            default: return createSingleResponse(request.getClientAddress(), -1);
        }
    }

    public List<Response> addListenerCommand(Request request) {
        List<Response> responses;
        if (userDBManager.checkUser(request.getUserData())) {
            clientAddressSet.add(request.getClientAddress());
            responses = createSingleResponse(request.getClientAddress(), 200);
        } else {
            responses = createSingleResponse(request.getClientAddress(), 403);
        }
        return responses;
    }

    public List<Response> removeListenerCommand(Request request) {
        List<Response> responses;
        if (userDBManager.checkUser(request.getUserData())) {
            clientAddressSet.remove(request.getClientAddress());
            responses = createSingleResponse(request.getClientAddress(), 200);
        } else {
            responses = createSingleResponse(request.getClientAddress(), 403);
        }
        return responses;
    }

    public List<Response> authCommand(Request request) {
        List<Response> responses;
        if (userDBManager.checkUser(request.getUserData())) {
            responses = createSingleResponse(request.getClientAddress(), 200);
        } else {
            responses = createSingleResponse(request.getClientAddress(), 403);
        }
        return responses;
    }

    public List<Response> getTicketCommand(Request request) {
        List<Response> responses;
        if (userDBManager.checkUser(request.getUserData())) {
            responses = createSingleResponse(request.getClientAddress(), Response.UPDATE_COLLECTION, ticketsDBManager.getTickets());
        } else {
            responses = createSingleResponse(request.getClientAddress(), Response.DENIED);
        }
        return responses;
    }

    public List<Response> registerCommand(Request request) {
        List<Response> responses;
        if (userDBManager.createUser(request.getUserData())) {
            responses = createSingleResponse(request.getClientAddress(), 200);
        } else {
            responses = createSingleResponse(request.getClientAddress(), 403);
        }
        return responses;
    }

    public List<Response> updateCommand(Request request) {
        List<Response> responses;
        if (userDBManager.checkUser(request.getUserData())) {
            if (ticketsDBManager.updateTicket(request.getTicket(), request.getUserData())) {
                responses = createResponses(Response.UPDATE_TICKET, request.getTicket());
            } else {
                responses = createSingleResponse(request.getClientAddress(), Response.FAIL);
            }
        } else {
            responses = createSingleResponse(request.getClientAddress(), Response.DENIED);
        }
        return responses;
    }

    public List<Response> insertCommand(Request request) {
        List<Response> responses;
        if (userDBManager.checkUser(request.getUserData())) {
            Long id = ticketsDBManager.insertTicket(request.getTicket(), request.getUserData());
            if (id != null) {
                Ticket ticket = request.getTicket();
                ticket.setId(id);
                responses = createResponses(Response.ADD_TICKET, ticket);
            } else {
                responses = createSingleResponse(request.getClientAddress(), Response.FAIL);
            }
        } else {
            responses = createSingleResponse(request.getClientAddress(), Response.DENIED);
        }
        return responses;
    }

    public List<Response> deleteCommand(Request request) {
        List<Response> responses;
        if (userDBManager.checkUser(request.getUserData())) {
            if (ticketsDBManager.deleteTicket(request.getTicket(), request.getUserData())) {
                responses = createResponses(Response.DELETE_TICKET, request.getTicket());
            } else {
                responses = createSingleResponse(request.getClientAddress(), Response.FAIL);
            }
        } else {
            responses = createSingleResponse(request.getClientAddress(), Response.DENIED);
        }
        return responses;
    }

    public List<Response> cleanCommand(Request request) {
        List<Response> responses;
        if (userDBManager.checkUser(request.getUserData())) {
            if (ticketsDBManager.deleteAllTickets(request.getUserData())) {
                responses = createResponses(Response.UPDATE_COLLECTION, ticketsDBManager.getTickets());
            } else {
                responses = createSingleResponse(request.getClientAddress(), Response.FAIL);
            }
        } else {
            responses = createSingleResponse(request.getClientAddress(), Response.DENIED);
        }
        return responses;
    }

    public List<Response> createResponses(int status) {
        return createResponses(status, null);
    }

    public List<Response> createResponses(int status, Object object) {
        List<Response> responses = new ArrayList<>();
        for (SocketAddress socket : clientAddressSet.getCopy()) {
            responses.add(new Response(socket, status, object));
        }
        return responses;
    }

    public List<Response> createSingleResponse(SocketAddress socketAddress, int status) {
        return createSingleResponse(socketAddress, status, null);
    }

    public List<Response> createSingleResponse(SocketAddress socketAddress, int status, Object object) {
        List<Response> responses = new ArrayList<>();
        responses.add(new Response(socketAddress, status, object));
        return responses;
    }
}
