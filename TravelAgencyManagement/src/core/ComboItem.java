package core; // Declares the package name

// This class represents a key-value pair.
public class ComboItem { // Declares the ComboItem class

    private int key;        // The key of the item
    private String value;   // The value of the item

    // Constructor for ComboItem
    public ComboItem(int key, String value) { // Declares a constructor for ComboItem class
        this.key = key; // Initializes the key field with the provided key parameter
        this.value = value; // Initializes the value field with the provided value parameter
    }

    // toString() method returns the value of the item
    @Override
    public String toString() { // Overrides the toString() method
        return value; // Returns the value of the item as a string
    }

    // getKey() method returns the key value
    public int getKey() { // Declares a method to get the key value
        return key; // Returns the key value
    }

    // setKey() method sets the key value
    public void setKey(int key) { // Declares a method to set the key value
        this.key = key; // Sets the key value
    }

    // getValue() method returns the value field
    public String getValue() { // Declares a method to get the value field
        return value; // Returns the value field
    }

    // setValue() method sets the value field
    public void setValue(String value) { // Declares a method to set the value field
        this.value = value; // Sets the value field
    }
}
