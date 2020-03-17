import java.util.ListIterator;

public class Game {

	final static int LOOSE    = -1;
	final static int WIN      = 1;
	final static int TIE_GAME = 0; 
	
	PlayersList players = new PlayersList();
	String name;

	/**
	 * 
	 * @param players
	 */
	public Game(PlayersList players) {
		this.players = players;
	}
	
	/**
	 * 
	 * @param players
	 * @param name
	 */
	public Game(PlayersList players, String name) {
		this.players = players;
		this.name = name;
	}

	/**
	 * @return the players
	 */
	public PlayersList getPlayers() {
		return players;
	}

	/**
	 * @param players the players to set
	 */
	public void setPlayers(PlayersList playersList) {
		this.players = playersList;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Return a player by index
	 * 
	 * @param index
	 * @return
	 */
	public Player getPlayer(int index) {
		return this.players.get(index);
	}
	
	/**
	 * Return a player by name
	 * 
	 * @param name
	 * @return
	 */
	public Player getPlayer(String name) {
		
		ListIterator<Player> itPlayer = this.players.listIterator();
		
		while (itPlayer.hasNext()) {
			
			Player player = (Player) itPlayer.next();
			
			if(player.getName().equals(name)) {
				return player;
			}
		}
		
		return null;
	}
}
