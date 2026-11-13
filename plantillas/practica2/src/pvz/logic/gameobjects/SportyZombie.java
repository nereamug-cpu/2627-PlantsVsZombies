package pvz.logic.gameobjects;

import utils.Position;

import pvz.logic.GameWorld;
import pvz.view.Messages;

public class SportyZombie extends Zombies {
	public static final int DAMAGE = 1;
	public static final int ENDURANCE = 2;
	public static final int SPEED = 1;
	
	public SportyZombie() {
		super(DAMAGE, ENDURANCE, SPEED);
	}
	
	public SportyZombie(Position p, GameWorld gameWorld) {
		super(gameWorld, p, DAMAGE, ENDURANCE, SPEED);
	}
	
	@Override
	public String getSymbol() {
		return Messages.SPORTY_ZOMBIE_SYMBOL;
	}
	
	@Override
	public String getName() {
		return Messages.SPORTY_ZOMBIE_NAME;
	}
	
	// falta el update() que como no hemos llegado a Actions es un lío
	
	@Override
	public Zombies copy(Position p, GameWorld gameWorld) {
		return new SportyZombie(p, gameWorld);
	}
}
