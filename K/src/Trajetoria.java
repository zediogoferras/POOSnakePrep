import java.util.ArrayList;

/**
 * Class that defines a trajectory with an array of points.
 * @author Jose Diogo Ferras
 * @version v0.0    20/02/2024
 * @inv number of points has to be >= 2
 * @inv can't have 2 point with the exact same coordinates
 */
public class Trajetoria {
    private Ponto[] pontos;

    /**
     * Constructor
     * @param p array of points that define the trajectory
     */
    public Trajetoria(Ponto[] p){
        if(p.length < 2){
            System.out.println("Trajetoria:vi");
            System.exit(0);
        }
        else if(duplicatePoints(p)){
            System.out.println("Trajetoria:vi");
            System.exit(0);
        }
        this.pontos = new Ponto[p.length];
        for(int i = 0; i < pontos.length; i++){
            this.pontos[i] = new Ponto(p[i].x(), p[i].y());
        }
    }

    /**
     * Verifies if the array of points p has any pair of points with the exact same coordinates
     * @param p array of points
     * @return true if there is any pair of points with the exact same coordinates, false if not
     */
    private static boolean duplicatePoints(Ponto[] p){
        for(int i = 0; i < p.length-1; i++){
            for(int j = i+1; j < p.length; j++){
                if(p[i].equals(p[j])){
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * Creates SegementoReta array with all the SegmentosReta that form the Trajetoria
     * @return the SegmentoReta array
     */
    public SegmentoReta[] createSegmentosReta(){
        int n = this.pontos.length;
        SegmentoReta ab;
        SegmentoReta[] segmentosReta = new SegmentoReta[n-1];
        for(int i = 0; i < segmentosReta.length; i++){
            ab = new SegmentoReta(this.pontos[i], this.pontos[i+1]);
            segmentosReta[i] = ab;
        }
        return segmentosReta;
    }

    /**
     * Verifies if Trajetoria collides with any of the obstacles represented by Poligonos
     * @param poligonos array of Poligonos that define the obstacles
     * @return true if it collides with any Polygon, false if not
     */
    public boolean collidesWithObstacles(Poligono[] poligonos){
        SegmentoReta[] segmentosTrajetoria = this.createSegmentosReta();
        ArrayList<SegmentoReta> segmentosPoligonos = Poligono.createSegmentosReta(poligonos);
        for(SegmentoReta sr0 : segmentosTrajetoria){
            for(SegmentoReta sr1 : segmentosPoligonos){
                if(sr0.intersects(sr1)){
                    return true;
                }
            }
        }
        return false;
    }
}
