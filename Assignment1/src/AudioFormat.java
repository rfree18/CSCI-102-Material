
public abstract class AudioFormat {
	
	private String artist;
	private String album;
	private int year;
	
	/**
	 * Gets the value of the artist instance variable
	 * 
	 * @return 
	 * 		a string containing the name of the artist
	 */
	
	public String getArtist() {
		return this.artist;
	}
	
	/**
	 * Changes the value of the artist instance variable
	 * 
	 * @param Artist
	 * 		a string that the artist instance variable will be set to
	 */
	
	public void setArtist(String Artist) {
		this.artist = Artist;
	}
	
	/**
	 * Gets the value of the album instance variable
	 * 
	 * @return
	 * 		a string object containing the value of the album instance variable
	 */
	
	public String getAlbum() {
		return this.album;
	}
	
	/**
	 * Changes the value of the album instance variable
	 * 
	 * @param album
	 * 		a string that the album instance variable will be set to
	 */
	
	public void setAlbum(String album) {
		this.album = album;
	}
	
	/**
	 * Gets the value of the year instance variable
	 * 
	 * @return
	 * 		an int containing the value of the year instance variable
	 */
	
	public int getYear() {
		return this.year;
	}
	
	/**
	 * Changes the value of the year instance variable
	 * 
	 * @param year
	 * 		an int that the year instance variable will be set to
	 */
	
	public void setYear(int year) {
		this.year = year;
	}
	
	/**
	 * Prints out a string indicating the song playing
	 * 
	 * @return
	 */
	public abstract void play();
	
	/**
	 * Gets the format type
	 * 
	 * @return
	 * 		a string containing the format type
	 */
	public abstract String getFormat();
	
	public boolean equals(Object a) {
		AudioFormat compareItem = (AudioFormat) a;
		
		if(this.getFormat().equals(compareItem.getFormat()) && this.getAlbum().equals(compareItem.getAlbum()) && 
				this.getArtist().equals(compareItem.getArtist()) && this.getYear() == compareItem.getYear()) {
			return true;
		}
		
		else
			return false;
	}

}
