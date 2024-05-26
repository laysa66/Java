import poste.*; // car les classes d'objet postaux sont dans ce package
import java.util.ArrayList; 

public class ProgrammePoste {

	public static void main(String[] args)
	{
	ObjetPostal o1 = new Lettre("Montpellier","pole nord","8809",0.02,0.01,Taux.faible,true);
	o1.affiche();

	Colis o2 = new Colis("Pole sud","Paris","75000",2,3,Taux.fort,"photos d'iceberg",3);
	o2.affiche();

	// colis avec la date d'envoi du jour	
	Colis o3 = new ColisExpress("Argentine","Clermont","000",80,3,Taux.fort,"maté",3,true); 
	o3.affiche();
	
	
	System.out.println("\nLe même affichage à partir d'une collection de ces objets :");
	
	ArrayList<ObjetPostal> T = new ArrayList<ObjetPostal>();
	T.add(o1);
	T.add(o2);
	T.add(o3);
	for (int i = 0; i < T.size(); i++)
		T.get(i).affiche();
	
	}
}
