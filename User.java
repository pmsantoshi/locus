/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package locusauthbasedsystem;

//import locusauthbasedsystem.LocusAuthBasedSystem.Role;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;


/**
 *
 * @author Pranita
 */
public class User {
    
    private int id;
    
    private Set<Role> userRoles = new HashSet<>();
    
    //private Role r;
    
    public User(int id)
    {
        this.id = id;
    }
    
    public void setId(int value)
    {
        this.id = value;
    }
    
    public int getId()
    {
        return this.id;
    }
    
    public void addRole(Role r)
    {
        userRoles.add(r);
    }
    
    public void removeRole(Role r)
    {
        if(userRoles.contains(r))
        {
            userRoles.remove(r);
        }
    }
    
    public boolean doesUserHaveAccess(Resource r, ActionType at)
    {
        RoleDao roleDao = new RoleDao();
        
        HashMap<Resource,HashSet<ActionType>> userPermissions = new HashMap<>();
        
        for(Role role: userRoles)
        {
            HashMap<Resource,HashSet<ActionType>> userPermissionsForRole = roleDao.getResourcesByRole(role);
            
            for(Resource resource: userPermissionsForRole.keySet())
            {
                if(userPermissions.get(resource) == null)
                {
                    userPermissions.put(resource, userPermissionsForRole.get(resource));
                }
                else
                {
                    userPermissions.get(resource).addAll(userPermissionsForRole.get(resource));                                        
                }
            }
        }                                         
        
        if(userPermissions.get(r) == null)
        {
            return false;
        }
        else
        {
            if(userPermissions.get(r).contains(at))
            {
                return true;
            }
            else
            {
                return false;
            }
        }
    }
    
}
