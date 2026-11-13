package pvz.logic.gameobjects;

import java.util.ArrayList;


import java.util.List;
import pvz.logic.Game;
import pvz.view.Messages;
import utils.Position;

public class GameObjectContainer {
	
	private List<GameObject> gameObjects;
	
	public GameObjectContainer() {
		gameObjects = new ArrayList<>();
	}
	
	public GameItem getGameItemInPosition(Position position) {
		GameItem sol = null;
		boolean found = false;
		int pos = 0;
		
		while (!found && pos < gameObjects.size()) {
			GameObject object_actual = gameObjects.get(pos);
			
			if (object_actual.isInPosition(position)) {
				found = true;
				sol = object_actual;
			}
			else {
				pos++;
			}
		}
		
		return sol;
	}
	
	public void add(GameObject o) {
		if (o != null) this.gameObjects.add(o);
	}
	
	public void update() {
        for (int i = 0; i < gameObjects.size(); i++) {
        	gameObjects.get(i).update();
        }
        removeDead();
    }

	public String positionToString(Position p) {
		String c = Messages.EMPTY_STRING;
        boolean found = false;
        int i = 0;
        
        while (!found && i < gameObjects.size()) {
            GameObject objectAct = gameObjects.get(i);
            if (objectAct.isInPosition(p) && objectAct.isAlive()) {
                c = objectAct.getIcon();
                found = true;
            } else i++;
        }
        return c;
    }
	
	public void removeDead() {
		for (int i = 0; i < gameObjects.size(); i++) {
			if (!gameObjects.get(i).isAlive()) {
				gameObjects.remove(i);
			}
		}
	}
	
	public boolean receiveDamage(Position p, int damage) {
		boolean attacked = false;
		boolean found = false;
		int pos = 0;
		while (!found && pos < gameObjects.size()) {
			GameObject objectAct = gameObjects.get(pos);
			if (objectAct.getPosition().equals(p)) {
				found = true;
				attacked = objectAct.receiveZombieAttack(damage) && objectAct.receivePlantAttack(damage);
			}
		}
		return attacked;
	}
	
	
	public String iconInPosition(Position p) {
		String icon = Messages.EMPTY_STRING;
		boolean found = false;
		int pos = 0;
		
		while (!found && pos < gameObjects.size()) {
			GameObject objectAct = gameObjects.get(pos);
			if (objectAct.getPosition().equals(p)) {
				found = true;
				icon = objectAct.getIcon();
			}
		}
		
		return icon;
	}
	
	public boolean doZombieReachTheHouse() {
		boolean reach = false;
		int pos = 0;
		
		while (!reach && pos < gameObjects.size()) {
			GameObject objectAct = gameObjects.get(pos);
			if (objectAct.getPosition().column() < 0) {
				reach = true;
			}
		}
		
		return reach;
	}
}
