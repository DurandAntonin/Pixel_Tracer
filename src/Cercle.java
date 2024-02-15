
import java.io.*;
import java.util.*;

/**
 * 
 */
public class Cercle extends Shape {
    /**
     * 
     */
    private Point center;

    /**
     * 
     */
    private int radius;

    /**
     * @param parCenter 
     * @param parRadius
     */
    public Cercle(Point parCenter, Integer parRadius) {
        // TODO implement here
        super(parRadius, parRadius, parRadius, null, parRadius);
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

    public Point getCenter() {
        return this.center;
    }

    public int getRadius() {
        return this.radius;
    }
}