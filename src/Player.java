import itens.ItemInteface;

public class Player {
	
	String name;
	ItemInteface item;
	
	/**
	 * @param name
	 * @param item
	 */
	public Player(String name, ItemInteface item) {
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
	public ItemInteface getItem() {
		return item;
	}
	/**
	 * @param item the item to set
	 */
	public void setItem(ItemInteface item) {
		this.item = item;
	}
}
