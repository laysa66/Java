

public class ChatV2 {
	private String nom;
	private PelageChat pelage;
	private int anneeNaissance;
	private boolean pucé;
	
	public ChatV2(String nom, PelageChat pelage, int anneeNaissance, boolean pucé) {
		this.nom = nom;
		this.pelage = pelage;
		this.anneeNaissance = anneeNaissance;
		this.pucé = pucé;
	}
	
	public ChatV2(String nom, Couleur[] couleurs, boolean poilLong, String descriptionPelage,int anneeNaissance, boolean pucé) {
		this.nom = nom;
		this.pelage = new PelageChat(couleurs, poilLong, descriptionPelage);
		this.anneeNaissance = anneeNaissance;
		this.pucé = pucé;
	}

	public String toString() {
		return "Chat [nom=" + nom + ", "+pelage+" né en "	+ anneeNaissance + ", pucé=" + pucé + "]";
	}


}
