package service;

import dao.UserDao;
import dao.UserInterface;
import domain.User;

import java.sql.SQLException;
import java.util.List;


public class UserService {

   public UserInterface userInterface;

    public UserService() {
        userInterface=new UserDao();
    }

    public void insertUser(int customerid, String customername, String customeremail,String customernumber) throws SQLException, ClassNotFoundException {
        userInterface.inserttablecustomer1(customerid,customername,customeremail,customernumber);
    }

    public List<User> getAllUsers(){
        return userInterface.getAllUsers();
    }

    public User getUser(int userId){
        return userInterface.getUserForId(userId);
    }

}
