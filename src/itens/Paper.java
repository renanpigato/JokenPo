package itens;

public class Paper extends Item implements ItemInterface {

	@Override
	public ItemInterface getWinTo() {
		return new Stone();
	}

	@Override
	public ItemInterface getLooseTo() {
		return new Scissor();
	}

	@Override
	public String typeOf() {
		return ItemInterface.PAPER;
	}

	@Override
	public String translatePortuguese() {
		return super.translatePortuguese(ItemInterface.PAPER);
	}
}
