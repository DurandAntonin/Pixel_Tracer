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
        super(null, null, null, null, null);
        this.point = parPoint;
        this.length = parLength;
    }

    /**
     * @return
     */
    public ArrayList<Pixel> draw() {
        ArrayList<Pixel> pixels = new ArrayList<>();
        int departX = this.point.getPosX();
        int departY =  this.point.getPosY();
        pixels.add(new Pixel(departX, departY));
 
        for(int i = 1;i < this.length -1;i++){
            pixels.add(new Pixel(departX, departY+i));
            pixels.add(new Pixel(departX+i, departY));
        }

        for (int i = 1; i<this.length;i++){
            pixels.add(new Pixel(departX+this.length,departY+i ));
            pixels.add(new Pixel(departX+i,departY+this.length ));
        }
    
        return pixels;
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
        return this.point == ((Square) object).getPoint() && this.length == ((Square) object).getLength();
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