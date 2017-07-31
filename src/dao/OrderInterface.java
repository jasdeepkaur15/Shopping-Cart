package dao;

import domain.Order;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by jasdeepkaur on 3/7/17.
 */
public interface OrderInterface {
    public void inserttableorder1(int customerid, int productid,int quantity) throws SQLException, ClassNotFoundException;
    public List<Order> getAllOrders();

}
