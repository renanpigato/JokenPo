import java.util.ListIterator;
import itens.ItemInterface;

public class Judge {

	Player winner;
	PlayersList players = new PlayersList();
	PlayersList winners = new PlayersList();
	PlayersList loosers = new PlayersList();

	/**
	 * @param players
	 */
	public Judge(Game game) {
		this.players = game.getPlayers();
	}

	/**
	 * @return the winner
	 */
	public Player getWinner() {
		return this.winner;
	}

	/**
	 * Return the list of players that win the game
	 * 
	 * @return
	 */
	public PlayersList getWinners() {
		return this.winners;
	}
	
	/**
	 * Return the list of players that loose the game
	 * 
	 * @return
	 */
	public PlayersList getLoosers() {
		return this.loosers;
	}
	
	/**
	 * Return if tie on game
	 * 
	 * @return
	 */
	public boolean isTieGame() {
		
		if(!this.winners.isEmpty() && this.winners.size() > 1) {
			return true;
		}
		
		return false;
	}
	
	/**
	 * Judge a game with the players of instance
	 * 
	 * @return
	 */
	public int adjudicate() {
		return this.adjudicate(this.players);
	}
	
	
	/**
	 * Method that separate loosers and winners
	 * 
	 * @param player
	 * @param anotherPlayer
	 */
	private void detachWinnersLoosers(Player player, Player anotherPlayer) {
		
		ItemInterface itemWin   = player.getItem().getWinTo();
		ItemInterface itemLoose = player.getItem().getLooseTo();
		
		if(anotherPlayer.getItem().typeOf().equals(itemWin.typeOf())) {
			this.winners.remove(player);
			this.winners.add(player);
		}
		
		if(anotherPlayer.getItem().typeOf().equals(itemLoose.typeOf())) {
			this.loosers.remove(player);
			this.loosers.add(player);
		}
	}

	/**
	 * This method clean the winners 
	 * that loose to another player
	 */
	private void cleanWinners() {
		
		if(!this.loosers.isEmpty()) {
			
			ListIterator<Player> itLoosers = this.loosers.listIterator();
			
			while (itLoosers.hasNext()) {
				
				Player pLooser = (Player) itLoosers.next();
				this.winners.remove(pLooser);
			}
		}
	}
	
	/**
	 * Judge a game with the players informed
	 * 
	 * @param players
	 * @return
	 */
	public int adjudicate(PlayersList players) {
		
		ListIterator<Player> itPlayers = players.listIterator();
		
		while (itPlayers.hasNext()) {
			
			Player player  = (Player) itPlayers.next();
			ListIterator<Player> itAnotherPlayers = players.listIterator();
			
			while (itAnotherPlayers.hasNext()) {
				
				Player anotherPlayer = (Player) itAnotherPlayers.next();
				
				if(!player.equals(anotherPlayer)) {
					this.detachWinnersLoosers(player, anotherPlayer);
				}
			}
		}
		
		this.cleanWinners();
		
		if(this.winners.isEmpty()) {
			return Game.LOOSE;
		}
		
		if(this.winners.size() == 1) {
			this.winner = this.winners.get(0);
			return Game.WIN;
		}
		
		return Game.TIE_GAME;
	}
	
	/**
	 * Process a result of a game
	 * 
	 * @return
	 */
	public String result() {
		return this.processResult(this.players);
	}
	
	/**
	 * Process a result of a game
	 * 
	 * @return
	 */
	public String result(PlayersList players) {
		return this.processResult(players);
	}
	
	/**
	 * Process and return the result of a judge
	 * 
	 * @param players
	 * @return
	 */
	private String processResult(PlayersList players) {
		
		String result = new String("");
		
		switch (this.adjudicate(players)) {
		
			case Game.WIN:
				result += this.getWinner().getName() + "("+ this.getWinner().getItem().translatePortuguese() +") ganhou o jogo";
				break;
				
			case Game.TIE_GAME:
				result += "Houve empate entre os jogadores: "+ this.getWinnersName();
				break;
	
			default:
				result += "Não houve ganhadores";
				break;
		}
		
		return result;
	}
	
	/**
	 * Return the name of winners
	 * 
	 * @return
	 */
	public String getWinnersName() {
		
		PlayersList winners = this.getWinners();
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
		
		return winnersName;
	}
}
