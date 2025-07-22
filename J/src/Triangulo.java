/**
 * Class that defines a Triangle.
 * @author Jose Diogo Ferras
 * @version v0.0    11/03/2024
 * @inv has to be formed by three points
 */
public class Triangulo extends Poligono{

    /**
     * Constructor
     * @param p array of points that will form the triangle
     */
    public Triangulo(Ponto[] p) {
        super(p);
    }

    /**
     * Constructor that is called with a string with the points
     * @param pontos string with the points that will define the triangle
     */
    public Triangulo(String pontos){
        this(stringToPontos(pontos));
    }

    /**
     * Tests if the points are elegible to form a triangle
     * @param p array of points
     * @return array of points to call the super constructor with
     */
    private static Ponto[] trianguloTests(Ponto[] p){
        if(p.length != 3){
            System.out.println("Triangulo:vi");
            System.exit(0);
        }
        return p;
    }

    /**
     * Rotates the triangle "angle" degrees clockwise about the point c
     * @return rotated Triangulo
     */
    public Triangulo rotate(double angle, Ponto c){
        return new Triangulo(rotatePoints(angle, c));
    }

    /**
     * Rotates the triangle "angle" degrees clockwise about the centroid
     * @return rotated Triangulo
     */
    public Triangulo rotate(double angle){
        return rotate(angle, this.findCentroid());
    }

    /**
     * Translates the triangle x and y coordinates
     * @return translated triangle
     */
    public Triangulo translate(double x, double y){
        return new Triangulo(translatePoints(x,y));
    }

    /**
     * Metodo toString
     * @return  transforma o Triangulo num formato de string
     */
    public String toString(){
        String result = "";
        result += ("Triangulo: [");
        result += pointsToString();
        result += "]";
        return result;
    }
}
