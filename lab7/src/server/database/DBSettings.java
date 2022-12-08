package server.database;

public class DBSettings {
    final static String PASSWORD = "eNiIXg15sQmP6nDf";
    final static String LOGIN = "s334645";
    final static String HOST = "pg";
    final static String PORT = "5432";
    final static String DEBUG_HOST = "localhost";
    final static String DEBUG_PORT = "1099";
    final static boolean DEBUG = true;

    static String url() {
        return "jdbc:postgresql://" + (DEBUG ? DEBUG_HOST : HOST)  +  ":"
                + (DEBUG ? DEBUG_PORT : PORT) + "/studs";
    }
}