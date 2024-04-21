package entity; // Declares the package name

import java.time.LocalDate; // Imports the LocalDate class from the java.time package

public class Season { // Declares the Season class

    private int season_id; // Declares a private integer variable to store the season ID
    private int season_hotel_id; // Declares a private integer variable to store the hotel ID associated with the season
    private LocalDate season_start_date; // Declares a private LocalDate variable to store the start date of the season
    private LocalDate season_end_date; // Declares a private LocalDate variable to store the end date of the season
    private SeasonName seasonName; // Declares a private SeasonName variable to store the name of the season
    private String hotelName; // Declares a private String variable to store the name of the hotel associated with the season
    private Hotel hotel; // Declares a private Hotel variable to store the Hotel object associated with the season

    public enum SeasonName{ // Defines an enum SeasonName to represent different types of seasons
        SUMMER, // Represents the summer season
        WINTER, // Represents the winter season
        FULL // Represents the full season
    }

    // Constructor with parameters to initialize the Season object
    public Season(int season_id, int season_hotel_id, LocalDate season_start_date, LocalDate season_end_date, SeasonName seasonName, String hotelName, Hotel hotel) {
        this.season_id = season_id; // Initializes the season ID
        this.season_hotel_id = season_hotel_id; // Initializes the hotel ID associated with the season
        this.season_start_date = season_start_date; // Initializes the start date of the season
        this.season_end_date = season_end_date; // Initializes the end date of the season
        this.seasonName = seasonName; // Initializes the name of the season
        this.hotelName = hotelName; // Initializes the name of the hotel associated with the season
        this.hotel = hotel; // Initializes the Hotel object associated with the season
    }

    // Getter method for retrieving the season name
    public SeasonName getSeasonName() {
        return seasonName; // Returns the name of the season
    }

    // Setter method for setting the season name
    public void setSeasonName(SeasonName seasonName) {
        this.seasonName = seasonName; // Sets the name of the season
    }

    // Default constructor
    public Season() {
    }

    // Getter method for retrieving the season ID
    public int getSeason_id() {
        return season_id; // Returns the season ID
    }

    // Getter method for retrieving the hotel name
    public String getHotelName() {
        return hotelName; // Returns the name of the hotel associated with the season
    }

    // Setter method for setting the hotel name
    public void setHotelName(String hotelName) {
        this.hotelName = hotelName; // Sets the name of the hotel associated with the season
    }

    // Setter method for setting the season ID
    public void setSeason_id(int season_id) {
        this.season_id = season_id; // Sets the season ID
    }

    // Getter method for retrieving the Hotel object associated with the season
    public Hotel getHotel() {
        return hotel; // Returns the Hotel object associated with the season
    }

    // Setter method for setting the Hotel object associated with the season
    public void setHotel(Hotel hotel) {
        this.hotel = hotel; // Sets the Hotel object associated with the season
    }

    // Getter method for retrieving the hotel ID associated with the season
    public int getSeason_hotel_id() {
        return season_hotel_id; // Returns the hotel ID associated with the season
    }

    // Setter method for setting the hotel ID associated with the season
    public void setSeason_hotel_id(int season_hotel_id) {
        this.season_hotel_id = season_hotel_id; // Sets the hotel ID associated with the season
    }

    // Getter method for retrieving the start date of the season
    public LocalDate getSeason_start_date() {
        return season_start_date; // Returns the start date of the season
    }

    // Setter method for setting the start date of the season
    public void setSeason_start_date(LocalDate season_start_date) {
        this.season_start_date = season_start_date; // Sets the start date of the season
    }

    // Getter method for retrieving the end date of the season
    public LocalDate getSeason_end_date() {
        return season_end_date; // Returns the end date of the season
    }

    // Setter method for setting the end date of the season
    public void setSeason_end_date(LocalDate season_end_date) {
        this.season_end_date = season_end_date; // Sets the end date of the season
    }

}
