package util;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import domain.Order;
import domain.Product;
import domain.User;


public class ReadFile {

    final static List<User> userList=new ArrayList<User>();
    final static List<Product> productList=new ArrayList<Product>();
    final static List<Order> orderList=new ArrayList<Order>();

            public static List<User> readUserCSV()throws Exception{
                FileInputStream fis=new FileInputStream("resources/CustomerDetails.txt");
                InputStreamReader isr=new InputStreamReader(fis);
                BufferedReader br=new BufferedReader(isr);
                String line=br.readLine();

                while(line != null){
                    String[] comSeperated=line.split(",");
                    int id=Integer.parseInt(comSeperated[0]);
                    String name=comSeperated[1];
                    String email=comSeperated[2];
                    String contact=comSeperated[3];
                    User u=new User();
                    u.setUserId(id);
                    u.setName(name);
                    u.setEmail(email);
                    userList.add(u);
                    line=br.readLine();
                }
                return userList;
            }

            public static List<Product> readProductCSV()throws Exception{
                FileInputStream fis=new FileInputStream("resources/ProductDetails.txt");
                InputStreamReader isr=new InputStreamReader(fis);
                BufferedReader br=new BufferedReader(isr);
                String line=br.readLine();

                while(line != null){
                    String[] comSeperated=line.split(",");
                    int id=Integer.parseInt(comSeperated[0]);
                    String name=comSeperated[1];
                    int qty=Integer.parseInt(comSeperated[3]);
                    int unitPrice=Integer.parseInt(comSeperated[2]);
                    Product p=new Product(id, name,unitPrice,qty);
                    productList.add(p);
                    line=br.readLine();
                }
                return productList;
            }

            public static List<Order> readOrderCSV()throws Exception{
        FileInputStream fis=new FileInputStream("resources/OrderDetails.txt");
        InputStreamReader isr=new InputStreamReader(fis);
        BufferedReader br=new BufferedReader(isr);
        String line=br.readLine();

        while(line != null){
            String[] comSeperated=line.split(",");
            int custId=Integer.parseInt(comSeperated[0]);
            int productId=Integer.parseInt(comSeperated[1]);
            int qty=Integer.parseInt(comSeperated[2]);
            Order order=new Order(custId, productId, qty);
            orderList.add(order);
            line=br.readLine();
        }
        return orderList;
    }


}
