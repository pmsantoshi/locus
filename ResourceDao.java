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
public class ResourceDao {
    
    private ResourcesDB rDB = ResourcesDB.getInstance();
    
    private Map<Integer,Resource> resourceMap= new HashMap<>();
    
    public ResourceDao()
    {
        initResourceMap();
    }
    
    private void initResourceMap()
    {
        for(Resource r: rDB.getResources())
        {
            resourceMap.put(r.getId(),r);
        }
    }
    
    public List<Resource> getAllResources()
    {
        return rDB.getResources();
    }
    
    public Resource getResourceByID(int id)
    {                
        return resourceMap.get(id);
    }
    
    
    
}
