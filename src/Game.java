import java.util.ListIterator;

import javax.json.JsonArray;
import javax.json.JsonObject;

import itens.ItemBuilder;

public class Game {

	final static int WIN = 1;
	final static int TIE_GAME = 0; 
	
	PlayersList players = new PlayersList();
	String name;
	Judge judge;

	/**
	 * @param game
	 * @throws Exception 
	 */
	public Game(JsonObject game) throws Exception {
		super();
		this.init(game);
	}
	
	/**
	 * @param game
	 * @param judge
	 * @throws Exception 
	 */
	public Game(JsonObject game, Judge judge) throws Exception {
		super();
		this.init(game);
		this.judge = judge;
	}

	/**
	 * Initialize object
	 * 
	 * @param game
	 * @throws Exception 
	 */
	private void init(JsonObject game) throws Exception {
		
		this.name = game.getString("name");		
		JsonArray playersArray = game.getJsonArray("players");
		
		for (int i = 0; i < playersArray.size(); i++) {
			
			JsonObject playerObject = playersArray.getJsonObject(i);
			
			this.players.add(new Player(
					playerObject.getString("name"),
					ItemBuilder.create(playerObject.getString("item"))
			));
		}
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
	 * @return the judge
	 */
	public Judge getJudge() {
		return judge;
	}

	/**
	 * @param judge the judge to set
	 */
	public void setJudge(Judge judge) {
		this.judge = judge;
	}

	/**
	 * Return a player by index
	 * 
	 * @param index
	 * @return
	 */
	public Player getPlayer(int index) {
		//return this.players.getJsonObject(index);
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
			
			if(player.getName().equals(new String(name))) {
				return player;
			}
		}
		
		return null;
	}
	
	/**
	 * Process a result of a game
	 * 
	 * @return
	 */
	public String result() {
		return this.processResult(this.judge);
	}
	
	/**
	 * Process a result of another judge
	 * 
	 * @return
	 */
	public String result(Judge judge) {
		return this.processResult(judge);
	}
	
	private String processResult(Judge judge) {
		
		String result = new String("Game: "+ this.name);
		result += new String(" - ");
		
		switch (judge.adjudicate(this.players)) {
		
			case WIN:
				result += judge.getWinner().getName() + "("+ judge.getWinner().getItem().translatePortuguese() +") ganhou o jogo";
				break;
				
			case TIE_GAME:
				PlayersList winners = judge.getWinners();
				String winnersName  = new String("");
				ListIterator<Player> itWinners = winners.listIterator();
				
				while (itWinners.hasNext()) {
					
					Player winner = (Player) itWinners.next();
					winnersName  += winner.getName();
					winnersName  += "("+ winner.getItem().translatePortuguese() +")";
					
					if(itWinners.hasNext()) {
						winnersName += new String(", ");
					}
				}
				
				result += "Houve empate entre os jogadores: "+ winnersName;
				break;
	
			default:
				result += "Não houve ganhadores";
				break;
		}
		
		return result;
	}
}
