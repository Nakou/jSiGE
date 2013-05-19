/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package net.nakou.indie.jsige.entity;

/**
 *
 * @author Nakou
 */
public class RigidBody {
    private AbstractEntity entity;
    private int weight;
    private int density;
    private boolean Static;
    private boolean solid;
    
    /**
     * in case of cloud or those shits.
     */
    public RigidBody(){
        weight = 0;
        Static = true;
        solid = false;
    }
    
    public RigidBody(AbstractEntity e,int w, boolean stc, boolean sld){
        this.entity = e;
        this.weight = w;
        this.solid = sld;
        this.Static = stc;
    }

    public int getDensity() {
        return density;
    }

    public void setDensity(int density) {
        this.density = density;
    }

    public boolean isStatic() {
        return Static;
    }

    public void setStatic(boolean isStatic) {
        this.Static = isStatic;
    }

    public boolean isSolid() {
        return solid;
    }

    public void setSolid(boolean isSolid) {
        this.solid = isSolid;
    }
    
    public int getWeight(){
        return this.weight;
    }
    
    public void setWeight(int w){
        this.weight = w;
    }


    public AbstractEntity getEntity() {
        return entity;
    }

    public void setEntity(AbstractEntity entity) {
        this.entity = entity;
    }
    
    
}
