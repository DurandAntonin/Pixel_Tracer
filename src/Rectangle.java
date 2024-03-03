import java.util.*;

/**
 * 
 */
public class Rectangle extends Shape {

    /**
     * 
     */
    private Point point;

    /**
     * 
     */
    private Integer width;

    /**
     * 
     */
    private Integer height;

    /**
     * @param parPoint 
     * @param parWidth 
     * @param parHeight
     */
    public Rectangle(int parId, COLOR parColor, int parThickness, Point parPoint, int parWidth, int parHeight) {
        //on initialise les attributs
        super(parId, 0, 0, parColor, parThickness);
        this.point = parPoint;
        this.width = parWidth;
        this.height = parHeight;
    }

    /**
     * @param parPoint 
     * @param parWidth 
     * @param parHeight
     */
    public Rectangle(Point parPoint, Integer parWidth, Integer parHeight) {
        //on initialise les attributs
        super(null, null, null, null, null);
        this.point = parPoint;
        this.width = parWidth;
        this.height = parHeight;
    }

    /**
     * @return
     */
    public ArrayList<Pixel> draw() {
        //on va tracer des segments de pixels entre chaque point pour dessiner un rectangle
        ArrayList<Pixel> listPixelsRectangle = new ArrayList<>();

        Point p1 = this.point;
        Point p2 = new Point(p1.getPosX() + width -1, p1.getPosY());
        Point p3 = new Point(p1.getPosX()+ width -1, p1.getPosY() + height -1);
        Point p4 = new Point(p1.getPosX(), p1.getPosY() + height -1);

        //segment supérieur
        int dxP1P2 = Math.abs(p2.getPosX() - p1.getPosX());
        int dyP1P2 = Math.abs(p2.getPosY() - p1.getPosY());
        ArrayList<Pixel> listPixelsP1P2 = Line.drawSegment(p1.getPosX(), p1.getPosY(), dxP1P2, dyP1P2, this.getColor());
        //on enlève le premier et le dernier pixel du segment pour éviter la redondance
        if (listPixelsP1P2.size() > 1)
            listPixelsP1P2.remove(0);
        if (listPixelsP1P2.size() >= 2)
            listPixelsP1P2.remove(listPixelsP1P2.size()-1); 


        //segment droite
        int dxP2P3 = Math.abs(p3.getPosX() - p2.getPosX());
        int dyP2P3 = Math.abs(p3.getPosY() - p2.getPosY());
        ArrayList<Pixel> listPixelsP2P3 = Line.drawSegment(p2.getPosX(), p2.getPosY(), dxP2P3, dyP2P3, this.getColor());

        //segment inférieur
        int dxP3P4 = Math.abs(p3.getPosX() - p4.getPosX());
        int dyP3P4 = Math.abs(p3.getPosY() - p4.getPosY());
        ArrayList<Pixel> listPixelsP3P4 = Line.drawSegment(p4.getPosX(), p4.getPosY(), dxP3P4, dyP3P4, this.getColor());
        //on enlève le premier et le dernier pixel du segment pour éviter la redondance
        if (listPixelsP3P4.size() > 1)
            listPixelsP3P4.remove(0);
        if (listPixelsP3P4.size() >= 2)
            listPixelsP3P4.remove(listPixelsP3P4.size()-1); 

        //segment gauche
        int dxP4P1 = Math.abs(p4.getPosX() - p1.getPosX());
        int dyP4P1 = Math.abs(p4.getPosY() - p1.getPosY());
        ArrayList<Pixel> listPixelsP4P1 = Line.drawSegment(p1.getPosX(), p1.getPosY(), dxP4P1, dyP4P1, this.getColor());

        listPixelsRectangle.addAll(listPixelsP1P2);
        listPixelsRectangle.addAll(listPixelsP2P3);
        listPixelsRectangle.addAll(listPixelsP3P4);
        listPixelsRectangle.addAll(listPixelsP4P1);

        return listPixelsRectangle;
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
            return this.getId() == ((Rectangle) object).getId() && this.point.equals(((Rectangle)object).getPoint()) && this.width == ((Rectangle) object).getWidth() && this.height == ((Rectangle) object).getHeight() && this.getX() == ((Rectangle) object).getX() && this.getY() == ((Rectangle) object).getY() && this.getColor() == ((Rectangle) object).getColor() && this.getThickness() == ((Rectangle) object).getThickness();    
    }

    /**
     * @return
     */
    public String toString() {
        return "Rectangle [" + super.toString() + ", point: " + this.point.toString() + ", width: " + this.width + ", height: " + this.height + "]";
    }

    public Point getPoint() {
        return this.point;
    }

    public Integer getWidth() {
        return this.width;
    }

    public Integer getHeight() {
        return this.height;
    }
}