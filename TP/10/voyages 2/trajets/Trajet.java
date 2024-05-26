package voyages.trajets;

import java.time.LocalDate;

public abstract class Trajet {
    private LocalDate date;
    private String lieuDepart;
    private String lieuArrivee;
    private MoyenLocomotion transportUtilise;

    public Trajet(LocalDate date, String lieuDepart, String lieuArrivee, MoyenLocomotion transportUtilise) throws Exception {
        this.date = date;
        this.lieuDepart = lieuDepart;
        this.lieuArrivee = lieuArrivee;
        this.transportUtilise = transportUtilise;
        if (lieuDepart.equals(lieuArrivee)){
            throw new Exception("voyages.trajets.Trajet refusé");
        }
    }

    public String toString(){
        return date+" : "+lieuDepart+" -> "+lieuArrivee + " ("+transportUtilise+")";
    }

    public abstract int duree();
    public abstract float prix();

    public LocalDate getDate() {
        return date;
    }

    public String getLieuDepart() {
        return lieuDepart;
    }

    public String getLieuArrivee() {
        return lieuArrivee;
    }

    public MoyenLocomotion getTransportUtilise() {
        return transportUtilise;
    }
}
