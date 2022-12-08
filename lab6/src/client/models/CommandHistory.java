package client.models;

import java.io.Serializable;
import java.util.ArrayDeque;

public class CommandHistory implements Serializable {
    ArrayDeque<String> stack = new ArrayDeque<>();
    int maxSize = 12;

    public CommandHistory() {}

    public CommandHistory(int maxSize) {this.maxSize = maxSize;}

    public void add(String string) {
        if (stack.size() == maxSize) {
            stack.removeFirst();
        }
        stack.add(string);
    }

    public ArrayDeque<String> getStack() {
        return stack;
    }
}
