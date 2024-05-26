package documents;

public class DocumentCrypté extends Document{

	public DocumentCrypté(String titre, String texte) {
		super(titre, texte);
	}
	
	public static  String crypter(String s){
		return s+"je suis cryptée";
	}

}
