package pvz.logic;
import java.util.Random;
import pvz.utils.*;
import pvz.view.Messages;
import pvz.logic.gameobjects.*;
import pvz.logic.gameobjects.factories.PlantFactory;
import pvz.logic.gameobjects.factories.ZombieFactory;
import pvz.control.Level;

public class Game implements GameStatus, GameWorld, GameModel {
	public static final int INITIAL_COINS = 50;
	
	private boolean playerQuits;
	private final Level level;
	private final long seed;
	private int numCycle;
	private int suncoins;
	
	private GameObjectContainer container;
	
	
	public Game(long seed, Level level) {
		this.seed = seed;
		this.level = level;
		initGame();
	}
	
	private void initGame() { //separo del cosntructor para usar en reset
		Random rand = new Random(seed); //rand solo se usa aquí, es variable local
		/*
		zombiesManager= new ZombiesManager(this, level, rand);
		peashooters = new PeashooterList(); 
		sunflowers = new SunflowerList();
		*/
		numCycle  = 0;
		suncoins = INITIAL_COINS;
		playerQuits = false;
	}
	
	//...
	@Override
	public GameItem getGameItemInPosition (Position position) {
		return container.getGameItemInPosition(position);
	}
	
	@Override
	public int getCycles() {
		return numCycle;
	}
	
	@Override
	public int getCoins() {
		return suncoins;
	}
	
	@Override
	public int getRemainingZombies() {
		return ZombieFactory.getAvailabkeZombies().size();
	}
	
	@Override
	public boolean isEmpty(Position position) {
		return container.isEmpty(position);
	}
	
	@Override
	public boolean isInsideBoard(Position position) {
		return position.row() >= 0 && position.row() < NUM_ROWS && position.column() >= 0 && position.column() <NUM_COLS;
	}
	
	@Override
	public void addPlant(String plantType, Position position) {
		Plant plant = PlantFactory.spawnPlant(plantType, this, position);
		container.add(plant);
	}
	
	@Override
	public void generateCoins(int amount) {
		suncoins += amount;
	}
	
	@Override
	public String positionToString(Position p) {
		if (!container.isEmpty(p)) {
			
		}
		else {
			return Messages.EMPTY_STRING;
		}
	}
}
