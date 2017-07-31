package client;

import java.util.List;

import domain.Order;
import service.OrderService;
import util.ReadFile;
import util.GenerateBillCSV;


public class OrderClient {
    public static void main(String[] args)throws Exception {

        List<Order> ordersList= ReadFile.readOrderCSV();
        OrderService orderService=new OrderService();
        for (Order order:ordersList){
            orderService.insertOrder(order.getCustomerId(),order.getProductId(),order.getQuantity());
            System.out.println("Saved");
        }
        GenerateBillCSV bill=new GenerateBillCSV();
        bill.generateOrderDetailsCSV();

	}
}
