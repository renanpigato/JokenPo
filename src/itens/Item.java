package itens;

public interface Item {
	
	final static String STONE   = "stone";
	final static String PAPER   = "paper";
	final static String SCISSOR = "scissor";
	
	public Item getWinTo();
	
	public Item getLooseTo();
}
