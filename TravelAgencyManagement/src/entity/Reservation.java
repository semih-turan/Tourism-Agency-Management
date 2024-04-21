package entity; // Declares the package name where the class resides

import java.time.LocalDate; // Imports the LocalDate class from the java.time package

// Represents a Reservation entity
public class Reservation {
    private int reservation_id; // Unique identifier for the reservation
    private int reservation_hotel_id; // Identifier for the hotel associated with the reservation
    private int reservation_room_id; // Identifier for the room reserved
    private String reservation_guest_fullname; // Full name of the guest making the reservation
    private String reservation_guest_id; // Identification of the guest (e.g., passport number)
    private String reservation_guest_mpno; // Mobile phone number of the guest
    private String reservation_guest_email; // Email address of the guest
    private LocalDate reservation_checkin_date; // Date of check-in for the reservation
    private LocalDate reservation_checkout_date; // Date of check-out for the reservation
    private int reservation_child_count; // Number of children included in the reservation
    private int reservation_adult_count; // Number of adults included in the reservation
    private int reservation_totol_price; // Total price of the reservation
    private LocalDate reservation_date; // Date when the reservation was made

    // Parameterized constructor
    public Reservation(int reservation_id, int reservation_hotel_id, int reservation_room_id, String reservation_guest_fullname, String reservation_guest_id, String reservation_guest_mpno, String reservation_guest_email, LocalDate reservation_checkin_date, LocalDate reservation_checkout_date, int reservation_child_count, int reservation_adult_count, int reservation_totol_price, LocalDate reservation_date) {
        // Initialize instance variables with provided values
        this.reservation_id = reservation_id;
        this.reservation_hotel_id = reservation_hotel_id;
        this.reservation_room_id = reservation_room_id;
        this.reservation_guest_fullname = reservation_guest_fullname;
        this.reservation_guest_id = reservation_guest_id;
        this.reservation_guest_mpno = reservation_guest_mpno;
        this.reservation_guest_email = reservation_guest_email;
        this.reservation_checkin_date = reservation_checkin_date;
        this.reservation_checkout_date = reservation_checkout_date;
        this.reservation_child_count = reservation_child_count;
        this.reservation_adult_count = reservation_adult_count;
        this.reservation_totol_price = reservation_totol_price;
        this.reservation_date = reservation_date;
    }

    // Default constructor
    public Reservation() {
        // Default constructor
    }

    // Getter and setter methods for instance variables

    public int getReservation_id() {
        return reservation_id; // Returns the ID of the reservation
    }

    public void setReservation_id(int reservation_id) {
        this.reservation_id = reservation_id; // Sets the ID of the reservation
    }

    public int getReservation_hotel_id() {
        return reservation_hotel_id; // Returns the ID of the hotel associated with the reservation
    }

    public void setReservation_hotel_id(int reservation_hotel_id) {
        this.reservation_hotel_id = reservation_hotel_id; // Sets the ID of the hotel associated with the reservation
    }

    public int getReservation_room_id() {
        return reservation_room_id; // Returns the ID of the room reserved
    }

    public void setReservation_room_id(int reservation_room_id) {
        this.reservation_room_id = reservation_room_id; // Sets the ID of the room reserved
    }

    public String getReservation_guest_fullname() {
        return reservation_guest_fullname; // Returns the full name of the guest
    }

    public void setReservation_guest_fullname(String reservation_guest_fullname) {
        this.reservation_guest_fullname = reservation_guest_fullname; // Sets the full name of the guest
    }

    public String getReservation_guest_id() {
        return reservation_guest_id; // Returns the identification of the guest
    }

    public void setReservation_guest_id(String reservation_guest_id) {
        this.reservation_guest_id = reservation_guest_id; // Sets the identification of the guest
    }

    public String getReservation_guest_mpno() {
        return reservation_guest_mpno; // Returns the mobile phone number of the guest
    }

    public void setReservation_guest_mpno(String reservation_guest_mpno) {
        this.reservation_guest_mpno = reservation_guest_mpno; // Sets the mobile phone number of the guest
    }

    public String getReservation_guest_email() {
        return reservation_guest_email; // Returns the email address of the guest
    }

    public void setReservation_guest_email(String reservation_guest_email) {
        this.reservation_guest_email = reservation_guest_email; // Sets the email address of the guest
    }

    public LocalDate getReservation_checkin_date() {
        return reservation_checkin_date; // Returns the date of check-in for the reservation
    }

    public void setReservation_checkin_date(LocalDate reservation_checkin_date) {
        this.reservation_checkin_date = reservation_checkin_date; // Sets the date of check-in for the reservation
    }

    public LocalDate getReservation_checkout_date() {
        return reservation_checkout_date; // Returns the date of check-out for the reservation
    }

    public void setReservation_checkout_date(LocalDate reservation_checkout_date) {
        this.reservation_checkout_date = reservation_checkout_date; // Sets the date of check-out for the reservation
    }

    public int getReservation_child_count() {
        return reservation_child_count; // Returns the number of children included in the reservation
    }

    public void setReservation_child_count(int reservation_child_count) {
        this.reservation_child_count = reservation_child_count; // Sets the number of children included in the reservation
    }

    public int getReservation_adult_count() {
        return reservation_adult_count; // Returns the number of adults included in the reservation
    }

    public void setReservation_adult_count(int reservation_adult_count) {
        this.reservation_adult_count = reservation_adult_count; // Sets the number of adults included in the reservation
    }

    public int getReservation_totol_price() {
        return reservation_totol_price; // Returns the total price of the reservation
    }

    public void setReservation_totol_price(int reservation_totol_price) {
        this.reservation_totol_price = reservation_totol_price; // Sets the total price of the reservation
    }

    public LocalDate getReservation_date() {
        return reservation_date; // Returns the date when the reservation was made
    }

    public void setReservation_date(LocalDate reservation_date) {
        this.reservation_date = reservation_date; // Sets the date when the reservation was made
    }
}
