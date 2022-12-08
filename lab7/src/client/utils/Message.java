package client.utils;

import java.util.Hashtable;
import java.util.Set;
public class Message {
    protected static Set<String> availableLanguages;
    protected static String currentLanguage = "ru";
    private static Hashtable<String,String> hashtable;
    static {
        Hashtable<String, String> messages = new Hashtable();
        messages.put("console_prefix", ">>> ");
        messages.put("unavailable_command", "Недоступная команда.\nВведите \"help\" для справки.\n");
        messages.put("helpCommand_text","help : вывести справку по доступным командам\n" +
                    "info : вывести в стандартный поток вывода информацию о коллекции\n" +
                    "show : вывести в стандартный поток вывода все элементы коллекции в строковом представлении\n" +
                    "insert null {element} : добавить новый элемент с заданным ключом \n" +
                    "update id {element} : обновить значение элемента коллекции, id которого равен заданному \n" +
                    "remove_key null : удалить элемент из коллекции по его ключу \n" +
                    "clear : очистить коллекцию \n" +
                    "exit : завершить программу \n" +
                    "remove_greater {health} : удалить из коллекции все элементы, значения поля health которых превышают заданный \n"+
                    "remove_greater_key null : удалить из коллекции все элементы, ключ которых превышает заданный \n"+
                    "count_less_than_heart_count heartCount : вывести количество элементов, значение поля heartCount которых меньше заданного \n"+
                    "print_unique_melee_weapon : вывести уникальные значения поля meleeWeapon всех элементов в коллекции \n"+
                    "login: авторизация\n"+"register: регистрация\n"
                );
        messages.put("historyCommand_text", "Последние выполненные команды:\n");
        messages.put("infoCommand_format", "=== Информация о коллекции ===\nКоличество элементов: \n");
        messages.put("showCommand_emptyCollection", "Коллекция пуста.\n");
        messages.put("shell_incorrectFilename", "Некорректное имя файла.\nВведите новое имя: ");
        messages.put("insertCommand_invalidData", "Некорректные данные\n");
        messages.put("identifier_does_not_exist", "Такого идентификатора не существует.\n");
        messages.put("collection_is_clear", "Коллекция очищена.\n");
        messages.put("incorrectAttr", "Неверный параметр команды.\n");
        messages.put("incorrectId", "Билета с таким идентификатором не существует.\n");
        messages.put("insertCommand_addedSpaceMarine", "SpaceMarine добавлен.\n");
        messages.put("removeCommand", "SpaceMarine удален\n");
        messages.put("crushedServer", "Сервер временно не доступен, попробуйте позднее.\n");
        messages.put("updateCommand_wasUpdate", "Данные обновлены\n");
        messages.put("permission_denied", "Отказано в доступе\n");
        messages.put("login", "Введите имя пользователя: ");
        messages.put("helpText_login", "Логин должен быть не пустой и не превышать 50 символов.\n");
        messages.put("password", "Введите пароль: ");
        messages.put("helpText_password", "Пароль должен быть не пустой и не превышать 50 символов.\n");
        messages.put("no_id", "Вы не передали id");
        messages.put("SMForm_nameField", "Введите имя: ");
        messages.put("coordinatesForm_XField", "Введите координату x: ");
        messages.put("coordinatesForm_YField", "Введите координату y: ");
        messages.put("SMForm_healthField","Введите значение health(не null и больше 0):");
        messages.put("SMForm_heartCountField","Введите значение HeartCount(не null, больше 0, но меньше 3):");
        messages.put("SMForm_weaponField","Введите значение Weapon(BOLTGUN, PLASMA_GUN, GRENADE_LAUNCHER, INFERNO_PISTOL, HEAVY_FLAMER):");
        messages.put("SMForm_meleeWeaponField","Введите значение MeleeWeapon(CHAIN_SWORD, MANREAPER, LIGHTING_CLAW, POWER_BLADE):");
        messages.put("SMForm_chapterField","Введите Chapter(не null):");
        messages.put("SMForm_parentLegion","Введите ParentLegion(или оставьте поле пустым):");
        messages.put("spaceMarineForm_invalidName", "Имя не должно быть пустым.\n");
        messages.put("spaceMarineForm_invalidX","Неверное значение координаты x.\n");
        messages.put("spaceMarineForm_invalidY","Неверное значение координаты y.\n");
        messages.put("spaceMarineForm_invalidHealth","Неверное значение Health\n");
        messages.put("spaceMarineForm_invalidHeartCount","Неверное значение HeartCount\n");
        messages.put("spaceMarineForm_invalidChapter","Неверное значение Chapter\n");
        messages.put("spaceMarineForm_invalidWeaponType","Неверное значение WeaponType\n");
        messages.put("spaceMarineForm_invalidMeleeWeaponType","Неверное значение MeleeWeapon\n");
        messages.put("spaceMarineForm_isInvalid","Неверно введены данные SpaceMarine\n");
        messages.put("success", "Операция выполнена\n");
        messages.put("connection to db lost","Потеряно соединение с базой данных\n");
        hashtable = messages;

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