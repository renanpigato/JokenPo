package itens;

public class ItemBuilder {

	public static ItemInteface create(String type) throws Exception {
		
		switch (type) {
		
			case ItemInteface.PAPER:
				return new Paper();
				
			case ItemInteface.STONE:
				return new Stone();
				
			case ItemInteface.SCISSOR:
				return new Scissor();
				
			default:
				throw new Exception("Item desconhecido");
		}
	}
}
