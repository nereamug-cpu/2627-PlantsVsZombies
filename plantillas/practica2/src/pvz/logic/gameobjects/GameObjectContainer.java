package pvz.logic.gameobjects;
import java.util.List;
import pvz.utils.*;
import java.util.ArrayList;

public class GameObjectContainer {
	private List<GameObject> gameObjects;
	
	public GameObjectContainer() {
		gameObjects = new ArrayList<>();
	}
	
	//...
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
}
