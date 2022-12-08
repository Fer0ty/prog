package com.example.labeightserver.transfer;


import com.example.labeightserver.net.Request;
import com.example.labeightserver.net.Response;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.List;
import java.util.concurrent.locks.ReentrantLock;

public class ResponseQueue {
    final ReentrantLock lock;
    final Deque<Response> queue;

    public ResponseQueue() {
        lock = new ReentrantLock();
        queue = new ArrayDeque<>();
    }

    public void addLast(Response response) {
        lock.lock();
        queue.addLast(response);
        lock.unlock();
    }


    public void addAllLast(List<Response> responses) {
        lock.lock();
        for (Response resp : responses) {
            queue.addLast(resp);
        }
        lock.unlock();
    }

    public Response pollFirst() {
        lock.lock();
        Response response = queue.pollFirst();
        lock.unlock();
        return response;
    }
}
