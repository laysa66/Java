public class Point {
    private double coordX;
    private double coordY;

    /**
     * Constructeur paramétré
     * @param coordX coordonnée des abscisses
     * @param coordY coordonnée des ordonnées
     */
    public Point(double coordX, double coordY) {
        this.coordX = coordX;
        this.coordY = coordY;
    }

    /**
     * Constructeur non paramétré, construit le point origine (0,0)
     */
    public Point(){
        this.coordX=0;
        this.coordY=0;
    }

    public double getCoordX() {
        return coordX;
    }

    public double getCoordY() {
        return coordY;
    }

    public void setCoordX(double coordX) {
        this.coordX = coordX;
    }

    public void setCoordY(double coordY) {
        this.coordY = coordY;
    }

    @Override
    public String toString() {
        return "Point (" + coordX + ", " + coordY +')';
    }

    /**
     * Retourne la distance à l'origine
     * @return sqrt(pow(coordX,2)+pow(coordY,2))
     */
    public double module(){
        return Math.sqrt(Math.pow(coordX,2)+Math.pow(coordY, 2));
        // ou distanceDe(new Point())
    }

    /**
     * Retourne la distance entre l'objet receveur et le point en paramètre
     * @param p
     * @return sqrt(pow(coordX-p.coorX,2)+pow(coordY-p.coordY,2))
     */
    public double distanceDe(Point p){
        return Math.sqrt(Math.pow(coordX-p.coordX,2)+Math.pow(coordY-p.coordY, 2));
    }

    /**
     * Retourne le point symétrique receveur par symétrie centrale
     * @return le point de coordonnées (-coordX, -coordY)
     */
    public Point symetrique(){
        return new Point(-coordX,-coordY);
    }


}
