package client;

import java.sql.SQLException;
import java.util.List;

import domain.User;
import service.UserService;
import util.ReadFile;


public class UserClient {
    public static void main(String[] args)  {
        try {
        List<User> users= ReadFile.readUserCSV();
            UserService userService=new UserService();

            for(User user:users){
               userService.insertUser(user.getUserId(),user.getName(),user.getEmail(),user.getContact());
            }
            List<User> list=userService.getAllUsers();
            for(User user:list)
            {
                System.out.println(user.toString());
            }
            User user=userService.getUser(users.get(1).getUserId());
            System.out.println(user.toString());
//            System.out.println("\n Data Retrieval Successfull");
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
