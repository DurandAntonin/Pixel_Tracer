
import java.io.*;
import java.util.*;

/**
 * 
 */
public abstract class Shape {

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
        this.id = parId;
        this.x = parX;
        this.y = parY;
        this.color = parColor;
        this.thickness = parThickness;
    }

    /**
     * @return
     */
    public abstract List<Pixel> draw();

    @Override
    public abstract boolean equals(Object object);

    /**
     * @return
     */
    public String toString() {
        return "id : " + this.id + ", x : "+this.x+ ", y : "+this.y+", color : " + this.color+", thickness"+this.thickness;
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