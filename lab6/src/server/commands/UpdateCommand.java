package server.commands;

import client.models.SMCollection;
import client.models.SpaceMarine;
import client.net.Request;
import server.net.ClientConnection;

public class UpdateCommand extends CommandAbstract {
    final Request request;

    public UpdateCommand(SMCollection smCollection, ClientConnection clientConnection, Request request) {
        super(smCollection, clientConnection);
        this.request = request;
    }

    private boolean updateSpaceMarine(SpaceMarine newSpaceMarine) {
        SpaceMarine oldSpaceMarine = smCollection.getSpaceMarine(getId().toString());
        if (oldSpaceMarine != null) {
            oldSpaceMarine.setName(newSpaceMarine.getName());
            oldSpaceMarine.setCoordinates(newSpaceMarine.getCoordinates());
            oldSpaceMarine.setHealth(newSpaceMarine.getHealth());
            oldSpaceMarine.setHeartCount(newSpaceMarine.getHeartCount());
            oldSpaceMarine.setWeaponType(newSpaceMarine.getWeapon());
            oldSpaceMarine.setMeleeWeapon(newSpaceMarine.getMeleeWeapon());
            oldSpaceMarine.setMeleeWeapon(newSpaceMarine.getMeleeWeapon());
            oldSpaceMarine.setChapter(newSpaceMarine.getChapter());
            return true;
        } else {
            return false;
        }
    }

    private Long getId() {
        Long id = null;
        if (!request.getAttr(1).isEmpty()) {
            try {
                id = Long.parseLong(request.getAttr(1));
            } catch (NumberFormatException ignore) {}
        }
        return id;
    }

    public void execute() {
        if (getId() == null) {
            printMessage("incorrectId");
        } else {
            SpaceMarine spaceMarine = request.getSM();
            if (spaceMarine != null) {
                addSelfInCommandHistory();
                if (updateSpaceMarine(spaceMarine)) {
                    printMessage("updateCommandText");
                } else {
                    printMessage("IncorrectID");
                }
            } else {
                printMessage("spaceMarineForm_isInvalid");
            }
        }
    }
}
