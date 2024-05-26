package voyages;

import voyages.trajets.*;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Collections;

public class Voyage {
    private ArrayList<Trajet> trajets;
    private ArrayList<Hebergement> hebergements;

    public Voyage() {
        trajets=new ArrayList<>();
        hebergements=new ArrayList<>();
    }

    public void addTrajet(Trajet t){
        LocalDate date= t.getDate();
        if (!trajets.isEmpty()){
            int i=0;
            Trajet current=trajets.get(i);

            while((i<trajets.size()-1)&&current.getDate().isBefore(date)){
                i++;
                current=trajets.get(i);
            }
            if (current.getDate().isAfter(date) ){//! current.getDate().isEqual(date)){
                trajets.add(i, t);
            }else if (i==trajets.size()-1){ // on est arrivé en bout de liste
                trajets.add(t);
            }// sinon on n'ajoute pas ...
        }else{// premier trajet du voyage à ajouter
            trajets.add(t);
        }
    }

    public String toString(){
        String result="VOYAGE\n";
        for (Trajet t:trajets){
            result+=t+"\n";
        }

        for (Hebergement h:hebergements){
            result+=h+"\n";
        }
        return result;


    }

    public LocalDate debutVoyage(){
        if (!trajets.isEmpty()){
            return trajets.get(0).getDate();
        }else{
            return null;
        }
    }

    public LocalDate finVoyage(){
        if (!trajets.isEmpty()){
            return trajets.get(trajets.size()-1).getDate();
        }else{
            return null;
        }
    }

    public int nbTrajets(){
        return trajets.size();
    }

    public int dureeTotaleTrajets(){
        int duree=0;
        for (Trajet t:trajets){
            duree+=t.duree();
        }
        return duree;
    }

    public ArrayList<String> listeEtapes(){
        ArrayList<String> res=new ArrayList<>();
        for (Trajet t:trajets){
            if (!res.contains(t.getLieuDepart())) {
                res.add(t.getLieuDepart());
            }
        }
        Collections.sort(res);
        return res;
    }


    public boolean estDansLeVoyage(LocalDate date){
        return !date.isBefore(debutVoyage())&&!finVoyage().isBefore(date);
    }
    public String villeEtape(LocalDate date){
        if (trajets.isEmpty()||!estDansLeVoyage(date)) {
            return null;
        }
        int i=0;
        Trajet current=trajets.get(i);

        while(current.getDate().isBefore(date)){
            i++;
            current=trajets.get(i);
        }
        if (current.getDate().equals(date)){
            return current.getLieuArrivee();
        } else {// on a  (current.getDate().isAfter(date)
            return trajets.get(i-1).getLieuArrivee(); // il y a forcément un i-1
        }
    }

    // Les hébergements ...

    public void ajoutHebergement(Hebergement h){
        LocalDate date= h.getArrivee();
        if (!hebergements.isEmpty()){
            int i=0;
            Hebergement current=hebergements.get(i);
            while(i< (hebergements.size()-1)&&current.getArrivee().isBefore(date)){
                i++;
                current=hebergements.get(i);
            }
            // on est arrivé à la fin, on ajoute à la fin (après current) si la date de départ de current est avant ou égale l'arrivée de h
            if (i== hebergements.size()-1 && ! current.getDepart().isAfter(date)){
                // ajout après i, donc à la fin
                hebergements.add(h);
            }else {// on insère en i, donc avant current si le départ de h n'est pas après l'arrivée de current et
                // si l'arrivée de h n'est pas avant le départ de pred(current) (s'il existe)
                if (!h.getDepart().isAfter(current.getArrivee())
                        && ((i==0) || !h.getArrivee().isBefore(hebergements.get(i-1).getDepart()))){
                    hebergements.add(i,h);
                }
            }
            // sinon on n'ajoute pas ...
        }else{// premier hébergement du voyage à ajouter
            hebergements.add(h);
        }
    }

    public Hebergement getHebergement(LocalDate date){

        if (hebergements.isEmpty()|| date.isBefore(debutVoyage())||finVoyage().isBefore(date)){
            return null;
        }else{
            for (Hebergement h:hebergements) {
                if (h.inclutDate(date)) {
                    return h;
                }
            }
        }
        return null;
    }

