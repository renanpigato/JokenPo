package itens;

public class Stone extends Item implements ItemInterface {

	@Override
	public ItemInterface getWinTo() {
		return new Scissor();
	}

	@Override
	public ItemInterface getLooseTo() {
		return new Paper();
	}

	@Override
	public String typeOf() {
		return ItemInterface.STONE;
	}

	@Override
	public String translatePortuguese() {
		return super.translatePortuguese(ItemInterface.STONE);
	}	
}
