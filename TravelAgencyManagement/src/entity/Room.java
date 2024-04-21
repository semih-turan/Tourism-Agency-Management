package entity; // Declares the package name where the class resides

// Represents a Room entity
public class Room {
    private int room_id; // Unique identifier for the room
    private int room_hotel_id; // Identifier for the hotel associated with the room
    private int room_seasson_id; // Identifier for the season associated with the room
    private String room_pansion_type; // Type of pansion associated with the room
    private String room_number; // Number or name of the room
    private int room_capacity; // Maximum capacity of the room
    private int room_adult_price; // Price for adults staying in the room
    private int room_child_price; // Price for children staying in the room
    private int room_stock_quantity; // Quantity of available rooms
    private int room_bed_count; // Number of beds in the room
    private int room_square_meters; // Area of the room in square meters
    private boolean room_has_tv; // Indicates if the room has a TV
    private boolean room_has_mini_bar; // Indicates if the room has a mini-bar
    private boolean room_has_gaming_console; // Indicates if the room has a gaming console
    private boolean room_has_safe_box; // Indicates if the room has a safe box
    private boolean room_has_projector; // Indicates if the room has a projector
    private Hotel hotel; // Hotel object associated with the room
    private Season season; // Season object associated with the room
    private Pansion pansion; // Pansion object associated with the room
    private Type roomType; // Type of the room (SINGLE, DOUBLE, JUNIOR, SUITE)
    private int room_reservation_id; // Identifier for the reservation associated with the room

    // Enum representing different types of rooms
    public enum Type{
        SINGLE,
        DOUBLE,
        JUNIOR,
        SUITE
    }

    // Default constructor
    public Room() {
        // Default constructor
    }

    // Parameterized constructor
    public Room(int room_id, int room_hotel_id, int room_seasson_id, String room_pansion_type, String room_number, int room_capacity, int room_adult_price, int room_child_price, int room_stock_quantity, int room_bed_count, int room_square_meters, boolean room_has_tv, boolean room_has_mini_bar, boolean room_has_gaming_console, boolean room_has_safe_box, boolean room_has_projector, Hotel hotel, Season season, Pansion pansion, Type roomType, int room_reservation_id) {
        // Initialize instance variables with provided values
        this.room_id = room_id;
        this.room_hotel_id = room_hotel_id;
        this.room_seasson_id = room_seasson_id;
        this.room_pansion_type = room_pansion_type;
        this.room_number = room_number;
        this.room_capacity = room_capacity;
        this.room_adult_price = room_adult_price;
        this.room_child_price = room_child_price;
        this.room_stock_quantity = room_stock_quantity;
        this.room_bed_count = room_bed_count;
        this.room_square_meters = room_square_meters;
        this.room_has_tv = room_has_tv;
        this.room_has_mini_bar = room_has_mini_bar;
        this.room_has_gaming_console = room_has_gaming_console;
        this.room_has_safe_box = room_has_safe_box;
        this.room_has_projector = room_has_projector;
        this.hotel = hotel;
        this.season = season;
        this.pansion = pansion;
        this.roomType = roomType;
        this.room_reservation_id = room_reservation_id;
    }

    // Getter and setter methods for instance variables

    public int getRoom_reservation_id() {
        return room_reservation_id; // Returns the ID of the reservation associated with the room
    }

    public void setRoom_reservation_id(int room_reservation_id) {
        this.room_reservation_id = room_reservation_id; // Sets the ID of the reservation associated with the room
    }

    public Season getSeason() {
        return season; // Returns the Season object associated with the room
    }

    public void setSeason(Season season) {
        this.season = season; // Sets the Season object associated with the room
    }

    public Pansion getPansion() {
        return pansion; // Returns the Pansion object associated with the room
    }

    public void setPansion(Pansion pansion) {
        this.pansion = pansion; // Sets the Pansion object associated with the room
    }

    public Hotel getHotel() {
        return hotel; // Returns the Hotel object associated with the room
    }

    public void setHotel(Hotel hotel) {
        this.hotel = hotel; // Sets the Hotel object associated with the room
    }

    public int getRoom_id() {
        return room_id; // Returns the ID of the room
    }

    public void setRoom_id(int room_id) {
        this.room_id = room_id; // Sets the ID of the room
    }

