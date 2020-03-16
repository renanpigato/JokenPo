import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import org.junit.jupiter.api.Test;

import itens.Paper;
import itens.Scissor;
import itens.Stone;

class JudgeJUnitJupiterTest {
	
	@Test
	void winPaperTwoPlayers() {
		
		Player p1 = new Player("pl1", new Stone());
		Player p2 = new Player("pl2", new Paper());
		
		PlayersList playersList = new PlayersList();
		playersList.add(p1);
		playersList.add(p2);
		
		Judge jd = new Judge(playersList);
		
		assertEquals(Game.WIN, jd.adjudicate());
		assertArrayEquals(jd.getWinner().getName().getBytes(), (new String("pl2")).getBytes());
	}
	
	@Test
	void winStoneTwoPlayers() {
		
		Player p1 = new Player("pl1", new Stone());
		Player p2 = new Player("pl2", new Scissor());
		
		PlayersList playersList = new PlayersList();
		playersList.add(p1);
		playersList.add(p2);
		
		Judge jd = new Judge(playersList);
		
		assertEquals(Game.WIN, jd.adjudicate());
		assertArrayEquals(jd.getWinner().getName().getBytes(), (new String("pl1")).getBytes());
	}
	
	@Test
	void winScissorTwoPlayers() {
		
		Player p1 = new Player("pl1", new Scissor());
		Player p2 = new Player("pl2", new Paper());
		
		PlayersList playersList = new PlayersList();
		playersList.add(p1);
		playersList.add(p2);
		
		Judge jd = new Judge(playersList);
		
		assertEquals(Game.WIN, jd.adjudicate());
		assertArrayEquals(jd.getWinner().getName().getBytes(), (new String("pl1")).getBytes());
	}
	
	@Test
	void winManyPlayers() {
		
		Player p1 = new Player("pl1", new Scissor());
		Player p2 = new Player("pl2", new Paper());
		Player p3 = new Player("pl3", new Paper());
		
		PlayersList playersList = new PlayersList();
		playersList.add(p1);
		playersList.add(p2);
		playersList.add(p3);
		
		Judge jd = new Judge(playersList);
		
		assertEquals(Game.WIN, jd.adjudicate());
		assertArrayEquals(jd.getWinner().getName().getBytes(), (new String("pl1")).getBytes());
	}
	
	@Test
	void noWinnersManyPlayers() {
		
		Player p1 = new Player("pl1", new Scissor());
		Player p2 = new Player("pl2", new Paper());
		Player p3 = new Player("pl3", new Stone());
		
		PlayersList playersList = new PlayersList();
		playersList.add(p1);
		playersList.add(p2);
		playersList.add(p3);
		
		Judge jd = new Judge(playersList);
		
		// No winners
		assertEquals(-1, jd.adjudicate());
		assertEquals(0, jd.getWinners().size());
		assertEquals(3, jd.getLoosers().size());
	}
	
	@Test
	void tieGameManyPlayers() {
		
		Player p1 = new Player("pl1", new Scissor());
		Player p2 = new Player("pl2", new Scissor());
		Player p3 = new Player("pl3", new Paper());
		
		PlayersList playersList = new PlayersList();
		playersList.add(p1);
		playersList.add(p2);
		playersList.add(p3);
		
		PlayersList playersListWinners = new PlayersList();
		playersListWinners.add(p1);
		playersListWinners.add(p2);
		
		Judge jd = new Judge(playersList);
		
		// Tie on the Game
		assertEquals(Game.TIE_GAME, jd.adjudicate());
		
		// Validate the looser
		assertSame(p3, jd.getLoosers().get(0));
		
		// Validate the winners
		assertArrayEquals(playersListWinners.toArray(), jd.getWinners().toArray());
	}
}
