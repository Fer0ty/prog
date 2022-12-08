package client.utils;

import java.util.Hashtable;


import java.util.Set;

public class Message {
    protected static Set<String> availableLanguages;
    protected static String currentLanguage = "ru";
    private static Hashtable<String,String> hashtable;
    static {
        Hashtable<String, String> hashtable1 = new Hashtable();
        hashtable1.put("unavailable_command", "Недоступная команда.\nВведите \"help\" для справки.\n");
        hashtable1.put("consolePrefix",">>> ");
        hashtable1.put("incorrectFileName","Некорректное имя файла.\nВведите новое имя файла: ");
        hashtable1.put("helpCommandText","help : вывести справку по доступным командам\n" +
                "info : вывести в стандартный поток вывода информацию о коллекции\n" +
                "show : вывести в стандартный поток вывода все элементы коллекции в строковом представлении\n" +
                "insert null {element} : добавить новый элемент с заданным ключом \n" +
                "update id {element} : обновить значение элемента коллекции, id которого равен заданному \n" +
                "remove_key null : удалить элемент из коллекции по его ключу \n" +
                "clear : очистить коллекцию \n" +
                "execute_script file_name : считать и исполнить скрипт из указанного файла. \n" +
                "exit : завершить программу (без сохранения в файл) \n" +
                "remove_greater {Health} : удалить из коллекции все элементы, превышающие заданный \n" +
                "history : вывести последние 12 команд (без их аргументов) \n" +
                "remove_greater_key null : удалить из коллекции все элементы, ключ которых превышает заданный \n" +
                "remove_all_by_melee_weapon meleeWeapon : удалить из коллекции все элементы, значение поля meleeWeapon которого " +
                "эквивалентно заданному \n" +
                "count_less_than_heart_count heartCount : вывести количество элементов, значение поля heartCount которых меньше заданного \n" +
                "print_unique_melee_weapon : вывести уникальные значения поля meleeWeapon всех элементов в коллекции \n");
        hashtable1.put("historyCommandText", "Последние выполненные команды:\n");
        hashtable1.put("infoCommandFormat","=== Информация о коллекции ===\nПоследнее сохранение: %s;\nКоличество элементов: %d;\nРабочий файл: %s\n");
        hashtable1.put("showCommand_emptyCollection", "Коллекция пуста.\n");
        hashtable1.put("clearCommandText", "Коллекция очищена\n");
        hashtable1.put("insertCommandText","SpaceMarine добавлен\n");
        hashtable1.put("removeCommandText","SpaceMarine удален\n");
        hashtable1.put("updateCommandText","Данные SpaceMarine обновлены\n");
        hashtable1.put("success","Операция выполнена\n");
        hashtable1.put("crushedServer","сервер временно недоступен. Попробуйте позднее\n");

        hashtable1.put("SMForm_nameField", "Введите имя(не null):");
        hashtable1.put("SMForm_xField","Введите координату x(Double):");
        hashtable1.put("SMForm_yField","Введите координату y(Int):");
        hashtable1.put("SMForm_healthField","Введите значение health(не null и больше 0):");
        hashtable1.put("SMForm_heartCountField","Введите значение HeartCount(не null, больше 0, но меньше 3):");
        hashtable1.put("SMForm_weaponField","Введите значение Weapon(BOLTGUN, PLASMA_GUN, GRENADE_LAUNCHER, INFERNO_PISTOL, HEAVY_FLAMER):");
        hashtable1.put("SMForm_meleeWeaponField","Введите значение MeleeWeapon(CHAIN_SWORD, MANREAPER, LIGHTING_CLAW, POWER_BLADE):");
        hashtable1.put("SMForm_chapterField","Введите Chapter(не null):");
        hashtable1.put("SMForm_parentLegion","Введите ParentLegion(или оставьте поле пустым):");

        hashtable1.put("spaceMarineForm_invalidName", "Имя не должно быть пустым.\n");
        hashtable1.put("spaceMarineForm_invalidX","Неверное значение координаты x.\n");
        hashtable1.put("spaceMarineForm_invalidY","Неверное значение координаты y.\n");
        hashtable1.put("spaceMarineForm_invalidHealth","Неверное значение Health\n");
        hashtable1.put("spaceMarineForm_invalidHeartCount","Неверное значение HeartCount\n");
        hashtable1.put("spaceMarineForm_invalidChapter","Неверное значение Chapter\n");
        hashtable1.put("spaceMarineForm_invalidWeaponType","Неверное значение WeaponType\n");
        hashtable1.put("spaceMarineForm_invalidMeleeWeaponType","Неверное значение MeleeWeapon\n");
        hashtable1.put("spaceMarineForm_isInvalid","Неверно введены данные spaceMarine\n");

        hashtable1.put("unavailableCommand","Недоступная команда. \n Введите \"help\" для справки.\n");
        hashtable1.put("incorrectScriptFileName","Некорректное имя файла\n");
        hashtable1.put("recursion","При выполнении скрипта возникает рекурсия\n");
        hashtable1.put("insertCommand_invalidData", "Некорректные данные\n");
        hashtable1.put("ID_does_not_exist","Такого идентификатора не существует.\n");
        hashtable1.put("executeScript_failExecution","Не удалось выполнить скрипт.\n");
        hashtable1.put("IncorrectID","SpaceMarine с таким ID не существует\n");
        hashtable1.put("incorrectAttr","Некорректное значение");
        hashtable = hashtable1;
    }

    public static String getMessage(String messageCode) {
        return hashtable.get(messageCode);
    }

    public static void changeLanguage(String language) {
        if (availableLanguages.contains(language)) {
            currentLanguage = language;
        }
    }

}