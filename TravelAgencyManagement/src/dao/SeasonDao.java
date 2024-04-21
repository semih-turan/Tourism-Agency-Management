package dao; // Declares the package name

import core.Database; // Imports the Database class from the core package
import entity.Season; // Imports the Season class from the entity package
import java.sql.*; // Imports SQL-related classes
import java.util.ArrayList; // Imports ArrayList class

public class SeasonDao { // Declares the SeasonDao class

    private Connection connection; // Declares a private Connection variable to manage database connections

    public SeasonDao() { // Constructor for SeasonDao class
        connection = Database.connector(); // Initializes the database connection using the Database class
    }

    // Method to find all seasons
    public ArrayList<Season> findByAll(){ // Declares a method to find all seasons
        ArrayList<Season> list = new ArrayList<>(); // Initializes an ArrayList to store Season objects
        String query = "select * from public.season order by season_id asc"; // SQL query to select all seasons

        try { // Begins a try block to handle potential exceptions
            Statement statement = connection.createStatement(); // Creates a Statement object for executing SQL queries
            ResultSet data = statement.executeQuery(query); // Executes the SQL query and stores the result
            while (data.next()){ // Iterates through the ResultSet
                list.add(match(data)); // Adds a Season object to the list by mapping ResultSet data
            }
            return list; // Returns the list of seasons
        } catch (SQLException e) { // Catches any SQLException that occurs
            throw new RuntimeException(e); // Throws a RuntimeException with the caught SQLException
        }
    }

    // Method to map ResultSet data to Season object
    public Season match(ResultSet data) throws SQLException { // Declares a method to map ResultSet data to Season object
        Season season = new Season(); // Initializes a new Season object

        // Sets values for each attribute of the Season object using ResultSet data
        season.setSeason_id(data.getInt("season_id"));
        season.setSeason_hotel_id(data.getInt("season_hotel_id"));
        season.setSeason_start_date(data.getDate("season_start_date").toLocalDate());
        season.setSeason_end_date(data.getDate("season_end_date").toLocalDate());
        season.setSeasonName(Season.SeasonName.valueOf(data.getString("season_name")));
        season.setHotelName(data.getString("season_hotel_name"));

        return season; // Returns the mapped Season object
    }

    // Method to delete a season by ID
    public boolean delete(int id){ // Declares a method to delete a season by ID
        String query = "delete from public.season where season_id = ?"; // SQL query to delete a season by ID
        try { // Begins a try block to handle potential exceptions
            PreparedStatement preparedStatement = connection.prepareStatement(query); // Creates a PreparedStatement object
            preparedStatement.setInt(1,id); // Sets the season ID parameter in the SQL query
            return preparedStatement.executeUpdate() != -1; // Executes the SQL query and returns true if successful
        } catch (SQLException e) { // Catches any SQLException that occurs
            throw new RuntimeException(e); // Throws a RuntimeException with the caught SQLException
        }
    }

    // Method to save a new season
    public boolean save(Season season){ // Declares a method to save a new season
        String query = "insert into public.season (season_hotel_id,season_start_date,season_end_date," +
                "season_name,season_hotel_name) values (?,?,?,?,?)"; // SQL query to insert a new season
        try { // Begins a try block to handle potential exceptions
            PreparedStatement preparedStatement = connection.prepareStatement(query); // Creates a PreparedStatement object
            preparedStatement.setInt(1,season.getSeason_hotel_id()); // Sets the season hotel ID parameter
            preparedStatement.setDate(2,Date.valueOf(season.getSeason_start_date())); // Sets the season start date parameter
            preparedStatement.setDate(3,Date.valueOf(season.getSeason_end_date())); // Sets the season end date parameter
            preparedStatement.setString(4, String.valueOf(season.getSeasonName())); // Sets the season name parameter
            preparedStatement.setString(5, season.getHotelName()); // Sets the season hotel name parameter

            return preparedStatement.executeUpdate() != -1; // Executes the SQL query and returns true if successful
        } catch (SQLException e) { // Catches any SQLException that occurs
            throw new RuntimeException(e); // Throws a RuntimeException with the caught SQLException
        }
    }

    // Method to update an existing season
    public boolean update(Season season){ // Declares a method to update an existing season
        String query = "update public.season set season_hotel_id = ? , season_start_date = ? , " +
                "season_end_date = ?, season_name = ?,season_hotel_name = ? where season_id = ?"; // SQL query to update a season
        try { // Begins a try block to handle potential exceptions
            PreparedStatement preparedStatement = connection.prepareStatement(query); // Creates a PreparedStatement object
            preparedStatement.setInt(1,season.getSeason_hotel_id()); // Sets the season hotel ID parameter
            preparedStatement.setDate(2,Date.valueOf(season.getSeason_start_date())); // Sets the season start date parameter
            preparedStatement.setDate(3,Date.valueOf(season.getSeason_end_date())); // Sets the season end date parameter
            preparedStatement.setString(4, String.valueOf(season.getSeasonName())); // Sets the season name parameter
            preparedStatement.setString(5, season.getHotelName()); // Sets the season hotel name parameter
            preparedStatement.setInt(6,season.getSeason_id()); // Sets the season ID parameter

            return preparedStatement.executeUpdate() != -1; // Executes the SQL query and returns true if successful
        } catch (SQLException e) { // Catches any SQLException that occurs
            throw new RuntimeException(e); // Throws a RuntimeException with the caught SQLException
        }
    }

