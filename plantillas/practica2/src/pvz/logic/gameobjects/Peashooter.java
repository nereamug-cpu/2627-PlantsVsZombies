package pvz.logic.gameobjects;
import pvz.utils.*;
import pvz.view.Messages;
import pvz.logic.GameWorld;

public class Peashooter extends Plant{
	private static final int COST = 50;
	private static final int ENDURANCE = 3;
	private static final int DAMAGE = 1;
	
	Peashooter(GameWorld game, Position p) {
		super(game, p, COST, ENDURANCE, DAMAGE);
	}
	
	
	@Override
	public String getIcon() {
		return Messages.PEASHOOTER_ICON;
	}
	
	@Override
	public String getDescription() {
		return Messages.PEASHOOTER_DESCRIPTION;
	}
	
	@Override
	public void update() {
		if (isAlive()) {
			// Comprobar si está bien
			Position p = super.getPosition();
			game.attackZombie(p, DAMAGE);
		}
	}
}
