import java.util.Arrays;

public class PelageChat {
	private Couleur[] couleurs;
	private boolean multicolore;
	private boolean poilLong;
	private String description;
	
	public PelageChat(Couleur[] couleurs, boolean poilLong, String description) {
		this.couleurs = couleurs;
		this.multicolore=couleurs.length>1;
		this.poilLong = poilLong;
		this.description = description;
	}

	@Override
	public String toString() {
		String multicol=(multicolore)?", multicolore":"" + multicolore;
		String poils=(poilLong)?"poils longs ":"poils courts";
		return "Pelage ["+Arrays.toString(couleurs) + multicol +" ,"+ poils + ", " + description + "]";
	}

}
