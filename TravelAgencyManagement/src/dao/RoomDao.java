package dao; // Declares the package name

import core.Database; // Imports the Database class from the core package
import entity.Room; // Imports the Room class from the entity package
import java.sql.*; // Imports SQL-related classes
import java.util.ArrayList; // Imports ArrayList class

public class RoomDao { // Declares the RoomDao class

    private Connection connection; // Declares a private Connection variable to manage database connections
    private boolean isAdmin; // Declares a private boolean variable to track admin status

    public RoomDao() { // Constructor for RoomDao class
        connection = Database.connector(); // Initializes the database connection using the Database class
    }

    // Method to find all rooms
    public ArrayList<Room> findByAll(){ // Declares a method to find all rooms
        ArrayList<Room> roomList = new ArrayList<>(); // Initializes an ArrayList to store Room objects
        String query = "select * from public.room order by room_id asc"; // SQL query to select all rooms

        try { // Begins a try block to handle potential exceptions
            Statement statement = connection.createStatement(); // Creates a Statement object for executing SQL queries
            ResultSet data = statement.executeQuery(query); // Executes the SQL query and stores the result
            while (data.next()){ // Iterates through the ResultSet
                roomList.add(match(data)); // Adds a Room object to the list by mapping ResultSet data
            }
            return roomList; // Returns the list of rooms
        } catch (SQLException e) { // Catches any SQLException that occurs
            throw new RuntimeException(e); // Throws a RuntimeException with the caught SQLException
        }
    }

    // Method to map ResultSet data to Room object
    public Room match(ResultSet data) throws SQLException { // Declares a method to map ResultSet data to Room object
        Room room = new Room(); // Initializes a new Room object

        // Sets values for each attribute of the Room object using ResultSet data
        room.setRoom_id(data.getInt("room_id"));
        room.setRoom_hotel_id(data.getInt("room_hotel_id"));
        room.setRoom_seasson_id(data.getInt("room_season_id"));
        room.setRoom_pansion_type(data.getString("room_pansion_type"));
        room.setRoomType(Room.Type.valueOf(data.getString("room_type")));
        room.setRoom_number(data.getString("room_number"));
        room.setRoom_capacity(data.getInt("room_capacity"));
        room.setRoom_adult_price(data.getInt("room_adult_price"));
        room.setRoom_child_price(data.getInt("room_child_price"));
        room.setRoom_stock_quantity(data.getInt("room_stock_quantity"));
        room.setRoom_bed_count(data.getInt("room_bed_count"));
        room.setRoom_square_meters(data.getInt("room_square_meters"));
        room.setRoom_has_tv(data.getBoolean("room_has_tv"));
        room.setRoom_has_mini_bar(data.getBoolean("room_has_mini_bar"));
        room.setRoom_has_gaming_console(data.getBoolean("room_has_gaming_console"));
        room.setRoom_has_safe_box(data.getBoolean("room_has_safe_box"));
        room.setRoom_has_projector(data.getBoolean("room_has_projector"));

        return room; // Returns the mapped Room object
    }

    // Method to delete a room by ID
    public boolean delete(int id){ // Declares a method to delete a room by ID
        String query = "delete from public.room where room_id = ?"; // SQL query to delete a room by ID
        try { // Begins a try block to handle potential exceptions
            PreparedStatement preparedStatement = connection.prepareStatement(query); // Creates a PreparedStatement object
            preparedStatement.setInt(1,id); // Sets the room ID parameter in the SQL query
            return preparedStatement.executeUpdate() != -1; // Executes the SQL query and returns true if successful
        } catch (SQLException e) { // Catches any SQLException that occurs
            throw new RuntimeException(e); // Throws a RuntimeException with the caught SQLException
        }
    }

