package dao;

import domain.Product;

import java.sql.SQLException;

/**
 * Created by jasdeepkaur on 3/7/17.
 */
public interface ProductInterface {

    public void inserttableproduct1(int productid, String productname, int productprice,int productquantity) throws SQLException, ClassNotFoundException;
    public Product getProductForProductId(int productId);


}
