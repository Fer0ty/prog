package server.transfer;

import common.transfer.Response;

import java.util.ArrayDeque;
import java.util.Deque;

public class ResponseQueue {

    final Deque<Response> queue;

    public ResponseQueue() {

        queue = new ArrayDeque<>();
    }

    synchronized public void addLast(Response response) {
        queue.addLast(response);
    }

    synchronized public Response pollFirst() {
        Response response = queue.pollFirst();
        return response;
    }
}
