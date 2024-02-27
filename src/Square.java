import java.util.*;

/**
 * 
 */
public class Square extends Shape {

    /**
     * 
     */
    private Point point;

    /**
     * 
     */
    private Integer length;

    /**
     * @param parPoint 
     * @param parLength
     */
    public Square(Point parPoint, Integer parLength) {
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

    public Point getPoint() {
        return this.point;
    }

    public Integer getLength() {
        return this.length;
    }
}