package dao;


import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import domain.User;
import util.DBConnection;

public class UserDao implements UserInterface{

    public void inserttablecustomer1(int customerid, String customername, String customeremail,String customernumber) throws SQLException, ClassNotFoundException {
        Connection conn= DBConnection.getConnection();
        PreparedStatement pst=conn.prepareStatement("Insert into user values (?,?,?,?)");
        pst.setInt(1, customerid);
        pst.setString(2,customername);
        pst.setString(3,customeremail);
        pst.setString(4,customernumber);
        pst.execute();
        System.out.println("User Data has been saved to databse with primary Key :");
        conn.close();
    }
    public List<User> getAllUsers()
    {
        List<User> users=new ArrayList<User>();
        Connection conn= null;
        try {
            conn = DBConnection.getConnection();
            Statement stmt=conn.createStatement();
            String sql = "SELECT * FROM user";
            ResultSet rs = stmt.executeQuery(sql);
            while(rs.next()){
                //Retrieve by column name
                int id = rs.getInt("user_id");
                String name= rs.getString("user_name");
                String address = rs.getString("user_email");
                String email = rs.getString("user_contact");
                User user=new User(id,name,address,email);
                users.add(user);
            }
            rs.close();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return users;
    }

    public User getUserForId(int userId){
        User user=null;
        Connection conn= null;
        try {
            conn = DBConnection.getConnection();

            String sql = "SELECT * FROM user WHERE user_id= "+ userId ;
            PreparedStatement pst=conn.prepareStatement(sql);
            pst.execute();
            ResultSet rs = pst.executeQuery(sql);
            while(rs.next()){
                //Retrieve by column name
                user=new User(rs.getInt("user_id"),rs.getString("user_name"),rs.getString("user_email"),rs.getString("user_contact"));
            }
            rs.close();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return user;

    }


}
