package client;

import domain.Product;
import service.ProductService;
import util.ReadFile;

import java.util.List;


public class ProductClient {
    public static void main(String[] args) {
        try {
        List<Product> products= ReadFile.readProductCSV();
            ProductService pservice=new ProductService();

            for(Product p:products){
                pservice.insertProduct(p.getProductId(),p.getProductName(),p.getProductPrice(),p.getQuantity());
            }
        System.out.println(pservice.getProduct(1).toString());
        } /*catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }*/ catch (Exception e) {
            e.printStackTrace();
        }
    }

}
