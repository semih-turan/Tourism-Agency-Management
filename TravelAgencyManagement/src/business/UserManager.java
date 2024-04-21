package business;

import dao.UserDao;
import entity.User;

import java.util.ArrayList;

public class UserManager {

    private final UserDao userDao;

    // Constructor
    public UserManager() {
        this.userDao = new UserDao();
    }

    // Method to get user data for table display
    public ArrayList<Object[]> getForTable(int size){
        ArrayList<Object[]> rowList = new ArrayList<>();
        for(User user : findByAll()){ // Iterate over all users
            Object[] rows = new Object[size];
            int i = 0;
            // Add user details to the row list
            rows[i++] = user.getUser_id();
            rows[i++] = user.getUser_name();
            rows[i++] = user.getUser_pass();
            rows[i++] = user.getPerm();
            rowList.add(rows);
        }
        return rowList;
    }

    // Method to login
    public User login(String username,String password){
        return userDao.login(username,password);
    }

    // Method to retrieve all users
    public ArrayList<User> findByAll(){
        return userDao.findByAll();
    }

    // Method to delete a user by ID
    public boolean delete(int id){
        return userDao.delete(id);
    }

    // Method to save a user
    public boolean save(User user){
        return userDao.save(user);
    }

    // Method to update a user
    public boolean update(User user){
        return userDao.update(user);
    }

    // Method to get a user by ID
    public User getById(int id){
        return userDao.getById(id);
    }
}
