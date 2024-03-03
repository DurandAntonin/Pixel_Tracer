
import java.io.*;
import java.util.*;

/**
 * 
 */
public class Curve extends Shape {

    /**
     * 
     */
    private Point p1;

    /**
     * 
     */
    private Point p2;

    /**
     * 
     */
    private Point p3;

    /**
     * 
     */
    private Point p4;

    /**
     * @param parP1 
     * @param parP2 
     * @param parP3 
     * @param parP4
     */
    public Curve(int parId, COLOR parColor, int parThickness, Point parP1, Point parP2, Point parP3, Point parP4) {
        //on initialise les champs
        super(parId, 0, 0, parColor, parThickness);
        this.p1 = parP1;
        this.p2 = parP2;
        this.p3 = parP3;
        this.p4 = parP4;
    }

    /**
     * @param parP1 
     * @param parP2 
     * @param parP3 
     * @param parP4
     */
    public Curve(Point parP1, Point parP2, Point parP3, Point parP4) {
        //on initialise les champs
        super(null, null, null, null, null);
        this.p1 = parP1;
        this.p2 = parP2;
        this.p3 = parP3;
        this.p4 = parP4;
    }

    public static Point calcPointMedian(Point p1, Point p2, double t) {
        double x = p1.getPosX() * (1 - t) + p2.getPosX() * t;
        double y = p1.getPosY() * (1 - t) + p2.getPosY() * t;
        return new Point((int)x, (int)y);
    }

    public static Point cjCalc(Point[] points, double t) {
        Point[] tmpPt = new Point[points.length];
        System.arraycopy(points, 0, tmpPt, 0, points.length);

        for (int i = points.length - 1; i > 0; --i) {
            for (int j = 0; j < i; ++j) {
                tmpPt[j] = calcPointMedian(tmpPt[j], tmpPt[j + 1], t);
            }
        }
        return tmpPt[0];
    }

    /**
     * @return
     */
    public ArrayList<Pixel> draw() {
        ArrayList<Pixel> listPixelsCurve = new ArrayList<>();

        Point[] points = {this.p1, this.p2, this.p3, this.p4};
        double t = 0;

        for (t = 0; t < 1.0; t += 0.0001) {
            Point cjp1 = cjCalc(points, t);
            Pixel px = new Pixel(cjp1.getPosX(), cjp1.getPosY(), this.getColor());
            listPixelsCurve.add(px);
        }

        return listPixelsCurve;
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
        return this.getId() == ((Curve) object).getId() && this.p1.equals(((Curve)object).getP1()) && this.p2.equals(((Curve)object).getP2()) && this.p3.equals(((Curve)object).getP3()) && this.p4.equals(((Curve)object).getP4()) && this.getX() == ((Curve) object).getX() && this.getY() == ((Curve) object).getY() && this.getColor() == ((Curve) object).getColor() && this.getThickness() == ((Curve) object).getThickness();
    }

    /**
     * @return
     */
    public String toString() {
        return "Curve [" + super.toString() + ", p1: " + this.p1.toString() + ", p2: " + this.p2.toString() + ", p3: " + this.p3.toString() + ", p4: " + this.p4.toString() + "]";
    }

    public Point getP1() {
        return this.p1;
    }

    public Point getP2() {
        return this.p2;
    }

    public Point getP3() {
        return this.p3;
    }

    public Point getP4() {
        return this.p4;
    }
}

