package pvz.logic.gameobjects;
import pvz.utils.*;
import pvz.view.Messages;
import pvz.logic.GameWorld;

public abstract class Plant extends GameObject{
	 private int cost;
	 private int endurance;
	 private int damage;

	 
	 Plant(GameWorld game, Position p, int cost, int endurance, int damage) {
		 super(game, p);
		 this.cost = cost;
		 this.endurance = endurance;
		 this.damage = damage;
	 }
	 
	 protected abstract String getSymbol();
	 protected abstract String getNameAndShortcut();
	 
	 @Override
	 public String getIcon() {
		 return String.format(Messages.GAME_OBJECT_ICON, getSymbol(), endurance);
	 }
	 
	 @Override
	 public String getDescription() {
		 return String.format(Messages.PLANT_DESCRIPTION, getNameAndShortcut(), cost, damage, endurance);
	 }
	 
	 @Override
	 public boolean isAlive() {
		 return endurance > 0;
	 }
	 
	 @Override
	 public void onEnter() {}
	 
	 @Override
	 public void onExit() {}
	 
	 @Override
	 public boolean receiveZombieAttack(int damage) {
		 endurance -= damage;
		 return true;
	 }
	 
	 public boolean verifyName(String plantName) {
		 return getNameAndShortcut().equalsIgnoreCase(plantName);
	 }
	 
	 abstract public Plant add(GameWorld g, Position p);
}
