package server.commands;

import common.transfer.Request;
import common.transfer.Response;
import server.database.SpaceMarinesDBManager;
import server.database.UserDBManager;
import server.transfer.RequestQueue;
import server.transfer.ResponseQueue;


public class CommandExecutor implements Runnable {
    RequestQueue requestQueue;
    ResponseQueue responseQueue;
    UserDBManager userDBManager;
    SpaceMarinesDBManager spaceMarinesDBManager;

    public CommandExecutor(RequestQueue requestQueue, ResponseQueue responseQueue,
                           UserDBManager userDBManager, SpaceMarinesDBManager spaceMarinesDBManager) {
        this.requestQueue = requestQueue;
        this.responseQueue = responseQueue;
        this.userDBManager = userDBManager;
        this.spaceMarinesDBManager = spaceMarinesDBManager;
    }

    @Override
    public void run() {
        while (true) {
            Request request = requestQueue.pollFirst();
            if (request != null) {
                responseQueue.addLast(executeCommand(request));
            }
        }
    }

    public Response executeCommand(Request request) {
        switch (request.getCommandType()) {
            case INSERT: return insertCommand(request);
            case CLEAN: return cleanCommand(request);
            case DELETE: return deleteCommand(request);
            case UPDATE: return updateCommand(request);
            case REGISTER: return registerCommand(request);
            case GET_SPACEMARINES: return getSpaceMarineCommand(request);
            default: return new Response(request.getClientAddress(), "Что то пошло не так");
        }
    }

    public Response getSpaceMarineCommand(Request request) {
        Response response;
        if (userDBManager.checkUser(request.getUserData())) {
            response = new Response(request.getClientAddress(), "Команда выполнена\n", spaceMarinesDBManager.getSpaceMarines());
        } else {
            response = new Response(request.getClientAddress(), "Отказано в доступе\n");
        }
        return response;
    }

    public Response registerCommand(Request request) {
        Response response;
        if (userDBManager.createUser(request.getUserData())) {
            response = new Response(request.getClientAddress(), "Пользователь добавлен\n");
        } else {
            response = new Response(request.getClientAddress(), "Не удалось добавить пользователя\n");
        }
        return response;
    }

    public Response updateCommand(Request request) {
        Response response;
        if (userDBManager.checkUser(request.getUserData())) {
            if (spaceMarinesDBManager.updateSpaceMarine(request.getSpaceMarine(), request.getUserData())) {
                response = new Response(request.getClientAddress(), "Данные обновлены\n");
            } else {
                response = new Response(request.getClientAddress(), "Не удалось обновить элемент\n");
            }
        } else {
            response = new Response(request.getClientAddress(), "Отказано в доступе\n");
        }
        return response;
    }

    public Response insertCommand(Request request) {
        Response response;
        if (userDBManager.checkUser(request.getUserData())) {
            if (spaceMarinesDBManager.insertSpaceMarine(request.getSpaceMarine(), request.getUserData())) {
                response = new Response(request.getClientAddress(), "Элемент добавлен\n");
            } else {
                response = new Response(request.getClientAddress(), "Не удалось добавить элемент\n");
            }
        } else {
            response = new Response(request.getClientAddress(), "Отказанно в доступе\n");
        }
        return response;
    }

    public Response deleteCommand(Request request) {
        Response response;
        if (userDBManager.checkUser(request.getUserData())) {
            if (spaceMarinesDBManager.deleteSpaceMarine(request.getSpaceMarine(), request.getUserData())) {
                response = new Response(request.getClientAddress(), "Элемент удален\n");
            } else {
                response = new Response(request.getClientAddress(), "Не удалось добавить элемент\n");
            }
        } else {
            response = new Response(request.getClientAddress(), "Отказано в доступе\n");
        }
        return response;
    }

    public Response cleanCommand(Request request) {
        Response response;
        if (userDBManager.checkUser(request.getUserData())) {
            if (spaceMarinesDBManager.deleteAllSpaceMarines(request.getUserData())) {
                response = new Response(request.getClientAddress(), "Все ваши SpaceMarines удалены\n");
            } else {
                response = new Response(request.getClientAddress(), "Не удалось удалить элементы\n");
            }
        } else {
            response = new Response(request.getClientAddress(), "Отказано в доступе\n");
        }
        return response;
    }
}
