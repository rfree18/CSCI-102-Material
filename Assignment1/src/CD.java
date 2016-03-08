
public class CD extends AudioFormat {

	public void play() {
		System.out.println("Playing: " + this.getFormat() + " of " 
					+ this.getArtist() + " Album: " + this.getAlbum() + " Year: " + this.getYear());

	}
	
	public String getFormat() {
		return "CD";
	}

}
