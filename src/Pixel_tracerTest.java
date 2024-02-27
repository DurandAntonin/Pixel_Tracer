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
        assertEquals(0,(int)pixel_tracer.getCurrentArea().getId());
    }

    @Test
    public void testGetCurrentLayer() {
        assertEquals(0,(int)pixel_tracer.getCurrentLayer().getId());
    }

    @Test
    public void testGetCurrentShape() {
        assertEquals(null,(int)pixel_tracer.getCurrentShape().getId());
        Point p1 = new Point(0,0);
        assertEquals((int)p1.getId(),(int)pixel_tracer.getCurrentShape().getId());
    }

    @Test
    public void testGetEmptyChar() {
        assertEquals("#",pixel_tracer.getEmptyChar());
    }

    @Test
    public void testGetFullChar() {
        assertEquals(".",pixel_tracer.getEmptyChar());
    }

    @Test
    public void testGetListArea() {
        ArrayList<Area> al1 = new ArrayList<>();
        Area a1 = new Area(80, 40, 1, "a1");
        Area a2 = new Area(80, 40, 2, "a2");
        Area a3 = new Area(80, 40, 3, "a3");
        al1.add(a1);
        al1.add(a2);
        al1.add(a3);
        assertEquals(al1, pixel_tracer.getListArea());
    }
}
