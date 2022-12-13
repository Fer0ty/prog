package server.database;

public class DBSettings {
    final static String PASSWORD = "DB_PASS";
    final static String LOGIN = "ITMO_LOGIN";
    final static String HOST = "pg";
    final static String PORT = "PORT";
    final static String DEBUG_HOST = "localhost";
    final static String DEBUG_PORT = "LOCAL_PORT";
    final static boolean DEBUG = true;

    static String url() {
        return "jdbc:postgresql://" + (DEBUG ? DEBUG_HOST : HOST)  +  ":"
                + (DEBUG ? DEBUG_PORT : PORT) + "/studs";
    }
}
