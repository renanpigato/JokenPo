package itens;

public class ItemBuilder {

	public static ItemInterface create(String type) throws Exception {
		
		switch (type) {
		
			case ItemInterface.PAPER:
				return new Paper();
				
			case ItemInterface.STONE:
				return new Stone();
				
			case ItemInterface.SCISSOR:
				return new Scissor();
				
			default:
				throw new Exception("Item desconhecido");
		}
	}
}
