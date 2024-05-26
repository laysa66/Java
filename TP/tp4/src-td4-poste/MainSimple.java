
import posteV1.*; // le package où sont définies les classes d'objets postaux

public class MainSimple {

	public static void main(String[] args)
	{
	ObjetPostal o1 = new Lettre("Montpellier","pole nord","8809",0.02,0.01,Taux.faible,true);
	// comme o1 est de type ObjetPostal, cette variable peut référencer un objet de n'importe quelle classe dérivée de ObjetPostal
	System.out.println(o1); // appelle o1.toString()

	Colis o2 = new Colis("Pole sud","Paris","75000",2,3,Taux.fort,"photos d'iceberg",3);
	System.out.println(o2);
	
	// attention : dans la classe ColisExpress, il faut ajouter un attribut booléen pour l'emballage
	// on l'avait oublié dans la modélisation UML

	Colis o3 = new ColisExpress("Argentine","Clermont","000",80,3,Taux.fort,"maté",3,true); 
	System.out.println(o3);
	System.out.println(); // pour laisser une ligne
			
	// on peut ajouter cette méthode dans ObjetPostal :
	// public void affiche(){ System.out.println(this.toString()); } 
	// on vérifie que c'est bien la bonne méthode toString() qui est appelée pour chaque objet
	o1.affiche();
	o2.affiche();
	o3.affiche();
	}
}

/* Résultat :
 Lettre/8809/pole nord/faible/urgente
Colis/75000/Paris/fort/3.0/3.0
ColisExpress/000/Clermont/fort/3.0/3.0/80.0/1

Lettre/8809/pole nord/faible/urgente
Colis/75000/Paris/fort/3.0/3.0
ColisExpress/000/Clermont/fort/3.0/3.0/80.0/1
*/
