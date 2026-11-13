package pvz.logic.gameobjects;

import utils.Position;
import pvz.logic.GameWorld;
import pvz.view.Messages;

public class Zombie extends Zombies {
	public static final int DAMAGE = 1;
	public static final int ENDURANCE = 5;
	public static final int SPEED = 2;
	
	private int cycles;
	
	public Zombie() {
		super(DAMAGE, ENDURANCE, SPEED);
	}
	
	public Zombie(Position p, GameWorld gameWorld) {
		super(gameWorld, p, DAMAGE, ENDURANCE, SPEED);
		cycles = 0;
	}
	
	@Override
	public String getSymbol() {
		return Messages.ZOMBIE_SYMBOL;
	}
	
	@Override
	public String getName() {
		return Messages.ZOMBIE_NAME;
	}
	
	// falta el update() que como no hemos llegado a Actions es un lío
	
	@Override
	public Zombies copy(Position p, GameWorld gameWorld) {
		return new Zombie(p, gameWorld);
	}
}
