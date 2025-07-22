import java.util.ArrayList;
import java.util.Arrays;

import static java.lang.Math.max;
import static java.lang.Math.min;

/**
 *  Class that defines a line segment, with 2 points.
 *  @author Jose Diogo Ferras
 *  @version v0.0   18/02/2024
 *  @inv Line segments can't be formed with two points that have the same coordinates
 */
public class SegmentoReta {
    private Ponto a;
    private Ponto b;

    /**
     * Constructor
     * @param a first point
     * @param b second point
     */
    public SegmentoReta(Ponto a, Ponto b){
        if(a.equals(b)) {
            System.out.println("Segmento:vi");
            System.exit(0);
        }
        this.a = new Ponto(a.x(), a.y());
        this.b = new Ponto(b.x(), b.y());
    }

    /**
     * Getter of point a
     * @return point a
     */
    public Ponto a(){
        return this.a;
    }

    /**
     * Getter of point b
     * @return point b
     */
    public Ponto b(){
        return this.b;
    }

    /**
     * Verifies if two line segments share one of the vertices
     * @param that second line segment (first line segment is the one the method is called with)
     * @return true if they share a vertex, false if not
     */
    public boolean sharesVertex(SegmentoReta that){
        if(this.a().equals(that.a()) || this.a().equals(that.b()) || this.b().equals(that.a()) || this.b().equals(that.b())){
            return true;
        }
        return false;
    }

    /**
     * Verifies if these two line segments intersect with each other
     * @param that second line segment (first line segment is the one the method is called with)
     * @return true if two line segments intersect, false if they don't
     * @see "https://www.youtube.com/watch?v=bvlIYX9cgls"
     */
    public boolean intersects(SegmentoReta that){
        Ponto A = this.a();
        Ponto B = this.b();
        Ponto C = that.a();
        Ponto D = that.b();
        double a = ((D.x() - C.x())*(C.y() - A.y())) - ((D.y() - C.y())*(C.x() - A.x()));
        double b = ((D.x() - C.x())*(B.y() - A.y())) - ((D.y() - C.y())*(B.x() - A.x()));
        double c = ((B.x() - A.x())*(C.y() - A.y())) - ((B.y() - A.y())*(C.x() - A.x()));
        //are collinear
        if(b == 0.0 && a == 0.0){
            return false;
        }
        //are parallel
        else if(b == 0.0){
            return false;
        }

        double alpha = a/b;
        double beta = c/b;

        if(alpha > 0 && alpha < 1 && beta > 0 && beta < 1){
            return true;
        }
        else{
            return false;
        }
    }
}
