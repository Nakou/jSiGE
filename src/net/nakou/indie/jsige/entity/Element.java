/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package net.nakou.indie.jsige.entity;

import net.nakou.indie.jsige.STATICS.CONF;
import org.newdawn.slick.Image;
import org.newdawn.slick.SpriteSheet;

/**
 *
 * @author Nakou
 */
public class Element{
    private AbstractEntity entity;
    private Image sprite = null;
    private SpriteSheet sheet;
    private float scale = 1.0f;  
    private float spriteSizeX = 0;
    private float spriteSizeY = 0;
    

    public Element(AbstractEntity entity, Image sprite){
	this.entity = entity;
	this.sprite = sprite;
	this.spriteSizeX = sprite.getWidth();
	this.spriteSizeY = sprite.getHeight();
    }    
    
    
    public Element(AbstractEntity entity, SpriteSheet sheet){
	this.entity = entity;
	this.sheet = sheet;
	this.sprite = sheet.getSprite(2,2);
	this.spriteSizeX = sprite.getWidth();
	this.spriteSizeY = sprite.getHeight();
    }
    
    public Element(AbstractEntity entity, SpriteSheet sheet, Image sprite){
	this.entity = entity;
	this.sheet = sheet;
	this.sprite = sprite;
	this.spriteSizeX = sprite.getWidth();
	this.spriteSizeY = sprite.getHeight();
    }

    public void draw() {
	if(CONF.debugLevel >= 3)
	    System.out.println("[DEBUG] PLAYER : X : "+entity.getController().getX()+" ; Y : "+entity.getController().getY()+" ;");
	sprite.draw(entity.getController().getX(), entity.getController().getY(), scale);
    }
    
    public Image getSprite() {
        return sprite;
    }

    public void setSprite(Image sprite) {
        this.sprite = sprite;
    }
    public AbstractEntity getEntity() {
        return entity;
    }

    public void setEntity(AbstractEntity entity) {
        this.entity = entity;
    }

    public float getScale() {
	return scale;
    }

    public void setScale(float scale) {
	this.scale = scale;
    }

    public SpriteSheet getSheet() {
	return sheet;
    }

    public void setSheet(SpriteSheet sheet) {
	this.sheet = sheet;
    }

    public float getSpriteSizeX() {
	return spriteSizeX;
    }

    public void setSpriteSizeX(float spriteSizeX) {
	this.spriteSizeX = spriteSizeX;
    }

    public float getSpriteSizeY() {
	return spriteSizeY;
    }

    public void setSpriteSizeY(float spriteSizeY) {
	this.spriteSizeY = spriteSizeY;
    }
    
    
}
