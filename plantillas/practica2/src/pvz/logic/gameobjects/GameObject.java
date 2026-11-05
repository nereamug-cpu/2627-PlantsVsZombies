package pvz.logic.gameobjects;
import pvz.logic.GameWorld;
import pvz.utils.*;

public abstract class GameObject implements GameItem {
	protected GameWorld game;
	protected Position position;
	
	GameObject(GameWorld game, Position p) {
		this.game = game;
		this.position = p;
	}
	
	public boolean isInPosition(Position other) {
		return this.position.equals(other);
	}
	
	public Position getPosition() {
		return position;
	}
	
	abstract public String getIcon();
	
	abstract public String getDescription();
	
	abstract public boolean isAlive();
	
	abstract public void onEnter();
	
	abstract public void onExit();
	
	abstract public void update();
	
	//...
}
