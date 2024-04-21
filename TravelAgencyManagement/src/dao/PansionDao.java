package dao; // Declares the package name

import core.Database; // Imports the Database class from the core package
import entity.Pansion; // Imports the Pansion class from the entity package
import java.sql.*; // Imports SQL-related classes
import java.util.ArrayList; // Imports ArrayList class
import java.util.List; // Imports List interface

public class PansionDao { // Declares the PansionDao class

    private Connection connection; // Declares a private Connection variable to manage database connections
    private boolean isAdmin; // Declares a private boolean variable to track admin status

    public PansionDao() { // Constructor for PansionDao class
        connection = Database.connector(); // Initializes the database connection using the Database class
    }

    // Method to find all pansions
    public ArrayList<Pansion> findByAll(){ // Declares a method to find all pansions
        ArrayList<Pansion> pansionList = new ArrayList<>(); // Initializes an ArrayList to store Pansion objects
        String query = "select * from public.pansion order by pansion_id asc"; // SQL query to select all pansions

        try { // Begins a try block to handle potential exceptions
            Statement statement = connection.createStatement(); // Creates a Statement object for executing SQL queries
            ResultSet data = statement.executeQuery(query); // Executes the SQL query and stores the result
            while (data.next()){ // Iterates through the ResultSet
                pansionList.add(match(data)); // Adds a Pansion object to the list by mapping ResultSet data
            }
            return pansionList; // Returns the list of pansions
        } catch (SQLException e) { // Catches any SQLException that occurs
            throw new RuntimeException(e); // Throws a RuntimeException with the caught SQLException
        }
    }

    // Method to map ResultSet data to Pansion object
    public Pansion match(ResultSet data) throws SQLException { // Declares a method to map ResultSet data to Pansion object
        Pansion pansion = new Pansion(); // Initializes a new Pansion object

        // Sets values for each attribute of the Pansion object using ResultSet data
        pansion.setPansion_id(data.getInt("pansion_id"));
        pansion.setPansion_type(data.getString("pansion_type"));

        return pansion; // Returns the mapped Pansion object
    }

    // Method to find pansions by hotel ID
    public Pansion[] findByHotelId(int hotelId) { // Declares a method to find pansions by hotel ID
        List<Pansion> pansionList = new ArrayList<>(); // Initializes a List to store Pansion objects
        String query = "SELECT * FROM public.pansion WHERE pansion_hotel_id = ?"; // SQL query to select pansions by hotel ID

        try { // Begins a try block to handle potential exceptions
            PreparedStatement statement = connection.prepareStatement(query); // Creates a PreparedStatement object
            statement.setInt(1, hotelId); // Sets the hotel ID parameter in the SQL query
            ResultSet data = statement.executeQuery(); // Executes the SQL query and stores the result
            while (data.next()) { // Iterates through the ResultSet
                pansionList.add(match(data)); // Adds a Pansion object to the list by mapping ResultSet data
            }
        } catch (SQLException e) { // Catches any SQLException that occurs
            throw new RuntimeException(e); // Throws a RuntimeException with the caught SQLException
        }

        return pansionList.toArray(new Pansion[0]); // Converts the List to an array and returns it
    }

    // Method to delete a pansion by ID
    public boolean delete(int id){ // Declares a method to delete a pansion by ID
        String query = "delete from public.pansion where pansion_id = ?"; // SQL query to delete a pansion by ID
        try { // Begins a try block to handle potential exceptions
            PreparedStatement preparedStatement = connection.prepareStatement(query); // Creates a PreparedStatement object
            preparedStatement.setInt(1,id); // Sets the pansion ID parameter in the SQL query
            return preparedStatement.executeUpdate() != -1; // Executes the SQL query and returns true if successful
        } catch (SQLException e) { // Catches any SQLException that occurs
            throw new RuntimeException(e); // Throws a RuntimeException with the caught SQLException
        }
    }

    // Method to save a new pansion
    public boolean save(Pansion pansion){ // Declares a method to save a new pansion
        String query = "insert into public.pansion (pansion_type) values (?)"; // SQL query to insert a new pansion
        try { // Begins a try block to handle potential exceptions
            PreparedStatement preparedStatement = connection.prepareStatement(query); // Creates a PreparedStatement object
            preparedStatement.setString(1,pansion.getPansion_type()); // Sets the pansion type parameter in the SQL query
            return preparedStatement.executeUpdate() != -1; // Executes the SQL query and returns true if successful
        } catch (SQLException e) { // Catches any SQLException that occurs
            throw new RuntimeException(e); // Throws a RuntimeException with the caught SQLException
        }
    }

    // Method to update pansion information
    public boolean update(Pansion pansion){ // Declares a method to update pansion information
        String query = "update public.pansion set pansion_type = ?  where pansion_id = ?"; // SQL query to update pansion information
        try { // Begins a try block to handle potential exceptions
            PreparedStatement preparedStatement = connection.prepareStatement(query); // Creates a PreparedStatement object
            preparedStatement.setString(1,pansion.getPansion_type()); // Sets the pansion type parameter in the SQL query
            preparedStatement.setInt(2,pansion.getPansion_id()); // Sets the pansion ID parameter in the SQL query
            return preparedStatement.executeUpdate() != -1; // Executes the SQL query and returns true if successful
        } catch (SQLException e) { // Catches any SQLException that occurs
            throw new RuntimeException(e); // Throws a RuntimeException with the caught SQLException
        }
    }

    // Method to get a pansion by ID
    public Pansion getById(int id){ // Declares a method to get a pansion by ID
        String query = "select * from public.pansion where pansion_id = ?"; // SQL query to select a pansion by ID
        Pansion pansion = null; // Initializes a Pansion object
        try { // Begins a try block to handle potential exceptions
            PreparedStatement preparedStatement = connection.prepareStatement(query); // Creates a PreparedStatement object
            preparedStatement.setInt(1,id); // Sets the pansion ID parameter in the SQL query
            ResultSet data = preparedStatement.executeQuery(); // Executes the SQL query and stores the result
            if(data.next()){ // Checks if the ResultSet has any data
                pansion = match(data); // Maps the ResultSet data to a Pansion object
            }
            return pansion; // Returns the Pansion object
        } catch (SQLException e) { // Catches any SQLException that occurs
            throw new RuntimeException(e); // Throws a RuntimeException with the caught SQLException
        }
    }

    // Method to select pansions by a custom query
    public ArrayList<Pansion> selectByQuery(String query){ // Declares a method to select pansions by a custom query
        ArrayList<Pansion> pansions = new ArrayList<>(); // Initializes an ArrayList to store Pansion objects

        try { // Begins a try block to handle potential exceptions
            ResultSet data = connection.createStatement().executeQuery(query); // Executes the custom SQL query and stores the result
            while (data.next()){ // Iterates through the ResultSet
                pansions.add(match(data)); // Adds a Pansion object to the list by mapping ResultSet data
            }
        } catch (SQLException e) { // Catches any SQLException that occurs
            throw new RuntimeException(e); // Throws a RuntimeException with the caught SQLException
        }

        return pansions; // Returns the list of pansions
    }
}
