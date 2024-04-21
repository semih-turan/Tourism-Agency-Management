package entity; // Declares the package name

public class User { // Declares the User class

    private int user_id; // Declares a private integer variable to store the user ID
    private String user_name; // Declares a private String variable to store the user name
    private String user_pass; // Declares a private String variable to store the user password
    private Perm perm; // Declares a private Perm variable to store the user's permission level

    public enum Perm { // Defines an enum Perm to represent different permission levels
        ADMIN, // Represents the admin permission level
        EMPLOYEE // Represents the employee permission level
    }

    // Default constructor
    public User() {
    }

    // Constructor with parameters to initialize the User object
    public User(int user_id, String user_name, String user_pass, Perm perm) {
        this.user_id = user_id; // Initializes the user ID
        this.user_name = user_name; // Initializes the user name
        this.user_pass = user_pass; // Initializes the user password
        this.perm = perm; // Initializes the user's permission level
    }

    // Constructor with parameters (excluding user_id) to initialize the User object
    public User(String user_name, String user_pass, Perm perm) {
        this.user_name = user_name; // Initializes the user name
        this.user_pass = user_pass; // Initializes the user password
        this.perm = perm; // Initializes the user's permission level
    }

    // Getter method for retrieving the user's permission level
    public Perm getPerm() {
        return perm; // Returns the user's permission level
    }

    // Setter method for setting the user's permission level
    public void setPerm(Perm perm) {
        this.perm = perm; // Sets the user's permission level
    }

    // Getter method for retrieving the user ID
    public int getUser_id() {
        return user_id; // Returns the user ID
    }

    // Setter method for setting the user ID
    public void setUser_id(int user_id) {
        this.user_id = user_id; // Sets the user ID
    }

    // Getter method for retrieving the user name
    public String getUser_name() {
        return user_name; // Returns the user name
    }

    // Setter method for setting the user name
    public void setUser_name(String user_name) {
        this.user_name = user_name; // Sets the user name
    }

    // Getter method for retrieving the user password
    public String getUser_pass() {
        return user_pass; // Returns the user password
    }

    // Setter method for setting the user password
    public void setUser_pass(String user_pass) {
        this.user_pass = user_pass; // Sets the user password
    }
}
