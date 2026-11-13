package pvz.logic.gameobjects;

import pvz.logic.GameWorld;
import pvz.view.Messages;
import utils.Position;

public class Peashooter extends Plant{
	public static final int COST = 50;
	public static final int ENDURANCE = 3;
	public static final int DAMAGE = 1;
	
	public Peashooter() {
		super(COST, ENDURANCE, DAMAGE);
	}
	
	public Peashooter(Position p, GameWorld game) {
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
	        Position p = getPosition();
	        boolean hit = false;
	        Position target = p.right();

	        while (!hit && game.isInsideBoard(target)) {
	            GameItem item = game.getGameItemInPosition(target);
	            
	            if (item != null) {
	                // Al atacar al item, receiveZombieAttack o recibir ataque según la interfaz
	                hit = item.receivePlantAttack(DAMAGE);
	            } else {
	                target = target.right();
	            }
	        }
	    }
	}
	
	@Override
    public String getSymbol() {
        return Messages.PEASHOOTER_SYMBOL;
    }

    @Override
    public String getNameAndShortcut() {
        return Messages.PEASHOOTER_NAME_AND_SHORTCUT;
    }
    
    @Override
    public Plant copy(Position p, GameWorld gameWorld) {
    	return new Peashooter(p, gameWorld);
    }
    
    @Override
    public String getName() {
    	return Messages.PEASHOOTER_NAME;
    }
}
