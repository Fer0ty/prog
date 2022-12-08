package server.database;

import common.models.SpaceMarine;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class SpaceMarinesDBManager {
    final DatabaseHandler DBHandler;
    private UserDBManager userDBManager;

    public SpaceMarinesDBManager(DatabaseHandler DBHandler, UserDBManager userDBManager) {
        this.DBHandler = DBHandler;
        this.userDBManager = userDBManager;
        createTable();
    }

    private void createTable() {
        //language=SQL
        String CREATION_SQL = "CREATE TABLE IF NOT EXISTS SPACEMARINES (" +
                "id BIGSERIAL PRIMARY KEY," +
                "name TEXT NOT NULL CHECK (name <> '')," +
                "coordinateX FLOAT NOT NULL," +
                "coordinateY INTEGER NOT NULL," +
                "creationDate BIGINT NOT NULL," +
                "health FLOAT CHECK(health > 0)," +
                "heartCount FLOAT CHECK(heartCount > 0 and heartCount < 4)," +
                "weapon VARCHAR(50) CHECK (weapon = 'BOLTGUN' or weapon = 'PLASMA_GUN' or weapon = 'GRENADE_LAUNCHER' or weapon = 'INFERNO_PISTOL' or weapon = 'HEAVY_FLAMER')," +
                "meleeWeapon VARCHAR(50) CHECK (meleeWeapon = 'CHAIN_SWORD' or meleeWeapon = 'MANREAPER' or meleeWeapon = 'LIGHTING_CLAW' or meleeWeapon = 'POWER_BLADE')," +
                "chapterName TEXT NOT NULL," +
                "parentLegion TEXT," +
                "author VARCHAR(50) NOT NULL REFERENCES USERS(username)" +
                ");";
        try {
            Statement statement = DBHandler.getStatement();
            statement.execute(CREATION_SQL);
        } catch (DatabaseException | SQLException ignore) {}
    }

    public boolean insertSpaceMarine(SpaceMarine spaceMarine, UserData userData) {
        //language=SQL
        String INSERT_SQL = "INSERT INTO SPACEMARINES " +
                "(name,coordinateX, coordinateY, creationDate, health, heartCount, weapon, meleeWeapon, chapterName, parentLegion, author) " +
                "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try {
            DBHandler.setSavepoint();
            PreparedStatementWithNull preparedStatement = DBHandler.getPreparedStatementWithNull(INSERT_SQL);
            preparedStatement.setString(1, spaceMarine.getName());
            preparedStatement.setFloat(2, spaceMarine.getCoordinates().getX());
            preparedStatement.setInt(3, spaceMarine.getCoordinates().getY());
            preparedStatement.setLong(4, spaceMarine.getCreationDate() == null ? new Date().getTime() : spaceMarine.getCreationDate().getTime());
            preparedStatement.setFloat(5, spaceMarine.getHealth());
            preparedStatement.setLong(6, spaceMarine.getHeartCount());
            preparedStatement.setString(7, spaceMarine.getWeapon() != null ? spaceMarine.getWeapon().toString() : "PLASMA_GUN");
            preparedStatement.setString(8, spaceMarine.getMeleeWeapon() != null ? spaceMarine.getMeleeWeapon().toString() : "POWER_BLADE");
            preparedStatement.setString(9, spaceMarine.getChapter().getName());
            preparedStatement.setString(10, spaceMarine.getChapter().getParentLegion());
            preparedStatement.setString(11, userData.username);
            preparedStatement.execute();
            DBHandler.commit();
            return true;
        } catch (SQLException | DatabaseException e) {
            DBHandler.rollback();
            return false;
        }
    }

    public boolean updateSpaceMarine(SpaceMarine spaceMarine, UserData userData) {
        //language=SQL
        String UPDATE_SQL = "UPDATE SPACEMARINES SET name = ?, " +
                "coordinateX = ?, coordinateY = ?, " +
                "creationDate = ?, health = ?,heartCount = ?," +
                "weapon = ?,meleeWeapon = ?, chapterName = ?," +
                " parentLegion = ? WHERE id = ? and author = ?";
        try {
            DBHandler.setSavepoint();
            PreparedStatementWithNull preparedStatement = DBHandler.getPreparedStatementWithNull(UPDATE_SQL);
            preparedStatement.setString(1, spaceMarine.getName());
            preparedStatement.setFloat(2, spaceMarine.getCoordinates().getX());
            preparedStatement.setInt(3, spaceMarine.getCoordinates().getY());
            preparedStatement.setLong(4, spaceMarine.getCreationDate() == null ? new Date().getTime() : spaceMarine.getCreationDate().getTime());
            preparedStatement.setFloat(5, spaceMarine.getHealth());
            preparedStatement.setLong(6, spaceMarine.getHeartCount());
            preparedStatement.setString(7, spaceMarine.getWeapon() != null ? spaceMarine.getWeapon().toString() : null);
            preparedStatement.setString(8, spaceMarine.getMeleeWeapon() != null ? spaceMarine.getMeleeWeapon().toString() : null);
            preparedStatement.setString(9, spaceMarine.getChapter().getName());
            preparedStatement.setString(10, spaceMarine.getChapter().getParentLegion());
            preparedStatement.setLong(11, spaceMarine.getId());
            preparedStatement.setString(12, userData.username);
            preparedStatement.execute();
            DBHandler.commit();
            return true;
        } catch (SQLException | DatabaseException e) {
            DBHandler.rollback();
            return false;
        }
    }

    public boolean deleteSpaceMarine(SpaceMarine spaceMarine, UserData userData) {
        return deleteSpaceMarine(spaceMarine.getId(), userData);
    }

    public boolean deleteSpaceMarine(Long spacemarineId, UserData userData) {
        //language=SQL
        String DELETE_SQL =  "DELETE FROM SPACEMARINES WHERE id = ? and author = ?";
        try {
            DBHandler.setSavepoint();
            PreparedStatement preparedStatement = DBHandler.getPreparedStatement(DELETE_SQL);
            preparedStatement.setLong(1, spacemarineId);
            preparedStatement.setString(2, userData.username);
            preparedStatement.execute();
            DBHandler.commit();
            return true;
        } catch (SQLException | DatabaseException e) {
            DBHandler.rollback();
            return false;
        }
    }

    public boolean deleteAllSpaceMarines(UserData userData) {
        //language=SQL
        String DELETE_SQL =  "DELETE FROM SPACEMARINES WHERE author = ?";
        try {
            DBHandler.setSavepoint();
            PreparedStatement preparedStatement = DBHandler.getPreparedStatement(DELETE_SQL);
            preparedStatement.setString(1, userData.username);
            preparedStatement.execute();
            DBHandler.commit();
            return true;
        } catch (SQLException | DatabaseException e) {
            DBHandler.rollback();
            return false;
        }
    }

    public Set<SpaceMarine> getSpaceMarines() {
        //language=SQL
        String DELETE_SQL =  "SELECT * FROM SPACEMARINES";
        try {
            PreparedStatement preparedStatement = DBHandler.getPreparedStatement(DELETE_SQL);
            preparedStatement.execute();
            return getSpaceMarineSet(preparedStatement.getResultSet());
        } catch (SQLException | DatabaseException e) {
            return new HashSet<>();
        }
    }

    public Set<SpaceMarine> getSpaceMarineSet(ResultSet resultSet) throws SQLException {
        Set<SpaceMarine> spaceMarineSet = new HashSet<>();
        while (resultSet.next()) {
            SpaceMarine spaceMarine = new SpaceMarine(
                    resultSet.getLong("id"),
                    resultSet.getString("name"),
                    resultSet.getFloat("coordinateX"),
                    resultSet.getInt("coordinateY"),
                    resultSet.getLong("creationDate"),
                    resultSet.getFloat("health"),
                    resultSet.getLong("heartCount"),
                    resultSet.getString("weapon"),
                    resultSet.getString("meleeWeapon"),
                    resultSet.getString("chapterName"),
                    resultSet.getString("parentLegion"),
                    resultSet.getString("author")
            );
            spaceMarineSet.add(spaceMarine);
        }
        return spaceMarineSet;
    }
}
