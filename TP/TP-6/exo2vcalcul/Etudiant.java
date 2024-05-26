package exo2vcalcul;

public class Etudiant {
    private final String nom;
    private OrdiPortable ordiPortableEmprunte;

    public Etudiant(String nom) {
        this.nom = nom;
        this.ordiPortableEmprunte=null;// pas d'emprunt initial
    }

    public String getNom() {
        return nom;
    }

    public OrdiPortable getOrdiPortableEmprunte() {
        return ordiPortableEmprunte;
    }

    // attention, cette méthode ne met pas à jour ordi avec le nouvel emprunteur !
    boolean nouvelEmprunt(OrdiPortable ordi){
        if (ordiPortableEmprunte!=null){
            return false;
        }else{
            this.ordiPortableEmprunte=ordi;
            return true;
        }
    }

    void finEmprunt(){
        ordiPortableEmprunte=null;
    }
}
