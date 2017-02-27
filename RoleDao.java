/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package locusauthbasedsystem;

import java.util.*;

/**
 *
 * @author Pranita
 */
public class RoleDao {
    
    //public static RoleDao roles = new RoleDao();
    
    private EnumMap<Role,HashMap<Resource,HashSet<ActionType>>> rolesMap = new EnumMap<>(Role.class);
    
    public RoleDao()
    {
        initRolesMap();
    }
    
    private void initRolesMap()
    {
        ResourceDao rDao = new ResourceDao();
        
        //For Admin Role - Add all resources and all provide all the actionTypes        
        
        HashMap<Resource,HashSet<ActionType>> resourcesAndActionTypesForAdmins = new HashMap<>();               
        for(Resource resource: rDao.getAllResources())
        {
            resourcesAndActionTypesForAdmins.put(resource,new HashSet<>(Arrays.asList(ActionType.READ, ActionType.WRITE, ActionType.AUTHORIZE, ActionType.DELETE)));
        }        
        rolesMap.put(Role.Admin, resourcesAndActionTypesForAdmins);        
        
        //For External users - Provide read and write permissions on resources 1 & 2 and provide read only permission on resource 3
        
        HashMap<Resource,HashSet<ActionType>> resourcesAndActionTypesForExternalUsers = new HashMap<>();
        
        resourcesAndActionTypesForExternalUsers.put(rDao.getResourceByID(1), new HashSet<>(Arrays.asList(ActionType.READ, ActionType.WRITE)));
        resourcesAndActionTypesForExternalUsers.put(rDao.getResourceByID(2), new HashSet<>(Arrays.asList(ActionType.READ, ActionType.WRITE)));
        resourcesAndActionTypesForExternalUsers.put(rDao.getResourceByID(3), new HashSet<>(Arrays.asList(ActionType.READ)));
        
        rolesMap.put(Role.externalUser, resourcesAndActionTypesForExternalUsers);
        
        //For Operations - Provide  read, write and authorize permissions on resources 1,2,4
        
        HashMap<Resource,HashSet<ActionType>> resourcesAndActionTypesForOperations = new HashMap<>();
        
        resourcesAndActionTypesForOperations.put(rDao.getResourceByID(1), new HashSet<>(Arrays.asList(ActionType.READ, ActionType.WRITE, ActionType.AUTHORIZE)));
        resourcesAndActionTypesForOperations.put(rDao.getResourceByID(2), new HashSet<>(Arrays.asList(ActionType.READ, ActionType.WRITE, ActionType.AUTHORIZE)));
        resourcesAndActionTypesForOperations.put(rDao.getResourceByID(4), new HashSet<>(Arrays.asList(ActionType.READ, ActionType.WRITE, ActionType.AUTHORIZE)));

        rolesMap.put(Role.Operations, resourcesAndActionTypesForOperations);
        
        //For Client Service Reps, provide read only permissions on r1 and r2, and all actionTypes on resource4
        
        HashMap<Resource,HashSet<ActionType>> resourcesAndActionTypesForCSRs = new HashMap<>();
        
        resourcesAndActionTypesForCSRs.put(rDao.getResourceByID(1), new HashSet<>(Arrays.asList(ActionType.READ)));
        resourcesAndActionTypesForCSRs.put(rDao.getResourceByID(2), new HashSet<>(Arrays.asList(ActionType.READ)));
        resourcesAndActionTypesForCSRs.put(rDao.getResourceByID(4), new HashSet<>(Arrays.asList(ActionType.READ, ActionType.WRITE, ActionType.AUTHORIZE, ActionType.DELETE)));

        rolesMap.put(Role.ClientServiceRep, resourcesAndActionTypesForCSRs);
        
    }
    
    public HashMap<Resource, HashSet<ActionType>> getResourcesByRole(Role r)
    {
        return rolesMap.get(r);
    }
}
