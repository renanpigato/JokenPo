import itens.ItemInterface;

public class Player {
	
	String name;
	ItemInterface item;
	
	/**
	 * @param name
	 * @param item
	 */
	public Player(String name, ItemInterface item) {
		this.name = name;
		this.item = item;
	}
	
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	
	/**
	 * @return the item
	 */
	public ItemInterface getItem() {
		return item;
	}
	
	/**
	 * @param item the item to set
	 */
	public void setItem(ItemInterface item) {
		this.item = item;
	}
}
