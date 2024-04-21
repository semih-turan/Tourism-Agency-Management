package business;

import dao.ReservationDao;
import dao.RoomDao;
import entity.Reservation;
import entity.Room;

import java.util.ArrayList;

public class RoomManager {

    private final RoomDao roomDao;
    private final ReservationManager reservationManager;

    // Constructor
    public RoomManager() {
        this.reservationManager = new ReservationManager();
        this.roomDao = new RoomDao();
    }

    // Method to save a reservation for a room
    public boolean saveReservation(Room room){
        return roomDao.saveReservation(room);
    }

    // Method to retrieve room data for table display
    public ArrayList<Object[]> getForTable(int size, ArrayList<Room> list){
        ArrayList<Object[]> rowList = new ArrayList<>();
        for(Room obj : list){ // Iterate over all rooms
            Object[] rows = new Object[size];
            int i = 0;
            // Add room details to the row list
            rowList.add(rows);
        }
        return rowList;
    }

    // Method to filter rooms for table display based on hotel ID
    public ArrayList<Room> filterTable(int id){
        ArrayList<String> whereList = new ArrayList<>();
        String select = "select * from public.room";

        if(id != 0){
            whereList.add("room_hotel_id = " + id);
        }
        String whereStr = String.join(" and ",whereList);
        String query = select;
        if(whereStr.length() > 0){
            query += " where " + whereStr;
        }
        return roomDao.selectByQuery(query);
    }

    // Method to retrieve all rooms
    public ArrayList<Room> findByAll(){
        return roomDao.findByAll();
    }

    // Method to delete a room by ID
    public boolean delete(int id){
        // Delete associated reservations
        for(Reservation reservation : reservationManager.getRoomId(id)){
            reservationManager.delete(reservation.getReservation_id());
        }
        return roomDao.delete(id);
    }

    // Method to save a new room
    public boolean save(Room room){
        return roomDao.save(room);
    }

    // Method to update an existing room
    public boolean update(Room room){
        return roomDao.update(room);
    }

    // Method to get a room by ID
    public Room getById(int id){
        return roomDao.getById(id);
    }

    // Method to retrieve rooms by hotel ID
    public ArrayList<Room> getHotelId(int id){
        return roomDao.getHotelId(id);
    }

    // Method to retrieve rooms by season ID
    public ArrayList<Room> getSeasonId(int id){
        return roomDao.getSeasonId(id);
    }

    // Method to check room stock
    public boolean stockCheck(Room room){
        return roomDao.stockCheck(room);
    }

}
