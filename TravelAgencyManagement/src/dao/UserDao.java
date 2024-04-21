package dao; // Declares the package name

import core.Database; // Imports the Database class from the core package
import entity.User; // Imports the User class from the entity package
import java.sql.*; // Imports SQL-related classes
import java.util.ArrayList; // Imports ArrayList class

public class UserDao { // Declares the UserDao class

    private Connection connection; // Declares a private Connection variable to manage database connections
    private boolean isAdmin; // Declares a private boolean variable to store admin status

    public UserDao() { // Constructor for UserDao class
        connection = Database.connector(); // Initializes the database connection using the Database class
    }

    // Method to authenticate user login
    public User login(String username,String password){ // Declares a method to authenticate user login
        User user = null; // Initializes a User object
        String query = "select * from public.users where user_name = ?  and user_pass = ?"; // SQL query to authenticate user login
        try { // Begins a try block to handle potential exceptions
            PreparedStatement preparedStatement = connection.prepareStatement(query); // Creates a PreparedStatement object
            preparedStatement.setString(1,username); // Sets the username parameter in the SQL query
            preparedStatement.setString(2,password); // Sets the password parameter in the SQL query
            ResultSet data = preparedStatement.executeQuery(); // Executes the SQL query and stores the result
            if(data.next()){ // Checks if the ResultSet has data
                user = match(data); // Maps the ResultSet data to a User object
                System.out.println("Information correct"); // Prints a message indicating correct login information
            }
            return user; // Returns the User object
        } catch (SQLException e) { // Catches any SQLException that occurs
            throw new RuntimeException(e); // Throws a RuntimeException with the caught SQLException
        }
    }

    // Method to find all users
    public ArrayList<User> findByAll(){ // Declares a method to find all users
        ArrayList<User> list = new ArrayList<>(); // Initializes an ArrayList to store User objects
        String query = "select * from public.users order by user_id asc"; // SQL query to select all users

        try { // Begins a try block to handle potential exceptions
            Statement statement = connection.createStatement(); // Creates a Statement object for executing SQL queries
            ResultSet data = statement.executeQuery(query); // Executes the SQL query and stores the result
            while (data.next()){ // Iterates through the ResultSet
                list.add(match(data)); // Adds a User object to the list by mapping ResultSet data
            }
            return list; // Returns the list of users
        } catch (SQLException e) { // Catches any SQLException that occurs
            throw new RuntimeException(e); // Throws a RuntimeException with the caught SQLException
        }
    }

    // Method to map ResultSet data to User object
    public User match(ResultSet data) throws SQLException { // Declares a method to map ResultSet data to User object
        User user = new User(); // Initializes a new User object

        // Sets values for each attribute of the User object using ResultSet data
        user.setUser_id(data.getInt("user_id"));
        user.setUser_name(data.getString("user_name"));
        user.setUser_pass(data.getString("user_pass"));
        user.setPerm(User.Perm.valueOf(data.getString("user_perm")));

        return user; // Returns the mapped User object
    }

    // Method to delete a user by ID
    public boolean delete(int id){ // Declares a method to delete a user by ID
        String query = "delete from public.users where user_id = ?"; // SQL query to delete a user by ID
        try { // Begins a try block to handle potential exceptions
            PreparedStatement preparedStatement = connection.prepareStatement(query); // Creates a PreparedStatement object
            preparedStatement.setInt(1,id); // Sets the user ID parameter in the SQL query
            return preparedStatement.executeUpdate() != -1; // Executes the SQL query and returns true if successful
        } catch (SQLException e) { // Catches any SQLException that occurs
            throw new RuntimeException(e); // Throws a RuntimeException with the caught SQLException
        }
    }

    // Method to save a new user
    public boolean save(User user){ // Declares a method to save a new user
        String query = "insert into public.users (user_name,user_pass,user_perm) values (?,?,?)"; // SQL query to insert a new user
        try { // Begins a try block to handle potential exceptions
            PreparedStatement preparedStatement = connection.prepareStatement(query); // Creates a PreparedStatement object
            preparedStatement.setString(1,user.getUser_name()); // Sets the username parameter
            preparedStatement.setString(2,user.getUser_pass()); // Sets the password parameter
            preparedStatement.setString(3,user.getPerm().toString()); // Sets the permission parameter

            return preparedStatement.executeUpdate() != -1; // Executes the SQL query and returns true if successful
        } catch (SQLException e) { // Catches any SQLException that occurs
            throw new RuntimeException(e); // Throws a RuntimeException with the caught SQLException
        }
    }

    // Method to update an existing user
    public boolean update(User user){ // Declares a method to update an existing user
        String query = "update public.users set user_name = ? , user_pass = ? , user_perm = ? where user_id = ?"; // SQL query to update a user
        try { // Begins a try block to handle potential exceptions
            PreparedStatement preparedStatement = connection.prepareStatement(query); // Creates a PreparedStatement object
            preparedStatement.setString(1,user.getUser_name()); // Sets the username parameter
            preparedStatement.setString(2,user.getUser_pass()); // Sets the password parameter
            preparedStatement.setString(3,user.getPerm().toString()); // Sets the permission parameter
            preparedStatement.setInt(4,user.getUser_id()); // Sets the user ID parameter

            return preparedStatement.executeUpdate() != -1; // Executes the SQL query and returns true if successful
        } catch (SQLException e) { // Catches any SQLException that occurs
            throw new RuntimeException(e); // Throws a RuntimeException with the caught SQLException
        }
    }

    // Method to get a user by ID
    public User getById(int id){ // Declares a method to get a user by ID
        String query = "select * from public.users where user_id = ?"; // SQL query to select a user by ID
        User user = null; // Initializes a User object
        try { // Begins a try block to handle potential exceptions
            PreparedStatement preparedStatement = connection.prepareStatement(query); // Creates a PreparedStatement object
            preparedStatement.setInt(1,id); // Sets the user ID parameter in the SQL query
            ResultSet data = preparedStatement.executeQuery(); // Executes the SQL query and stores the result
            if(data.next()){ // Checks if the ResultSet has data
                user = match(data); // Maps the ResultSet data to a User object
            }
            return user; // Returns the User object
        } catch (SQLException e) { // Catches any SQLException that occurs
            throw new RuntimeException(e); // Throws a RuntimeException with the caught SQLException
        }
    }

    public boolean isAdmin() { // Declares a method to check if the user is an admin
        return isAdmin; // Returns the value of isAdmin variable
    }
}