    // Method to get a season by ID
    public Season getById(int id){ // Declares a method to get a season by ID
        String query = "select * from public.season where season_id = ?"; // SQL query to select a season by ID
        Season season = null; // Initializes a Season object
        try { // Begins a try block to handle potential exceptions
            PreparedStatement preparedStatement = connection.prepareStatement(query); // Creates a PreparedStatement object
            preparedStatement.setInt(1,id); // Sets the season ID parameter in the SQL query
            ResultSet data = preparedStatement.executeQuery(); // Executes the SQL query and stores the result
            if(data.next()){ // Checks if the ResultSet has data
                season = match(data); // Maps the ResultSet data to a Season object
            }
            return season; // Returns the Season object
        } catch (SQLException e) { // Catches any SQLException that occurs
            throw new RuntimeException(e); // Throws a RuntimeException with the caught SQLException
        }
    }

    // Method to get the hotel name by its ID
    public Season getByHotel(int id){ // Declares a method to get the hotel name by its ID
        String query = "select public.hotel_name from public.hotel where hotel_id = ?"; // SQL query to select the hotel name by its ID
        Season season = null; // Initializes a Season object
        try { // Begins a try block to handle potential exceptions
            PreparedStatement preparedStatement = connection.prepareStatement(query); // Creates a PreparedStatement object
            preparedStatement.setInt(1,id); // Sets the hotel ID parameter in the SQL query
            ResultSet data = preparedStatement.executeQuery(); // Executes the SQL query and stores the result
            if(data.next()){ // Checks if the ResultSet has data
                season = getHotelName(data); // Retrieves the hotel name from the ResultSet
            }
            return season; // Returns the Season object
        } catch (SQLException e) { // Catches any SQLException that occurs
            throw new RuntimeException(e); // Throws a RuntimeException with the caught SQLException
        }
    }

    // Method to get only the hotel name
    public Season getHotelName(ResultSet data) throws SQLException { // Declares a method to get only the hotel name
        Season season = new Season(); // Initializes a new Season object

        season.setHotelName(data.getString("hotel_name")); // Sets the hotel name using ResultSet data
        return season; // Returns the Season object
    }

    // Method to get the season ID by its name
    public int getSeasonIdBySeasonName (String seasonName){ // Declares a method to get the season ID by its name
        String query = "select season_id from public.season where season_name = ?"; // SQL query to select the season ID by its name
        int season =0; // Initializes an integer variable to store the season ID
        try { // Begins a try block to handle potential exceptions
            PreparedStatement preparedStatement = connection.prepareStatement(query); // Creates a PreparedStatement object
            preparedStatement.setString(1,seasonName); // Sets the season name parameter in the SQL query
            ResultSet data = preparedStatement.executeQuery(); // Executes the SQL query and stores the result
            if(data.next()){ // Checks if the ResultSet has data
                season = data.getInt("season_id"); // Retrieves the season ID from the ResultSet
            }
            return season; // Returns the season ID
        }catch (SQLException e){ // Catches any SQLException that occurs
            throw new RuntimeException(e); // Throws a RuntimeException with the caught SQLException
        }
    }

    // Method to select seasons by a custom query
    public ArrayList<Season> selectByQuery(String query){ // Declares a method to select seasons by a custom query
        ArrayList<Season> seasons = new ArrayList<>(); // Initializes an ArrayList to store Season objects
        try { // Begins a try block to handle potential exceptions
            ResultSet data = connection.createStatement().executeQuery(query); // Executes the custom SQL query and stores the result
            while (data.next()){ // Iterates through the ResultSet
                seasons.add(match(data)); // Adds a Season object to the list by mapping ResultSet data
            }
        } catch (SQLException e) { // Catches any SQLException that occurs
            throw new RuntimeException(e); // Throws a RuntimeException with the caught SQLException
        }
        return seasons; // Returns the list of seasons
    }

    // Method to get seasons by hotel ID
    public ArrayList<Season> getHotelId(int id){ // Declares a method to get seasons by hotel ID
        return selectByQuery("select * from public.season where season_hotel_id =" + id); // Returns the seasons selected by the given hotel ID
    }
}
