
import java.io.*;
import java.util.*;

/**
 * 
 */
public class Shape {

    /**
     * 
     */
    private Integer x;

    /**
     * 
     */
    private Integer y;

    /**
     * 
     */
    private COLOR color;

    /**
     * 
     */
    private Integer id;

    /**
     * 
     */
    private Integer thickness;

    /**
     * @param parId 
     * @param parX 
     * @param parY 
     * @param parColor 
     * @param parThickness
     */
    public Shape(Integer parId, Integer parX, Integer parY, COLOR parColor, Integer parThickness) {
        // TODO implement here
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

    public Integer getX() {
        return this.x;
    }

    public Integer getY() {
        return this.y;
    }

    public COLOR getColor() {
        return this.color;
    }

    public Integer getId() {
        return this.id;
    }

    public Integer getThickness() {
        return this.thickness;
    }
}