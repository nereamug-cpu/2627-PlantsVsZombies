package pvz.logic.gameobjects;

import utils.Position;
import pvz.logic.GameWorld;
import pvz.view.Messages;

public class BucketHead extends Zombies {
	public static final int DAMAGE = 1;
	public static final int ENDURANCE = 8;
	public static final int SPEED = 4;
	
	private int cycles;
	
	public BucketHead(Position p, GameWorld gameWorld) {
		super(gameWorld, p, DAMAGE, ENDURANCE, SPEED);
	}
	
	@Override
	public String getSymbol() {
		return Messages.BUCKET_HEAD_ZOMBIE_SYMBOL;
	}
	
	@Override
	public String getName() {
		return Messages.BUCKET_HEAD_ZOMBIE_NAME;
	}
	
	// falta el update() que como no hemos llegado a Actions es un lío
	
	
	@Override
	public Zombies copy(Position p, GameWorld gameWorld) {
		return new BucketHead(p, gameWorld);
	}
}
