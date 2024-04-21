package entity; // Declares the package name where the class resides

// Represents a Pansion entity
public class Pansion {
    private int pansion_id; // Unique identifier for the pansion
    //private int pansion_hotel_id; // Identifier for the hotel associated with this pansion (commented out as not currently used)
    private String pansion_type; // Type of pansion (e.g., bed and breakfast, half board, full board)

    // Parameterized constructor
    public Pansion(int pansion_id, int pansion_hotel_id, String pansion_type) {
        this.pansion_id = pansion_id; // Initialize pansion_id with provided value
        //this.pansion_hotel_id = pansion_hotel_id; // Initialize pansion_hotel_id with provided value (commented out as not currently used)
        this.pansion_type = pansion_type; // Initialize pansion_type with provided value
    }

    // Getter and setter methods for instance variables

    public String getPansion_type() {
        return pansion_type; // Returns the type of pansion
    }

    public void setPansion_type(String pansion_type) {
        this.pansion_type = pansion_type; // Sets the type of pansion
    }

    public Pansion() {
        // Default constructor
    }

    public int getPansion_id() {
        return pansion_id; // Returns the ID of the pansion
    }

    public void setPansion_id(int pansion_id) {
        this.pansion_id = pansion_id; // Sets the ID of the pansion
    }
}
