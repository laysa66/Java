public class ManipulationsSyntheseMeteoCorr {
    public static void main(String[] args) {
        float[] tmin={1, 2, 3, 4, 5, 12, 15, 16, 14, 12, 8, 3};
        float[] tmax={7, 8, 14, 17, 20, 30, 37, 36, 29, 27, 19, 17};
        SyntheseMeteoCorr nimes=new SyntheseMeteoCorr("Nîmes", tmin, tmax);
        System.out.println(nimes.temperatureMensuelleMax());

        System.out.println(nimes.moisLePlusChaudv1());
        System.out.println(nimes.moisLePlusChaudv2());
        SyntheseMeteoCorr lille=new SyntheseMeteoCorr("Lille");
        lille.setTmin(1, -3);
        lille.setTmin(13, 12);
        lille.setTmin(Mois.JUILLET, 15);

    }

}
