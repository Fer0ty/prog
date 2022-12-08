package com.example.labeightserver.transfer;

import java.net.SocketAddress;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.locks.ReentrantLock;

public class ClientAddressSet {
    final ReentrantLock lock;
    final HashSet<SocketAddress> sockets;

    public ClientAddressSet() {
        lock = new ReentrantLock();
        sockets = new HashSet<>();
    }

    public void add(SocketAddress address) {
        lock.lock();
        sockets.add(address);
        lock.unlock();
    }

    public Set<SocketAddress> getCopy() {
        lock.lock();
        Set<SocketAddress> s = (Set<SocketAddress>) sockets.clone();
        lock.unlock();
        return s;
    }

    public void remove(SocketAddress address) {
        lock.lock();
        sockets.remove(address);
        lock.unlock();
    }
}
