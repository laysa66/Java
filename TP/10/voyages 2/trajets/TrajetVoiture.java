package voyages.trajets;

import voyages.OpenMoogleGaps;

import java.time.LocalDate;

public class TrajetVoiture extends TrajetLibre{

    public static final int CONSOESSENCE100KM = 7;
    public static final float PRIXESSENCELITRE = 1.97f;

    public TrajetVoiture(LocalDate date, String lieuDepart, String lieuArrivee) throws Exception {
        super(date, lieuDepart, lieuArrivee, MoyenLocomotion.VOITURE);
    }

    @Override
    public float prix(){
        return super.prix()+ OpenMoogleGaps.travelSummary(this.getLieuDepart(), this.getLieuArrivee(), this.getDate(), this.getTransportUtilise()).getDistance()* CONSOESSENCE100KM * PRIXESSENCELITRE /100;
    }
}
