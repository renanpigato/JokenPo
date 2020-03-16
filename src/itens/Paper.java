package itens;

public class Paper extends Item implements ItemInteface {

	@Override
	public ItemInteface getWinTo() {
		return new Stone();
	}

	@Override
	public ItemInteface getLooseTo() {
		return new Scissor();
	}

	@Override
	public String typeOf() {
		return ItemInteface.PAPER;
	}

	@Override
	public String translatePortuguese() {
		return super.translatePortuguese(ItemInteface.PAPER);
	}
}
