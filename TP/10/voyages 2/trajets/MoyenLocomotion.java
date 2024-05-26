package voyages.trajets;

import java.util.Arrays;
import java.util.List;

public enum MoyenLocomotion {
    BUS, VOITURE, VELO, MARCHE, TRAIN;
    private static List<MoyenLocomotion> transportsEnCommun= Arrays.asList(BUS, TRAIN);

    public boolean estEnCommun() {
        return  transportsEnCommun.contains(this);
    }
}
