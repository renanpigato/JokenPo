package itens;

public class ItemBuilder {

	public static Item create(String type) throws Exception {
		
		switch (type) {
		
			case Item.PAPER:
				return new Paper();
				
			case Item.STONE:
				return new Stone();
				
			case Item.SCISSOR:
				return new Scissor();
				
			default:
				throw new Exception("Item desconhecido");
		}
	}
}
