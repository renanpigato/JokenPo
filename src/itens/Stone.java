package itens;

public class Stone extends Item implements ItemInteface {

	@Override
	public ItemInteface getWinTo() {
		return new Scissor();
	}

	@Override
	public ItemInteface getLooseTo() {
		return new Paper();
	}

	@Override
	public String typeOf() {
		return ItemInteface.STONE;
	}

	@Override
	public String translatePortuguese() {
		return super.translatePortuguese(ItemInteface.STONE);
	}	
}
