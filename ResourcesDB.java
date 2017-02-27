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
public class ResourcesDB {
    
    private static ResourcesDB resources = new ResourcesDB();
    
    private List<Resource> listOfResources = new ArrayList<>();
    
    private ResourcesDB()
    {
        
        //private List<Resource> listOfResources = new ArrayList<Resource>();
        
        listOfResources.add(new Resource(1));
        listOfResources.add(new Resource(2));
        listOfResources.add(new Resource(3));
        listOfResources.add(new Resource(4));
        listOfResources.add(new Resource(5));
    }
    
    public static ResourcesDB getInstance()
    {
        return resources;
    }
    
    public List<Resource> getResources()
    {
        return listOfResources;
    }
    
}
