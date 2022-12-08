package com.example.labeightserver.net;

import java.io.Serializable;

public enum CommandType implements Serializable {
    INSERT,
    UPDATE,
    DELETE,
    CLEAN,
    GET_TICKETS,
    REGISTER,
    AUTH,
    ADD_LISTENER,
    REMOVE_LISTENER
}
