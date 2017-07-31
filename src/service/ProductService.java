package service;

import dao.ProductDao;
import dao.ProductInterface;
import domain.Product;

import java.sql.SQLException;

public class ProductService {
    public ProductInterface productInterface;

    public ProductService() {
        productInterface=new ProductDao();
    }

    public void insertProduct(int productid, String productname, int productprice,int productquantity) throws SQLException, ClassNotFoundException {
        productInterface.inserttableproduct1(productid,productname,productprice,productquantity);
    }

    public Product getProduct(int productId){
        return productInterface.getProductForProductId(productId);
    }
}
