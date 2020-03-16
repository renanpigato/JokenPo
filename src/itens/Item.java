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
			case ItemInteface.PAPER:
				return new String("papel");

			case ItemInteface.STONE:
				return new String("pedra");
				
			case ItemInteface.SCISSOR:
				return new String("tesoura");
		}
		
		return null;
	}
}
