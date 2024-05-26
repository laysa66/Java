package poste;
import java.util.ArrayList; // nom complet de ArrayList

public class SacPostalTD {

	private ArrayList<ObjetPostal> contenu = new ArrayList<ObjetPostal>();
	// ne pas oublier de créer l'ArrayList (sinon contenu = null)
	// si on ne le fait pas ici, il faut le faire dans chaque constructeur
	private double capacité; // volume maximal
	
	// constante de classe
	private static final double CAPACITE_STD = 0.5; // en m3
	private static final double VOLUME_TOILE = 0.005; // en m3
	
	public SacPostalTD()
	{
		this.capacité = SacPostalTD.CAPACITE_STD; 
	}
	
	public SacPostalTD(double capacité)
	{
		this.capacité = capacité;
	}
	
	public double getVolume()
	{
		double v = SacPostalTD.VOLUME_TOILE; 
		// faire la somme des volumes des objets contenus
		/*
		 * for(int i = 0; i < contenu.size(); i++)
			v += contenu.get(i).getVolume();
		*/
		for (ObjetPostal o : contenu)
			v+= o.getVolume();
		return v;
	}
	
	public void ajout (ObjetPostal o)
	{
		double nouveauVolume = this.getVolume() + o.getVolume();
		if (nouveauVolume <= this.capacité) // on ne doit dépasser la capacité du sac
				contenu.add(o);
	}
	
	
	public double valeurRemboursement()
	{
		double v = 0;
		for (ObjetPostal o : contenu)
			v+= o.tarifRemb();
		return v;
	}
	
	public int nbObjets()
	// Nbre objets du sac - utilisé pour vérification dans le main
	{
		return contenu.size();
	}
	
	public SacPostalTD tranfertAutreSac(String code) 
	// crée un autre sac avec les objets de ce sac qui ont le codePostal code
	{
		SacPostalTD autreSac = new SacPostalTD();
		
		for (int i = 0; i < this.contenu.size(); i++) 
		{
			ObjetPostal objetPostalCourant = this.contenu.get(i);
			if (objetPostalCourant.getCodePostal().equals(code)) 
				// equals car code est une String (si c'était un int on utiliserait ==)
			{
				autreSac.ajout(objetPostalCourant);
				//this.contenu.remove(objetPostalCourant); // ERREUR (modification des indices du contenu de this)
			}
		}
		// finalement, on supprime les objets transférés dans autreSac
		this.contenu.removeAll(autreSac.contenu);
		return autreSac;
	}
	
	
	
	// méthode main qui aurait vocation à être ailleurs 
	public static void main(String[] args) {
		
		SacPostalTD sac = new SacPostalTD(1); // capacité de 1 m3	
		ObjetPostal o1 = new Lettre("Montpellier","pole nord","8809",0.02,0.01,Taux.faible,true);
		Colis o2 = new Colis("Pole sud","Paris","75000",2,0.1,Taux.fort,"photos d'iceberg",3);
		Colis o3 = new ColisExpress("Argentine","Paris","75000",80,0.1,Taux.fort,"maté",3, true); 
		Colis o4 = new Colis("Pole sud", "Paris", "75000", 2, 0.1, Taux.fort, " encore des photos d'iceberg", 3);

		sac.ajout(o1);
		sac.ajout(o2);
		sac.ajout(o3);
		sac.ajout(o4);
		// volume du sac : 0.005 (toile) + 0.01 + 0.1 x 3 = 0.315 
		System.out.println("Volume du sac :" + sac.getVolume());
		System.out.println("Nb objets du sac : " + sac.nbObjets());
		
		System.out.println("Transfert du courrier de code 75000");
		SacPostalTD sac2 = sac.tranfertAutreSac("75000");
		System.out.println("Nb objets du nouveau sac : " + sac2.nbObjets());
		System.out.println("Nb objets restant dans le premier sac : " + sac.nbObjets());
		
		

	}

}
