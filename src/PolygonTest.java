import static org.junit.Assert.assertEquals;

import java.util.ArrayList;

import org.junit.Test;
import org.junit.Before;
import org.junit.After;
import org.junit.Assert;

public class PolygonTest {

    private Polygon polygon;
    private final Point p1 = new Point(5, 5);
    private final Point p2 = new Point(7, 5);
    private final Point p3 = new Point(7, 8);
    private final Point p4 = new Point(7, 10);
    private final Point p5 = new Point(10, 10);
    private ArrayList<Point> pointList;

    @Before
    public void beforeTest(){
        pointList = new ArrayList<>();
        pointList.add(p1);
        pointList.add(p2);
        pointList.add(p3);
        pointList.add(p4);
        pointList.add(p5);

        polygon = new Polygon(pointList.size(), pointList);
    }

    @After
    public void afterTest(){
        polygon = null;
    }

    @Test
    public void testEquals(){
        //cas meme instance
        Assert.assertTrue(polygon.equals(polygon));

        //cas 2eme objet null
        Assert.assertFalse(polygon.equals(null));

        //cas objets de classes différentes
        Assert.assertFalse(polygon.equals(new String()));

        //cas objets de meme classe avec un nombre de points différents
        ArrayList<Point> pointList2 = new ArrayList<>();
        pointList2.add(p1);
        pointList2.add(p2);
        pointList2.add(p3);
        Assert.assertFalse(polygon.equals(new Polygon(pointList2.size(), pointList2)));

        //cas objets de meme classe avec un nombre de points identique mais pas les meme valeurs
        ArrayList<Point> pointList3 = new ArrayList<>();
        pointList3.add(p1);
        pointList3.add(p2);
        pointList3.add(p3);
        pointList3.add(p5);
        pointList3.add(p4);
        Assert.assertFalse(polygon.equals(new Polygon(pointList3.size(), pointList3)));

        //cas objets de meme classe et valeur des champs identique
        Assert.assertTrue(polygon.equals(new Polygon(pointList.size(), pointList)));
    }

    @Test
    public void testDraw() {
        ArrayList<Pixel> listPixelsActual = polygon.draw();
        ArrayList<Pixel> listPixelsExcepted = new ArrayList<>();
        listPixelsExcepted.add(new Pixel(5, 5));
        listPixelsExcepted.add(new Pixel(6, 5));
        listPixelsExcepted.add(new Pixel(7, 5));
        listPixelsExcepted.add(new Pixel(7, 6));
        listPixelsExcepted.add(new Pixel(7, 7));
        listPixelsExcepted.add(new Pixel(7, 8));
        listPixelsExcepted.add(new Pixel(7, 9));
        listPixelsExcepted.add(new Pixel(7, 10));
        listPixelsExcepted.add(new Pixel(8, 10));
        listPixelsExcepted.add(new Pixel(9, 10));
        listPixelsExcepted.add(new Pixel(10, 10));

        Assert.assertEquals(listPixelsExcepted.size(), listPixelsActual.size());

        assertEquals(listPixelsExcepted, listPixelsActual);
    }

    @Test
    public void testGetNbOfPoints() {
        assertEquals((Integer)pointList.size(), polygon.getNbOfPoints());
    }

    @Test
    public void testGetPointList() {
        ArrayList<Point> pointListPolygon = polygon.getPointList();
        assertEquals(pointList, pointListPolygon);
    }

    @Test
    public void testToString() {
        String polygonStringActual = polygon.toString();

        ArrayList<Point> pointListPolygon = polygon.getPointList();
        String polygonStringExcepted = "Polygon [ nbOfPoints: " + polygon.getNbOfPoints() + ", pointList: [";
        for (int i=0; i<pointListPolygon.size(); i++){
            polygonStringExcepted += pointListPolygon.get(i).toString() + ", ";
        }
        polygonStringExcepted = polygonStringExcepted.substring(0, polygonStringExcepted.length()-2);
        polygonStringExcepted += "]]";

        Assert.assertEquals(polygonStringExcepted, polygonStringActual);
    }
}
