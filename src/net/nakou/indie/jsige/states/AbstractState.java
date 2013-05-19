/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package net.nakou.indie.jsige.states;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;
import org.newdawn.slick.Sound;

/**
 *
 * @author Julia & Nakou
 */
public abstract class AbstractState {

    protected boolean active = false;
    protected String name;
    protected GameContainer gc;
    protected Graphics graphics;
    protected Sound sound;
    protected Input inputs;
    protected StateManager stateManager;
    
    
    public AbstractState(String name, GameContainer gc, Graphics g, StateManager sm){
        this.name = name;
        this.gc = gc;
        this.graphics = g;
        this.inputs = gc.getInput();
        this.stateManager = sm;
    }
    
    public boolean isActive() {
        return this.active;
    }

    abstract void update(int delta);
    
    abstract void init();
    abstract void inputs(int delta);
    abstract void render();
    
    @Deprecated
    public void setActive(boolean b){
        this.active = b;
        AbstractState s = this.stateManager.getActive();
        if(s != null)
            s.setActive(false);
        this.init();
    }
    
    public void activate(){
        AbstractState s = this.stateManager.getActive();
        if(s != null)
            s.desactivate();
        this.active = true;
        this.init();    
    }
    
    public void desactivate(){
        this.active = false;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    
}
