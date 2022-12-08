package client.io;

import client.utils.Message;

public class ConsoleOutput implements OutputHandler {
    Message message =new Message();
    @Override
    public void printMessage(String messageCode) {
        System.out.print(message.getMessage(messageCode));
    }

    @Override
    public void print(Object object) {
        System.out.print(object);
    }

    @Override
    public void alwaysPrint(Object object) {
        System.out.print(object);
    }

    @Override
    public void println(Object object) {
        System.out.println(object);
    }

    @Override
    public void alwaysPrintln(Object object) {
        System.out.println(object);
    }
}
