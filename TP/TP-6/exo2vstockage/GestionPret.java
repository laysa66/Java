package exo2vstockage;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

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

    public List<Etudiant> etudiantsEmprunteurs(){
        ArrayList<Etudiant> result=new ArrayList<>();
        for (OrdiPortable ordi:stockOrdisPortables){
            if (ordi.estEmprunte()){
                Etudiant e=ordi.getEmprunteur();
                if (!result.contains(e)){
                    result.add(e);
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        OrdiPortable dell1 = new OrdiPortable(111, "dell");
        OrdiPortable dell2 = new OrdiPortable(112, "dell");
        OrdiPortable hp1 = new OrdiPortable(113, "hp");
        OrdiPortable hp2 = new OrdiPortable(114, "hp");
        Etudiant e1 = new Etudiant("Tom");
        Etudiant e2 = new Etudiant("Amel");
        GestionPret gestion = new GestionPret();
        gestion.ajoutOrdi(dell1);
        gestion.ajoutOrdi(dell2);
        gestion.ajoutOrdi(hp1);
        gestion.ajoutOrdi(hp2);
        System.out.println(gestion.etudiantsEmprunteurs());
        gestion.nouveauPret(dell1, e1);
        System.out.println(gestion.etudiantsEmprunteurs());
        gestion.nouveauPret(dell2, e2);
        System.out.println(gestion.etudiantsEmprunteurs());
        gestion.retourOrdi(dell1);
        System.out.println(gestion.etudiantsEmprunteurs());
    }
}
