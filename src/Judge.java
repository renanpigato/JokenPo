import java.util.ListIterator;

import itens.Item;

public class Judge {

	PlayersList winners = new PlayersList();
	PlayersList loosers = new PlayersList();
	
	public int adjudicate(PlayersList players) {
		
		ListIterator<Player> itPlayers = players.listIterator();
		
		while (itPlayers.hasNext()) {
			
			Player player  = (Player) itPlayers.next();
			Item itemWin   = player.getItem().getWinTo();
			Item itemLoose = player.getItem().getLooseTo();
			
			ListIterator<Player> itAnotherPlayers = players.listIterator();
			
			while (itAnotherPlayers.hasNext()) {
				
				Player anotherPlayer = (Player) itAnotherPlayers.next();
				
				if(!player.equals(anotherPlayer)) {
					
					if(anotherPlayer.equals(itemWin)) {
						this.winners.add(player);
					}
					
					if(anotherPlayer.equals(itemLoose)) {
						this.loosers.add(player);
						this.winners.remove(player);
					}
				}
			}
		}
		
		if(this.winners.size() > 1) {
			return Game.TIE_GAME;
		}
		
		if(this.winners.size() == 1) {
			return Game.WIN;
		}
		
		return -1;
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
		
		if(this.winners.isEmpty() && this.loosers.isEmpty()) {
			return true;
		}
		
		return false;
	}
}
