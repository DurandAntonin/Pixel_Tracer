import java.util.ArrayList;

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
    public Point(int parId, COLOR parColor, int parThickness, int px, int py) {
        //on initialise les champs
        super(parId, 0, 0, parColor, parThickness);
        this.posX = px;
        this.posY = py;
    }

    public Point(int px, int py) {
        //on initialise les champs
        super(null, 0, 0, null, 1);
        this.posX = px;
        this.posY = py;
    }

    /**
     * @return
     */
    public ArrayList<Pixel> draw() {
        //on convertit l'objet en pixels
        ArrayList<Pixel> pixelPoint = new ArrayList<>();
        pixelPoint.add(new Pixel(this.posX, this.posY, this.getColor()));
        
        return pixelPoint;
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
        return this.getId() == ((Point) object).getId() && this.posX == ((Point) object).posX && this.posY == ((Point) object).posY && this.getX() == ((Point) object).getX() && this.getY() == ((Point) object).getY() && this.getColor() == ((Point) object).getColor() && this.getThickness() == ((Point) object).getThickness();

    }

    /**
     * @return
     */
    public String toString() {
        // TODO implement here
        return "Point [" + super.toString() + ", posX: " + this.posX + ", posY: " + this.posY + "]";
    }

    public int getPosX() {
        return this.posX;
    }

    public int getPosY() {
        return this.posY;
    }
}