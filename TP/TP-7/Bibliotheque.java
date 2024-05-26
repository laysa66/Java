import java.util.Hashtable;
import java.util.Optional;

public class Bibliotheque {
	private Hashtable<Integer, Livre> catalogue=new Hashtable<>();
	public void ajoutLivre(Livre l){
		catalogue.put(l.getCode(), l);
	}

	public Optional<Livre> getLivreByCodeVersionAvecOptional(int code){
		return Optional.ofNullable(catalogue.get(code));
	}

	public Livre getLivreByCode(int code){
		return catalogue.get(code);
	}
}