    // Method to save a new room
    public boolean save(Room room){ // Declares a method to save a new room
        String query = "insert into public.room " +
                "(room_hotel_id,room_season_id," +
                "room_pansion_type,room_type,room_number," +
                "room_capacity,room_adult_price,room_child_price," +
                "room_stock_quantity,room_bed_count,room_square_meters" +
                ",room_has_tv,room_has_mini_bar," +
                "room_has_gaming_console,room_has_safe_box,room_has_projector)" +
                " values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)"; // SQL query to insert a new room
        try { // Begins a try block to handle potential exceptions
            PreparedStatement preparedStatement = connection.prepareStatement(query); // Creates a PreparedStatement object
            // Sets values for each parameter in the SQL query using Room object attributes
            preparedStatement.setInt(1,room.getRoom_hotel_id());
            preparedStatement.setInt(2,room.getRoom_seasson_id());
            preparedStatement.setString(3,room.getRoom_pansion_type());
            preparedStatement.setString(4, String.valueOf(room.getRoomType()));
            preparedStatement.setString(5,room.getRoom_number());
            preparedStatement.setInt(6,room.getRoom_capacity());
            preparedStatement.setInt(7,room.getRoom_adult_price());
            preparedStatement.setInt(8,room.getRoom_child_price());
            preparedStatement.setInt(9,room.getRoom_stock_quantity());
            preparedStatement.setInt(10,room.getRoom_bed_count());
            preparedStatement.setInt(11,room.getRoom_square_meters());
            preparedStatement.setBoolean(12,room.isRoom_has_tv());
            preparedStatement.setBoolean(13,room.isRoom_has_mini_bar());
            preparedStatement.setBoolean(14,room.isRoom_has_gaming_console());
            preparedStatement.setBoolean(15,room.isRoom_has_safe_box());
            preparedStatement.setBoolean(16,room.isRoom_has_projector());

            return preparedStatement.executeUpdate() != -1; // Executes the SQL query and returns true if successful
        } catch (SQLException e) { // Catches any SQLException that occurs
            throw new RuntimeException(e); // Throws a RuntimeException with the caught SQLException
        }
    }

    // Method to save a reservation for a room
    public boolean saveReservation(Room room){ // Declares a method to save a reservation for a room
        String query = "update public.room set room_reservation_id = ? where room_id = ?"; // SQL query to update room reservation
        try { // Begins a try block to handle potential exceptions
            PreparedStatement preparedStatement = connection.prepareStatement(query); // Creates a PreparedStatement object
            preparedStatement.setInt(1,room.getRoom_reservation_id()); // Sets the reservation ID parameter in the SQL query
            preparedStatement.setInt(2,room.getRoom_id()); // Sets the room ID parameter in the SQL query
            return preparedStatement.executeUpdate() != -1; // Executes the SQL query and returns true if successful
        } catch (SQLException e) { // Catches any SQLException that occurs
            throw new RuntimeException(e); // Throws a RuntimeException with the caught SQLException
        }
    }

    // Method to update room information
    public boolean update(Room room){ // Declares a method to update room information
        String query = "update public.room set " +
                "room_hotel_id = ? , room_season_id = ? ,room_pansion_type = ?, room_type = ?, " +
                "room_number = ? , room_capacity = ?, room_adult_price = ? ,room_child_price = ? ," +
                "room_stock_quantity = ?,room_bed_count = ?,room_square_meters = ?,room_has_tv = ?," +
                " room_has_mini_bar = ?,room_has_gaming_console = ?,room_has_safe_box = ?,room_has_projector = ? " +
                "where room_id = ?"; // SQL query to update room information
        try { // Begins a try block to handle potential exceptions
            PreparedStatement preparedStatement = connection.prepareStatement(query); // Creates a PreparedStatement object
            // Sets values for each parameter in the SQL query using Room object attributes
            preparedStatement.setInt(1,room.getRoom_hotel_id());
            preparedStatement.setInt(2,room.getRoom_seasson_id());
            preparedStatement.setString(3,room.getRoom_pansion_type());
            preparedStatement.setString(4, String.valueOf(room.getRoomType()));
            preparedStatement.setString(5,room.getRoom_number());
            preparedStatement.setInt(6,room.getRoom_capacity());
            preparedStatement.setInt(7,room.getRoom_adult_price());
            preparedStatement.setInt(8,room.getRoom_child_price());
            preparedStatement.setInt(9,room.getRoom_stock_quantity());
            preparedStatement.setInt(10,room.getRoom_bed_count());
            preparedStatement.setInt(11,room.getRoom_square_meters());
            preparedStatement.setBoolean(12,room.isRoom_has_tv());
            preparedStatement.setBoolean(13,room.isRoom_has_mini_bar());
            preparedStatement.setBoolean(14,room.isRoom_has_gaming_console());
            preparedStatement.setBoolean(15,room.isRoom_has_safe_box());
            preparedStatement.setBoolean(16,room.isRoom_has_projector());
            preparedStatement.setInt(17,room.getRoom_id()); // Sets the room ID parameter in the SQL query
            return preparedStatement.executeUpdate() != -1; // Executes the SQL query and returns true if successful
        } catch (SQLException e) { // Catches any SQLException that occurs
            throw new RuntimeException(e); // Throws a RuntimeException with the caught SQLException
        }
    }

