package server.commands;

import client.models.ParsingError;
import client.models.SMCollection;
import server.net.ClientConnection;

import java.io.IOException;

public class ExitCommand extends CommandAbstract {
    public ExitCommand(SMCollection smCollection, ClientConnection clientConnection) {
        super(smCollection, clientConnection);
    }

    public void execute() {
        addSelfInCommandHistory();
        try {
            smCollection.dumpToXMLile();
        } catch (IOException ignore) {
        } catch (ParsingError e) {
            e.printStackTrace();
        }
    }
}
