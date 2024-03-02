import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

import java.util.ArrayList;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class RectangleTest {

    Point p1, p2;
    Integer w, h;
    Pixel px1,px2,px3,px4,px5,px6,px7,px8,px9,px10,px11,px12,px13,px14,px15,px16,px17,px18,px19,px20,px21,px22;
    Rectangle rec1, rec2;

    @Before
    public void init() {
        p1 = new Point(5, 5);
        p2 = new Point(4, 4);
        w = 8;
        h = 4;
        rec1 = new Rectangle(p1, w, h);
        px1 = new Pixel(5, 8);
        px2 = new Pixel(6, 5);
        px3 = new Pixel(7, 5);
        px4 = new Pixel(8, 5);
        px5 = new Pixel(9, 5);
        px6 = new Pixel(10, 5);
        px7 = new Pixel(11, 5);
        px8 = new Pixel(12, 5);
        px9 = new Pixel(12, 6);
        px10 = new Pixel(12, 7);
        px11 = new Pixel(12, 8);
        px12 = new Pixel(6, 8);
        px13 = new Pixel(7, 8);
        px14 = new Pixel(8, 8);
        px15 = new Pixel(9, 8);
        px16 = new Pixel(10, 8);
        px17 = new Pixel(11, 8);
        px18 = new Pixel(5, 5);
        px19 = new Pixel(5, 6);
        px20 = new Pixel(5, 7);
    }

    @Test
    public void testDraw() {
        ArrayList<Pixel> listPixelsActual = rec1.draw();
        ArrayList<Pixel> listPixelsExcepted = new ArrayList<>();
        listPixelsExcepted.add(px2);
        listPixelsExcepted.add(px3);
        listPixelsExcepted.add(px4);
        listPixelsExcepted.add(px5);
        listPixelsExcepted.add(px6);
        listPixelsExcepted.add(px7);
        listPixelsExcepted.add(px8);
        listPixelsExcepted.add(px9);
        listPixelsExcepted.add(px10);
        listPixelsExcepted.add(px11);
        listPixelsExcepted.add(px12);
        listPixelsExcepted.add(px13);
        listPixelsExcepted.add(px14);
        listPixelsExcepted.add(px15);
        listPixelsExcepted.add(px16);
        listPixelsExcepted.add(px17);
        listPixelsExcepted.add(px18);
        listPixelsExcepted.add(px19);
        listPixelsExcepted.add(px20);
        listPixelsExcepted.add(px1);
        
        assertEquals(listPixelsExcepted.size(), listPixelsActual.size());
        assertEquals(listPixelsExcepted, listPixelsActual);
    }

    @Test
    public void testGetHeight() {
        assertEquals(h, rec1.getHeight());
    }

    @Test
    public void testGetPoint() {
        assertEquals(p1, rec1.getPoint());
    }

    @Test
    public void testGetWidth() {
        assertEquals(w, rec1.getWidth());
    }

    @Test
    public void testToString() {
        assertEquals("Rectangle [id: " + rec1.getId() + ", x: " + rec1.getX() + ", y: " + rec1.getY() + ", color: " + rec1.getColor() + ", thickness: " + rec1.getThickness() + ", point: " + rec1.getPoint().toString() + ", width: " + rec1.getWidth() + ", height: " + rec1.getHeight() + "]", rec1.toString());
    }

    @Test
    public void testEquals(){
        //cas meme instance
        Assert.assertTrue(rec1.equals(rec1));

        //cas 2eme objet null
        Assert.assertFalse(rec1.equals(null));

        //cas objets de classes différentes
        Assert.assertFalse(rec1.equals(new String()));

        //cas objets de meme classe et valeur des champs différentes
        Assert.assertFalse(rec1.equals(new Rectangle(p2, w, h)));

        //cas objets de meme classe et valeur des champs identique
        Assert.assertTrue(rec1.equals(new Rectangle(p1, w, h)));
    }
}
