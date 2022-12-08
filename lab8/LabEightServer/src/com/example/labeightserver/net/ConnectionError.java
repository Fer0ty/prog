package com.example.labeightserver.net;

public class ConnectionError extends RuntimeException {
    public ConnectionError() {
        super();
    }

    public ConnectionError(String message) {
        super(message);
    }
}
