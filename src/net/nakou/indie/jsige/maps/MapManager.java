/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package net.nakou.indie.jsige.maps;
import java.util.ArrayList;

/**
 *
 * @author Nakou
 */
public class MapManager {
   private ArrayList<Map> mapList;
   private Map activeMapRef;
    
    public MapManager(){
        mapList = new ArrayList<>();
    }
    
    public void addMap(Map m){
        mapList.add(m);
    }
    
    public void setActive(Map m){
        activeMapRef = m;
    }
    
    public void draw(){
        activeMapRef.draw();
    }

    public Map getActiveMapRef() {
	return activeMapRef;
    }
    
}
