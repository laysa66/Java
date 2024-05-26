package exo2vstockage;

import java.util.ArrayList;

public class OrdiPortable {
    private int numeroInventaire;
    private String marque;
    private Etudiant emprunteur;
    private ArrayList<Etudiant> historiqueEmprunteur=new ArrayList<>();
    public OrdiPortable(int numeroInventaire, String marque) {
        this.numeroInventaire = numeroInventaire;
        this.marque = marque;
        this.emprunteur=null; // initialement un ordinateur n'est pas emprunté
    }

    public int getNumeroInventaire() {
        return numeroInventaire;
    }

    public String getMarque() {
        return marque;
    }

    public Etudiant getEmprunteur() {
        return emprunteur;
    }

    @Override
    public String toString() {
        return "exo1.OrdiPortable{" +
                "numeroInventaire=" + numeroInventaire +
                ", marque='" + marque +
                ", historique="+ historiqueEmprunteur +'\'' +
                '}';
    }

    public boolean estEmprunte(){
        return emprunteur!=null;
    }

    public boolean estDisponible(){
        return !estEmprunte();
    }

    public boolean nouveauPretA(Etudiant e){
        if (!estEmprunte()&&e.nouvelEmprunt(this)){
            emprunteur=e;
            return true;
        }else{
            return false;
        }
    }

    public boolean retour() {
        if (estEmprunte()) {
            emprunteur.finEmprunt();
            historiqueEmprunteur.add(emprunteur);
            emprunteur=null;
            return true;
        }else{
            return false;
        }
    }
}
