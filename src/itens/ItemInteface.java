package itens;

public interface ItemInteface {
	
	final static String STONE   = "stone";
	final static String PAPER   = "paper";
	final static String SCISSOR = "scissor";
	
	/**
	 * Method to return the item of this win the game
	 * 
	 * @return
	 */
	public ItemInteface getWinTo();
	
	/**
	 * Method to return the item of this loose the game
	 * 
	 * @return
	 */
	public ItemInteface getLooseTo();
	
	/**
	 * Method to return type of a item
	 * 
	 * @return
	 */
	public String typeOf();
	
	/**
	 * Method to return correct translate on item classes
	 * 
	 * @return
	 */
	public abstract String translatePortuguese();
}
