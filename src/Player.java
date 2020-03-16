import itens.Item;

public class Player {
	
	String name;
	Item item;
	
	/**
	 * @param name
	 * @param item
	 */
	public Player(String name, Item item) {
		super();
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
	public Item getItem() {
		return item;
	}
	/**
	 * @param item the item to set
	 */
	public void setItem(Item item) {
		this.item = item;
	}
}
