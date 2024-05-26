public class ManipulationsPoint {
    public static void main(String[] args) {
        Point o=new Point();
        Point p1=new Point(3, 4);
        System.out.println("Le point "+o+" a pour module "+o.module());
        System.out.println("Le point "+p1+" a pour module "+p1.module());
        Point p2=p1.symetrique();
        System.out.println("Distance entre p1 et son symétrique : "+p1.distanceDe(p2));
    }
}
