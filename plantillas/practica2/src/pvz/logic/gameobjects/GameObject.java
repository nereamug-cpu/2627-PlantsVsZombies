package pvz.logic.gameobjects;

import pvz.logic.GameWorld;
import utils.Position;

public abstract class GameObject implements GameItem {
	protected GameWorld game;
	protected Position position;
	
	public GameObject() {
		this.game = null;
		this.position = null;
	}
	
	public GameObject(GameWorld game, Position p) {
		this.game = game;
		this.position = p;
	}
	
	public boolean isInPosition(Position other) {
		boolean isInPosition = false;
        if (other != null && this.position != null) isInPosition = this.position.equals(other);
        return isInPosition;	
	}
	
	public Position getPosition() {
		return position;
	}
	
	public abstract String getIcon();
	
	public abstract String getDescription();
	
	public abstract boolean isAlive();
	
	public abstract void onEnter();
	
	public abstract void onExit();
	
	public abstract void update();
	
	public abstract boolean canBeSpawnedAt(Position p);
	
}
