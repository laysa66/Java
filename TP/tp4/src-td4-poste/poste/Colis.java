package poste;

public class Colis extends ObjetPostal {
	
	private String declContenu;
	private double valeurDecl;
	
	private static double tarifBase=2;
	
	public Colis(String origine, String destination, String codePostal,
			double poids, double volume, Taux tauxRec, String declContenu,
			double valeurDecl) {
		super(origine, destination, codePostal, poids, volume, tauxRec);
		this.declContenu = declContenu;
		this.valeurDecl = valeurDecl;
	}
	
	@Override
	public String getTypeObjet() {
		return "Colis";
	}

	@Override
	public String toString() {
		return super.toString() +"/"+
				this.getVolume()+"/"+
				this.valeurDecl;
	}
	
	// remarque : on ne redefinit pas affiche car la version heritee convient !
	
   /////////////////////////////////////////////	
	
	@Override 
	public double tarifRemb() { 
    if (this.getTauxRec() == Taux.moyen) return 0.1*this.valeurDecl; 
	if (this.getTauxRec() == Taux.fort) return 0.5*this.valeurDecl; 
	return 0; 
	}	 
	
	
	//Autre version avec switch (assez bizarre: il ne faut pas préfixer par TauxRecom)
	/*
	 * @Override 
	 * public double tarifRemb() { 
	 * switch (this.getTauxRec())
	 * { case moyen:return 10*this.valeurDecl/100.0; 
	 *   case fort:return 50*this.valeurDecl/100.0; 
	 *   default: return 0;
	 *  } 
	 *  }
	 */
		
	  ///////////////////
		
	  @Override
	  public double getTarifBase() {
		  return 2; 			//Colis.tarifBase;
	  }

	  @Override
	  public double tarifAff() {
		  double t = super.tarifAff(); // appel à la méthode héritée
		  if (this.getVolume()>1/8) t+= 3;
		  return t;
	  }


	/////////////////////////////////////////
	

	public String getDeclContenu() {
		return declContenu;
	}
	public void setDeclContenu(String declContenu) {
		this.declContenu = declContenu;
	}
	public double getValeurDecl() {
		return valeurDecl;
	}
	public void setValeurDecl(double valeurDecl) {
		this.valeurDecl = valeurDecl;
	}
	public static void setTarifBase(double tarifBase) {
		Colis.tarifBase = tarifBase;
	}
	
	
	
}
