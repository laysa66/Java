 package poste;

public abstract class ObjetPostal {

	private String  origine,
					destination,
					codePostal;
	private double  poids,
				    volume;
	
	private Taux tauxRec;
	

	public ObjetPostal(String origine, String destination, String codePostal,
			double poids, double volume, Taux tauxRec) {
		
		this.origine = origine;
		this.destination = destination;
		this.codePostal = codePostal;
		this.poids = poids;
		this.volume = volume;
		this.tauxRec = tauxRec;
	}
	
	abstract public String getTypeObjet();
	
	public String toString(){
		return this.getTypeObjet()+"/"+this.codePostal+"/"+
				this.destination+"/"+this.tauxRec;
	}
	
	public void affiche(){
		System.out.println(this.toString());
	}
	
    //////////////////////////////////////////
	
	public abstract  double tarifRemb();	
	
	abstract public double getTarifBase();
	
	public double tarifAff(){
	// ici, on factorise ce qu'il y a de commun aux lettres et colis
		double t=this.getTarifBase();
		if (this.tauxRec==Taux.moyen) t+=0.5;
		else 
		if (this.tauxRec == Taux.fort) t+=1.5;
		return t;
	}
	
	//////////////////////////////////////////
	public String getOrigine() {
		return origine;
	}
	public void setOrigine(String origine) {
		this.origine = origine;
	}
	public String getDestination() {
		return destination;
	}
	public void setDestination(String destination) {
		this.destination = destination;
	}
	public String getCodePostal() {
		return codePostal;
	}
	public void setCodePostal(String codePostal) {
		this.codePostal = codePostal;
	}
	public double getPoids() {
		return poids;
	}
	public void setPoids(double poids) {
		this.poids = poids;
	}
	public double getVolume() {
		return volume;
	}
	public void setVolume(double volume) {
		this.volume = volume;
	}
	public Taux getTauxRec() {
		return tauxRec;
	}
	public void setTauxRec(Taux tauxRec) {
		this.tauxRec = tauxRec;
	}
		
}
