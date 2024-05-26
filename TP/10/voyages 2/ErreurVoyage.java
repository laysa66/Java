package voyages;

import java.time.LocalDate;

public class ErreurVoyage {
    private LocalDate date;
    private MotifErreurVoyage motif;

    public ErreurVoyage(LocalDate date, MotifErreurVoyage motif) {
        this.date = date;
        this.motif = motif;
    }

    public LocalDate getDate() {
        return date;
    }

    public MotifErreurVoyage getMotif() {
        return motif;
    }

    @Override
    public String toString() {
        return "ErreurVoyage{" +
                "date=" + date +
                ", motif=" + motif +
                '}';
    }
}
