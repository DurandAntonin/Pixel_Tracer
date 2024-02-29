import java.util.*;

/**
 * 
 */
public class Pixel {
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
     * @param parX 
     * @param parY
     */
    public Pixel(Integer parX, Integer parY, COLOR parColor) {
        this.x = parX;
        this.y = parY;
        this.color = parColor;
    }

    public Pixel(Integer parX, Integer parY) {
        this.x = parX;
        this.y = parY;
        this.color = COLOR.BLACK;
    }

    @Override
    public boolean equals(Object object){
        //on regarde si les 2 variables font référence au meme objet
        if (this == object)
            return true;

        //on regarde si l'objet à comparer est null ou qu'il n'est pas de la meme classe que this
        if (object == null || !this.getClass().equals(object.getClass()))
            return false;
        
        //on vérifie que les valeurs des champs sont identiques
        return this.x == ((Pixel) object).getX() && this.y == ((Pixel) object).getY() && this.color == ((Pixel) object).getColor();
    }

    /**
     * @return
     */
    public String toString() {
        return "Pixel [x: " + this.x + ", y: "+this.y + ", color: "+this.color +"]";
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
}