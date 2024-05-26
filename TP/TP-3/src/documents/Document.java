package documents;

public class Document {
	private String titre;
	private String texte;
	public Document(String titre, String texte) {
		this.titre = titre;
		this.texte = texte;
	}

	public int nbCars() {
		return titre.length()+texte.length();
	}
	public String export() {
		//return titre+" "+texte;
		return "# "+titre+"\n"+texte;
	}
}
