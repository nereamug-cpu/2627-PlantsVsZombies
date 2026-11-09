package pvz.logic.gameobjects;
import pvz.utils.*;
import pvz.view.Messages;
import pvz.logic.GameWorld;

public abstract class Zombie extends GameObject{
	private int damage;
	private int endurance;
	private int speed;
	
	private int cycles;
	
	Zombie(GameWorld game, Position p, int damage, int endurance, int speed) {
		super(game, p);
		this.damage = damage;
		this.endurance = endurance;
		this.speed = speed;
	}
	
	protected abstract String getSymbol();
	protected abstract String getName();
	
	@Override
	public String getIcon() {
		return String.format(Messages.GAME_OBJECT_ICON, getSymbol(), endurance);
	}
	
	@Override
	public String getDescription() {
		return String.format(Messages.ZOMBIE_DESCRIPTION, getSymbol(), speed, damage, endurance);
	}
	
	@Override
	public boolean isAlive() {
		return endurance > 0;
	}
	
	@Override
	public boolean receiveZombieAttack(int damage) {
		return false;
	}
	
	@Override
	public void update() {
		if (isAlive()) {
		  if (cycles == speed) {
			  cycles = 0;
			  Position p = position.left();
			  if (game.isEmpty(p)) {
				  position = p;
			  }
		  }

		  GameItem item = game.getGameItemInPosition(position);
		  if (item != null) {
		    item.receiveZombieAttack(this.damage);
		  }
		  cycles++;
		}
	}
	
	public boolean verifyName(String zombieName) {
		return getName().equalsIgnoreCase(zombieName);
	}
	
	abstract public Zombie add(GameWorld g, Position p);
}
