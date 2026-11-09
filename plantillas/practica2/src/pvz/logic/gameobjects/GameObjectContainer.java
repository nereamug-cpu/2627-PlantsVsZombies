package pvz.logic.gameobjects;

import java.util.ArrayList;
import java.util.List;
import pvz.utils.Position;
import pvz.view.Messages;

public class GameObjectContainer {
	
	private List<GameObject> gameObjects;
	
	public GameObjectContainer() {
		gameObjects = new ArrayList<>();
	}
	
	public GameItem getGameItemInPosition(Position position) {
		GameItem sol = null;
		boolean enc = false;
		int pos = 0;
		
		while (!enc && pos < gameObjects.size()) {
			GameObject object_actual = gameObjects.get(pos);
			
			if (object_actual.isInPosition(position)) {
				enc = true;
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
        for (int i = 0; i < gameObjects.size(); i++) gameObjects.get(i).update();
    }

	public String positionToString(Position p) {
		String c = Messages.EMPTY_STRING;
        boolean found = false;
        int i = 0;
        
        while (!found && i < gameObjects.size()) {
            GameObject o = gameObjects.get(i);
            if (o.isInPosition(p) && o.isAlive()) {
                c = o.getIcon();
                found = true;
            } else i++;
        }
        return c;
    }
	
}
