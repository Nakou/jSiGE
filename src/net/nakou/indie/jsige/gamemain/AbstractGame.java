/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package net.nakou.indie.jsige.gamemain;

import net.nakou.indie.jsige.STATICS.CONF;
import net.nakou.indie.jsige.states.StateManager;
import org.newdawn.slick.BasicGame;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;

/**
 *
 * @author Nakou
 */
public abstract class AbstractGame extends BasicGame{
    
    protected StateManager stateManager;
    
    public AbstractGame(){
	super(CONF.nameGame);
    }

    /**
     * 
     * @param gc
     * @throws SlickException 
     * You have to declare the stateManager = new StateManager(gc);
     * and declare all the states you have mades.
     */
    @Override
    public abstract void init(GameContainer gc) throws SlickException;

    @Override
    public void update(GameContainer gc, int i) throws SlickException {
        stateManager.update(i);
    }

    @Override
    public void render(GameContainer gc, Graphics grphcs) throws SlickException {
        stateManager.render();
    }
    
}
