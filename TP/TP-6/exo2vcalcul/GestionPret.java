package exo2vcalcul;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class GestionPret {
    private ArrayList<OrdiPortable> stockOrdisPortables=new ArrayList<OrdiPortable>();
    private ArrayList<Etudiant> etudiantsAvecEmpruntEnCours=new ArrayList<>();

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
        boolean succes=ordi.nouveauPretA(emprunteur);
        if (succes) etudiantsAvecEmpruntEnCours.add(emprunteur);
        return succes;
    }

    public boolean retourOrdi(OrdiPortable ordi){
        Etudiant emprunteur=ordi.getEmprunteur();
        boolean succes=ordi.retour();
        if (succes){
            etudiantsAvecEmpruntEnCours.remove(emprunteur);
        }
        return succes;
    }

    // attention, on si on renvoie ici une ref sur la liste, la liste devient modifiable par l'appelant...
    public List<Etudiant> etudiantsEmprunteurs(){
        return Collections.unmodifiableList(etudiantsAvecEmpruntEnCours);
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
        gestion.nouveauPret(dell1, e1);
        System.out.println(gestion.etudiantsEmprunteurs());
        gestion.nouveauPret(dell2, e2);
        System.out.println(gestion.etudiantsEmprunteurs());
        gestion.retourOrdi(dell1);
        System.out.println(gestion.etudiantsEmprunteurs());

    }
}
