package pvz.logic.gameobjects;

import utils.Position;
import pvz.logic.GameWorld;
import pvz.view.Messages;

public class CherryBomb extends Plant{
	public static final int COST = 50;
	public static final int ENDURANCE = 2;
	public static final int DAMAGE = 10;
	
	public CherryBomb(Position p,  GameWorld gameWorld) {
		super(gameWorld, p, COST, ENDURANCE, DAMAGE);
	}
	
	@Override
	public String getSymbol() {
		return Messages.CHERRY_BOMB_SYMBOL;
	}
	
	@Override
	public String getName() {
		return Messages.CHERRY_BOMB_NAME;
	}
	
	@Override
	public String getNameAndShortcut() {
		return Messages.CHERRY_BOMB_NAME_SHORTCUT;
	}
	
	@Override
	public void update() {
		// ...
	}
	
	@Override
	public Plant copy(Position p, GameWorld gameWorld) {
		return new CherryBomb(p, gameWorld);
	}
}
