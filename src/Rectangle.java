import java.util.*;

/**
 * 
 */
public class Rectangle extends Shape {

    /**
     * 
     */
    private Point point;

    /**
     * 
     */
    private Integer width;

    /**
     * 
     */
    private Integer height;

    /**
     * @param parPoint 
     * @param parWidth 
     * @param parHeight
     */
    public Rectangle(Point parPoint, Integer parWidth, Integer parHeight) {
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

    public Point getPoint() {
        return this.point;
    }

    public Integer getWidth() {
        return this.width;
    }

    public Integer getHeight() {
        return this.height;
    }
}