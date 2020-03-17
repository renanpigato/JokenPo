package itens;

public class Scissor extends Item implements ItemInterface {

	@Override
	public ItemInterface getWinTo() {
		return new Paper();
	}

	@Override
	public ItemInterface getLooseTo() {
		return new Stone();
	}

	@Override
	public String typeOf() {
		return ItemInterface.SCISSOR;
	}

	@Override
	public String translatePortuguese() {
		return super.translatePortuguese(ItemInterface.SCISSOR);
	}
}
