import java.util.ArrayList;

public class PolynomeCreux {
    private ArrayList<Monome> monomes; // on maintient la liste par ordre de degrés croissants

    public PolynomeCreux() {
        monomes=new ArrayList<>();
    }

    public String toString(){
        String result="";
        for (Monome m:monomes){
            result+=m;
        }
        if (monomes.isEmpty()){result="polynôme nul";}
        return result;
    }
    public void ajoutMonome(Monome m){
        // ajout d'un clone de m au polynome
        if (!monomes.isEmpty()) {
            int posCourante=0;
            Monome courant=monomes.get(posCourante);
            // on cherche la position d'insertion
            while (courant.getDegre()<m.getDegre() && posCourante< monomes.size()-1){
                // on passe au monome suivant
                posCourante++;
                courant=monomes.get(posCourante);
            }
            if (courant.getDegre()==m.getDegre()){
                // on avait déjà un monome de même degré, on ajoute les coeff
                courant.ajoutAuCoeff(m.getCoeff());
                if (courant.getCoeff()==0){
                    // on retire le monome nul de la liste
                    monomes.remove(courant);
                }
            }else if (courant.getDegre()>m.getDegre()){
                // on a dépassé la position d'insertion, insertion de m avant le monome courant
                monomes.add(posCourante, new Monome(m)); // juste m dans les premières questions
            } else {
                // on insère à la fin
                monomes.add(new Monome(m)); // juste m dans les premières questions
            }
        }else{ // premier monome du polynome
            monomes.add(new Monome(m)); // juste m dans les premières questions
        }
    }

    /**
     * Multiplication par un monome
     * @param facteur monome par lequel on multiplie le polynome
     * @return le produit du polynpome receveur par facteur
     */
    public PolynomeCreux produit(Monome facteur){
        PolynomeCreux result=new PolynomeCreux();
        for (Monome m:monomes){
            result.ajoutMonome(Monome.produit(m,facteur));
        }
        return result;
    }
    public PolynomeCreux somme(PolynomeCreux terme){
            PolynomeCreux result=new PolynomeCreux();
            // on duplique this dans result (prévoir un autre constructeur par copie !!)
            for (Monome m:monomes){
                result.ajoutMonome(m);
            }
            // on ajoute les monomes de terme
            for (Monome mterme:terme.monomes){
                result.ajoutMonome(mterme);
            }
            return result;
}
    public PolynomeCreux produit(PolynomeCreux facteur){
        PolynomeCreux result=new PolynomeCreux();
        for (Monome m:monomes){
            result=result.somme(facteur.produit(m));
        }
        return result;
    }

    // ce serait mieux de le faire avec Horner
    public double evalNaif(double valeur){
        double result=0;
        for (Monome m:monomes){
            result+=m.eval(valeur);
        }
        return result;
    }

    public PolynomeCreux derivee(){
        PolynomeCreux derivee=new PolynomeCreux();
        for (Monome m:monomes){
            derivee.ajoutMonome(m.derivee());
        }
        return derivee;
    }



    public static void main(String[] args) {
        PolynomeCreux p1=new PolynomeCreux();
        p1.ajoutMonome(new Monome(1, 10));
        p1.ajoutMonome(new Monome(1, 7));
        p1.ajoutMonome(new Monome(1, 3));
        p1.ajoutMonome(new Monome(1,1));

        p1.ajoutMonome(new Monome(1, 5));
        p1.ajoutMonome(new Monome(1, 3));
        p1.ajoutMonome(new Monome(-1, 7));
        System.out.println(p1);
        p1.produit(new Monome(3, 2));

        System.out.println(p1);
        System.out.println(p1.evalNaif(1));
        System.out.println(p1.derivee());

        // question sur la réf de monome
        Monome m1=new Monome(3,1);
        Monome m2=new Monome(5,5);
        PolynomeCreux p=new PolynomeCreux();
        p.ajoutMonome(m1);
        p.ajoutMonome(m2);
        System.out.println("p avant modif m1 : "+p);
        m1.ajoutAuCoeff(3); // cette instruction a t-elle un effet de bord sur p ?
        System.out.println("p après modif m1 : "+p);
        System.out.println(p1.produit(new Monome(3, 1)));
        System.out.println(p1.produit(new Monome(5, 5)));
        System.out.println(p1.produit(new Monome(3, 1)).somme(p1.produit(new Monome(5, 5))));
        System.out.println(p1.produit(p));
    }
}
