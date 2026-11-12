package pvz.logic;
import java.util.Random;

import pvz.logic.gameobjects.factories.PlantFactory;
import utils.Position;
import pvz.logic.gameobjects.Plant;
import pvz.control.Level;
import pvz.logic.gameobjects.GameObjectContainer;
import pvz.logic.gameobjects.GameItem;


// FALTA RANDOM

public class Game implements GameStatus, GameWorld, GameModel {
	public static final int INITIAL_COINS = 50;
	
	private boolean playerQuits;
	private final Level level;
	private final long seed;
	private Random rand;
	private int numCycle;
	private int suncoins;
	private int remainingZombies;
	
	private GameObjectContainer container;
	private ZombieManager zombieManager;
	
	
	public Game(long seed, Level level) {
		this.seed = seed;
		this.level = level;
		initGame();
	}
	
	private void initGame() { //separo del cosntructor para usar en reset
		//ya no Random rand pq no es local
		numCycle  = 0;
		suncoins = INITIAL_COINS;
		playerQuits = false;
		remainingZombies = level.getNumberOfZombies();
		rand = new Random(seed);
		container = new GameObjectContainer();
		zombieManager = new ZombieManager(this, level, rand);
	}
	
	//TODO. Falta comentar lo que hace cada una auqnue sea obvio para que no nos penalice jeje:
	
	@Override
	public GameItem getGameItemInPosition (Position p) {
		return container.getGameItemInPosition(p);
	}
	
	@Override
	public int getCycles() {
		return numCycle;
	}
	
	@Override
    public void reset() {
        initGame();
    }

    @Override
    public void update() {
    	// Falta eliminar objectos muertos
        numCycle++;
        zombieManager.update();
        container.update();
        
        // Comprobamos si debe aparecer un zombie
        if (remainingZombies > 0 && rand.nextDouble() < level.getZombieFrequency()) {
        	int zombieRow = rand.nextInt(Game.NUM_ROWS);
        	
        	// La posición del nuevo zombie será en una fila aleatoria y en la columna de la derecha (NUM_COLS)
        	Position spawnPos = new Position(zombieRow, NUM_COLS);
        	
        	// falta el ZombieFactory
        	
        	remainingZombies--;
        }
    }

    @Override
    public void quit() {
        this.playerQuits = true;
    }

    @Override
    public boolean addGameObject(String plantType, Position p) {
    	boolean add = false;
        Plant plant = PlantFactory.spawnPlant(plantType, this, p);
        if (plant != null && this.suncoins >= plant.getCost()) {
            this.suncoins -= plant.getCost();//descuenta soles
            this.container.add(plant);//añade la planta a container
            add = true;
        }
        return add;
    }
    
    @Override
    public boolean addGameObjectForFree(String plantType, Position p) {
    	boolean add = false;
        Plant plant = PlantFactory.spawnPlant(plantType, this, p);
        if (plant != null) {
            this.container.add(plant);//añade la planta a container
            add = true;
        }
        return add;
    }

    @Override
    public void addSuncoins(int amount) {
        this.suncoins += amount;
    }

    @Override
    public int getCoins() {
        return suncoins;
    }

    @Override
    public boolean isInsideBoard(Position p) {
        boolean inside = false;
        if (p != null) {
        	inside = p.row() >= 0 && p.row() < NUM_ROWS && p.column() >= 0 && p.column() < NUM_COLS;
        }
        return inside;
    }
    
    @Override
    public boolean isInBoardLimit(Position p) {
    	boolean limit = false;
    	if (p != null) {
    		limit = p.column() == -1 || p.column() == Game.NUM_COLS;
    	}
    	return limit;
    }
    
    @Override
    public boolean isValidPosition(Position p) {
    	boolean valid = false;
    	if (p != null) {
    		valid = isInsideBoard(p) || isInBoardLimit(p);
    	}
    	return valid;
    }

    @Override
    public boolean isEmpty(Position p) {
        return container.getGameItemInPosition(p) == null;
    }

    @Override
    public boolean checkGameObject(String plantType) {
    	boolean check = false;
    	if (plantType != null) {
    		check = PlantFactory.spawnPlant(plantType, this, new Position(0, 0)) != null; 
    	}
        return check;
    }

    @Override
    public int getRemainingZombies() {
        return remainingZombies;
    }

    @Override
    public String positionToString(Position p) {
        return this.container.positionToString(p);
    }

    @Override
    public boolean playerWins() {
        return remainingZombies == 0 && container.allZombiesWereKilled();
    }

    @Override
    public boolean playerQuits() {
        return playerQuits;
    }

    @Override
    public boolean hasGameFinished() {
        return playerQuits || playerWins() || container.zombiesReachedHouse();
    }
    
    @Override
    public boolean doZombiesReachTheHouse() {
    	// ...
    }
}