    public int getRoom_hotel_id() {
        return room_hotel_id; // Returns the ID of the hotel associated with the room
    }

    public void setRoom_hotel_id(int room_hotel_id) {
        this.room_hotel_id = room_hotel_id; // Sets the ID of the hotel associated with the room
    }

    public int getRoom_seasson_id() {
        return room_seasson_id; // Returns the ID of the season associated with the room
    }

    public void setRoom_seasson_id(int room_seasson_id) {
        this.room_seasson_id = room_seasson_id; // Sets the ID of the season associated with the room
    }

    public String getRoom_pansion_type() {
        return room_pansion_type; // Returns the type of pansion associated with the room
    }

    public void setRoom_pansion_type(String room_pansion_type) {
        this.room_pansion_type = room_pansion_type; // Sets the type of pansion associated with the room
    }

    public Type getRoomType() {
        return roomType; // Returns the type of the room
    }

    public void setRoomType(Type roomType) {
        this.roomType = roomType; // Sets the type of the room
    }

    public String getRoom_number() {
        return room_number; // Returns the number or name of the room
    }

    public void setRoom_number(String room_number) {
        this.room_number = room_number; // Sets the number or name of the room
    }

    public int getRoom_capacity() {
        return room_capacity; // Returns the maximum capacity of the room
    }

    public void setRoom_capacity(int room_capacity) {
        this.room_capacity = room_capacity; // Sets the maximum capacity of the room
    }

    public int getRoom_adult_price() {
        return room_adult_price; // Returns the price for adults staying in the room
    }

    public void setRoom_adult_price(int room_adult_price) {
        this.room_adult_price = room_adult_price; // Sets the price for adults staying in the room
    }

    public int getRoom_child_price() {
        return room_child_price; // Returns the price for children staying in the room
    }

    public void setRoom_child_price(int room_child_price) {
        this.room_child_price = room_child_price; // Sets the price for children staying in the room
    }

    public int getRoom_stock_quantity() {
        return room_stock_quantity; // Returns the quantity of available rooms
    }

    public void setRoom_stock_quantity(int room_stock_quantity) {
        this.room_stock_quantity = room_stock_quantity; // Sets the quantity of available rooms
    }

    public int getRoom_bed_count() {
        return room_bed_count; // Returns the number of beds in the room
    }

    public void setRoom_bed_count(int room_bed_count) {
        this.room_bed_count = room_bed_count; // Sets the number of beds in the room
    }

    public int getRoom_square_meters() {
        return room_square_meters; // Returns the area of the room in square meters
    }

    public void setRoom_square_meters(int room_square_meters) {
        this.room_square_meters = room_square_meters; // Sets the area of the room in square meters
    }

    public boolean isRoom_has_tv() {
        return room_has_tv; // Returns true if the room has a TV, otherwise false
    }

    public void setRoom_has_tv(boolean room_has_tv) {
        this.room_has_tv = room_has_tv; // Sets whether the room has a TV
    }

    public boolean isRoom_has_mini_bar() {
        return room_has_mini_bar; // Returns true if the room has a mini-bar, otherwise false
    }

    public void setRoom_has_mini_bar(boolean room_has_mini_bar) {
        this.room_has_mini_bar = room_has_mini_bar; // Sets whether the room has a mini-bar
    }

    public boolean isRoom_has_gaming_console() {
        return room_has_gaming_console; // Returns true if the room has a gaming console, otherwise false
    }

    public void setRoom_has_gaming_console(boolean room_has_gaming_console) {
        this.room_has_gaming_console = room_has_gaming_console; // Sets whether the room has a gaming console
    }

    public boolean isRoom_has_safe_box() {
        return room_has_safe_box; // Returns true if the room has a safe box, otherwise false
    }

    public void setRoom_has_safe_box(boolean room_has_safe_box) {
        this.room_has_safe_box = room_has_safe_box; // Sets whether the room has a safe box
    }

    public boolean isRoom_has_projector() {
        return room_has_projector; // Returns true if the room has a projector, otherwise false
    }

    public void setRoom_has_projector(boolean room_has_projector) {
        this.room_has_projector = room_has_projector; // Sets whether the room has a projector
    }
}
