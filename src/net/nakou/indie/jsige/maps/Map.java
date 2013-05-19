/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package net.nakou.indie.jsige.maps;

import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import net.nakou.indie.jsige.STATICS.CONF;
import net.nakou.indie.jsige.entity.AbstractEntity;
import net.nakou.indie.jsige.entity.Controller;
import net.nakou.indie.jsige.entity.Element;
import net.nakou.indie.jsige.entity.RigidBody;
import net.nakou.indie.jsige.physics.AbstractPhysicsManager;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.tiled.TiledMapPlus;

/**
 *
 * @author Nakou
 */
public class Map {

    private AbstractPhysicsManager physics; 
    private ArrayList<AbstractEntity> mapElements;
    private ArrayList<AbstractEntity> mobAndPlayerElements;
    private Image background;
    private TiledMapPlus tileMap;
    
    public Map(Image bgd, AbstractPhysicsManager phys) {
        mapElements = new ArrayList<>();
        mobAndPlayerElements = new ArrayList<>();
        physics = phys;
        background = bgd;
    }
    
    public Map (Image bgd, TiledMapPlus map, AbstractPhysicsManager phys){
        mapElements = new ArrayList<>();
        mobAndPlayerElements = new ArrayList<>();
        physics = phys;
        background = bgd;        
        tileMap = map;
	this.fillFromTile();
    }
    
    public void fillFromTile(){
	if(tileMap != null){
	    BlockMap ent;
	    Controller c;
	    Element e;
	    RigidBody r;
	    for (int xAxis=0;xAxis<tileMap.getWidth(); xAxis++)
	    {
		for (int yAxis=0;yAxis<tileMap.getHeight(); yAxis++)
		{
		    int tileID = tileMap.getTileId(xAxis, yAxis, 0);
		    if(CONF.debugLevel >= 3)
			System.out.println(tileMap.getTileProperty(tileID, "Solid", "0"));
		    if(tileMap.getTileProperty(tileID, "Solid", "0").equals("1")){
			try {
			    ent = new BlockMap();
			    e = new Element(ent, tileMap.getVisibleTile(xAxis, yAxis));
			    ent.setElement(e);
			    c = new Controller(ent, xAxis*32, yAxis*32);
			    ent.setController(c);
			    r = new RigidBody(ent,1, true, true);
			    ent.setRigidbody(r);
                            ent.setEntityName("BlockN°"+tileID);
			} catch (SlickException ex) {
			    Logger.getLogger(Map.class.getName()).log(Level.SEVERE, null, ex);
			    ent = null;
			}
			this.addElement(ent);
		    }
		}
	    }
	}
    }
    
    public void draw(){
	background.draw(0, 0);
        for(AbstractEntity e : mapElements){
            e.draw();
        }
        for(AbstractEntity e : mobAndPlayerElements){
            e.draw();
        }
    }
    
    public void addPlayer(AbstractEntity p){
        this.mobAndPlayerElements.add(p);
        this.physics.addElement(p);
    }
    
    public void addElement(AbstractEntity e){
        this.mapElements.add(e);
        this.physics.addElement(e);
    }

    public AbstractPhysicsManager getPhysics() {
	return physics;
    }

    public void setPhysics(AbstractPhysicsManager physics) {
	this.physics = physics;
    }

}
