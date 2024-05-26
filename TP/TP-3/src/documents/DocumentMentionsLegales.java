package documents;

public class DocumentMentionsLegales extends Document {
	private String mentionsLegales;

	public DocumentMentionsLegales(String titre, String texte, String mentionsLegales) {
		super(titre, texte);
		this.mentionsLegales = mentionsLegales;
	}
	public String export() {
		return super.export()+" "+mentionsLegales;
	}
}
