/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package locusauthbasedsystem;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Pranita
 */
public class UsersDB {
    
    private static UsersDB users = new UsersDB();
    
    private List<User> listOfUsers = new ArrayList<>();
    
    private UsersDB()
    {
       listOfUsers.add(new User(1));
       listOfUsers.add(new User(2));
       listOfUsers.add(new User(3));
    }
    
    public static UsersDB getInstance()
    {
        return users;
    }
    
    public List<User> getAllUsers()
    {
        return this.listOfUsers;
    }
}