    // Method to get a room by ID
    public Room getById(int id){ // Declares a method to get a room by ID
        String query = "select * from public.room where room_id = ?"; // SQL query to select a room by ID
        Room room = null; // Initializes a Room object
        try { // Begins a try block to handle potential exceptions
            PreparedStatement preparedStatement = connection.prepareStatement(query); // Creates a PreparedStatement object
            preparedStatement.setInt(1,id); // Sets the room ID parameter in the SQL query
            ResultSet data = preparedStatement.executeQuery(); // Executes the SQL query and stores the result
            if(data.next()){ // Checks if the ResultSet has data
                room = match(data); // Maps the ResultSet data to a Room object
            }
            return room; // Returns the Room object
        } catch (SQLException e) { // Catches any SQLException that occurs
            throw new RuntimeException(e); // Throws a RuntimeException with the caught SQLException
        }
    }

    // Method to select rooms by a custom query
    public ArrayList<Room> selectByQuery(String query){ // Declares a method to select rooms by a custom query
        ArrayList<Room> rooms = new ArrayList<>(); // Initializes an ArrayList to store Room objects
        try { // Begins a try block to handle potential exceptions
            ResultSet data = connection.createStatement().executeQuery(query); // Executes the custom SQL query and stores the result
            while (data.next()){ // Iterates through the ResultSet
                rooms.add(match(data)); // Adds a Room object to the list by mapping ResultSet data
            }
        } catch (SQLException e) { // Catches any SQLException that occurs
            throw new RuntimeException(e); // Throws a RuntimeException with the caught SQLException
        }
        return rooms; // Returns the list of rooms
    }

    // Method to get rooms by hotel ID
    public ArrayList<Room> getHotelId(int id){ // Declares a method to get rooms by hotel ID
        return selectByQuery("select * from public.room where room_hotel_id =" + id); // Calls selectByQuery method with a custom SQL query
    }

    // Method to get rooms by season ID
    public ArrayList<Room> getSeasonId(int id){ // Declares a method to get rooms by season ID
        return selectByQuery("select * from public.room where room_season_id =" + id); // Calls selectByQuery method with a custom SQL query
    }

    // Method to check room stock quantity
    public boolean stockCheck(Room room){ // Declares a method to check room stock quantity
        String query = "update public.room set room_stock_quantity = ? where room_id = ?"; // SQL query to update room stock quantity
        PreparedStatement preparedStatement = null; // Initializes a PreparedStatement variable
        try { // Begins a try block to handle potential exceptions
            preparedStatement = connection.prepareStatement(query); // Creates a PreparedStatement object
            preparedStatement.setInt(1,room.getRoom_stock_quantity()); // Sets the stock quantity parameter in the SQL query
            preparedStatement.setInt(2,room.getRoom_id()); // Sets the room ID parameter in the SQL query
            return preparedStatement.executeUpdate() != -1; // Executes the SQL query and returns true if successful
        } catch (SQLException e) { // Catches any SQLException that occurs
            throw new RuntimeException(e); // Throws a RuntimeException with the caught SQLException
        }
    }
}
