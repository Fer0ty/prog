package server.commands;

import client.models.SMCollection;
import client.models.SpaceMarine;
import server.net.ClientConnection;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.Set;
import java.util.stream.Stream;

public class PrintUniqueMeleeWeaponCommand extends CommandAbstract {
    public PrintUniqueMeleeWeaponCommand(SMCollection smCollection, ClientConnection clientConnection) {
        super(smCollection, clientConnection);
    }

    @Override
    public void execute() {
        addSelfInCommandHistory();
        LinkedHashSet<String>  meleeWeapons = new LinkedHashSet<>();
        for (String key : smCollection.keySet()){
            meleeWeapons.add(smCollection.getSpaceMarine(key).getMeleeWeapon().toString());
        }
        printObject((LinkedHashSet)meleeWeapons);
    }
}

