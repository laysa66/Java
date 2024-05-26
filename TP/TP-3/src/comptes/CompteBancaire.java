package comptes;

public class CompteBancaire {
	private final int numeroCompte;
	private float solde;

	public CompteBancaire(int numeroCompte, float solde) {
		this.numeroCompte = numeroCompte;
		this.solde = solde;
	}

	public int getNumeroCompte() {
		return numeroCompte;
	}

	public float getSolde() {
		return solde;
	}	
	
	protected void setSolde(float newSolde) {
		this.solde=newSolde;
	}

	public void crediter(float montant) {
		if (montant<0) {
			System.out.println("ERREUR, le montant à créditer doit être positif");
		}else {
			solde+=montant;
		}
	}

	public void debiter(float montant) {
		if (montant<0) {
			System.out.println("ERREUR, le montant à débiter doit être positif");
		}else if (solde<montant) 
		{
			System.out.println("ERREUR, le solde est n'est pas suffisant");
		}else {
			solde-=montant;
		}
	}

}
