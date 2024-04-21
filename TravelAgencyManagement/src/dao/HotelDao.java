package dao; // Declares the package name

import core.Database; // Imports the Database class from the core package
import entity.Hotel; // Imports the Hotel class from the entity package
import java.sql.*; // Imports SQL-related classes
import java.util.ArrayList; // Imports ArrayList class

public class HotelDao { // Declares the HotelDao class

    private Connection connection; // Declares a private Connection variable to manage database connections
    private boolean isAdmin; // Declares a private boolean variable to track admin status

    public HotelDao() { // Constructor for HotelDao class
        connection = Database.connector(); // Initializes the database connection using the Database class
    }

    // Method to find all hotels
    public ArrayList<Hotel> findByAll(){ // Declares a method to find all hotels
        ArrayList<Hotel> list = new ArrayList<>(); // Initializes an ArrayList to store Hotel objects
        String query = "select * from public.hotel order by hotel_id asc"; // SQL query to select all hotels

        try { // Begins a try block to handle potential exceptions
            Statement statement = connection.createStatement(); // Creates a Statement object for executing SQL queries
            ResultSet data = statement.executeQuery(query); // Executes the SQL query and stores the result
            while (data.next()){ // Iterates through the ResultSet
                list.add(match(data)); // Adds a Hotel object to the list by mapping ResultSet data
            }
            return list; // Returns the list of hotels
        } catch (SQLException e) { // Catches any SQLException that occurs
            throw new RuntimeException(e); // Throws a RuntimeException with the caught SQLException
        }
    }

    // Method to map ResultSet data to Hotel object
    public Hotel match(ResultSet data) throws SQLException { // Declares a method to map ResultSet data to Hotel object
        Hotel hotel = new Hotel(); // Initializes a new Hotel object

        // Sets values for each attribute of the Hotel object using ResultSet data
        hotel.setHotel_id(data.getInt("hotel_id"));
        hotel.setHotel_name(data.getString("hotel_name"));
        hotel.setHotel_city(data.getString("hotel_city"));
        hotel.setHotel_region(data.getString("hotel_region"));
        hotel.setHotel_fulladres(data.getString("hotel_fulladress"));
        hotel.setHotel_mail(data.getString("hotel_email"));
        hotel.setHotel_phone(data.getString("hotel_phone"));
        hotel.setHotel_star(data.getString("hotel_star"));
        hotel.setHotel_free_parking(data.getBoolean("hotel_free_parking"));
        hotel.setHotel_free_wifi(data.getBoolean("hotel_free_wifi"));
        hotel.setHotel_swimming_pool(data.getBoolean("hotel_swimming_pool"));
        hotel.setHotel_fitness_center(data.getBoolean("hotel_fitness_center"));
        hotel.setHotel_concierge(data.getBoolean("hotel_concierge"));
        hotel.setHotel_spa(data.getBoolean("hotel_spa"));
        hotel.setHotel_room_services(data.getBoolean("hotel_room_services"));

        // Converts hotel_pansion_type data
        Array pansionTypeArray = data.getArray("hotel_pansion_type");
        if (pansionTypeArray != null) { // Checks if the pansionTypeArray is not null
            Object[] pansionTypeObjects = (Object[]) pansionTypeArray.getArray(); // Retrieves the array of pansion types
            String[] pansionTypes = new String[pansionTypeObjects.length]; // Initializes an array to store pansion types
            for (int i = 0; i < pansionTypeObjects.length; i++) { // Iterates through the pansion type objects
                pansionTypes[i] = String.valueOf(pansionTypeObjects[i]); // Converts each pansion type object to a String
            }
            hotel.setHotel_pansion_type(pansionTypes); // Sets the pansion types for the hotel
        }

        return hotel; // Returns the mapped Hotel object
    }

    // Method to delete a hotel by ID
    public boolean delete(int id){ // Declares a method to delete a hotel by ID
        String query = "delete from public.hotel where hotel_id = ?"; // SQL query to delete a hotel by ID
        try { // Begins a try block to handle potential exceptions
            PreparedStatement preparedStatement = connection.prepareStatement(query); // Creates a PreparedStatement object
            preparedStatement.setInt(1,id); // Sets the hotel ID parameter in the SQL query
            return preparedStatement.executeUpdate() != -1; // Executes the SQL query and returns true if successful
        } catch (SQLException e) { // Catches any SQLException that occurs
            throw new RuntimeException(e); // Throws a RuntimeException with the caught SQLException
        }
    }

