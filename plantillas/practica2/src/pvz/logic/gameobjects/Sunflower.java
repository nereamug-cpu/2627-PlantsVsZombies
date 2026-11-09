package pvz.logic.gameobjects;

import pvz.logic.GameWorld;
import pvz.utils.Position;
import pvz.view.Messages;

public class Sunflower extends Plant{
	private static final int COST = 20;
	private static final int ENDURANCE = 1;
	private static final int PERIOD = 3;
	private static final int DAMAGE = 0;
	
	private int cycles;
	
	public Sunflower(GameWorld game, Position p) {
		super(game, p, COST, ENDURANCE, DAMAGE);
		this.cycles = 0;
	}
	
	@Override
	public void update() {
		if (isAlive()) {
			if (cycles == PERIOD) {
				game.addSuncoins(10);//2.1 añade coins directamente al jugador
				cycles = 0;
			}
			cycles++;
		}
	}
	
	@Override
    protected String getSymbol() {
        return Messages.SUNFLOWER_SYMBOL;
    }

    @Override
    protected String getNameAndShortcut() {
        return Messages.SUNFLOWER_NAME_AND_SHORTCUT;
    }
}
