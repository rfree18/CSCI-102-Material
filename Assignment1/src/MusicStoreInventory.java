import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;

public class MusicStoreInventory {

	private InventoryItem[] listOfItems;

	public InventoryItem[] getItems() {
		return this.listOfItems;
	}
	
	/**
	 * Reads information from file and either performs instructions or adds new records
	 * precondition: path must be to a valid and properly formatted file
	 * 
	 * @param path
	 * 		the path to the file being read
	 * @return
	 * @throws IOException
	 * 		throws exception if file does cannot be read
	 * @throws FileNotFoundException
	 * 		throws exception if file is not found at the given path
	 */

	public void readFromFile(String path) {
		BufferedReader input;

		try {
			input = new BufferedReader(new FileReader(path));
			
			ArrayList<InventoryItem> itemsAdded = new ArrayList<InventoryItem>();
			
			boolean addedNewItems = false;

			String inputLine;
			try {
				inputLine = input.readLine();
				while (inputLine != null) {
					String[] tokens = inputLine.split(",");
					
					
					if(tokens[0].equalsIgnoreCase("")) {
						System.out.println("Error: No information on given line");
					}

					else if(tokens[0].equalsIgnoreCase("FIND")) {
						String artist = tokens[1];
						
						InventoryItem[] results = this.findItemsByArtist(artist);
						
						for (InventoryItem item : results) {
							System.out.println(item);
						}
					}

					else if(tokens[0].equalsIgnoreCase("ADD")) {
						String artist = tokens[1];
						String album = tokens[2];
						int year = Integer.parseInt(tokens[3]);
						String format = tokens[4];
						int quantity = Integer.parseInt(tokens[5]);
						double price = Double.parseDouble(tokens[6]);
						
						AudioFormat newRecord;
						
						if(format.equalsIgnoreCase("CD")) {
							newRecord = new CD();
						}
						else if(format.equalsIgnoreCase("CASSETTE")) {
							newRecord = new Cassette();
						}
						
						else {
							newRecord = new Vinyl();
						}
						
						newRecord.setAlbum(album);
						newRecord.setArtist(artist);
						newRecord.setYear(year);
						
						this.addItem(newRecord, quantity, price);
					}

					else if(tokens[0].equalsIgnoreCase("SELL")) {
						String artist = tokens[1];
						String album = tokens[2];
						int year = Integer.parseInt(tokens[3]);
						String format = tokens[4];
						int quantity = Integer.parseInt(tokens[5]);
						
						AudioFormat newRecord;
						
						if(format.equalsIgnoreCase("CD")) {
							newRecord = new CD();
						}
						else if(format.equalsIgnoreCase("CASSETTE")) {
							newRecord = new Cassette();
						}
						
						else {
							newRecord = new Vinyl();
						}
						
						newRecord.setAlbum(album);
						newRecord.setArtist(artist);
						newRecord.setYear(year);
						
						this.sellItem(newRecord, quantity);
					}

					else {
						
						addedNewItems = true;
						
						String artist = tokens[0];
						String album = tokens[1];
						String format = tokens[3];
						int year = Integer.parseInt(tokens[2]);
						int quantity = Integer.parseInt(tokens[4]);
						double price = Double.parseDouble(tokens[5]);

						AudioFormat newRecord;
						InventoryItem newItem = new InventoryItem();

						if (format.equalsIgnoreCase("CD")) {
							newRecord = new CD();
						}

						else if (format.equalsIgnoreCase("Cassette")) {
							newRecord = new Cassette();
						}

						else {
							newRecord = new Vinyl();
						}

						newRecord.setAlbum(album);
						newRecord.setArtist(artist);
						newRecord.setYear(year);

						newItem.setRecord(newRecord);
						newItem.setPrice(price);
						newItem.setQuantity(quantity);

						itemsAdded.add(newItem);
						
						
					}
					inputLine = input.readLine();
				
				} 
				
				if(addedNewItems)
					this.listOfItems = itemsAdded.toArray(new InventoryItem[itemsAdded.size()]);

				input.close();

				

			} catch (IOException e) {
				e.printStackTrace();
			}

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

	}

	/**
	 * Writes current list of items to file at indicated path
	 * 
	 * @param path
	 * 		the path of the file to be written to
	 * @return
	 * @throws FileNotFoundException
	 * 		throws exception if the file path does not exist or cannot be written to
	 */
	
	public void writeToFile(String path) {
		File file = new File(path);

		try {
			PrintWriter output = new PrintWriter(file);

			for (InventoryItem item : this.listOfItems) {
				AudioFormat record = item.getRecord();

				output.print(record.getArtist() + ",");
				output.print(record.getAlbum() + ",");
				output.print(record.getYear() + ",");
				output.print(record.getFormat() + ",");
				output.print(item.getQuantity() + ",");
				output.println(item.getPrice());

			}

			output.close();

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

	}

	/**
	 * Deducts the given quantity of a record if given quantity > available quantity
	 * 
	 * @param record
	 * 		the record being purchased
	 * @param quantity
	 * 		the quantity of the given record being purchased
	 * @return
	 */
	
	public void sellItem(AudioFormat record, int quantity) {

		boolean isInList = false;

		for (InventoryItem item : this.listOfItems) {
			if (item.getRecord().equals(record)) {
				isInList = true;

				if (item.getQuantity() < quantity) {
					System.out.println("Error: Not enough of " + item.getRecord().getAlbum() + " by " 
									+ item.getRecord().getArtist() + " available to sell.");
				}

				else {
					item.setQuantity(item.getQuantity() - quantity);
				}
			}
		}

		if (!isInList) {
			System.out.println("Error: Requested item does not exist.");
		}

	}

	/**
	 * Adds a new item or updates an existed item to the list of items
	 * 
	 * @param record
	 * 		the record being added
	 * @param quantity
	 * 		the number of the record being added
	 * @param price
	 * 		the price of the record being added
	 * @return
	 */
	
	public void addItem(AudioFormat record, int quantity, double price) {

		boolean isInList = false;

		for (InventoryItem item : this.listOfItems) {
			if (item.getRecord().equals(record)) {
				isInList = true;

				item.setQuantity(item.getQuantity() + quantity);
				item.setPrice(price);
			}
		}

		if (!isInList) {
			InventoryItem newItem = new InventoryItem();
			newItem.setPrice(price);
			newItem.setQuantity(quantity);
			newItem.setRecord(record);

			ArrayList<InventoryItem> updatedList = new ArrayList<InventoryItem>(Arrays.asList(this.listOfItems));
			updatedList.add(newItem);

			this.listOfItems = updatedList.toArray(new InventoryItem[updatedList.size()]);

		}

	}

	/**
	 * Finds InventoryItems matching the given artist
	 * 
	 * @param artist
	 * 		the artist to match with items
	 * @return
	 * 		an array of the items matching the given artist
	 */
	
	public InventoryItem[] findItemsByArtist(String artist) {
		InventoryItem[] searchResults;
		ArrayList<InventoryItem> items = new ArrayList<InventoryItem>();

		for (InventoryItem item : this.listOfItems) {
			AudioFormat record = item.getRecord();
			if (record.getArtist().equals(artist)) {
				items.add(item);
			}
		}

		searchResults = items.toArray(new InventoryItem[items.size()]);

		return searchResults;
	}
	
	public static void main(String[] args) {
		MusicStoreInventory inventory = new MusicStoreInventory();
		
		final String inputRecords = args[0];
		final String instructions = args[1];
		final String outputRecords = args[2];

		inventory = new MusicStoreInventory();
		inventory.readFromFile(inputRecords);
		inventory.readFromFile(instructions);
		inventory.writeToFile(outputRecords);
	}

}
