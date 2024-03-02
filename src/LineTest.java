import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class LineTest {

    Point p1,p2,p3,p4;
    Line l1;
    Pixel px1, px2, px3, px4, px5, px6, px7, px8, px9, px10, px11;


    @Before 
    public void init()  {
        p1 = new Point(3, 9);
        p2 = new Point(13, 5);
        p3 = new Point(1, 4);
        p4 = new Point(7, 6);
        l1 = new Line(p1, p2);
        px1 = new Pixel(3,9);
        px2 = new Pixel(4,9);
        px3 = new Pixel(5,10);
        px4 = new Pixel(6,10);
        px5 = new Pixel(7,11);
        px6 = new Pixel(8,11);
        px7 = new Pixel(9,11);
        px8 = new Pixel(10,12);
        px9 = new Pixel(11,12);
        px10 = new Pixel(12,13);
        px11 = new Pixel(13,13);

    }

    @Test
    public void testEquals(){
        //cas meme instance
        Assert.assertTrue(l1.equals(l1));

        //cas 2eme objet null
        Assert.assertFalse(l1.equals(null));

        //cas objets de classes différentes
        Assert.assertFalse(l1.equals(new String()));

        //cas objets de meme classe et valeur des champs différentes
        Assert.assertFalse(l1.equals(new Line(p3, p4)));

        //cas objets de meme classe et valeur des champs identique
        Assert.assertTrue(l1.equals(new Line(p1, p2)));
    }

    @Test
    public void testDraw() {
        List<Pixel> pixelsExcepted = Arrays.asList(px1, px2, px3, px4, px5, px6, px7, px8, px9, px10, px11);
        ArrayList<Pixel> pixelsActual = l1.draw();
        assertEquals(pixelsExcepted, pixelsActual);
    }

    @Test
    public void testGetP1() {
        assertEquals(p1, l1.getP1());

    }

    @Test
    public void testGetP2() {
        assertEquals(p2, l1.getP2());
    }

    @Test
    public void testToString(){
        String l1StringActual = l1.toString();
        String l1StringExcepted = "Line [id: " + l1.getId() + ", x: " + l1.getX() + ", y: " + l1.getY() + ", color: " + l1.getColor() + ", thickness: " + l1.getThickness() + ", p1: " + l1.getP1().toString() + ", p2: " + l1.getP2().toString() + "]";

        Assert.assertEquals(l1StringExcepted, l1StringActual);
    }
}
