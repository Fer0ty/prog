package server;

import client.models.ParsingError;
import client.models.SMCollection;
import client.net.Request;
import client.net.TransferException;
import server.commands.*;
import server.net.ClientConnection;


import java.io.IOException;
import java.util.Scanner;


public class Server {
    ClientConnection clientConnection;
    SMCollection smCollection;

    public Server(String path) {
        try {
            clientConnection = new ClientConnection();
            smCollection = new SMCollection();
            smCollection.loadFromXML(path);
        } catch (ParsingError e) {
            throw new RuntimeException();
        }
    }

    public Server(String path, int port) {
        try {
            clientConnection = new ClientConnection(port);
            smCollection = new SMCollection();
            smCollection.loadFromXML(path);
        } catch (ParsingError e) {
            throw new RuntimeException();
        }
    }

    private Command getCommand(Request request) {
        if (request.getCommand().equalsIgnoreCase("show")) {             //+
            return new ShowCommand(smCollection, clientConnection);
        } else if (request.getCommand().equalsIgnoreCase("history")) {             //+
            return new HistoryCommand(smCollection, clientConnection);
        } else if (request.getCommand().equalsIgnoreCase("clear")) {             //+
            return new ClearCommand(smCollection, clientConnection);
        } else if (request.getCommand().equalsIgnoreCase("help")) {             //+
            return new HelpCommand(smCollection, clientConnection);
        } else if (request.getCommand().equalsIgnoreCase("info")) {             //+
            return new InfoCommand(smCollection, clientConnection);
        } else if (request.getCommand().equalsIgnoreCase("print_unique_melee_weapon")) {             //+
            return new PrintUniqueMeleeWeaponCommand(smCollection, clientConnection);
        } else if (request.getCommand().equalsIgnoreCase("insert")) {             //+
            return new InsertCommand(smCollection, clientConnection, request);
        } else if (request.getCommand().equalsIgnoreCase("remove_key")) {             //+
            return new RemoveKeyCommand(smCollection, clientConnection, request);
        }  else if (request.getCommand().equalsIgnoreCase("update")) {             //+
            return new UpdateCommand(smCollection, clientConnection, request);
        } else if (request.getCommand().equalsIgnoreCase("remove_greater")) {
            return new RemoveGreaterCommand(smCollection, clientConnection, request);
        } else if (request.getCommand().equalsIgnoreCase("exit")) {             //+
            return new RemoveGreaterCommand(smCollection, clientConnection, request);
        } else if (request.getCommand().equalsIgnoreCase("remove_greater_key")) {             //+
            return new RemoveGreaterKeyCommand(smCollection, clientConnection, request);
        }else if (request.getCommand().equalsIgnoreCase("remove_all_by_melee_weapon")) {
            return new RemoveAllByMeleeWeaponCommand(smCollection, clientConnection, request);
        }else if (request.getCommand().equalsIgnoreCase("count_less_than_heart_count")) {
            return new CountLessThanHeartCountCommand(smCollection, clientConnection, request);
        } else {
            return new UndefinedCommand(smCollection, clientConnection);
        }
    }

    public void run() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            try {
                Request request = clientConnection.receive();
                Command command = getCommand(request);
                command.execute();
                smCollection.dumpToXMLile();
            } catch (TransferException | IOException ignore) {
            } catch (ParsingError e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {

        if (args.length == 0) {
            String path = "/home/studs/s334645/CollectionXML.xml";
            new Server(path).run();
        } else if (args.length == 1)  {
            new Server(args[0]).run();
        } else {
            new Server(args[0], Integer.parseInt(args[1])).run();
        }
    }
}
