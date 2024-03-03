import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

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
    public void testDestroyApp() {
        
    }

    @Test
    public void testEraseArea() {

    }

    @Test
    public void testDrawCurrentArea() {

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
        assertEquals(null,pixel_tracer.getCurrentShape());
        Point p1 = new Point(0,0);
        pixel_tracer.addShapeToCurrentLayer(p1);
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

        pixel_tracer.createArea(1, "a1");
        pixel_tracer.createArea(2, "a2");
        pixel_tracer.createArea(3, "a3");
        assertEquals(al1, pixel_tracer.getListArea());
    }

    @Test
    public void testAddNewLayer(){
        pixel_tracer.createLayerInCurrentArea(1, "Layer 1");
        assertEquals(2, pixel_tracer.getCurrentArea().getNumberOfLayers());
        assertEquals(1, pixel_tracer.getCurrentLayer().getId());
    }

    @Test
    public void testAddShapeToCurrentLayer(){
        Point point = new Point(0, 0);
        pixel_tracer.addShapeToCurrentLayer(point);
        assertEquals(point, pixel_tracer.getCurrentShape());
    }

    @Test
    public void testSelectArea(){
        //cas area existe
        assertTrue(pixel_tracer.selectArea(0));
        assertEquals(0, pixel_tracer.getCurrentArea().getId());

        //cas area n'existe pas
        assertFalse(pixel_tracer.selectArea(1));
        assertEquals(0, pixel_tracer.getCurrentArea().getId());
    }

    @Test
    public void testSelectLayer(){
        //cas layer existe
        assertTrue(pixel_tracer.selectLayer(0));
        assertEquals(0, pixel_tracer.getCurrentLayer().getId());

        //cas layer n'existe pas
        assertFalse(pixel_tracer.selectLayer(1));
        assertEquals(0, pixel_tracer.getCurrentLayer().getId());
    }

    @Test
    public void testDeleteArea(){
        //cas area existe
        assertTrue(pixel_tracer.deleteArea(0));
        assertEquals(null, pixel_tracer.getCurrentArea());

        //cas area n'existe pas
        assertFalse(pixel_tracer.selectArea(0));
        assertEquals(null, pixel_tracer.getCurrentArea());

        //cas n areas 
        pixel_tracer.createArea(1, "area 0");
        pixel_tracer.createArea(2, "area 1");
        assertTrue(pixel_tracer.deleteArea(1));
        assertEquals(2, pixel_tracer.getCurrentArea().getId());
    }

    @Test
    public void testDeleteLayerInCurrentArea(){
        //cas layer n'existe pas
        assertFalse(pixel_tracer.deleteLayerInCurrentArea(1));
        assertEquals(0, pixel_tracer.getCurrentLayer().getId());

        //cas layer existe
        assertTrue(pixel_tracer.deleteLayerInCurrentArea(0));
        assertEquals(null, pixel_tracer.getCurrentLayer());

        //cas n areas 
        pixel_tracer.createLayerInCurrentArea(1, "Layer 1");
        pixel_tracer.createLayerInCurrentArea(2, "Layer 2");
        assertTrue(pixel_tracer.deleteLayerInCurrentArea(1));
        assertEquals(2, pixel_tracer.getCurrentLayer().getId());
    }

    public void testDeleteShapeInCurrentLayer(){
        Point point = new Point(0, 0);
        pixel_tracer.addShapeToCurrentLayer(point);

        //cas shape n'existe pas
        assertFalse(pixel_tracer.deleteShapeInCurrentLayer(1));
        assertEquals(0, pixel_tracer.getCurrentShape());

        //cas shape existe
        assertTrue(pixel_tracer.deleteShapeInCurrentLayer(0));
        assertEquals(null, pixel_tracer.getCurrentShape());

        //cas n shapes 
        Point point1 = new Point(0, 0);
        Point point2 = new Point(0, 0);
        pixel_tracer.addShapeToCurrentLayer(point1);
        pixel_tracer.addShapeToCurrentLayer(point2);
        assertTrue(pixel_tracer.deleteShapeInCurrentLayer(1));
        assertEquals(1, (int)pixel_tracer.getCurrentShape().getId());
    }

    public void testChangeLayerVisibilityInCurrentArea(){
        //TODO
    }
}
