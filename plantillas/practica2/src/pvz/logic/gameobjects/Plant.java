package pvz.logic.gameobjects;

import pvz.logic.GameWorld;
import pvz.logic.gameobjects.factories.PlantFactory;
import pvz.view.Messages;
import utils.Position;

public abstract class Plant extends GameObject{
	 private int cost;
	 protected int endurance;
	 private int damage;

	 
	 Plant(GameWorld game, Position p, int cost, int endurance, int damage) {
		 super(game, p);
		 this.cost = cost;
		 this.endurance = endurance;
		 this.damage = damage;
	 }
	 
	 public abstract String getSymbol();
	 public abstract String getNameAndShortcut();
	 public abstract String getName();
	 
	 @Override
	 public String getIcon() {
		 int enduranceAux = 0;
		 if (isAlive()) enduranceAux = this.endurance;
		 return String.format(Messages.GAME_OBJECT_ICON, getSymbol(), enduranceAux);
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
	 
	 public int getCost() {
		    return this.cost;
	 }
	 
	 public int getEndurance() {
		    return this.endurance;
	 }
	 
	 public int getDamage() {
		 return damage;
	 }
	
	 @Override
	 public boolean receivePlantAttack(int damage) {
		 return false;
	 }
	 
	 @Override
	 public boolean canBeSpawnedAt(Position p) {
		 return PlantFactory.spawnPlant(getNameAndShortcut(), this.game, p) != null;
	 }
	 
	 public abstract Plant copy(Position p, GameWorld gameWorld);
}
