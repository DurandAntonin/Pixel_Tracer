import java.util.ArrayList;

/**
 * 
 */
public class Line extends Shape {
    /**
     * 
     */
    private Point p1;

    /**
     * 
     */
    private Point p2;


    /**
     * @param px 
     * @param py
     */
    public Line(int parId, COLOR parColor, int parThickness, Point parP1, Point parP2) {
        //on initialise les champs
        super(parId, 0, 0, parColor, parThickness);
        this.p1 = parP1;
        this.p2 = parP2;
    }

    /**
     * @param parP1 
     * @param parP2
     */
    public Line(Point parP1, Point parP2) {
        //on initialise les champs
        super(null, null, null, null, null);
        this.p1 = parP1;
        this.p2 = parP2;
    }

    public static ArrayList<Pixel> drawSegment(int x, int y, int dx, int dy, COLOR pixelColor){
        ArrayList<Pixel> listPixelSegment = new ArrayList<>();

        int cumul;
        int xinc = (dx > 0) ? 1 : -1;
        int yinc = (dy > 0) ? 1 : -1;

        listPixelSegment.add(new Pixel(x, y, pixelColor));
        if (dx > dy){
            cumul = dx /2;
            for (int i=1; i<=dx; i++){
                x += xinc;
                cumul += dy;
                if (cumul >= dx){
                    cumul -= dx;
                    y += yinc;
                }

                listPixelSegment.add(new Pixel(x, y, pixelColor));
            }
        }
        else{
            cumul = dy / 2;
            for (int i=1; i<=dy; i++){
                y += yinc;
                cumul += dx;
                if (cumul >= dy){
                    cumul -= dy;
                    x += xinc;
                }

                listPixelSegment.add(new Pixel(x, y, pixelColor));
            }
        }

        return listPixelSegment;
    }

    /**
     * Utilise l'algorithme de tracé de segment version Nicolas Flasque
     * 
     * @return
     */
    public ArrayList<Pixel> draw() {
        int dx = Math.abs(this.p2.getPosX() - this.p1.getPosX());
        int dy = Math.abs(this.p2.getPosY() - this.p1.getPosY());

        int x = this.p1.getPosX();
        int y = this.p1.getPosY();

        return Line.drawSegment(x, y, dx, dy, this.getColor());
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
        return this.getId() == ((Line) object).getId() && this.getP1().equals(((Line) object).getP1()) && this.getP2().equals(((Line) object).getP2()) && this.getX() == ((Line) object).getX() && this.getY() == ((Line) object).getY() && this.getColor() == ((Line) object).getColor() && this.getThickness() == ((Line) object).getThickness();
    }

    /**
     * @return
     */
    public String toString() {
        // TODO implement here
        return "Line [" + super.toString() + ", p1: " + this.p1.toString() + ", p2: " + this.p2.toString() + "]";
    }

    public Point getP1() {
        return this.p1;
    }

    public void setP1(Point p1) {
        this.p1 = p1;
    }

    public Point getP2() {
        return this.p2;
    }

    public void setP2(Point p2) {
        this.p2 = p2;
    }

}