    // Method to save a new hotel
    public boolean save(Hotel hotel){ // Declares a method to save a new hotel
        String query = "insert into public.hotel (hotel_name,hotel_city,hotel_region,hotel_fulladress," +
                "hotel_email,hotel_phone,hotel_star,hotel_free_parking,hotel_free_wifi,hotel_swimming_pool," +
                "hotel_fitness_center,hotel_concierge,hotel_spa,hotel_room_services,hotel_pansion_type) " +
                "values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)"; // SQL query to insert a new hotel
        try { // Begins a try block to handle potential exceptions
            PreparedStatement preparedStatement = connection.prepareStatement(query); // Creates a PreparedStatement object
            // Sets parameters for the SQL query using data from the Hotel object
            preparedStatement.setString(1,hotel.getHotel_name());
            preparedStatement.setString(2,hotel.getHotel_city());
            preparedStatement.setString(3,hotel.getHotel_region());
            preparedStatement.setString(4,hotel.getHotel_fulladres());
            preparedStatement.setString(5,hotel.getHotel_mail());
            preparedStatement.setString(6,hotel.getHotel_phone());
            preparedStatement.setString(7,hotel.getHotel_star());
            preparedStatement.setBoolean(8,hotel.isHotel_free_parking());
            preparedStatement.setBoolean(9,hotel.isHotel_free_wifi());
            preparedStatement.setBoolean(10,hotel.isHotel_swimming_pool());
            preparedStatement.setBoolean(11,hotel.isHotel_fitness_center());
            preparedStatement.setBoolean(12,hotel.isHotel_concierge());
            preparedStatement.setBoolean(13,hotel.isHotel_spa());
            preparedStatement.setBoolean(14,hotel.isHotel_room_services());
            // Converts hotel_pansion_type to appropriate format and sets it as a parameter
            Array pansionTypeArray = connection.createArrayOf("text", hotel.getHotel_pansion_type());
            preparedStatement.setArray(15, pansionTypeArray);
            return preparedStatement.executeUpdate() != -1; // Executes the SQL query and returns true if successful
        } catch (SQLException e) { // Catches any SQLException that occurs
            throw new RuntimeException(e); // Throws a RuntimeException with the caught SQLException
        }
    }

    // Method to update hotel information
    public boolean update(Hotel hotel) { // Declares a method to update hotel information
        String query = "update public.hotel set hotel_name = ?, hotel_city = ?, hotel_region = ?, " +
                "hotel_fulladress = ?, hotel_email = ?, hotel_phone = ?, hotel_star = ?, hotel_free_parking = ?," +
                "hotel_free_wifi = ?, hotel_swimming_pool = ?, hotel_fitness_center = ?, hotel_concierge = ?, " +
                "hotel_spa = ?, hotel_room_services = ?, hotel_pansion_type = ? where hotel_id = ?"; // SQL query to update hotel information
        try { // Begins a try block to handle potential exceptions
            PreparedStatement preparedStatement = connection.prepareStatement(query); // Creates a PreparedStatement object
            // Sets parameters for the SQL query using data from the Hotel object
            preparedStatement.setString(1, hotel.getHotel_name());
            preparedStatement.setString(2, hotel.getHotel_city());
            preparedStatement.setString(3, hotel.getHotel_region());
            preparedStatement.setString(4, hotel.getHotel_fulladres());
            preparedStatement.setString(5, hotel.getHotel_mail());
            preparedStatement.setString(6, hotel.getHotel_phone());
            preparedStatement.setString(7, hotel.getHotel_star());
            preparedStatement.setBoolean(8, hotel.isHotel_free_parking());
            preparedStatement.setBoolean(9, hotel.isHotel_free_wifi());
            preparedStatement.setBoolean(10, hotel.isHotel_swimming_pool());
            preparedStatement.setBoolean(11, hotel.isHotel_fitness_center());
            preparedStatement.setBoolean(12, hotel.isHotel_concierge());
            preparedStatement.setBoolean(13, hotel.isHotel_spa());
            preparedStatement.setBoolean(14, hotel.isHotel_room_services());
            // Converts hotel_pansion_type to appropriate format and sets it as a parameter
            Array pansionTypeArray = connection.createArrayOf("text", hotel.getHotel_pansion_type());
            preparedStatement.setArray(15, pansionTypeArray);
            preparedStatement.setInt(16, hotel.getHotel_id()); // Sets the hotel ID parameter in the SQL query
            return preparedStatement.executeUpdate() != -1; // Executes the SQL query and returns true if successful
        } catch (SQLException e) { // Catches any SQLException that occurs
            throw new RuntimeException(e); // Throws a RuntimeException with the caught SQLException
        }
    }

    // Method to get a hotel by ID
    public Hotel getById(int id){ // Declares a method to get a hotel by ID
        String query = "select * from public.hotel where hotel_id = ?"; // SQL query to select a hotel by ID
        Hotel hotel = null; // Initializes a Hotel object
        try { // Begins a try block to handle potential exceptions
            PreparedStatement preparedStatement = connection.prepareStatement(query); // Creates a PreparedStatement object
            preparedStatement.setInt(1,id); // Sets the hotel ID parameter in the SQL query
            ResultSet data = preparedStatement.executeQuery(); // Executes the SQL query and stores the result
            if(data.next()){ // Checks if the ResultSet has any data
                hotel = match(data); // Maps the ResultSet data to a Hotel object
            }
            return hotel; // Returns the Hotel object
        } catch (SQLException e) { // Catches any SQLException that occurs
            throw new RuntimeException(e); // Throws a RuntimeException with the caught SQLException
        }
    }

    // Method to get hotel ID by name
    public int getHotelIdByName (String hotelName){ // Declares a method to get hotel ID by name
        String query = "select hotel_id from public.hotel where hotel_name = ?"; // SQL query to select hotel ID by name
        int hotel =0; // Initializes a variable to store the hotel ID
        try { // Begins a try block to handle potential exceptions
            PreparedStatement preparedStatement = connection.prepareStatement(query); // Creates a PreparedStatement object
            preparedStatement.setString(1,hotelName); // Sets the hotel name parameter in the SQL query
            ResultSet data = preparedStatement.executeQuery(); // Executes the SQL query and stores the result
            if(data.next()){ // Checks if the ResultSet has any data
                hotel = data.getInt("hotel_id"); // Retrieves the hotel ID from the ResultSet
            }
            return hotel; // Returns the hotel ID
        }catch (SQLException e){ // Catches any SQLException that occurs
            throw new RuntimeException(e); // Throws a RuntimeException with the caught SQLException
        }
    }
}
