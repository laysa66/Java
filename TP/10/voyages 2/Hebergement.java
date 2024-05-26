package voyages;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class Hebergement {
    private String nom;
    private String ville;
    private LocalDate arrivee;
    private LocalDate depart;

    public Hebergement(String nom, String ville, LocalDate arrivee, LocalDate depart) throws Exception {
        if (!depart.isAfter(arrivee)) throw new Exception("dates d'hébergement incorrectes");
        this.nom = nom;
        this.ville=ville;
        this.arrivee = arrivee;
        this.depart = depart;
    }

    public String getVille() {
        return ville;
    }

    public String getNom() {
        return nom;
    }

    public LocalDate getArrivee() {
        return arrivee;
    }

    public LocalDate getDepart() {
        return depart;
    }

    public String toString(){
        return nom+"("+ville+") du"+arrivee+" au "+depart;
    }

    public int nbNuitees(){
        return (int) arrivee.until(depart, ChronoUnit.DAYS);
    }

    public boolean inclutDate(LocalDate date){
        return !date.isBefore(arrivee)&&!date.isAfter(depart);
    }

    public static void main(String[] args) throws Exception {
        Hebergement troisNuits=new Hebergement("Llop gris", "Ordino", LocalDate.of(2022,8, 22), LocalDate.of(2022, 8, 25));
        System.out.println(troisNuits.nbNuitees());
    }
}
