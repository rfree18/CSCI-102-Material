
public class InventoryItem {
	
	private AudioFormat record;
	private int quantity;
	private double price;
	
	public AudioFormat getRecord() {
		return this.record;
	}
	
	public void setRecord(AudioFormat record) {
		this.record = record;
	}
	
	public int getQuantity() {
		return this.quantity;
	}
	
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
	public double getPrice() {
		return this.price;
	}
	
	public void setPrice(double price) {
		this.price = price;
	}
	
	public String toString() {
		return "Artist: " + this.getRecord().getArtist() + " Album: " + 
						this.getRecord().getAlbum() + " Year: " + this.record.getYear() + 
						" Format: " + this.getRecord().getFormat() + " Quantity: " + 
						this.getQuantity() + " Price: " + this.getPrice();
	}
	
	public boolean equals(Object a) {
		
		InventoryItem newItem = (InventoryItem) a;
		
		if(this.getRecord().equals(newItem.getRecord())) {
			return true;
		}
		
		else
			return false;
	}

}
