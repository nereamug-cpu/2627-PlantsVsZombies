package pvz.logic;
import java.util.Random;
import pvz.logic.gameobjects.factories.PlantFactory;
import pvz.logic.gameobjects.Plant;
import pvz.control.Level;
import pvz.logic.gameobjects.GameObjectContainer;
import pvz.logic.gameobjects.GameItem;
import pvz.utils.Position;

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
		this.container = new GameObjectContainer();
		initGame();
	}
	
	private void initGame() { //separo del cosntructor para usar en reset
		//ya no Random rand pq no es local
		numCycle  = 0;
		suncoins = INITIAL_COINS;
		playerQuits = false;
	}
	
	//TODO. Falta comentar lo que hace cada una auqnue sea obvio para que no nos penalice jeje:
	
	@Override
	public GameItem getGameItemInPosition (Position position) {
		return container.getGameItemInPosition(position);
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
        numCycle++;
    }

    @Override
    public void quit() {
        this.playerQuits = true;
    }

    @Override
    public void addGameObject(String plantType, Position position) {
        Plant plant = PlantFactory.spawnPlant(plantType, this, position);
        if (plant != null) {
            this.suncoins -= plant.getCost();//descuenta soles
            this.container.add(plant);//añade la planta a container
        }
    }

    @Override
    public void generateCoins(int amount) {
        this.suncoins += amount;
    }

    @Override
    public int getCoins() {
        return suncoins;
    }

    @Override
    public boolean isInsideBoard(Position p) {
        boolean inside = false;
        if (p != null) inside = p.row() >= 0 && p.row() < NUM_ROWS && p.column() >= 0 && p.column() < NUM_COLS;
        return inside;
    }

    @Override
    public boolean isEmpty(Position position) {
        return container.getGameItemInPosition(position) == null;
    }

    @Override
    public boolean checkGameObject(String plantType) {
        return true; 
    }

    @Override
    public int getRemainingZombies() {
        return 0;
    }

    @Override
    public String positionToString(Position position) {
        return "";
    }

    @Override
    public boolean playerWins() {
        return false;
    }

    @Override
    public boolean playerQuits() {
        return playerQuits;
    }

    @Override
    public boolean hasGameFinished() {
        return playerQuits;
    }
}
