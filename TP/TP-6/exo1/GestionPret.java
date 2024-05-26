package exo1;

import java.util.ArrayList;

public class GestionPret {
    private ArrayList<OrdiPortable> stockOrdisPortables=new ArrayList<OrdiPortable>();

    public boolean ajoutOrdi(OrdiPortable ordi){
        if (stockOrdisPortables.contains(ordi)){
            return false;
        }else{
            return stockOrdisPortables.add(ordi);
        }
    }

    public boolean remove(OrdiPortable ordi){
        return stockOrdisPortables.remove(ordi);
    }

    public boolean nouveauPret(OrdiPortable ordi, Etudiant emprunteur){
        if (!stockOrdisPortables.contains(ordi)){
            System.out.println("ATTENTION ! Erreur stock !");
        }
        return ordi.nouveauPretA(emprunteur);
    }

    public boolean retourOrdi(OrdiPortable ordi){
        return ordi.retour();
    }

    public ArrayList<OrdiPortable> recherche(String marque, boolean disponible){
        ArrayList<OrdiPortable> result=new ArrayList<>();
        for (OrdiPortable ordi:stockOrdisPortables){
            if (ordi.estDisponible()==disponible && (marque.equals("all") || ordi.getMarque().equals(marque))){
                result.add(ordi);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        OrdiPortable dell1=new OrdiPortable(111, "dell");
        OrdiPortable dell2=new OrdiPortable(112, "dell");
        OrdiPortable hp1=new OrdiPortable(113, "hp");
        OrdiPortable hp2=new OrdiPortable(114, "hp");
        Etudiant e1=new Etudiant("Tom");
        Etudiant e2=new Etudiant("Amel");
        GestionPret gestion=new GestionPret();
        gestion.ajoutOrdi(dell1);
        gestion.ajoutOrdi(dell2);
        gestion.ajoutOrdi(hp1);
        gestion.ajoutOrdi(hp2);
        System.out.println(gestion.recherche("all", true));
        System.out.println(dell1);
        gestion.nouveauPret(dell1, e1);
        System.out.println(gestion.recherche("dell", true));
        System.out.println("emprunt dell1 à nouveau, devrait valoir false :  " + gestion.nouveauPret(dell1, e2));
        System.out.println(e1.getOrdiPortableEmprunte().getNumeroInventaire());
        System.out.println(dell1.getEmprunteur().getNom());
        gestion.retourOrdi(dell1);
        System.out.println(dell1);
    }
}
