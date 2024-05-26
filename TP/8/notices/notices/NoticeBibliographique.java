package notices;

import java.util.ArrayList;

public class NoticeBibliographique {

	private String titre;
	private String isbn;

	private ArrayList<Contribution> contributions;
	
 

	public NoticeBibliographique(String titre, String isbn) {
		contributions=new ArrayList<Contribution>();
		this.titre = titre;
		this.isbn = isbn;
	}


	public String getTitre() {
		return titre;
	}
	public String getIsbn() {
		return isbn;
	}
	
	public ArrayList<Contributeur> getContributeurs(){
		ArrayList<Contributeur> resultat=new ArrayList<Contributeur>();
		for (Contribution c: contributions){
			resultat.add(c.getContributeur());
		}
		return resultat;
	}

	public void ajoutContribution(Contributeur c, ArrayList<NatureContribution> roles){
		Contribution contrib=new Contribution (roles, this, c);
		ajoutContrib(contrib);
	}

	public void ajoutContribution(Contributeur c, NatureContribution role){
		Contribution contrib=new Contribution (role, this, c);
		ajoutContrib(contrib);
	}

	private void ajoutContrib(Contribution contrib){
		contributions.add(contrib);
		contrib.getContributeur().ajoutContribution(contrib);
	}
	

	
	
	@Override
	public String toString() {
		String resultat= "NoticeBibliographique [titre=" + titre + ", contributions=";
		for (Contribution c:contributions){
			resultat+=c.getContributeur().getNom()+" "+c.getNature();
		}
		resultat+=		"]";
		return resultat;
	}



	public boolean aPourContributeur(String nom){
		for (Contributeur c: getContributeurs())
			if (c.getNom().equals(nom))
				return true;
		return false;
	}
}
