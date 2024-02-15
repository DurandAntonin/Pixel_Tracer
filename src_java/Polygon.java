import java.util.*;

/**
 * 
 */
public class Polygon extends Shape {

    /**
     * 
     */
    private Integer nbOfPoints;

    /**
     * 
     */
    private List<Point> pointList;

    /**
     * @param parNbOfPoints 
     * @param parPointList
     */
    public Polygon(Integer parNbOfPoints, List<Point> parPointList) {
        // TODO implement here
        super(null, null, null, null, null);
    }

    /**
     * @return
     */
    public List<Pixel> draw() {
        // TODO implement here
        return null;
    }

    /**
     * @return
     */
    public String toString() {
        // TODO implement here
        return "";
    }

    public Integer getNbOfPoints() {
        return this.nbOfPoints;
    }

    public List<Point> getPointList() {
        return this.pointList;
    }
}