package util;

import dao.*;
import domain.Order;
import domain.Product;
import domain.User;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.List;

/**
 * Created by jasdeepkaur on 3/7/17.
 */
public class GenerateBillCSV {

    OrderInterface orderInterface=new OrderDao();
    UserInterface userInterface=new UserDao();



    public void generateOrderDetailsCSV(){
        try{

            String tvalue="CustomerId \t,ProductId \t,OrderedQuantity \n";
            BufferedWriter bw=new BufferedWriter(new FileWriter("/Users/jasdeepkaur/Order.csv"));

            List<Order> ordersList= orderInterface.getAllOrders();
            bw.write(tvalue);
            for (Order order:ordersList){

                int customerId=order.getCustomerId();
                int productId=order.getProductId();
                int orderQty=order.getQuantity();

                tvalue=customerId+", \t"+productId+", \t"+orderQty+"\t "+"\n";
                bw.write(tvalue);
            }
            bw.close();
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
        System.out.println("OrderDetailsCSV.csv has been generated in the Home directory");
    }


}
