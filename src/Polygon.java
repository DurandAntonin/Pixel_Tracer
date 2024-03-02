import java.util.ArrayList;

/**
 * 
 */
public class Polygon extends Shape {
    /**
     * 
     */
    private ArrayList<Point> pointList;

    /**
     * @param parNbOfPoints 
     * @param parPointList
     */
    public Polygon(int parId, COLOR parColor, int parThickness, ArrayList<Point> parPointList) {
        //on initialise les champs
        super(parId, 0, 0, parColor, parThickness);
        this.pointList = parPointList;
    }

    public Polygon(ArrayList<Point> parPointList) {
        //on initialise les champs
        super(null, null, null, null, null);
        this.pointList = parPointList;
    }

    /**
     * @return
     */
    public ArrayList<Pixel> draw() {
        //on va dessiner des segments entre chaque point du polygon
        ArrayList<Pixel> listPixelsPolygon = new ArrayList<>();

        for (int i=0; i<this.pointList.size()-1; i++){
            Point p1 = this.pointList.get(i);
            Point p2 = this.pointList.get(i+1);

            int dx = Math.abs(p2.getPosX() - p1.getPosX());
            int dy = Math.abs(p2.getPosY() - p1.getPosY());

            int x = p1.getPosX();
            int y = p1.getPosY();

            ArrayList<Pixel> listPixelsSegment = Line.drawSegment(x, y, dx, dy);
            listPixelsPolygon.addAll(listPixelsSegment);

            //on enlève un pixel pour éviter le doublon sauf le dernier
            if (i < this.pointList.size()-2)
                listPixelsPolygon.remove(listPixelsPolygon.size()-1);
        }

        if (this.pointList.size() % 2 != 0){

        }

        System.out.println("Polygon draw : " + listPixelsPolygon);

        return listPixelsPolygon;
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
        return this.getId() == ((Polygon) object).getId() && this.getPointList().equals(((Polygon) object).getPointList()) && this.getX() == ((Polygon) object).getX() && this.getY() == ((Polygon) object).getY() && this.getColor() == ((Polygon) object).getColor() && this.getThickness() == ((Polygon) object).getThickness();

    }

    /**
     * @return
     */
    public String toString() {
        String polygonString = "Polygon [" + super.toString() + ", nbOfPoints: " + this.pointList.size() + ", pointList: [";

        for (int i=0; i<this.pointList.size(); i++){
            polygonString += this.pointList.get(i).toString() + ", ";
        }

        if (this.pointList.size() > 0)
            polygonString = polygonString.substring(0, polygonString.length()-2);
        polygonString += "]]";

        return polygonString;
    }

    public int getNbOfPoints() {
        return this.pointList.size();
    }

    public ArrayList<Point> getPointList() {
        return this.pointList;
    }
}