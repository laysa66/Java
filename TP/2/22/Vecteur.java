public class Vecteur {
    private Point coordonnees;

    // ce n'est pas précisé si on doit garder la même ref ou pas. on peut en discuter
    public Vecteur(Point p){
        this(p.getCoordX(), p.getCoordY());
    }

    public Vecteur(double coordX, double coordY) {
        coordonnees=new Point(coordX, coordY);
    }

    public Vecteur sommeAvec(Vecteur v){
        return new Vecteur(coordonnees.getCoordX()+v.coordonnees.getCoordX(), coordonnees.getCoordY()+v.coordonnees.getCoordY());
        // on peut aussi placer une méthode de translation d'un point par un vecteur dans Point et l'appeler
    }

    public void ajout(Vecteur v){
        Vecteur nv=sommeAvec(v);
        this.coordonnees.setCoordX(nv.coordonnees.getCoordX());
        this.coordonnees.setCoordY(nv.coordonnees.getCoordY());
    }

    public static Vecteur somme(Vecteur v1, Vecteur v2){
        return v1.sommeAvec(v2);
    }

    @Override
    public String toString() {
        return "Vecteur{" +
                "coordonnees=" + coordonnees +
                '}';
    }

    public static void main(String[] args) {
        Vecteur v1=new Vecteur(1, 2);
        Vecteur v2=new Vecteur(2, 1);
        Vecteur v3=new Vecteur(3, 3);
        Vecteur v4=v1.sommeAvec(v2);
        Vecteur v5=v3;
        System.out.println(v4);
    }

}
