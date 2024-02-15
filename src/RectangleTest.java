import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class RectangleTest {

    Point p1;
    Integer w, h;
    Pixel px1,px2,px3,px4,px5,px6,px7,px8,px9,px10,px11,px12,px13,px14,px15,px16,px17,px18,px19,px20;
    Rectangle rec1;

    @Before
    public void init() {
        p1 = new Point(5, 5);
        w = 4;
        h = 8;
        rec1 = new Rectangle(p1, w, h);
        px1 = new Pixel(5, 5);
        px2 = new Pixel(5, 6);
        px3 = new Pixel(5, 7);
        px4 = new Pixel(5, 8);
        px5 = new Pixel(5, 9);
        px6 = new Pixel(5, 10);
        px7 = new Pixel(5, 11);
        px8 = new Pixel(5, 12);
        px9 = new Pixel(6, 12);
        px10 = new Pixel(7, 12);
        px11 = new Pixel(8, 12);
        px12 = new Pixel(8, 11);
        px13 = new Pixel(8, 10);
        px14 = new Pixel(8, 9);
        px15 = new Pixel(8, 8);
        px16 = new Pixel(8, 7);
        px17 = new Pixel(8, 6);
        px18 = new Pixel(8, 5);
        px19 = new Pixel(7, 5);
        px20 = new Pixel(6, 5);
    }
    @Test
    public void testDraw() {
        Pixel[] pixels = {px1,px2,px3,px4,px5,px6,px7,px8,px9,px10,px11,px12,px13,px14,px15,px16,px17,px18,px19,px20};
        assertArrayEquals(rec1.draw().toArray(), pixels);
    }

    @Test
    public void testGetHeight() {
        assertEquals(rec1.getHeight(), h);
    }

    @Test
    public void testGetPoint() {
        assertEquals(rec1.getPoint(), p1);
    }

    @Test
    public void testGetWidth() {
        assertEquals(rec1.getWidth(), w);
    }

    @Test
    public void testToString() {
        assertEquals(rec1.toString(), "Rectangle [point: " + rec1.getPoint().toString() + ", width: " + rec1.getWidth() + ", height: " + rec1.getHeight() + "]");
    }
}
