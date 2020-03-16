package itens;

public class Scissor implements Item {

	@Override
	public Item getWinTo() {
		return new Paper();
	}

	@Override
	public Item getLooseTo() {
		return new Stone();
	}

	
}
