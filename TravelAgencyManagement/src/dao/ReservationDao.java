package dao; // Declares the package name

import core.Database; // Imports the Database class from the core package
import entity.Reservation; // Imports the Reservation class from the entity package
import java.sql.*; // Imports SQL-related classes
import java.util.ArrayList; // Imports ArrayList class

public class ReservationDao { // Declares the ReservationDao class

    private Connection connection; // Declares a private Connection variable to manage database connections
    private boolean isAdmin; // Declares a private boolean variable to track admin status

    public ReservationDao() { // Constructor for ReservationDao class
        connection = Database.connector(); // Initializes the database connection using the Database class
    }

    // Method to find all reservations
    public ArrayList<Reservation> findByAll(){ // Declares a method to find all reservations
        ArrayList<Reservation> reservationsList = new ArrayList<>(); // Initializes an ArrayList to store Reservation objects
        String query = "select * from public.reservation order by reservation_id asc"; // SQL query to select all reservations

        try { // Begins a try block to handle potential exceptions
            Statement statement = connection.createStatement(); // Creates a Statement object for executing SQL queries
            ResultSet data = statement.executeQuery(query); // Executes the SQL query and stores the result
            while (data.next()){ // Iterates through the ResultSet
                reservationsList.add(match(data)); // Adds a Reservation object to the list by mapping ResultSet data
            }
            return reservationsList; // Returns the list of reservations
        } catch (SQLException e) { // Catches any SQLException that occurs
            throw new RuntimeException(e); // Throws a RuntimeException with the caught SQLException
        }
    }

    // Method to map ResultSet data to Reservation object
    public Reservation match(ResultSet data) throws SQLException { // Declares a method to map ResultSet data to Reservation object
        Reservation reservation = new Reservation(); // Initializes a new Reservation object

        // Sets values for each attribute of the Reservation object using ResultSet data
        reservation.setReservation_id(data.getInt("reservation_id"));
        reservation.setReservation_hotel_id(data.getInt("reservation_hotel_id"));
        reservation.setReservation_room_id(data.getInt("reservation_room_id"));
        reservation.setReservation_guest_fullname(data.getString("reservation_guest_fullname"));
        reservation.setReservation_guest_id(data.getString("reservation_guest_id"));
        reservation.setReservation_guest_mpno(data.getString("reservation_guest_mpno"));
        reservation.setReservation_guest_email(data.getString("reservation_guest_email"));
        reservation.setReservation_checkin_date(data.getDate("reservation_checkin_date").toLocalDate());
        reservation.setReservation_checkout_date(data.getDate("reservation_checkout_date").toLocalDate());
        reservation.setReservation_child_count(data.getInt("reservation_child_count"));
        reservation.setReservation_adult_count(data.getInt("reservation_adult_count"));
        reservation.setReservation_totol_price(data.getInt("reservation_total_price"));
        reservation.setReservation_date(data.getDate("reservation_date").toLocalDate());

        return reservation; // Returns the mapped Reservation object
    }

    // Method to delete a reservation by ID
    public boolean delete(int id){ // Declares a method to delete a reservation by ID
        String query = "delete from public.reservation where reservation_id = ?"; // SQL query to delete a reservation by ID
        try { // Begins a try block to handle potential exceptions
            PreparedStatement preparedStatement = connection.prepareStatement(query); // Creates a PreparedStatement object
            preparedStatement.setInt(1,id); // Sets the reservation ID parameter in the SQL query
            return preparedStatement.executeUpdate() != -1; // Executes the SQL query and returns true if successful
        } catch (SQLException e) { // Catches any SQLException that occurs
            throw new RuntimeException(e); // Throws a RuntimeException with the caught SQLException
        }
    }

    // Method to save a new reservation
    public boolean save(Reservation reservation){ // Declares a method to save a new reservation
        String query = "insert into public.reservation " +
                "(reservation_hotel_id,reservation_room_id,reservation_guest_fullname," +
                "reservation_guest_id,reservation_guest_mpno,reservation_guest_email," +
                "reservation_checkin_date,reservation_checkout_date,reservation_child_count," +
                "reservation_adult_count,reservation_total_price,reservation_date)" +
                " values (?,?,?,?,?,?,?,?,?,?,?,?)"; // SQL query to insert a new reservation
        try { // Begins a try block to handle potential exceptions
            PreparedStatement preparedStatement = connection.prepareStatement(query); // Creates a PreparedStatement object
            // Sets values for each parameter in the SQL query using Reservation object attributes
            preparedStatement.setInt(1,reservation.getReservation_hotel_id());
            preparedStatement.setInt(2,reservation.getReservation_room_id());
            preparedStatement.setString(3,reservation.getReservation_guest_fullname());
            preparedStatement.setString(4,reservation.getReservation_guest_id());
            preparedStatement.setString(5,reservation.getReservation_guest_mpno());
            preparedStatement.setString(6,reservation.getReservation_guest_email());
            preparedStatement.setDate(7,Date.valueOf(reservation.getReservation_checkin_date()));
            preparedStatement.setDate(8,Date.valueOf(reservation.getReservation_checkout_date()));
            preparedStatement.setInt(9,reservation.getReservation_child_count());
            preparedStatement.setInt(10,reservation.getReservation_adult_count());
            preparedStatement.setInt(11,reservation.getReservation_totol_price());
            preparedStatement.setDate(12,Date.valueOf(reservation.getReservation_date()));

            return preparedStatement.executeUpdate() != -1; // Executes the SQL query and returns true if successful
        } catch (SQLException e) { // Catches any SQLException that occurs
            throw new RuntimeException(e); // Throws a RuntimeException with the caught SQLException
        }
    }

