package entity; // Declares the package name where the class resides

import java.time.LocalDate; // Imports the LocalDate class from the java.time package

// Represents a search entity
public class Search {
    private int hotel_id; // Identifier for the hotel
    private String hotel_name; // Name of the hotel
    private String hotel_city; // City where the hotel is located
    private String hotel_region; // Region where the hotel is located
    private String hotel_fulladress; // Full address of the hotel
    private String hotel_email; // Email address of the hotel
    private String hotel_phone; // Phone number of the hotel
    private String hotel_star; // Star rating of the hotel
    private boolean hotel_free_parking; // Indicates if the hotel offers free parking
    private boolean hotel_fee_wifi; // Indicates if the hotel offers free WiFi
    private boolean hotel_swimming_pool; // Indicates if the hotel has a swimming pool
    private boolean hotel_fitness_center; // Indicates if the hotel has a fitness center
    private boolean hotel_concierge; // Indicates if the hotel has a concierge service
    private boolean hotel_spa; // Indicates if the hotel has a spa
    private boolean hotel_room_services; // Indicates if the hotel offers room services
    private String[] hotel_pansion_types; // Types of pansion offered by the hotel
    private int room_id; // Identifier for the room
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
    private int season_type; // Type of the season
    private int season_hotel_id; // Identifier for the hotel associated with the season
    private LocalDate season_start_date; // Start date of the season
    private LocalDate season_end_date; // End date of the season
    private String season_name; // Name of the season
    private String season_hotel_hotel_name; // Name of the hotel associated with the season

    // Default constructor
    public Search() {
        // Default constructor
    }

    // Parameterized constructor
    public Search(int hotel_id, String hotel_name, String hotel_city, String hotel_region, String hotel_fulladress, String hotel_email, String hotel_phone, String hotel_star, boolean hotel_free_parking, boolean hotel_fee_wifi, boolean hotel_swimming_pool, boolean hotel_fitness_center, boolean hotel_concierge, boolean hotel_spa, boolean hotel_room_services, String[] hotel_pansion_types, int room_id, int room_hotel_id, int room_seasson_id, String room_pansion_type, String room_number, int room_capacity, int room_adult_price, int room_child_price, int room_stock_quantity, int room_bed_count, int room_square_meters, boolean room_has_tv, boolean room_has_mini_bar, boolean room_has_gaming_console, boolean room_has_safe_box, boolean room_has_projector, int season_type, int season_hotel_id, LocalDate season_start_date, LocalDate season_end_date, String season_name, String season_hotel_hotel_name) {
        // Initialize instance variables with provided values
        this.hotel_id = hotel_id;
        this.hotel_name = hotel_name;
        this.hotel_city = hotel_city;
        this.hotel_region = hotel_region;
        this.hotel_fulladress = hotel_fulladress;
        this.hotel_email = hotel_email;
        this.hotel_phone = hotel_phone;
        this.hotel_star = hotel_star;
        this.hotel_free_parking = hotel_free_parking;
        this.hotel_fee_wifi = hotel_fee_wifi;
        this.hotel_swimming_pool = hotel_swimming_pool;
        this.hotel_fitness_center = hotel_fitness_center;
        this.hotel_concierge = hotel_concierge;
        this.hotel_spa = hotel_spa;
        this.hotel_room_services = hotel_room_services;
        this.hotel_pansion_types = hotel_pansion_types;
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
        this.season_type = season_type;
        this.season_hotel_id = season_hotel_id;
        this.season_start_date = season_start_date;
        this.season_end_date = season_end_date;
        this.season_name = season_name;
        this.season_hotel_hotel_name = season_hotel_hotel_name;
    }

    // Getter and setter methods for instance variables
    public int getHotel_id() {
        return hotel_id; // Returns the ID of the hotel
    }

    public void setHotel_id(int hotel_id) {
        this.hotel_id = hotel_id; // Sets the ID of the hotel
    }

    public String getHotel_name() {
        return hotel_name; // Returns the name of the hotel
    }

    public void setHotel_name(String hotel_name) {
        this.hotel_name = hotel_name; // Sets the name of the hotel
    }

    public String getHotel_city() {
        return hotel_city; // Returns the city where the hotel is located
    }

    public void setHotel_city(String hotel_city) {
        this.hotel_city = hotel_city; // Sets the city where the hotel is located
    }

    public String getHotel_region() {
        return hotel_region; // Returns the region where the hotel is located
    }

    public void setHotel_region(String hotel_region) {
        this.hotel_region = hotel_region; // Sets the region where the hotel is located
    }

    public String getHotel_fulladress() {
        return hotel_fulladress; // Returns the full address of the hotel
    }

