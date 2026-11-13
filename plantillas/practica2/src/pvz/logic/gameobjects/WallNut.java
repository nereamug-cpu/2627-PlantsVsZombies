package pvz.logic.gameobjects;

import utils.Position;
import pvz.logic.GameWorld;
import pvz.view.Messages;

public class WallNut extends Plant {
	public static final int COST = 50;
	public static final int ENDURANCE = 10;
	public static final int DAMAGE = 0;
	
	public WallNut() {
		super(COST, ENDURANCE, DAMAGE);
	}
	
	public WallNut(Position p, GameWorld gameWorld) {
		super(gameWorld, p, COST, ENDURANCE, DAMAGE);
	}
	
	@Override
	public String getSymbol() {
		return Messages.WALL_NUT_SYMBOL;
	}
	
	@Override
	public String getName() {
		return Messages.WALL_NUT_NAME;
	}
	
	@Override 
	public String getNameAndShortcut() {
		return Messages.WALL_NUT_NAME_SHORTCUT;
	}
	
	@Override
	public void update() {
		if (isAlive()) {
			// ?
		}
	}
	
	@Override
	public Plant copy(Position p,  GameWorld gameWorld) {
		return new WallNut(p, gameWorld);
	}
}
