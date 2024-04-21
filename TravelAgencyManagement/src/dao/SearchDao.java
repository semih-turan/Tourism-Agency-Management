package dao; // Declares the package name

import core.Database; // Imports the Database class from the core package
import entity.Search; // Imports the Search class from the entity package

import java.sql.*; // Imports SQL-related classes
import java.util.ArrayList; // Imports ArrayList class

public class SearchDao { // Declares the SearchDao class

    private Connection connection; // Declares a private Connection variable to manage database connections

    public SearchDao() { // Constructor for SearchDao class
        connection = Database.connector(); // Initializes the database connection using the Database class
    }

    // Method to find all search results
    public ArrayList<Search> findByAll(){ // Declares a method to find all search results
        ArrayList<Search> list = new ArrayList<>(); // Initializes an ArrayList to store Search objects
        String query = "SELECT *\n" +
                "FROM public.hotel_room_season_table AS t1\n" +
                "WHERE room_id = (\n" +
                "    SELECT MIN(room_id)\n" +
                "    FROM public.hotel_room_season_table AS t2\n" +
                "    WHERE t1.season_id = t2.season_id\n" +
                ");"; // SQL query to select all search results

        try { // Begins a try block to handle potential exceptions
            Statement statement = connection.createStatement(); // Creates a Statement object for executing SQL queries
            ResultSet data = statement.executeQuery(query); // Executes the SQL query and stores the result
            while (data.next()){ // Iterates through the ResultSet
                list.add(match(data)); // Adds a Search object to the list by mapping ResultSet data
            }
            return list; // Returns the list of search results
        } catch (SQLException e) { // Catches any SQLException that occurs
            throw new RuntimeException(e); // Throws a RuntimeException with the caught SQLException
        }
    }

    // Method to map ResultSet data to Search object
    public Search match(ResultSet data) throws SQLException { // Declares a method to map ResultSet data to Search object
        Search search = new Search(); // Initializes a new Search object

        // Sets values for each attribute of the Search object using ResultSet data
        search.setRoom_seasson_id(data.getInt("room_season_id"));
        search.setRoom_id(data.getInt("room_id"));
        search.setHotel_id(data.getInt("hotel_id"));
        search.setHotel_name(data.getString("hotel_name"));
        search.setHotel_city(data.getString("hotel_city"));
        search.setSeason_start_date(data.getDate("season_start_date").toLocalDate());
        search.setSeason_end_date(data.getDate("season_end_date").toLocalDate());
        search.setRoom_pansion_type(data.getString("room_pansion_type"));
        search.setRoom_stock_quantity(data.getInt("room_stock_quantity"));
        search.setRoom_adult_price(data.getInt("room_adult_price"));
        search.setRoom_child_price(data.getInt("room_child_price"));

        return search; // Returns the mapped Search object
    }

    // Method to select search results by a custom query
    public ArrayList<Search> selectByQuery(String query){ // Declares a method to select search results by a custom query
        ArrayList<Search> searches = new ArrayList<>(); // Initializes an ArrayList to store Search objects
        try { // Begins a try block to handle potential exceptions
            ResultSet data = connection.createStatement().executeQuery(query); // Executes the custom SQL query and stores the result
            while (data.next()){ // Iterates through the ResultSet
                searches.add(match(data)); // Adds a Search object to the list by mapping ResultSet data
            }
        } catch (SQLException e) { // Catches any SQLException that occurs
            throw new RuntimeException(e); // Throws a RuntimeException with the caught SQLException
        }
        return searches; // Returns the list of search results
    }

    // Method to get a search result by ID
    public Search getById(int id){ // Declares a method to get a search result by ID
        String query = "select * from public.hotel_room_season_table where season_id = ?"; // SQL query to select a search result by ID
        Search search = null; // Initializes a Search object
        try { // Begins a try block to handle potential exceptions
            PreparedStatement preparedStatement = connection.prepareStatement(query); // Creates a PreparedStatement object
            preparedStatement.setInt(1,id); // Sets the season ID parameter in the SQL query
            ResultSet data = preparedStatement.executeQuery(); // Executes the SQL query and stores the result
            if(data.next()){ // Checks if the ResultSet has data
                search = match(data); // Maps the ResultSet data to a Search object
            }
            return search; // Returns the Search object
        } catch (SQLException e) { // Catches any SQLException that occurs
            throw new RuntimeException(e); // Throws a RuntimeException with the caught SQLException
        }
    }
}
