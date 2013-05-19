/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package net.nakou.indie.jsige.entity;

import net.nakou.indie.jsige.STATICS.CONF;
import org.lwjgl.util.vector.Vector2f;
import org.newdawn.slick.geom.Rectangle;

/**
 *
 * @author Nakou
 */
public class Controller {
    private AbstractEntity entity;
    private Rectangle hitbox;
    private float x;
    private float y;
    private Vector2f accelerate;

    
    public Controller(AbstractEntity e, float x, float y){
	this.entity = e;
	this.x = x;
	this.y = y;
        this.accelerate = new Vector2f(0,0);
	this.hitbox = new Rectangle((int)this.x,(int)this.y,(int)this.entity.getElement().getSpriteSizeX(),(int)this.entity.getElement().getSpriteSizeY());
	if(CONF.debugLevel >= 3)
	    System.out.println("[DEBUG] X = "+(int)this.x+" ; Y = "+(int)this.y+" ; SX = "+(int)this.entity.getElement().getSpriteSizeX()+" ; SY = "+(int)this.entity.getElement().getSpriteSizeY()+" ; ");
    }
    
    public AbstractEntity getEntity() {
        return entity;
    }

    public void setEntity(AbstractEntity entity) {
        this.entity = entity;
    }

    public float getX() {
        return x;
    }

    public void setX(float x) {
        this.x = x;
    }

    public float getY() {
        return y;
    }

    public void setY(float y) {
        this.y = y;
    }

    public Rectangle getHitbox() {
        return hitbox;
    }

    public void setHitbox(Rectangle hitbox) {
        this.hitbox = hitbox;
    }

    public Vector2f getAccelerate() {
        return accelerate;
    }

    public void setAccelerate(Vector2f accelerate) {
        this.accelerate = accelerate;
    }

    public void refreshHitbox(float x, float y){
        this.hitbox.setLocation(x, y);
    }
    
    public void update(){
        this.x += this.accelerate.getX();
        this.y += this.accelerate.getY();
        this.refreshHitbox(this.x, this.y);
    }
    
}
