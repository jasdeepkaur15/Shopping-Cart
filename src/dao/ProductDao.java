package dao;

import java.sql.*;

import domain.Product;
import util.DBConnection;


public class ProductDao implements ProductInterface {

    public void inserttableproduct1(int productid, String productname, int productprice,int productquantity) throws SQLException, ClassNotFoundException {
        Connection conn= DBConnection.getConnection();

        PreparedStatement pst=conn.prepareCall("Insert into inventory VALUES (?,?,?,?)");
        pst.setInt(1, productid);
        pst.setString(2, productname);
        pst.setInt(3,productprice);
        pst.setInt(4,productquantity);
        pst.execute();
        System.out.println("Product Data has been saved to databse with primary Key as productId:");
    }

public Product getProductForProductId(int productId){
    Product product=null;
    Connection conn= null;
    ResultSet rs=null;
    try {
        conn = DBConnection.getConnection();
        String sql = "SELECT * FROM inventory WHERE product_id = "+productId;
        PreparedStatement pst=conn.prepareStatement(sql);
        rs=pst.executeQuery(sql);

        while(rs.next()){
            //Retrieve by column name
            product=new Product(rs.getInt("product_id"),rs.getString("product_name"),rs.getInt("product_price"),rs.getInt("product_quantity"));
        }
        rs.close();
    } catch (SQLException e) {
        e.printStackTrace();
    } catch (ClassNotFoundException e) {
        e.printStackTrace();
    }
    return product;
}
}
