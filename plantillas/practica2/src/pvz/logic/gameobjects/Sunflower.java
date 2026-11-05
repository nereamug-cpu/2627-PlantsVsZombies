package pvz.logic.gameobjects;
import pvz.utils.*;
import pvz.view.Messages;
import pvz.logic.GameWorld;

public class Sunflower extends Plant{
	private static final int COST = 20;
	private static final int ENDURANCE = 1;
	private static final int COINS_GENERATED = 10; // 10 soles cada tres ciclos
	private static final int PERIOD = 3;
	private static final int DAMAGE = 0;
	
	private int cycles;
	
	Sunflower(GameWorld game, Position p) {
		super(game, p, COST, ENDURANCE, DAMAGE);
	}
	
	
	@Override
	public String getIcon() {
		return Messages.SUNFLOWER_ICON;
	}
	
	@Override
	public String getDescription() {
		return String.format(Messages.SUNFLOWER_DESCRIPTION, COST, DAMAGE, ENDURANCE);
	}
	
	@Override
	public void update() {
		if (isAlive()) {
			if (cycles == PERIOD) {
				game.generateCoins(COINS_GENERATED);
				cycles = 0;
			}
			cycles++;
		}
	}
}
