package voyages.trajets;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;

public class TrajetTransportEnCommun extends Trajet{
    private LocalTime horaireDepart;
    private LocalTime horaireArrivee;
    private float prix;

    public TrajetTransportEnCommun(LocalDate date, String lieuDepart, String lieuArrivee, MoyenLocomotion transportUtilise, LocalTime horaireDepart, LocalTime horaireArrivee, float prix) throws Exception {
        super(date, lieuDepart, lieuArrivee, transportUtilise);
        this.horaireDepart = horaireDepart;
        this.horaireArrivee = horaireArrivee;
        this.prix = prix;
        if (! transportUtilise.estEnCommun()){
            throw new Exception("moyen de transport incohérent");
        }
    }


    @Override
    public int duree() {
        return (int) horaireDepart.until(horaireArrivee, ChronoUnit.MINUTES);
    }

    @Override
    public float prix() {
        return prix;
    }
}
