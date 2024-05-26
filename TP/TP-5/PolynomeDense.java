import java.util.ArrayList;

public class PolynomeDense {

    private ArrayList<Integer> coefficients; // on maintient la liste des coefficients pour tous les degrés (ici le degré est l'indice)

    public PolynomeDense() {
        coefficients = new ArrayList<>();
    }

    public String toString() {
        String result = "";
        for (int i=0;i<coefficients.size();i++) {

            if (coefficients.get(i)!=0) {
                Monome m=new Monome(coefficients.get(i), i);
                result += m;

            }
        }
        if (result.equals("")) {// si result chaine vide ?
            result = "polynôme nul";
        }
        return result;
    }

    public boolean estNul() {
        for (int i = coefficients.size() - 1; i >= 0; i--) {
            if (coefficients.get(i) != 0) {
                return false;
            }
        }
        return true;
    }

    public int degreMax() {
        for (int i = coefficients.size() - 1; i >= 0; i--) {
            if (coefficients.get(i) != 0) {
                return i;
            }
        }
        return 0;
    }

    public void ajoutMonome(Monome m) {
        if (m.getDegre() < coefficients.size()) {
            coefficients.set(m.getDegre(), coefficients.get(m.getDegre()) + m.getCoeff());
        } else {
            int nbCasesARajouter=m.getDegre()-coefficients.size();
            for (int i = 0; i <nbCasesARajouter; i++) {
                coefficients.add(0);
            }
            coefficients.add(m.getCoeff());
        }

    }

            // ce serait mieux de le faire avec Horner
            public double evalNaif(double valeur){
                double result=0;
                for (int i=0; i<coefficients.size();i++){
                    result+=coefficients.get(i)*Math.pow(valeur, i);
                }
                return result;
            }

            public PolynomeDense derivee(){
                PolynomeDense derivee=new PolynomeDense();
                for (int i=0;i<coefficients.size();i++){
                    if (coefficients.get(i)!=0){
                        Monome m=new Monome(coefficients.get(i), i);
                        derivee.ajoutMonome(m.derivee());
                    }
                }
                return derivee;
            }

    public PolynomeDense produit(Monome facteur){
        PolynomeDense result=new PolynomeDense();
        for (int i=0;i<coefficients.size();i++){
            result.ajoutMonome(Monome.produit(new Monome(coefficients.get(i), i),facteur));
        }
        return result;
    }
    public PolynomeDense somme(PolynomeDense terme){
                // il y a plus efficace ...
        PolynomeDense result=new PolynomeDense();
        for (int i=0;i<coefficients.size();i++){
            result.ajoutMonome(new Monome(coefficients.get(i), i));
        }
        for (int i=0;i<terme.coefficients.size();i++){
            result.ajoutMonome(new Monome(terme.coefficients.get(i), i));
        }
        return result;
    }
    public PolynomeDense produit(PolynomeDense facteur){
        PolynomeDense result=new PolynomeDense();
        for (int i=0;i<coefficients.size();i++){
            result=result.somme(facteur.produit(new Monome(coefficients.get(i),i)));
        }
        return result;
    }

    public static void main(String[] args) {
        PolynomeDense p1 = new PolynomeDense();
        p1.ajoutMonome(new Monome(1, 10));
        p1.ajoutMonome(new Monome(-1, 10));
        p1.ajoutMonome(new Monome(1, 7));
        p1.ajoutMonome(new Monome(1, 3));
        p1.ajoutMonome(new Monome(1, 1));

        p1.ajoutMonome(new Monome(1, 5));
        p1.ajoutMonome(new Monome(1, 3));
        p1.ajoutMonome(new Monome(-1, 7));
        System.out.println(p1);
        //p1.mult(new Monome(3, 2));

        //System.out.println(p1);
        System.out.println(p1.evalNaif(1));
        System.out.println(p1.derivee());

        Monome m1=new Monome(3,1);
        Monome m2=new Monome(5,5);
        PolynomeDense p=new PolynomeDense();
        p.ajoutMonome(m1);
        p.ajoutMonome(m2);

        System.out.println(p1.produit(new Monome(3, 1)));
        System.out.println(p1.produit(new Monome(5, 5)));
        System.out.println(p1.produit(new Monome(3, 1)).somme(p1.produit(new Monome(5, 5))));
        System.out.println(p1.produit(p));

    }
}

