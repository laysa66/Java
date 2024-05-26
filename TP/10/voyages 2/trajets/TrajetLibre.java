package voyages.trajets;

import voyages.OpenMoogleGaps;

import java.time.LocalDate;

public class TrajetLibre extends Trajet{
    public TrajetLibre(LocalDate date, String lieuDepart, String lieuArrivee, MoyenLocomotion transportUtilise) throws Exception {
        super(date, lieuDepart, lieuArrivee, transportUtilise);
        if (transportUtilise.estEnCommun()){
            throw new Exception("moyen de transport incohérent");
        }
    }

    @Override
    public int duree() {
        return OpenMoogleGaps.travelSummary(this.getLieuDepart(), this.getLieuArrivee(), this.getDate(), this.getTransportUtilise()).getDuration();
    }

    @Override
    public float prix() {
        return OpenMoogleGaps.travelSummary(this.getLieuDepart(), this.getLieuArrivee(), this.getDate(), this.getTransportUtilise()).getPrice();
    }
}
