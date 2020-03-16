package itens;

public class Scissor extends Item implements ItemInteface {

	@Override
	public ItemInteface getWinTo() {
		return new Paper();
	}

	@Override
	public ItemInteface getLooseTo() {
		return new Stone();
	}

	@Override
	public String typeOf() {
		return ItemInteface.SCISSOR;
	}

	@Override
	public String translatePortuguese() {
		return super.translatePortuguese(ItemInteface.SCISSOR);
	}
}
