package notices;

import java.util.ArrayList;

public class Contributeur {
	private ArrayList<Contribution> contributions;
	private String nom;
	private String prenom;
	public String getNom() {
		return nom;
	}
	public String getPrenom() {
		return prenom;
	}
	public Contributeur(String nom, String prenom) {
		this.nom=nom;
		this.prenom=prenom;
		contributions=new ArrayList<Contribution>();
	}

	void ajoutContribution(Contribution contrib) {
		if (this==contrib.getContributeur()){
			contributions.add(contrib);
		}

	}

	public ArrayList<NoticeBibliographique> getNotices(){
		ArrayList<NoticeBibliographique> resultat=new ArrayList<NoticeBibliographique>();
		for (Contribution c: contributions){
			resultat.add(c.getNotice());
		}
		return resultat;
	}

}
