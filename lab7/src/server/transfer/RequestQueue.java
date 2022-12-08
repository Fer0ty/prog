package server.transfer;

import common.transfer.Request;

import java.util.ArrayDeque;
import java.util.Deque;

public class RequestQueue {
    final Deque<Request> queue;

    public RequestQueue() {
        queue = new ArrayDeque<>();
    }

   synchronized public void addLast(Request request) {
        queue.addLast(request);

    }

    synchronized public Request pollFirst() {
        Request request = queue.pollFirst();
        return request;
    }
}