    // Method to update reservation information
    public boolean update(Reservation reservation){ // Declares a method to update reservation information
        String query = "update public.reservation set " +
                "reservation_hotel_id = ? , reservation_room_id = ? ,reservation_guest_fullname = ?, reservation_guest_id = ?, " +
                "reservation_guest_mpno = ? , reservation_guest_email = ?, reservation_checkin_date = ? ,reservation_checkout_date = ? ," +
                "reservation_child_count = ?,reservation_adult_count = ?,reservation_total_price = ?,reservation_date = ? " +
                "where reservation_id = ?"; // SQL query to update reservation information
        try { // Begins a try block to handle potential exceptions
            PreparedStatement preparedStatement = connection.prepareStatement(query); // Creates a PreparedStatement object
            // Sets values for each parameter in the SQL query using Reservation object attributes
            preparedStatement.setInt(1,reservation.getReservation_hotel_id());
            preparedStatement.setInt(2,reservation.getReservation_room_id());
            preparedStatement.setString(3,reservation.getReservation_guest_fullname());
            preparedStatement.setString(4,reservation.getReservation_guest_id());
            preparedStatement.setString(5,reservation.getReservation_guest_mpno());
            preparedStatement.setString(6,reservation.getReservation_guest_email());
            preparedStatement.setDate(7,Date.valueOf(reservation.getReservation_checkin_date()));
            preparedStatement.setDate(8,Date.valueOf(reservation.getReservation_checkout_date()));
            preparedStatement.setInt(9,reservation.getReservation_child_count());
            preparedStatement.setInt(10,reservation.getReservation_adult_count());
            preparedStatement.setInt(11,reservation.getReservation_totol_price());
            preparedStatement.setDate(12,Date.valueOf(reservation.getReservation_date()));
            preparedStatement.setInt(13,reservation.getReservation_id());

            return preparedStatement.executeUpdate() != -1; // Executes the SQL query and returns true if successful
        } catch (SQLException e) { // Catches any SQLException that occurs
            throw new RuntimeException(e); // Throws a RuntimeException with the caught SQLException
        }
    }

    // Method to get a reservation by ID
    public Reservation getById(int id){ // Declares a method to get a reservation by ID
        String query = "select * from public.reservation where reservation_id = ?"; // SQL query to select a reservation by ID
        Reservation reservation = null; // Initializes a Reservation object
        try { // Begins a try block to handle potential exceptions
            PreparedStatement preparedStatement = connection.prepareStatement(query); // Creates a PreparedStatement object
            preparedStatement.setInt(1,id); // Sets the reservation ID parameter in the SQL query
            ResultSet data = preparedStatement.executeQuery(); // Executes the SQL query and stores the result
            if(data.next()){ // Checks if the ResultSet has data
                reservation = match(data); // Maps the ResultSet data to a Reservation object
            }
            return reservation; // Returns the Reservation object
        } catch (SQLException e) { // Catches any SQLException that occurs
            throw new RuntimeException(e); // Throws a RuntimeException with the caught SQLException
        }
    }

    // Method to get reservations by hotel ID
    public ArrayList<Reservation> getHotelId(int id){ // Declares a method to get reservations by hotel ID
        return selectByQuery("select * from public.reservation where reservation_hotel_id =" + id); // Calls selectByQuery method with a custom SQL query
    }

    // Method to get reservations by room ID
    public ArrayList<Reservation> getRoomId(int id){ // Declares a method to get reservations by room ID
        return selectByQuery("select * from public.reservation where reservation_room_id =" + id); // Calls selectByQuery method with a custom SQL query
    }

    // Method to select reservations by a custom query
    public ArrayList<Reservation> selectByQuery(String query){ // Declares a method to select reservations by a custom query
        ArrayList<Reservation> reservations = new ArrayList<>(); // Initializes an ArrayList to store Reservation objects
        try { // Begins a try block to handle potential exceptions
            ResultSet data = connection.createStatement().executeQuery(query); // Executes the custom SQL query and stores the result
            while (data.next()){ // Iterates through the ResultSet
                reservations.add(match(data)); // Adds a Reservation object to the list by mapping ResultSet data
            }
        } catch (SQLException e) { // Catches any SQLException that occurs
            throw new RuntimeException(e); // Throws a RuntimeException with the caught SQLException
        }
        return reservations; // Returns the list of reservations
    }
}
