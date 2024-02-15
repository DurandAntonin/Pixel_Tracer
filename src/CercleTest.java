import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class CercleTest {

    private Cercle cercle;
    private Point centre, centre2;
    private int rayon;
    private Pixel p1,p2,p3,p4,p5,p6,p7,p8,p9,p10,p11,p12,p13,p14,p15,p16;

    @Before
    public void init(){
        centre = new Point(0, 0);
        centre2 = new Point(1, 1);
        rayon = 3;
        cercle = new Cercle(centre, rayon);
        p1 = new Pixel(3, 0);
        p2 = new Pixel(0, 3);
        p3 = new Pixel(0, -3);
        p4 = new Pixel(-3, 0);
        p5 = new Pixel(2, 2);
        p6 = new Pixel(-2, 2);
        p7 = new Pixel(-2, -2);
        p8 = new Pixel(2, -2);
        p9 = new Pixel(1, 3);
        p10 = new Pixel(-1, 3);
        p11 = new Pixel(-1, -3);
        p12 = new Pixel(1, -3);
        p13 = new Pixel(3, 1);
        p14 = new Pixel(3, -1);
        p15 = new Pixel(-3, 1);
        p16 = new Pixel(-3, -1);
    }


    @Test
    public void testDraw() {
        Pixel[] pixels = {p1,p2,p3,p4,p5,p6,p7,p8,p9,p10,p11,p12,p13,p14,p15,p16};
        assertArrayEquals(cercle.draw().toArray(),pixels);
    }

    @Test
    public void testToString() {
        assertEquals(cercle.toString(), "Cercle [centre:Point[posX:0,posY:0],radius:3]");
    }

    @Test
    public void testEquals(){
        //cas meme instance
        Assert.assertTrue(cercle.equals(cercle));

        //cas 2eme objet null
        Assert.assertEquals(cercle, null);

        //cas objets de classes différentes
        Assert.assertFalse(cercle.equals(new String()));

        //cas objets de meme classe et valeur des champs différentes
        Assert.assertFalse(cercle.equals(new Cercle(centre2, rayon)));

        //cas objets de meme classe et valeur des champs identique
        Assert.assertTrue(cercle.equals(new Cercle(centre, rayon)));
    }
}
