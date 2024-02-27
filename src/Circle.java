import java.util.*;

/**
 * 
 */
public class Circle extends Shape {
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
    public Circle(Point parCenter, Integer parRadius) {
        // TODO implement here
        super(parRadius, parRadius, parRadius, null, parRadius);
    }

    /**
     * @return
     */
    public ArrayList<Pixel> draw() {
        // TODO implement here
        return new ArrayList<>();
    }

    @Override
    public boolean equals(Object object){
        return false;
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