    public void setHotel_fulladress(String hotel_fulladress) {
        this.hotel_fulladress = hotel_fulladress; // Sets the full address of the hotel
    }

    public String getHotel_email() {
        return hotel_email; // Returns the email address of the hotel
    }

    public void setHotel_email(String hotel_email) {
        this.hotel_email = hotel_email; // Sets the email address of the hotel
    }

    public String getHotel_phone() {
        return hotel_phone; // Returns the phone number of the hotel
    }

    public void setHotel_phone(String hotel_phone) {
        this.hotel_phone = hotel_phone; // Sets the phone number of the hotel
    }

    public String getHotel_star() {
        return hotel_star; // Returns the star rating of the hotel
    }

    public void setHotel_star(String hotel_star) {
        this.hotel_star = hotel_star; // Sets the star rating of the hotel
    }

    public boolean isHotel_free_parking() {
        return hotel_free_parking; // Returns true if the hotel offers free parking, otherwise false
    }

    public void setHotel_free_parking(boolean hotel_free_parking) {
        this.hotel_free_parking = hotel_free_parking; // Sets whether the hotel offers free parking
    }

    public boolean isHotel_fee_wifi() {
        return hotel_fee_wifi; // Returns true if the hotel offers free WiFi, otherwise false
    }

    public void setHotel_fee_wifi(boolean hotel_fee_wifi) {
        this.hotel_fee_wifi = hotel_fee_wifi; // Sets whether the hotel offers free WiFi
    }

    public boolean isHotel_swimming_pool() {
        return hotel_swimming_pool; // Returns true if the hotel has a swimming pool, otherwise false
    }

    public void setHotel_swimming_pool(boolean hotel_swimming_pool) {
        this.hotel_swimming_pool = hotel_swimming_pool; // Sets whether the hotel has a swimming pool
    }

    public boolean isHotel_fitness_center() {
        return hotel_fitness_center; // Returns true if the hotel has a fitness center, otherwise false
    }

    public void setHotel_fitness_center(boolean hotel_fitness_center) {
        this.hotel_fitness_center = hotel_fitness_center; // Sets whether the hotel has a fitness center
    }

    public boolean isHotel_concierge() {
        return hotel_concierge; // Returns true if the hotel has a concierge service, otherwise false
    }

    public void setHotel_concierge(boolean hotel_concierge) {
        this.hotel_concierge = hotel_concierge; // Sets whether the hotel has a concierge service
    }

    public boolean isHotel_spa() {
        return hotel_spa; // Returns true if the hotel has a spa, otherwise false
    }

    public void setHotel_spa(boolean hotel_spa) {
        this.hotel_spa = hotel_spa; // Sets whether the hotel has a spa
    }

    public boolean isHotel_room_services() {
        return hotel_room_services; // Returns true if the hotel offers room services, otherwise false
    }

    public void setHotel_room_services(boolean hotel_room_services) {
        this.hotel_room_services = hotel_room_services; // Sets whether the hotel offers room services
    }

    public String[] getHotel_pansion_types() {
        return hotel_pansion_types; // Returns the types of pansion offered by the hotel
    }

    public void setHotel_pansion_types(String[] hotel_pansion_types) {
        this.hotel_pansion_types = hotel_pansion_types; // Sets the types of pansion offered by the hotel
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

    public int getSeason_type() {
        return season_type; // Returns the type of the season
    }

    public void setSeason_type(int season_type) {
        this.season_type = season_type; // Sets the type of the season
    }

    public int getSeason_hotel_id() {
        return season_hotel_id; // Returns the ID of the hotel associated with the season
    }

    public void setSeason_hotel_id(int season_hotel_id) {
        this.season_hotel_id = season_hotel_id; // Sets the ID of the hotel associated with the season
    }

    public LocalDate getSeason_start_date() {
        return season_start_date; // Returns the start date of the season
    }

    public void setSeason_start_date(LocalDate season_start_date) {
        this.season_start_date = season_start_date; // Sets the start date of the season
    }

    public LocalDate getSeason_end_date() {
        return season_end_date; // Returns the end date of the season
    }

    public void setSeason_end_date(LocalDate season_end_date) {
        this.season_end_date = season_end_date; // Sets the end date of the season
    }

    public String getSeason_name() {
        return season_name; // Returns the name of the season
    }

    public void setSeason_name(String season_name) {
        this.season_name = season_name; // Sets the name of the season
    }

    public String getSeason_hotel_hotel_name() {
        return season_hotel_hotel_name; // Returns the name of the hotel associated with the season
    }

    public void setSeason_hotel_hotel_name(String season_hotel_hotel_name) {
        this.season_hotel_hotel_name = season_hotel_hotel_name; // Sets the name of the hotel associated with the season
    }
}
