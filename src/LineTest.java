import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

public class LineTest {

    Point p1,p2;
    Line l1;
    Pixel px1, px2, px3, px4, px5, px6, px7, px8, px9, px10, px11;


    @Before 
    public void init()  {
        p1 = new Point(3, 9);
        p2 = new Point(13, 5);
        l1 = new Line( p1, p2);
        px1 = new Pixel(3,9);
        px2 = new Pixel(4,9);
        px3 = new Pixel(5,8);
        px4 = new Pixel(6,8);
        px5 = new Pixel(7,7);
        px6 = new Pixel(8,7);
        px7 = new Pixel(9,6);
        px8 = new Pixel(10,6);
        px9 = new Pixel(11,5);
        px10 = new Pixel(12,5);
        px11 = new Pixel(13,5);

    }


    @Test
    public void testDraw() {
        List<Pixel> pixels = Arrays.asList(px1, px2, px3, px4, px5, px6, px7, px8, px9, px10, px11);
        assertArrayEquals(l1.draw().toArray(), pixels.toArray());
    }

    @Test
    public void testGetP1() {
        assertEquals(l1.getP1(),p1);

    }

    @Test
    public void testGetP2() {
        assertEquals(l1.getP2(),p2);
    }
}
