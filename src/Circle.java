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

    public Circle(int parId, COLOR parColor, int parThickness, Point parCenter, int parRadius) {
        //on initialise les champs
        super(parId, 0, 0, parColor, parThickness);
        this.center = parCenter;
        this.radius = parRadius;
    }

    /**
     * @param parCenter 
     * @param parRadius
     */
    public Circle(Point parCenter, Integer parRadius) {
        //on initialise les champs
        super(null, null, null, null, null);
        this.center = parCenter;
        this.radius = parRadius;
    }

    /**
     * @return
     */
    public ArrayList<Pixel> draw() {
        ArrayList<Pixel> listPixelsCicle = new ArrayList<>();

        int x = 0;
        int y = this.radius;
        int deltaError = this.radius - 1;
        int posXCenter = this.center.getPosX();
        int posYCenter = this.center.getPosY();

        while (y >= x){
            Pixel p1 = new Pixel(posXCenter+x, posYCenter+y);
            Pixel p2 = new Pixel(posXCenter+y, posYCenter+x);
            Pixel p3 = new Pixel(posXCenter-x, posYCenter+y);
            Pixel p4 = new Pixel(posXCenter-y, posYCenter+x);
            Pixel p5 = new Pixel(posXCenter+x, posYCenter-y);
            Pixel p6 = new Pixel(posXCenter+y, posYCenter-x);
            Pixel p7 = new Pixel(posXCenter-x, posYCenter-y);
            Pixel p8 = new Pixel(posXCenter-y, posYCenter-x);

            listPixelsCicle.add(p1);
            listPixelsCicle.add(p2);
            listPixelsCicle.add(p3);
            listPixelsCicle.add(p4);
            listPixelsCicle.add(p5);
            listPixelsCicle.add(p6);
            listPixelsCicle.add(p7);
            listPixelsCicle.add(p8);

            if (deltaError >= 2*x){
                deltaError -= 2*x + 1;
                x ++;
            }
            else if (deltaError < 2*(this.radius - y)){
                deltaError = 2 * y-1;
                y --;
            }
            else{
                deltaError += 2 *(y-x-1);
                y --;
                x ++;
            }
        }

        System.out.println(listPixelsCicle);

        return listPixelsCicle;
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
        return this.getId() == ((Circle) object).getId() && this.center.equals(((Circle)object).getCenter()) && this.radius == ((Circle) object).getRadius() && this.getX() == ((Circle) object).getX() && this.getY() == ((Circle) object).getY() && this.getColor() == ((Circle) object).getColor() && this.getThickness() == ((Circle) object).getThickness();
    }

    /**
     * @return
     */
    public String toString() {
        return "Circle [" + super.toString() + ", center: " + this.center + ", radius: " + this.radius + "]";
    }

    public Point getCenter() {
        return this.center;
    }

    public int getRadius() {
        return this.radius;
    }
}