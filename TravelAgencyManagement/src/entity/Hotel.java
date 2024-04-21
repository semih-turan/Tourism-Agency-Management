package entity; // Declares the package name where the class resides

// Represents a hotel entity
public class Hotel {
    private int hotel_id; // Unique identifier for the hotel
    private String hotel_name; // Name of the hotel
    private String hotel_city; // City where the hotel is located
    private String hotel_region; // Region or area within the city
    private String hotel_fulladres; // Full address of the hotel
    private String hotel_mail; // Email address of the hotel
    private String hotel_phone; // Phone number of the hotel
    private String hotel_star; // Star rating of the hotel
    private boolean hotel_free_parking; // Indicates if the hotel offers free parking
    private boolean hotel_free_wifi; // Indicates if the hotel offers free WiFi
    private boolean hotel_swimming_pool; // Indicates if the hotel has a swimming pool
    private boolean hotel_fitness_center; // Indicates if the hotel has a fitness center
    private boolean hotel_concierge; // Indicates if the hotel has a concierge service
    private boolean hotel_spa; // Indicates if the hotel has a spa
    private boolean hotel_room_services; // Indicates if the hotel offers room services
    private String[] hotel_pansion_type; // Types of meal plans offered by the hotel

    // Parameterized constructor
    public Hotel(int hotel_id, String hotel_name, String hotel_city, String hotel_region, String hotel_fulladres, String hotel_mail, String hotel_phone, String hotel_star, boolean hotel_free_parking, boolean hotel_free_wifi, boolean hotel_swimming_pool, boolean hotel_fitness_center, boolean hotel_concierge, boolean hotel_spa, boolean hotel_room_services, String[] hotel_pansion_type) {
        // Initialize instance variables with provided values
        this.hotel_id = hotel_id;
        this.hotel_name = hotel_name;
        this.hotel_city = hotel_city;
        this.hotel_region = hotel_region;
        this.hotel_fulladres = hotel_fulladres;
        this.hotel_mail = hotel_mail;
        this.hotel_phone = hotel_phone;
        this.hotel_star = hotel_star;
        this.hotel_free_parking = hotel_free_parking;
        this.hotel_free_wifi = hotel_free_wifi;
        this.hotel_swimming_pool = hotel_swimming_pool;
        this.hotel_fitness_center = hotel_fitness_center;
        this.hotel_concierge = hotel_concierge;
        this.hotel_spa = hotel_spa;
        this.hotel_room_services = hotel_room_services;
        this.hotel_pansion_type = hotel_pansion_type;
    }

    // Default constructor
    public Hotel() {
        // Empty constructor
    }

    // Getter and setter methods for instance variables

    public int getHotel_id() {
        return hotel_id;
    }

    public void setHotel_id(int hotel_id) {
        this.hotel_id = hotel_id;
    }

    public String getHotel_name() {
        return hotel_name;
    }

    public void setHotel_name(String hotel_name) {
        this.hotel_name = hotel_name;
    }

    public String getHotel_city() {
        return hotel_city;
    }

    public void setHotel_city(String hotel_city) {
        this.hotel_city = hotel_city;
    }

    public String getHotel_region() {
        return hotel_region;
    }

    public void setHotel_region(String hotel_region) {
        this.hotel_region = hotel_region;
    }

    public String getHotel_fulladres() {
        return hotel_fulladres;
    }

    public void setHotel_fulladres(String hotel_fulladres) {
        this.hotel_fulladres = hotel_fulladres;
    }

    public String getHotel_mail() {
        return hotel_mail;
    }

    public void setHotel_mail(String hotel_mail) {
        this.hotel_mail = hotel_mail;
    }

    public String getHotel_phone() {
        return hotel_phone;
    }

    public void setHotel_phone(String hotel_phone) {
        this.hotel_phone = hotel_phone;
    }

    public String getHotel_star() {
        return hotel_star;
    }

    public void setHotel_star(String hotel_star) {
        this.hotel_star = hotel_star;
    }

    public boolean isHotel_free_parking() {
        return hotel_free_parking;
    }

    public void setHotel_free_parking(boolean hotel_free_parking) {
        this.hotel_free_parking = hotel_free_parking;
    }

    public boolean isHotel_free_wifi() {
        return hotel_free_wifi;
    }

    public void setHotel_free_wifi(boolean hotel_free_wifi) {
        this.hotel_free_wifi = hotel_free_wifi;
    }

    public boolean isHotel_swimming_pool() {
        return hotel_swimming_pool;
    }

    public void setHotel_swimming_pool(boolean hotel_swimming_pool) {
        this.hotel_swimming_pool = hotel_swimming_pool;
    }

    public boolean isHotel_fitness_center() {
        return hotel_fitness_center;
    }

    public void setHotel_fitness_center(boolean hotel_fitness_center) {
        this.hotel_fitness_center = hotel_fitness_center;
    }

    public boolean isHotel_concierge() {
        return hotel_concierge;
    }

    public void setHotel_concierge(boolean hotel_concierge) {
        this.hotel_concierge = hotel_concierge;
    }

    public boolean isHotel_spa() {
        return hotel_spa;
    }

    public void setHotel_spa(boolean hotel_spa) {
        this.hotel_spa = hotel_spa;
    }

    public boolean isHotel_room_services() {
        return hotel_room_services;
    }

    public void setHotel_room_services(boolean hotel_room_services) {
        this.hotel_room_services = hotel_room_services;
    }

    public String[] getHotel_pansion_type() {
        return hotel_pansion_type;
    }

    public void setHotel_pansion_type(String[] hotel_pansion_type) {
        this.hotel_pansion_type = hotel_pansion_type;
    }
}
