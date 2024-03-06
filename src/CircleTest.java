import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class CircleTest {

    private Circle cercle;
    private Point centre, centre2;
    private int rayon;
    private Pixel p1,p2,p3,p4,p5,p6,p7,p8,p9,p10,p11,p12,p13,p14,p15,p16,p17,p18,p19,p20,p21,p22,p23,p24;

    @Before
    public void init(){
        centre = new Point(4, 4);
        centre2 = new Point(1, 1);
        rayon = 3;
        cercle = new Circle(0, COLOR.BLACK, 1, centre, rayon);
        p1 = new Pixel(4, 7, COLOR.BLACK);
        p2 = new Pixel(7, 4, COLOR.BLACK);
        p3 = new Pixel(4, 7, COLOR.BLACK);
        p4 = new Pixel(1, 4, COLOR.BLACK);
        p5 = new Pixel(4, 1, COLOR.BLACK);
        p6 = new Pixel(7, 4, COLOR.BLACK);
        p7 = new Pixel(4, 1, COLOR.BLACK);
        p8 = new Pixel(1, 4, COLOR.BLACK);
        p9 = new Pixel(5, 7, COLOR.BLACK);
        p10 = new Pixel(7, 5, COLOR.BLACK);
        p11 = new Pixel(3, 7, COLOR.BLACK);
        p12 = new Pixel(1, 5, COLOR.BLACK);
        p13 = new Pixel(5, 1, COLOR.BLACK);
        p24 = new Pixel(7, 3, COLOR.BLACK);
        p14 = new Pixel(3, 1, COLOR.BLACK);
        p15 = new Pixel(1, 3, COLOR.BLACK);
        p16 = new Pixel(6, 6, COLOR.BLACK);
        p17 = new Pixel(6, 6, COLOR.BLACK);
        p18 = new Pixel(2, 6, COLOR.BLACK);
        p19 = new Pixel(2, 6, COLOR.BLACK);
        p20 = new Pixel(6, 2, COLOR.BLACK);
        p21 = new Pixel(6, 2, COLOR.BLACK);
        p22 = new Pixel(2, 2, COLOR.BLACK);
        p23 = new Pixel(2, 2, COLOR.BLACK);
    }

    @Test
    public void testDraw() {
        Pixel[] pixels = {p1,p2,p3,p4,p5,p6,p7,p8,p9,p10,p11,p12,p13,p24,p14,p15,p16,p17,p18,p19,p20,p21,p22,p23};
        assertArrayEquals(pixels, cercle.draw().toArray());
    }

    @Test
    public void testToString() {
        assertEquals(cercle.toString(), "Circle [id: " + cercle.getId() + ", x: " + cercle.getX() + ", y: " + cercle.getY() + ", color: " + cercle.getColor() + ", thickness: " + cercle.getThickness() + ", center: Point [id: " + cercle.getCenter().getId() + ", x: " + cercle.getCenter().getX() + ", y: " + cercle.getCenter().getY() + ", color: " + cercle.getCenter().getColor() + ", thickness: " + cercle.getCenter().getThickness() + ", posX: " + cercle.getCenter().getPosX() + ", posY: " + cercle.getCenter().getPosY() + "], radius: " + cercle.getRadius() + "]");
    }

    @Test
    public void testEquals(){
        //cas meme instance
        Assert.assertTrue(cercle.equals(cercle));

        //cas 2eme objet null
        Assert.assertFalse(cercle.equals(null));

        //cas objets de classes différentes
        Assert.assertFalse(cercle.equals(new String()));

        //cas objets de meme classe et valeur des champs différentes
        Assert.assertFalse(cercle.equals(new Circle(centre2, rayon)));

        //cas objets de meme classe et valeur des champs identique
        Assert.assertTrue(cercle.equals(new Circle(0, COLOR.BLACK, 1,centre, rayon)));
    }

    @Test
    public void testGetCenter(){
        assertEquals(centre, cercle.getCenter());
    }

    @Test
    public void testGetRadius(){
        assertEquals(rayon, cercle.getRadius());
    }
}
