/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package locusauthbasedsystem;

/**
 *
 * @author Pranita
 */
public class LocusAuthBasedSystem {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        System.out.println("START");
        
        UserDao userDao = new UserDao();
        
        User userWithID1 = userDao.getUserByID(1);
        
        userWithID1.addRole(Role.Operations);
        
        //userWithID1.addRole(Role.Admin);
        
        ResourceDao resourceDao = new ResourceDao();
        
        Resource resourceWithID = resourceDao.getResourceByID(4);
        
        Boolean doesUserHavePermission = userWithID1.doesUserHaveAccess(resourceWithID, ActionType.READ);
        
        System.out.println(doesUserHavePermission);                
        
        System.out.println("END");
    }    
}
