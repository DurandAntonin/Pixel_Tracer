import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class PixelTest {

    private Pixel pixel;

    @Before
    public void beforeTest() {
        pixel = new Pixel(1, 1, COLOR.BLACK);
    }

    @After 
    public void afterTest() {
        pixel = null;
    }

    @Test
    public void testGetColor() {
        assertEquals(pixel.getColor(), COLOR.BLACK);
    }

    @Test
    public void testGetX() {
        assertEquals(pixel.getX(), 1);
    }

    @Test
    public void testGetY() {
        assertEquals(pixel.getY(), 1);
    }

    @Test
    public void testToString() {
        assertEquals(pixel.toString(),"Pixel:\nX:1\nY:1\nColor:BLACK");
    }
}
