package voyages;

public enum MotifErreurVoyage {
    HEBERGEMENT_MAUVAIS_ENDROIT("hébergement au mauvais endroit"),
    ABSENCE_HEBERGEMENT("absence d'hébergement");

    private String motifComplet;

    private MotifErreurVoyage(String motifComplet){
        this.motifComplet=motifComplet;
    }

    public String toString(){
        return motifComplet;
    }

    public String getMotifComplet() {
        return motifComplet;
    }
}
