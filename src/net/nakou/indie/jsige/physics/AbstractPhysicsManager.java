/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package net.nakou.indie.jsige.physics;

import net.nakou.indie.jsige.entity.AbstractEntity;
import net.nakou.indie.jsige.entity.RigidBody;
import java.util.ArrayList;

/**
 * 
 * @author Nakou
 */
public abstract class AbstractPhysicsManager {
    protected ArrayList<RigidBody> rigidList;
    protected ArrayList<AbstractEntity> entityList;
    
    protected AbstractPhysicsManager(){
        rigidList = new ArrayList<>();
        entityList = new ArrayList<>();
    }
    
    protected AbstractPhysicsManager(int grav){
        rigidList = new ArrayList<>();
        entityList = new ArrayList<>();
    }    
    
    protected AbstractPhysicsManager(ArrayList<RigidBody> rL){
        rigidList = rL;
        entityList = new ArrayList<>();
    }

    protected AbstractPhysicsManager(ArrayList<RigidBody> rL, int grav){
        rigidList = rL;
        entityList = new ArrayList<>();
    }
    
    public void deleteElement(AbstractEntity e){
	entityList.remove(e);
	rigidList.remove(e.getRigidbody());
    }
    
    public void addElement(AbstractEntity e){
	entityList.add(e);
	rigidList.add(e.getRigidbody());
    } 
    
    public abstract void update(int delta);

}