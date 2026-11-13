package pvz.logic;

import java.util.Random;
import pvz.control.Level;
import pvz.logic.gameobjects.Zombies;
import utils.Position;


/**
 * Manages the full lifecycle of zombies for a game session.
 *
 * <p>Responsibilities: deciding each cycle whether to spawn a new zombie
 * (probabilistically, subject to the remaining quota from {@link Level}),
 * delegating per-cycle updates and dead-removal to the underlying
 * {@link ZombieList}, and answering win/loss queries
 *
 */
public class ZombieManager {

	private GameWorld game;
	private Level level;
	private Random rand;
	private int remainingZombies;

	public ZombieManager(Game game, Level level, Random rand) {
		this.game = game;
		this.level = level;
		this.rand = rand;
		this.remainingZombies = level.getNumberOfZombies();
	}

	/**
	 * Checks if the game should add (if possible) a zombie to the game.
	 * 
	 * @return <code>true</code> if a zombie should be added to the game.
	 */
	private boolean shouldAddZombie() {
		return rand.nextDouble() < level.getZombieFrequency();
	}
	
	/**
	 * Return a random row within the board limits.
	 * 
	 * @return a random row.
	 */
	
	private int randomZombieRow() {
		return rand.nextInt(Game.NUM_ROWS);
	}
	
	public boolean addZombie() {
		int row = randomZombieRow();
		return addZombie(row);
	}

	public boolean addZombie(int row) {
		Position spawnPos = new Position(row, GameWorld.NUM_COLS);
		
		//si quedan, probabilidad se cumple y casilla vacía
		boolean canAdd = getRemainingZombies() > 0 && shouldAddZombie() && game.isEmpty(spawnPos);

		if(canAdd) {
			// TODO fill your code
			Zombies zombie = new Zombies(spawnPos, this.game);
			if (game.addGameObject(zombie)) {
				remainingZombies--;
			}
		}
		return canAdd;
	}
	
	public void update() {
		addZombie();
	}
		
	
	// TODO fill your code
	
	public int getRemainingZombies() {
		return remainingZombies;
	}
	
	public boolean allZombiesWereKilled() {
		return remainingZombies == 0;
	}
 }
