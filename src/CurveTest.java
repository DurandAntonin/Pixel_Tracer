import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class CurveTest {

    private Curve curve;
    private Point c1,c2,c3,c4;
    private Pixel p1,p2,p3,p4,p5,p6,p7,p8,p9,p10;


    @Before
    public void init(){
        c1 = new Point(0, 1);
        c2 = new Point(1, 3);
        c3 = new Point(2, 0);
        c4 = new Point(3, 2);
        curve = new Curve(c1, c2, c3, c4);

        p1 = new Pixel(0, 1);
        p2 = new Pixel(0, 1);
        p3 = new Pixel(1, 2);
        p4 = new Pixel(1, 2);
        p5 = new Pixel(1, 2);
        p6 = new Pixel(2, 1);
        p7 = new Pixel(2, 1);
        p8 = new Pixel(2, 1);
        p9 = new Pixel(3, 2);
        p10 = new Pixel(3, 2);
    }

    @Test
    public void testDraw() {
        Pixel[] pixels = {p1,p2,p3,p4,p5,p6,p7,p8,p9,p10};
        assertArrayEquals(pixels, curve.draw().toArray());

    }

    @Test
    public void testGetP1() {
        assertEquals(c1, curve.getP1());
    }

    @Test
    public void testGetP2() {
        assertEquals(c2, curve.getP2());
    }

    @Test
    public void testGetP3() {
        assertEquals(c3, curve.getP3());
    }   

    @Test
    public void testGetP4() {
        assertEquals(c4, curve.getP4());
    }

    @Test
    public void testToString() {
        assertEquals("Curve [id: " + curve.getId() + ", x: " + curve.getX() + ", y: " + curve.getY() + ", color: " + curve.getColor() + ", thickness: " + curve.getThickness() + ", p1: " + c1.toString() + ", p2: " + c2.toString()+ ", p3: " + c3.toString()+ ", p4: " + c4.toString()+"]", curve.toString());
    }
}
