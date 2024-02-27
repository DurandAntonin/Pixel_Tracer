import static org.junit.Assert.assertEquals;

import java.util.ArrayList;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class Pixel_tracerTest {

    private Pixel_tracer pixel_tracer;

    @Before
    public void beforeTest() {
        pixel_tracer = new Pixel_tracer();
    }

    @After 
    public void afterTest() {
        pixel_tracer = null;
    }


    @Test
    public void testClearArea() {
        
    }

    @Test
    public void testDeleteArea() {

    }

    @Test
    public void testDestroyApp() {
        
    }

    @Test
    public void testEraseArea() {

    }

    @Test
    public void testGetCurrentArea() {
        assertEquals(0,pixel_tracer.getCurrentArea().getId());
    }

    @Test
    public void testGetCurrentLayer() {
        assertEquals(0,pixel_tracer.getCurrentLayer().getId());
    }

    @Test
    public void testGetCurrentShape() {
        assertEquals(null,pixel_tracer.getCurrentShape().getId());
        Point p1 = new Point(0,0);
        assertEquals(p1.getId(),pixel_tracer.getCurrentShape().getId());
    }

    @Test
    public void testGetEmptyChar() {
        assertEquals(".",pixel_tracer.getEmptyChar());
    }

    @Test
    public void testGetFullChar() {
        assertEquals("#",pixel_tracer.getFullChar());
    }

    @Test
    public void testGetListArea() {
        ArrayList<Area> al1 = new ArrayList<>();
        Area a0 = new Area(0, 80, 40, "Default Area");
        Area a1 = new Area(1, 80, 40, "a1");
        Area a2 = new Area(2, 80, 40, "a2");
        Area a3 = new Area(3, 80, 40, "a3");

        al1.add(a0);
        al1.add(a1);
        al1.add(a2);
        al1.add(a3);

        pixel_tracer.createArea("a1");
        pixel_tracer.createArea("a2");
        pixel_tracer.createArea("a3");

        assertEquals(al1, pixel_tracer.getListArea());
    }
}
