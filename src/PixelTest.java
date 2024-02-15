import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class PixelTest {

    private Pixel pixel;
    private final Integer x = 1;
    private final Integer y = 1;
    private final COLOR color = COLOR.BLACK;

    @Before
    public void beforeTest() {
        pixel = new Pixel(x, y, color);
    }

    @After 
    public void afterTest() {
        pixel = null;
    }

    @Test
    public void testGetColor() {
        assertEquals(pixel.getColor(), color);
    }

    @Test
    public void testGetX() {
        assertEquals(pixel.getX(), x);
    }

    @Test
    public void testGetY() {
        assertEquals(pixel.getY(), y);
    }

    @Test
    public void testToString() {
        assertEquals(pixel.toString(),"Pixel [x: "+pixel.getX()+", y: "+pixel.getY()+", color: "+pixel.getColor()+"]");
    }
}
