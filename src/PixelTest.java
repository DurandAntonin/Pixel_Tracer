import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Assert;
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
        assertEquals(color,pixel.getColor());
    }

    @Test
    public void testGetX() {
        assertEquals(x,pixel.getX());
    }

    @Test
    public void testGetY() {
        assertEquals(y,pixel.getY());
    }

    @Test
    public void testToString() {
        assertEquals("Pixel [x: "+pixel.getX()+", y: "+pixel.getY()+", color: "+pixel.getColor()+"]",pixel.toString());
    }

    @Test
    public void testEquals(){
        //cas meme instance
        Assert.assertTrue(pixel.equals(pixel));

        //cas 2eme objet null
        Assert.assertFalse(pixel.equals(null));

        //cas objets de classes différentes
        Assert.assertFalse(pixel.equals(new String()));

        //cas objets de meme classe et valeur des champs différentes
        Assert.assertFalse(pixel.equals(new Pixel(y+1, x, color)));

        //cas objets de meme classe et valeur des champs identique
        Assert.assertTrue(pixel.equals(new Pixel(x, y, color)));
    }
}