    public ArrayList<ErreurVoyage> vérificationHebergements(){
        ArrayList<ErreurVoyage> erreurs=new ArrayList<>();
        for (LocalDate date:debutVoyage().datesUntil(finVoyage()).toList()){
            String villeEtape=villeEtape(date);
            Hebergement h=getHebergement(date);
            if (h==null){
                erreurs.add(new ErreurVoyage(date, MotifErreurVoyage.ABSENCE_HEBERGEMENT));
            }else if (!h.getVille().equals(villeEtape)){
                erreurs.add(new ErreurVoyage(date, MotifErreurVoyage.HEBERGEMENT_MAUVAIS_ENDROIT));
            }
        }
        return erreurs;
    }

    public static void main(String[] args) throws Exception {
        TrajetVoiture tvoiture=new TrajetVoiture(LocalDate.of(2022,8, 21),"Jacou", "Lyon");
        TrajetTransportEnCommun tbus=new TrajetTransportEnCommun(LocalDate.of(2022, 8, 23),
                "Lyon",
                "Lans-En-Vercors",
                MoyenLocomotion.BUS,
                LocalTime.of(12, 0),
                LocalTime.of(13,50),9f);
        TrajetTransportEnCommun tbus2=new TrajetTransportEnCommun(LocalDate.of(2022, 8, 25),
                "Lans-En-Vercors",
                "Villard-De-Lans",
                MoyenLocomotion.BUS,
                LocalTime.of(10, 0),
                LocalTime.of(10,20),2f);
        TrajetTransportEnCommun tbus3=new TrajetTransportEnCommun(LocalDate.of(2022, 8, 28),
                "Villard-De-Lans",
                "Grenoble",
                MoyenLocomotion.BUS,
                LocalTime.of(10, 0),
                LocalTime.of(11,20),7f);
        TrajetTransportEnCommun ttrain=new TrajetTransportEnCommun(LocalDate.of(2022, 8, 29),
                "Grenoble",
                "Lyon",
                MoyenLocomotion.TRAIN,
                LocalTime.of(10, 0),
                LocalTime.of(11,20),17f);
        TrajetVoiture tvoitureRetour=new TrajetVoiture(LocalDate.of(2022, 8, 30),
                "Lyon",
                "Jacou");

        Voyage v=new Voyage();

        v.addTrajet(tvoiture);
        v.addTrajet(tbus3);
        v.addTrajet(tbus2);
        v.addTrajet(ttrain);
        v.addTrajet(tbus);
        v.addTrajet(tvoitureRetour);
        System.out.println(v);
        System.out.println(v.dureeTotaleTrajets());
        System.out.println(v.listeEtapes());
        ///////////////////
        Hebergement troisNuits=new Hebergement("Llop gris", "Lyon", LocalDate.of(2022,8, 22), LocalDate.of(2022, 8, 25));
        Hebergement deuxNuits=new Hebergement("Pouet", "Grenoble", LocalDate.of(2022,8, 28), LocalDate.of(2022, 8, 30));
        Hebergement uneNuit=new Hebergement("Pouet2", "Hop2", LocalDate.of(2022,8, 30), LocalDate.of(2022, 9, 2));

        Hebergement err1=new Hebergement("err1", "err1ville", LocalDate.of(2022, 8, 23), LocalDate.of(2022, 8, 24));
        Hebergement err2=new Hebergement("err2", "err2ville", LocalDate.of(2022, 8, 26), LocalDate.of(2022, 8, 27));
        Hebergement err3=new Hebergement("err3", "err3ville", LocalDate.of(2022, 9, 1), LocalDate.of(2022, 9, 4));


        v.ajoutHebergement(deuxNuits);
        v.ajoutHebergement(troisNuits);
        v.ajoutHebergement(uneNuit);
        v.ajoutHebergement(err1); // période inclue dans une autre


        System.out.println(v.villeEtape(LocalDate.of(2022, 8, 28)));
        System.out.println(v.vérificationHebergements());

    }
}
