package com.example.labeightserver.database;


import com.example.labeightserver.models.Ticket;
import com.example.labeightserver.models.UserData;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class TicketsDBManager {
    final DatabaseHandler DBHandler;
    private UserDBManager userDBManager;

    public TicketsDBManager(DatabaseHandler DBHandler, UserDBManager userDBManager) {
        this.DBHandler = DBHandler;
        this.userDBManager = userDBManager;
        createTable();
    }

    private void createTable() {
        //language=SQL
        String CREATION_SQL = "CREATE TABLE IF NOT EXISTS TICKETS (" +
                "id BIGSERIAL PRIMARY KEY," +
                "name TEXT NOT NULL CHECK (name <> '')," +
                "coordinateX FLOAT NOT NULL," +
                "coordinateY INTEGER NOT NULL," +
                "creationDate BIGINT NOT NULL," +
                "price FLOAT CHECK(price > 0)," +
                "type VARCHAR(50) CHECK ( type = 'VIP' or type = 'USUAL' or type = 'BUDGETARY' or type = 'CHEAP' )," +
                "venueName TEXT," +
                "venueCapacity BIGINT CHECK ( venueCapacity > 0 )," +
                "author VARCHAR(50) NOT NULL REFERENCES USERS(username)" +
                ");";
        try {
            Statement statement = DBHandler.getStatement();
            statement.execute(CREATION_SQL);
        } catch (DatabaseException | SQLException ignore) {}
    }

    public Long insertTicket(Ticket ticket, UserData userData) {
        //language=SQL
        String INSERT_SQL = "INSERT INTO TICKETS " +
                "(name, coordinateX, coordinateY, creationDate, price, type, venueName, venueCapacity, author) " +
                "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?) RETURNING id";
        try {
            DBHandler.setSavepoint();
            PreparedStatementWithNull preparedStatement = DBHandler.getPreparedStatementWithNull(INSERT_SQL, true);
            preparedStatement.setString(1, ticket.getName());
            preparedStatement.setFloat(2, ticket.getCoordinateX());
            preparedStatement.setInt(3, ticket.getCoordinateY());
            preparedStatement.setLong(4, ticket.getCreationDate() == null ? new Date().getTime() : ticket.getCreationDate().getTime());
            preparedStatement.setFloat(5, ticket.getPrice());
            preparedStatement.setString(6, ticket.getType() != null ? ticket.getType().toString() : null);
            preparedStatement.setString(7, ticket.getVenueName());
            preparedStatement.setLong(8, ticket.getVenueCapacity());
            preparedStatement.setString(9, userData.username);
            PreparedStatement statement = preparedStatement.getPreparedStatement();
            statement.executeUpdate();

            ResultSet resultSet = statement.getGeneratedKeys();
            resultSet.next();
            long id = resultSet.getLong(resultSet.findColumn("id"));
            DBHandler.commit();
            return id;
        } catch (SQLException | DatabaseException e) {
            DBHandler.rollback();
            return null;
        }
    }

    public boolean updateTicket(Ticket ticket, UserData userData) {
        //language=SQL
        String UPDATE_SQL = "UPDATE TICKETS SET name = ?, " +
                "coordinateX = ?, coordinateY = ?, " +
                "creationDate = ?, price = ?, " +
                "type = ?, venueName = ?, venueCapacity = ? WHERE id = ? and author = ?";
        try {
            DBHandler.setSavepoint();
            PreparedStatementWithNull preparedStatement = DBHandler.getPreparedStatementWithNull(UPDATE_SQL);
            preparedStatement.setString(1, ticket.getName());
            preparedStatement.setFloat(2, ticket.getCoordinateX());
            preparedStatement.setInt(3, ticket.getCoordinateY());
            preparedStatement.setLong(4, ticket.getCreationDate().getTime());
            preparedStatement.setFloat(5, ticket.getPrice());
            preparedStatement.setString(6, ticket.getType() != null ? ticket.getType().toString() : null);
            preparedStatement.setString(7, ticket.getVenueName());
            preparedStatement.setLong(8, ticket.getVenueCapacity());
            preparedStatement.setLong(9, ticket.getId());
            preparedStatement.setString(10, userData.username);
            preparedStatement.execute();
            DBHandler.commit();
            return true;
        } catch (SQLException | DatabaseException e) {
            DBHandler.rollback();
            return false;
        }
    }

    public boolean deleteTicket(Ticket ticket, UserData userData) {
        return deleteTicket(ticket.getId(), userData);
    }

    public boolean deleteTicket(Long ticketId, UserData userData) {
        //language=SQL
        String DELETE_SQL =  "DELETE FROM TICKETS WHERE id = ? and author = ?";
        try {
            DBHandler.setSavepoint();
            PreparedStatement preparedStatement = DBHandler.getPreparedStatement(DELETE_SQL);
            preparedStatement.setLong(1, ticketId);
            preparedStatement.setString(2, userData.username);
            preparedStatement.execute();
            DBHandler.commit();
            return true;
        } catch (SQLException | DatabaseException e) {
            DBHandler.rollback();
            return false;
        }
    }

    public boolean deleteAllTickets(UserData userData) {
        //language=SQL
        String DELETE_SQL =  "DELETE FROM TICKETS WHERE author = ?";
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

    public Set<Ticket> getTickets() {
        //language=SQL
        String SELECT_SQL =  "SELECT * FROM TICKETS";
        try {
            PreparedStatement preparedStatement = DBHandler.getPreparedStatement(SELECT_SQL);
            preparedStatement.execute();
            return getTicketSet(preparedStatement.getResultSet());
        } catch (SQLException | DatabaseException e) {
            return new HashSet<>();
        }
    }

    public Set<Ticket> getTicketSet(ResultSet resultSet) throws SQLException {
        Set<Ticket> ticketsSet = new HashSet<>();
        while (resultSet.next()) {
            Ticket ticket = new Ticket(
                    resultSet.getLong("id"),
                    resultSet.getString("name"),
                    resultSet.getFloat("coordinateX"),
                    resultSet.getInt("coordinateY"),
                    resultSet.getLong("creationDate"),
                    resultSet.getFloat("price"),
                    resultSet.getString("type"),
                    resultSet.getString("venueName"),
                    resultSet.getLong("venueCapacity"),
                    resultSet.getString("author")
            );
            if (ticket.getPrice() == 0f) {ticket.setPrice(null);}
            ticketsSet.add(ticket);
        }
        return ticketsSet;
    }
}
