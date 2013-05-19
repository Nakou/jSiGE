/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package net.nakou.indie.jsige.entity;

/**
 *
 * @author Nakou
 */
public abstract class AbstractEntity {
    protected String entityName;
    protected Controller controller; // Position - Vector - Acceleration
    protected Element element; // Sprite - Image 
    protected RigidBody rigidbody; // Solid - Weight - 
    
    public AbstractEntity(Controller c, Element e, RigidBody r){
	this.element = e;
	this.controller = c;
	this.rigidbody = r;
    }

    public AbstractEntity(Controller c, Element e, RigidBody r, String name){
	this.element = e;
	this.controller = c;
	this.rigidbody = r;
        this.entityName = name;
    }    
    
    public AbstractEntity(){
	
    }

    public void update(){
        controller.update();
    }
    
    public void draw(){
	this.element.draw();
    }
    
    public Controller getController() {
        return controller;
    }

    public void setController(Controller controller) {
        this.controller = controller;
    }

    public Element getElement() {
        return element;
    }

    public void setElement(Element e) {
        this.element = e;
    }

    public RigidBody getRigidbody() {
        return rigidbody;
    }

    public void setRigidbody(RigidBody rigidbody) {
        this.rigidbody = rigidbody;
    }

    public String getEntityName() {
        return entityName;
    }

    public void setEntityName(String entityName) {
        this.entityName = entityName;
    }
    
    
}
