package client.utils;

import client.io.InputHandler;
import client.io.OutputHandler;
import common.models.*;

import java.util.NoSuchElementException;

public class SpaceMarineForm {
    final SpaceMarine spaceMarine;
    final InputHandler input;
    final OutputHandler output;

    public SpaceMarineForm (InputHandler input, OutputHandler output){
        this. input = input;
        this.output = output;
        this.spaceMarine = new SpaceMarine();
        this.spaceMarine.setCoordinates(new Coordinates());
    }

    public SpaceMarine getSpaceMarine(){
        try {
            fillSpaceMarine();
            return spaceMarine;
        } catch (NoSuchElementException e){
            return null;
        }
    }
    protected void fillSpaceMarine (){
        fillSMName();
        fillSMX();
        fillSMY();
        fillHealth();
        fillHeartCount();
        fillWeapon();
        fillMeleeWeapon();
        fillChapter();
    }

    protected void  fillSMName(){
        while (true){
            try {
                String name = getUserInput("SMForm_nameField");
                SpaceMarinesValidators.validateName(name);
                spaceMarine.setName(name);
                break;
            } catch (ValidationError e) {
                output.printMessage("spaceMarineForm_invalidName");
            }
        }
    }

    protected void fillSMX(){
        while (true){
            try{
                Float x = Float.parseFloat((getUserInput("coordinatesForm_XField")));
                SpaceMarinesValidators.validateCoordinateX(x);
                spaceMarine.getCoordinates().setX(x);
                break;
            } catch (ValidationError | NumberFormatException e) {
                output.printMessage("spaceMarineForm_invalidX");
            }
        }
    }

    protected void fillSMY(){
        while (true){
            try {
                Integer y = Integer.parseInt(getUserInput("coordinatesForm_YField"));
                SpaceMarinesValidators.validateCoordinateY(y);
                spaceMarine.getCoordinates().setY(y);
                break;
            } catch (ValidationError | NumberFormatException e) {
                output.printMessage("spaceMarineForm_invalidY");
            }
        }
    }

    protected void fillHealth(){
        while (true){
            try{
                Float health =  Float.parseFloat(getUserInput( "SMForm_healthField"));
                SpaceMarinesValidators.validateHealth(health);
                spaceMarine.setHealth(health);
                break;

            } catch (ValidationError | NumberFormatException e) {
                output.printMessage("spaceMarineForm_invalidHealth");
            }
        }
    }

    protected void fillHeartCount(){
        while (true){
            try {
                Long heartcount  = Long.parseLong(getUserInput("SMForm_heartCountField"));
                SpaceMarinesValidators.validateHeartCount(heartcount);
                spaceMarine.setHeartCount(heartcount);
                break;
            } catch (ValidationError | NumberFormatException e) {
                output.printMessage("spaceMarineForm_invalidHeartCount");
            }
        }
    }

    protected void fillWeapon(){
        while (true){
            try{
                String input = getUserInput("SMForm_weaponField");
                Weapon weaponType = null;
                if (!input.isEmpty()){
                    weaponType = Weapon.valueOf(input);
                }
                spaceMarine.setWeaponType(weaponType);
                break;

            } catch (IllegalArgumentException e) {
                output.printMessage("spaceMarineForm_invalidWeaponType");
            }
        }
    }

    protected void fillMeleeWeapon(){
        while (true){
            try{
                String input = getUserInput("SMForm_meleeWeaponField");
                MeleeWeapon meleeWeapon = null;
                if (!input.isEmpty()){
                    meleeWeapon = MeleeWeapon.valueOf(input);
                }
                spaceMarine.setMeleeWeapon(meleeWeapon);
                break;
            } catch (IllegalArgumentException e) {
                output.printMessage("spaceMarineForm_invalidMeleeWeaponType");
            }
        }
    }

    protected void fillChapter(){
        while (true){
            try {
                Chapter chapter = null;
                String chapterName = getUserInput("SMForm_chapterField");
                String parentLegion = getUserInput("SMForm_parentLegion");
                if (!(chapterName.isEmpty())){
                    chapter = new Chapter();
                    SpaceMarinesValidators.validateName(chapterName);
                    chapter.setName(chapterName);
                    chapter.setParentLegion(parentLegion);
                    spaceMarine.setChapter(chapter);
                }

                break;
            } catch (ValidationError | NumberFormatException e) {
                output.printMessage("spaceMarineForm_invalidChapter");
            }
        }

    }

    private String getUserInput(String messageCode){
        output.printMessage(messageCode);
        return input.nextLine();
    }
}

