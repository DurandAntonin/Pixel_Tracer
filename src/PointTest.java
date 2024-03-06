import static org.junit.Assert.assertEquals;

import java.util.ArrayList;

import org.junit.Test;
import org.junit.Before;
import org.junit.After;
import org.junit.Assert;

public class PointTest {

    private Point point;
    private final int x = 5;
    private final int y = 10;

    @Before
    public void beforeTest(){
        point = new Point(x, y);
    }

    @After
    public void afterTest(){
        point = null;
    }

    @Test
    public void testDraw() {
        ArrayList<Pixel> drawnPointActual = point.draw();
        ArrayList<Pixel> drawnPointExpected = new ArrayList<>();
        drawnPointExpected.add(new Pixel(x, y));

        Assert.assertEquals(drawnPointExpected.size(), drawnPointExpected.size());
        
        assertEquals(drawnPointActual, drawnPointExpected);
    }

    @Test
    public void testGetPosX() {
        assertEquals(this.x, point.getPosX());
    }

    @Test
    public void testGetPosY() {
        assertEquals(this.y, point.getPosY());
    }

    @Test
    public void testToString() {
        String stringPointReal = point.toString();
        String stringPointExpected = "Point [id: " + point.getId() + ", x: " + point.getX() + ", y: " + point.getY() + ", color: " + point.getColor() + ", thickness: " + point.getThickness() + ", posX: " + point.getPosX() + ", posY: " + point.getPosY() + "]";
        Assert.assertEquals("Test méthode toString", stringPointExpected, stringPointReal);
    }

    @Test
    public void testEquals(){
        //cas meme instance
        Assert.assertTrue(point.equals(point));

        //cas 2eme objet null
        Assert.assertFalse(point.equals(null));

        //cas objets de classes différentes
        Assert.assertFalse(point.equals(new String()));

        //cas objets de meme classe et valeur des champs différentes
        Assert.assertFalse(point.equals(new Point(y, x)));

        //cas objets de meme classe et valeur des champs identique
        Assert.assertTrue(point.equals(new Point(x, y)));
    }
}
