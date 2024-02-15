import java.util.ArrayList;

import org.junit.Test;
import org.junit.Before;
import org.junit.After;
import org.junit.Assert;

public class PointTest {

    private Point point;
    private final Integer x = 5;
    private final Integer y = 10;

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
        ArrayList<Pixel> drawnPointReal = point.draw();
        ArrayList<Pixel> drawnPointExpected = new ArrayList<>();
        drawnPointExpected.add(new Pixel(x, y));

        Assert.assertEquals(drawnPointExpected.size(), drawnPointExpected.size());
        
        for (int i=0;i<drawnPointExpected.size();i++) {
            Assert.assertTrue(drawnPointExpected.get(i).equals(drawnPointReal.get(i)));
        }
    }

    @Test
    public void testGetPosX() {
        Assert.assertEquals("Test méthode getPosX", this.x, point.getPosX());
    }

    @Test
    public void testGetPosY() {
        Assert.assertEquals("Test méthode getPosY", this.y, point.getPosY());
    }

    @Test
    public void testToString() {
        String stringPointReal = point.toString();
        String stringPointExpected = "Point [posX: " + point.getPosX() + ", posY: " + point.getPosY() + "]";
        Assert.assertEquals("Test méthode toString", stringPointExpected, stringPointReal);
    }

    @Test
    public void testEquals(){
        //cas meme instance
        Assert.assertTrue(point.equals(point));

        //cas 2eme objet null
        Assert.assertEquals(point, null);

        //cas objets de classes différentes
        Assert.assertFalse(point.equals(new String()));

        //cas objets de meme classe et valeur des champs différentes
        Assert.assertFalse(point.equals(new Point(y, x)));

        //cas objets de meme classe et valeur des champs identique
        Assert.assertTrue(point.equals(new Point(x, y)));
    }
}
