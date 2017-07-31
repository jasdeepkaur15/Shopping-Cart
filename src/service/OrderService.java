package service;

import dao.OrderDao;
import dao.OrderInterface;
import domain.Order;

import java.sql.SQLException;
import java.util.List;


public class OrderService {
    OrderInterface orderInterface;

    public OrderService() {
        orderInterface=new OrderDao();
    }

    public void insertOrder(int customerid, int productid,int quantity) throws SQLException, ClassNotFoundException {
        orderInterface.inserttableorder1(customerid,productid,quantity);
    }

    public List<Order> getOrder(){
        return orderInterface.getAllOrders();
    }

}
