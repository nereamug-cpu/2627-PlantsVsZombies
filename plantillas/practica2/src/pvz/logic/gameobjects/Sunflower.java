package pvz.logic.gameobjects;

import pvz.logic.GameWorld;
import pvz.view.Messages;
import utils.Position;

public class Sunflower extends Plant{
	public static final int COST = 20;
	public static final int ENDURANCE = 1;
	public static final int PERIOD = 3;
	public static final int DAMAGE = 0;
	private static final int COINS_GENERATED = 10;
	
	private int cycles;
	
	public Sunflower(Position p, GameWorld game) {
		super(game, p, COST, ENDURANCE, DAMAGE);
		this.cycles = 0;
	}
	
	@Override
	public void update() {
		if (isAlive()) {
			if (cycles == PERIOD) {
				game.addSuncoins(COINS_GENERATED);//2.1 añade coins directamente al jugador
				cycles = 0;
			}
			cycles++;
		}
	}
	
	@Override
    public String getSymbol() {
        return Messages.SUNFLOWER_SYMBOL;
    }

    @Override
    public String getNameAndShortcut() {
        return Messages.SUNFLOWER_NAME_AND_SHORTCUT;
    }
    
    @Override
    public Plant copy(Position p, GameWorld gameWorld) {
    	return new Sunflower(p, gameWorld);
    }
    
    @Override
    public String getName() {
    	return Messages.SUNFLOWER_NAME;
    }
}
