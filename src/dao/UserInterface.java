package dao;

import domain.User;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by jasdeepkaur on 3/7/17.
 */
public interface UserInterface {

    public void inserttablecustomer1(int customerid, String customername, String customeremail,String customernumber) throws SQLException, ClassNotFoundException;

    public List<User> getAllUsers();

    public User getUserForId(int userId);
}
