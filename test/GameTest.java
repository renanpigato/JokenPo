import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import itens.Paper;
import itens.Stone;

class GameTest {

	@Test
	void testGetPlayer() {
		
		Player p1 = new Player("pl1", new Stone());
		Player p2 = new Player("pl2", new Paper());
		PlayersList players = new PlayersList();
		players.add(p1);
		players.add(p2);
		
		Game g = new Game(players, new String("GameTest"));
		
		assertEquals(p1, g.getPlayer("pl1"));
		assertEquals(p2, g.getPlayer(1));
	}

}
