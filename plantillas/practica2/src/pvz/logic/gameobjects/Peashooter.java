package pvz.logic.gameobjects;

import pvz.logic.GameWorld;
import pvz.utils.Position;
import pvz.view.Messages;

public class Peashooter extends Plant{
	private static final int COST = 50;
	private static final int ENDURANCE = 3;
	private static final int DAMAGE = 1;
	
	public Peashooter(GameWorld game, Position p) {
		super(game, p, COST, ENDURANCE, DAMAGE);
	}
	
	
	@Override
	public String getIcon() {
	    String icon = Messages.EMPTY_STRING;
	    if (isAlive()) icon = String.format(Messages.PEASHOOTER_ICON, getEndurance());
	    else icon = String.format(Messages.PEASHOOTER_ICON, 0);
	    return icon;
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
		}
	}
	
	@Override
    protected String getSymbol() {
        return Messages.PEASHOOTER_SYMBOL;
    }

    @Override
    protected String getNameAndShortcut() {
        return Messages.PEASHOOTER_NAME_AND_SHORTCUT;
    }
}
