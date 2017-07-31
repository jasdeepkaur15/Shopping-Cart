package dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import domain.Order;
import domain.User;
import util.DBConnection;


public class OrderDao implements OrderInterface{

	public void inserttableorder1(int customerid, int productid,int quantity) throws SQLException, ClassNotFoundException {
		Connection con=DBConnection.getConnection();
		Statement st=con.createStatement();
		try
		{
			String sql6="insert into ordertable values(" +customerid+ ", "+ productid + ", "+ quantity +")";
			st.executeUpdate(sql6);
		}
		catch(Exception e)
		{
			System.out.print(e.getMessage());
		}
		st.close();
		con.close();
	}

    public List<Order> getAllOrders(){
		List<Order> orders=new ArrayList<Order>();
		Connection conn= null;
		ResultSet rs=null;
		try {
			conn = DBConnection.getConnection();
			String sql = "SELECT * FROM ordertable";
			PreparedStatement pst=conn.prepareStatement(sql);
			rs=pst.executeQuery(sql);

			while(rs.next()){
				//Retrieve by column name
				Order order=new Order(rs.getInt("customer_id"),rs.getInt("product_id"),rs.getInt("quantity"));
				orders.add(order);
			}
			rs.close();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return orders;
	}
}
