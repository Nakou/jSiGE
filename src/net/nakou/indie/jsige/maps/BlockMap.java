/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package net.nakou.indie.jsige.maps;

import net.nakou.indie.jsige.entity.AbstractEntity;
import net.nakou.indie.jsige.entity.Controller;
import net.nakou.indie.jsige.entity.Element;
import net.nakou.indie.jsige.entity.RigidBody;
import org.newdawn.slick.Image;

/**
 *
 * @author Nakou
 */
public class BlockMap extends AbstractEntity {
    
    public BlockMap(Controller c, Element e, RigidBody r,String s){
	super(c,e,r,s);
    }

    public BlockMap(int SizeX, int SizeY,int posX,int posY, Image sprite) {
	super();
    }
    
    public BlockMap(){
	super();
    }
}
