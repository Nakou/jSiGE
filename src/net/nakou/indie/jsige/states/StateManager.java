/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package net.nakou.indie.jsige.states;

import java.util.ArrayList;
import org.newdawn.slick.GameContainer;

/**
 *
 * @author Julia & Nakou
 */
public class StateManager {
    private AbstractState activeState;
    private ArrayList<AbstractState> states;
    private GameContainer gc;
    
    public StateManager(GameContainer gc){
        this.gc = gc;
        states = new ArrayList<>();
    }
    
    public void update(int delta){
        for(AbstractState s : states){
            if(s.isActive()){
                s.update(delta);
            }
        }
    }

    public void render(){
        for(AbstractState s : states){
            if(s.isActive()){
                s.render();
            }
        }
    }
    
    public void addState(AbstractState s){
	states.add(s);
    }

    public AbstractState getState(String n){
	for(AbstractState s : states){
	    if(s.getName().equals(n))
		return s;
	}
	return null;
    }
    
    public AbstractState getActive(){
        for(AbstractState s : states){
            if(s.isActive()){
                return s;
            }
        }
        return null;
    }
}
