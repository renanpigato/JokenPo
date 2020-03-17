package itens;

abstract class Item {
	
	/**
	 * Return translate of JokenPo itens, need param
	 * 
	 * @param type
	 * @return
	 */
	protected String translatePortuguese(String type) {
		
		switch (type) {
			case ItemInterface.PAPER:
				return new String("papel");

			case ItemInterface.STONE:
				return new String("pedra");
				
			case ItemInterface.SCISSOR:
				return new String("tesoura");
		}
		
		return null;
	}
}
