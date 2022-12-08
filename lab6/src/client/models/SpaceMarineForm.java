package client.models;

import client.io.InputHandler;
import client.io.OutputHandler;

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
                spaceMarine.validateName(name);
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
                Float x = Float.parseFloat((getUserInput("SMForm_xField")));
                spaceMarine.getCoordinates().validateX(x);
                spaceMarine.getCoordinates().setX(x);
                break;
            } catch (NumberFormatException e) {
                output.printMessage("spaceMarineForm_invalidX");
            } catch (ValidationError e) {
                output.printMessage("spaceMarineForm_invalidX");
            }
        }
    }

    protected void fillSMY(){
        while (true){
            try{
                Double y = Double.parseDouble(getUserInput("SMForm_yField"));
                spaceMarine.getCoordinates().validateY(y);
                spaceMarine.getCoordinates().setY(y);
                break;
            } catch (NumberFormatException e) {
                output.printMessage("spaceMarineForm_invalidY");
            } catch (ValidationError e) {
                output.printMessage("spaceMarineForm_invalidY");
            }
        }
    }

    protected void fillHealth(){
        while (true){
            try{
                String input = getUserInput( "SMForm_healthField");
                Double health = null;
                if(!input.isEmpty()){
                    health = Double.parseDouble(input);
                }
                spaceMarine.validateHealth(health);
                spaceMarine.setHealth(health);
                break;

            } catch (ValidationError e) {
                output.printMessage("spaceMarineForm_invalidHealth");
            } catch (NumberFormatException e){
                output.printMessage("spaceMarineForm_invalidHealth");
            }
        }
    }

    protected void fillHeartCount(){
        while (true){
            try {
                String input = getUserInput("SMForm_heartCountField");

                Long heartcount = null;
                if (!input.isEmpty()) {
                    heartcount = Long.parseLong(input);
                }
                spaceMarine.validateHeartCount(heartcount);
                spaceMarine.setHeartCount(heartcount);
                break;
            } catch (ValidationError e) {
                output.printMessage("spaceMarineForm_invalidHeartCount");
            } catch (NumberFormatException e){
                output.printMessage("spaceMarineForm_invalidHeartCount");
            }
        }
    }

    protected void fillWeapon(){
        while (true){
            try{
                String input = getUserInput("SMForm_weaponField");
                String weaponType = null;
                if (!input.isEmpty()){
                    weaponType = input;
                }
                spaceMarine.validateWeaponType(weaponType);
                break;
                
            } catch (ValidationError e) {
                output.printMessage("spaceMarineForm_invalidWeaponType");
            }
        }
    }

    protected void fillMeleeWeapon(){
        while (true){
            try{
                String input = getUserInput("SMForm_meleeWeaponField");
                String meleeWeaponType = null;
                if (!input.isEmpty()){
                    meleeWeaponType = input;
                }
                spaceMarine.validateMeeleWeapon(meleeWeaponType);
                break;
            } catch (ValidationError e) {
                output.printMessage("spaceMarineForm_invalidMeleeWeaponType");
            }
        }
    }
    
    protected void fillChapter(){
        while (true){
            try {
                Chapter chapter = null;
                String chapterName = getUserInput("SMForm_chapterField");
                chapter = new Chapter();
                chapter.validateName(chapterName);
                chapter.setName(chapterName);
                spaceMarine.setChapter(chapter);
                String parentLegion = getUserInput("SMForm_parentLegion");
                chapter.setParentLegion(parentLegion);
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

