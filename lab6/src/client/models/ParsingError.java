package client.models;

public class ParsingError extends Exception {
    public ParsingError(String message) {
        super(message);
    }

    public ParsingError() {
        super();
    }
}
