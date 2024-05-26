import java.util.Arrays;

public class SyntheseMeteoCorr {
    private final String ville;
    private float[] tmin=new float[12]; //Corrigez la classe Meteo de manière à ne plus avoir cette erreur.
    private float[] tmax=new float[12];

    public SyntheseMeteoCorr(String ville){
        this.ville=ville;
    }

    public SyntheseMeteoCorr(String ville, float[] tmin, float[] tmax){
        this(ville);
        this.tmin=tmin;
        this.tmax=tmax;
    }

    @Override
    public String toString() {
        return "SyntheseMeteo{" +
                "ville='" + ville + '\'' +
                ", tmin=" + Arrays.toString(tmin) +
                ", tmax=" + Arrays.toString(tmax) +
                '}';
    }

    public float temperatureMensuelleMax(){
        float result=tmax[0];
        // Le premier "tour" de la boucle for est inutile. Transformez la boucle for (qui est ici un \textit{pour tout}) en une boucle for avec un indice de boucle i allant de 1 à la taille du tableau exclue.
        for (int i=1;i<tmax.length;i++){
            if (tmax[i]>result){
                result=tmax[i];
            }
        }
        return result;
    }

    // Ajoutez une méthode moisLePlusChaud qui retourne le mois le plus chaud sous forme d'un entier (1 pour janvier, 2 pour février, 12 pour décembre).
    public int moisLePlusChaudv1(){
        float tempMax=tmax[0];
        int moisMax=1;
        for (int i=1;i<tmax.length;i++){
            if (tmax[i]>tempMax){
                tempMax=tmax[i];
                moisMax=i+1;
            }
        }
        return moisMax;
    }

    // Modifiez la méthode précédente pour retourner un littéral d'une énumération Mois plutôt que le numéro du mois.
    public Mois moisLePlusChaudv2(){
        float tempMax=tmax[0];
        Mois moisMax=Mois.JANVIER;
        for (int i=1;i<tmax.length;i++){
            if (tmax[i]>tempMax){
                tempMax=tmax[i];
                moisMax=numMoisVersMois(i+1);
            }
        }
        return moisMax;
    }

    private Mois numMoisVersMois(int numMois){
        //return Mois.values()[numMois-1]; // Cette instruction aurait suffit mais la comprenez-vous ?
        switch (numMois){
            case 1:return Mois.JANVIER;
            case 2:return Mois.FEVRIER;
            case 3:return Mois.MARS;
            case 4:return Mois.AVRIL;
            case 5:return Mois.MAI;
            case 6: return Mois.JUIN;
            case 7: return Mois.JUILLET;
            case 8: return Mois.AOUT;
            case 9: return Mois.SEPTEMBRE;
            case 10: return Mois.OCTOBRE;
            case 11: return Mois.NOVEMBRE;
            case 12: return Mois.DECEMBRE;
            default: return null;
        }
    }

    private int moisVersNumMois(Mois mois){
        //return Mois.JANVIER.ordinal()+1; // Cette instruction aurait suffit mais la comprenez-vous ?
        switch (mois){
            case JANVIER : return 1;
            case FEVRIER : return 2;
            case MARS : return 3;
            case AVRIL : return 4;
            case MAI : return 5;
            case JUIN : return 6;
            case JUILLET : return 7;
            case AOUT : return 8;
            case SEPTEMBRE : return 9;
            case OCTOBRE : return 10;
            case NOVEMBRE : return 11;
            case DECEMBRE : return 12;
            default: return -1;
        }
    }
    public void setTmin(int numMois, float valeur){
        if (numMois>=1 && numMois<=12 ){
            if (valeur>=-100 && valeur<=100) {
                tmin[numMois + 1] = valeur;
            }else{
                System.out.println("température incorrecte");
            }
        }else{
            System.out.println("numéro de mois incorrect");
        }

    }

    public void setTmin(Mois mois, float valeur){
        if (mois!=null){
            if (valeur>=-100 && valeur<=100) {
                tmin[moisVersNumMois(mois) + 1] = valeur;
            }else{
                System.out.println("température incorrecte");
            }
        }else{
            System.out.println("le mois ne doit pas être null");
        }

    }
}
