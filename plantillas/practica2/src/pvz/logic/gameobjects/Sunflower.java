package pvz.logic.gameobjects;

import pvz.logic.GameWorld;
import pvz.utils.Position;
import pvz.view.Messages;

public class Sunflower extends Plant{
	private static final int COST = 20;
	private static final int ENDURANCE = 1;
	private static final int COINS_GENERATED = 10; // 10 soles cada tres ciclos
	private static final int PERIOD = 3;
	private static final int DAMAGE = 0;
	
	private int cycles;
	
	public Sunflower(GameWorld game, Position p) {
		super(game, p, COST, ENDURANCE, DAMAGE);
		this.cycles = 0;
	}
	
	
	@Override
	public String getIcon() {
	    String icon = "";
	    if (isAlive()) icon = String.format(Messages.SUNFLOWER_ICON, getEndurance());
	    else icon = String.format(Messages.SUNFLOWER_ICON, 0);
	    return icon;
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
	
	@Override
    protected String getSymbol() {
        return Messages.SUNFLOWER_SYMBOL;
    }

    @Override
    protected String getNameAndShortcut() {
        return Messages.SUNFLOWER_NAME_AND_SHORTCUT;
    }
}
