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


    public Square(int parId, COLOR parColor, int parThickness, Point parPoint, Integer parLength) {
        //on initialise les champs
        super(parId, 0, 0, parColor, parThickness);
        this.point = parPoint;
        this.length = parLength;
    }

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
        ArrayList<Pixel> listPixelsSquare = new ArrayList<>();
        int departX = this.point.getPosX();
        int departY =  this.point.getPosY();
 
        for(int x = departX; x < this.length + departX;x++){
            listPixelsSquare.add(new Pixel(x, departY));
            listPixelsSquare.add(new Pixel(x, departY+this.length-1));     
        }

        for(int y = departY+1; y < this.length + departY - 1;y++){
            listPixelsSquare.add(new Pixel(departX, y));
            listPixelsSquare.add(new Pixel(departX+this.length-1,y));
        }

        

        System.out.println("Square draw : " + listPixelsSquare);
    
        return listPixelsSquare;
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
        String squareString = "Square [" + super.toString() + ", point: " + this.point.toString() + ", lenght: " + this.length.toString() + "]";
        return squareString;
    }

    public Point getPoint() {
        return this.point;
    }

    public Integer getLength() {
        return this.length;
    }
}