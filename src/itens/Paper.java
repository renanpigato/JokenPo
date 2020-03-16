package itens;

public class Paper implements Item {

	@Override
	public Item getWinTo() {
		return new Stone();
	}

	@Override
	public Item getLooseTo() {
		return new Scissor();
	}

}
