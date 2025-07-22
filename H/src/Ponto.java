/**
 *  Class that defines a 2D point, with x and y coordinates.
 *  @author Jose Diogo Ferras
 *  @version v0.0   18/02/2024
 *  @inv any point created by this class will have to belong to the first quadrant
 */
class Ponto {
    private int x;
    private int y;

    /**
     * Constructor
     * @param x coordinate
     * @param y coordinate
     */
    public Ponto(int x, int y){
        if(x < 0 || y < 0){
            System.out.println("Ponto:vi");
            System.exit(0);
        }
        this.x = x;
        this.y = y;
    }

    /**
     * Getter of the x coordinate of a point
     * @return x coordinate of that point
     */
    public int x(){
        return this.x;
    }

    /**
     * Getter of the y coordinate of a point
     * @return y coordinate of that point
     */
    public int y(){
        return this.y;
    }

    /**
     * Calculates the distance between to points
     * @param p second point (first point is the object we call the method with)
     * @return distance between these two points
     */
    double dist (Ponto p) {
        double dx = x - p.x;
        double dy = y - p.y;
        return Math.sqrt(dx*dx + dy*dy);
    }

    /**
     * Verifies if the points have the exact same coordinates
     * @param that second point (first point is the object we call the method with)
     * @return true if they have the exact same coordinates, false if not
     */
    boolean equals (Ponto that){
        if(this.x == that.x && this.y == that.y){
            return true;
        }
        else{
            return false;
        }
    }
}
