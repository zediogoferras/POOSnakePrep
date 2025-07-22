import static java.lang.Math.*;
import static java.lang.Math.round;

/**
 * Class that defines rectangle.
 * @author Jose Diogo Ferras
 * @version v0.0    11/03/2024
 * @inv each line segment formed by the array of points has to have one other line segment to which it is parallel with
 */
public class Retangulo extends Poligono{

    /**
     * Constructor
     * @param p array of points
     */
    public Retangulo(Ponto[] p) {
        super(retanguloTests(p));
    }

    /**
     * Constructor that is called with a string with the points
     * @param pontos string with the points that will define the rectangle
     */
    public Retangulo(String pontos){
        this(stringToPontos(pontos));
    }

    /**
     * Tests if the points are elegible to form a rectangle
     * @param p array of points
     * @return array of points to call the super constructor with
     */
    private static Ponto[] retanguloTests(Ponto[] p){

        if(p.length != 4){
            System.out.println("Retangulo:vi");
            System.exit(0);
        }
        else if(!checkParallelism(p)){
            System.out.println("Retangulo:vi");
            System.exit(0);
        }
        return p;
    }

    /**
     * Tests if for each line segment of the four there is one of the others that is parallel with the other
     * @param p array of points
     * @return true if they are parallel false if not
     */
    private static boolean checkParallelism(Ponto p[]){
        Reta ab = new Reta(p[0], p[1]);
        Reta bc = new Reta(p[1], p[2]);
        Reta cd = new Reta(p[2], p[3]);
        Reta da = new Reta(p[3], p[0]);
        return ab.isParallel(cd) && bc.isParallel(da);
    }

    /**
     * Rotates the rectangle "angle" degrees clockwise about the point c
     * @return rotated Retangulo
     */
    public Retangulo rotate(double angle, Ponto c){
        return new Retangulo(this.rotatePoints(angle, c));
    }

    /**
     * Rotates the rectangle "angle" degrees clockwise about the centroid
     * @return rotated Retangulo
     */
    public Retangulo rotate(double angle){
        return rotate(angle, this.findCentroid());
    }

    /**
     * Translates the rectangle x and y coordinates
     * @return translated rectangle
     */
    public Retangulo translate(double x, double y){
        return new Retangulo(translatePoints(x,y));
    }

    /**
     * Metodo toString
     * @return  transforma o Retangulo num formato de string
     */
    public String toString(){
        String result = "";
        result += ("Retangulo: [");
        result += pointsToString();
        result += "]";
        return result;
    }
}
