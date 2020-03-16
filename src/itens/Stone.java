package itens;

public class Stone implements Item {

	@Override
	public Item getWinTo() {
		return new Scissor();
	}

	@Override
	public Item getLooseTo() {
		return new Paper();
	}	
}
