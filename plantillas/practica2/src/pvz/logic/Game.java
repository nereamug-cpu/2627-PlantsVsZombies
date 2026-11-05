package pvz.logic;
import java.util.Random;
import pvz.utils.*;
import pvz.logic.gameobjects.*;
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
}
