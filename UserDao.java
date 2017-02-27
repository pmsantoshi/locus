/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package locusauthbasedsystem;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Pranita
 */
public class UserDao {
    
    private UsersDB uDB = UsersDB.getInstance();
    
    private Map<Integer, User> userMap = new HashMap<Integer, User>();
    
    public UserDao()
    {
        initUserMap();
    }
    
    private void initUserMap()
    {
        for(User user: uDB.getAllUsers())
        {
            userMap.put(user.getId(), user);
        }
    }
    
    public List<User> getAllUsers()
    {
        return uDB.getAllUsers();
    }
    
    public User getUserByID(int id)
    {
        return userMap.get(id);
    }
    
}
