import java.util.*;

/**
 * 
 */
public class Point extends Shape {

    /**
     * 
     */
    private Integer posX;

    /**
     * 
     */
    private Integer posY;

    /**
     * @param px 
     * @param py
     */
    public Point(int px, int py) {
        // TODO implement here
        super(null, null, null, null, null);
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

    public Integer getPosX() {
        return this.posX;
    }

    public Integer getPosY() {
        return this.posY;
    }
}