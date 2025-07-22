import static java.lang.Math.max;
import static java.lang.Math.min;

/**
 * Class that defines a (not tilted) rectangle with two points.
 * This rectangle is parallel to both axis
 * @author Jose Diogo Ferras
 * @version v0.0    05/03/2024
 * @inv the two points can't share any of the coordinates, be it x or y
 */
public class RetanguloSimples extends Retangulo{

    private final Ponto bottomLeft;
    private final Ponto topRight;

    /**
     * Constructor
     * @param p0 first point
     * @param p1 second point
     */
    public RetanguloSimples(Ponto p0, Ponto p1) {
        super(retanguloSimplesTests(p0,p1));
        this.bottomLeft = new Ponto(min(p0.x(),p1.x()),min(p0.y(),p1.y()));
        this.topRight = new Ponto(max(p0.x(),p1.x()),max(p0.y(),p1.y()));
    }

    /**
     * Tests if the two points are elegible to form a rectangle
     * @param p0 first point
     * @param p1 second point
     * @return array of points to call the super constructor with
     */
    private static Ponto[] retanguloSimplesTests(Ponto p0, Ponto p1){
        if(p0.x() == p1.x() || p0.y() == p1.y()){
            System.out.println("Retangulo:vi");
            System.exit(0);
        }
        Ponto a = new Ponto(min(p0.x(),p1.x()),min(p0.y(),p1.y()));
        Ponto b = new Ponto(max(p0.x(),p1.x()),min(p0.y(),p1.y()));
        Ponto c = new Ponto(max(p0.x(),p1.x()),max(p0.y(),p1.y()));
        Ponto d = new Ponto(min(p0.x(),p1.x()),max(p0.y(),p1.y()));
        return new Ponto[]{a,b,c,d};
    }

    /**
     * Getter of bottomLeft point
     * @return bottomLeft point of called object
     */
    public Ponto bottomLeft(){
        return this.bottomLeft;
    }

    /**
     * Getter of topRight point
     * @return topRight point of called object
     */
    public Ponto topRight(){
        return this.topRight;
    }

    /**
     * Verifies if two rectangles intersects each other or not
     * @param that second rectangle
     * @return true if the rectangles intersect, false if not
     */
    public boolean intersects(RetanguloSimples that){
        if(this.topRight.y() <= that.bottomLeft.y() || this.bottomLeft.y() >= that.topRight.y()){
            return false;
        }
        if(this.topRight.x() <= that.bottomLeft.x() || this.bottomLeft.x() >= that.topRight.x()){
            return false;
        }
        return true;
    }

    /**
     * CAN'T ROTATE A SIMPLE RECTANGLE
     */
    public RetanguloSimples rotate(double angle, Ponto c){
        throw new UnsupportedOperationException();
    }

    /**
     * Rotates the simple rectangle "angle" degrees clockwise about the centroid
     * @return rotated RetanguloSimples
     */
    public RetanguloSimples rotate(double angle){
        throw new UnsupportedOperationException();
    }

    /**
     * CAN'T TRANSLATE A SIMPLE RECTANGLE
     */
    public Quadrado translate(double x, double y){
        throw new UnsupportedOperationException();
    }

    /**
     * Metodo toString
     * @return  transforma o RetanguloSimples num formato de string
     */
    public String toString(){
        String result = "";
        result += ("Retangulo Simples: [");
        result += pointsToString();
        result += "]";
        return result;
    }
}
