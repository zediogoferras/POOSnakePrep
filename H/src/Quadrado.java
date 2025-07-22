/**
 * Class that defines a Square.
 * @author Jose Diogo Ferras
 * @version v0.0    11/03/2024
 * @inv all the sides of the square have to be equal
 */
public class Quadrado extends Retangulo{

    /**
     * Constructor
     * @param p array of points
     */
    public Quadrado(Ponto[] p) {
        super(quadradoTests(p));
    }

    /**
     * Constructor that is called with a string with the points
     * @param pontos string with the points that will define the square
     */
    public Quadrado(String pontos){
        this(stringToPontos(pontos));
    }

    /**
     * Tests if the points are elegible to form a square
     * @param p array of points
     * @return array of points to call the super constructor with
     */
    private static Ponto[] quadradoTests(Ponto[] p){
        if(!haveSameDistance(p)){
            System.out.println("Quadrado:vi");
            System.exit(0);
        }
        return p;
    }

    /**
     * Verifies if the array of points all have the same difference from each other (in sequence)
     * @param p array of points
     * @return true if they all have the same distance, false if not
     */
    private static boolean haveSameDistance(Ponto p[]){
        double ab = p[0].dist(p[1]);
        double bc = p[1].dist(p[2]);
        double cd = p[2].dist(p[3]);
        double da = p[3].dist(p[0]);
        return (ab == bc && ab == cd && ab == da);
    }

    /**
     * Rotates the square "angle" degrees clockwise about the point c
     * @return rotated Quadrado
     */
    public Quadrado rotate(int angle, Ponto c){
        return (Quadrado) super.rotate(angle,c);
    }

    /**
     * Rotates the square "angle" degrees clockwise about the centroid
     * @return rotated Quadrado
     */
    public Quadrado rotate(int angle){
        return rotate(angle, this.findCentroid());
    }

    /**
     * Metodo toString
     * @return  transforma o Quadrado num formato de string
     */
    public String toString(){
        String result = "";
        result += ("Quadrado: [");
        result += pointsToString();
        result += "]";
        return result;
    }
}
