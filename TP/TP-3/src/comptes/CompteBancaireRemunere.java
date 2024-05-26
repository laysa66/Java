package comptes;

public class CompteBancaireRemunere extends CompteBancaire{
	private float plafond;
	private static float tauxRemuneration=0.01f;
	public CompteBancaireRemunere(int numeroCompte, float solde, float plafond) {
		super(numeroCompte, solde);
		this.plafond = plafond;
	}
	
	public void crediter(float montant) {
		if (getSolde()+montant>plafond) {
			System.out.println("ERREUR, le plafond ne peut pas être dépassé");
		}else {
			super.crediter(montant);
		}
	}
	
	private float calculInteretsMensuels() {
		return getSolde()*tauxRemuneration;
	}
	
	public void ajoutInterets() {
		setSolde(getSolde()+calculInteretsMensuels());
	}
}
