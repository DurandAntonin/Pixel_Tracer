import static org.junit.Assert.assertArrayEquals;

import org.junit.Before;
import org.junit.Test;

public class SquareTest {

    Point p1;
    Integer len;
    Pixel px1,px2,px3,px4,px5,px6,px7,px8,px9,px10,px11,px12;
    Square sq1;

    @Before
    public void init() {
        p1 = new Point(5, 5);
        len = 4;
        sq1 = new Square(p1, len);
        px1 = new Pixel(5, 5);
        px2 = new Pixel(5, 6);
        px3 = new Pixel(5, 7);
        px4 = new Pixel(5, 8);
        px5 = new Pixel(6, 8);
        px6 = new Pixel(7, 8);
        px7 = new Pixel(8, 8);
        px8 = new Pixel(8, 7);
        px9 = new Pixel(8, 6);
        px10 = new Pixel(8, 5);
        px11 = new Pixel(7, 5);
        px12 = new Pixel(6, 5);
    }

    @Test
    public void testDraw() {
        Pixel[] pixels = {px1,px2,px3,px4,px5,px6,px7,px8,px9,px10,px11,px12};
        assertArrayEquals(sq1.draw().toArray(), pixels);
    }

}
