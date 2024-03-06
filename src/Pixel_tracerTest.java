import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class Pixel_tracerTest {

    private Pixel_tracer pixel_tracer;
    int height = 10;
    int width = 10;

    @Before
    public void beforeTest() {
        pixel_tracer = new Pixel_tracer(width, height);
    }

    @After 
    public void afterTest() {
        pixel_tracer = null;
    }


    @Test
    public void testClearArea() {
        String[][] area;
        COLOR[][] areaColor;

        pixel_tracer.addShapeToCurrentLayer(new Point(0, COLOR.BLACK, 1, 9, 9));
        pixel_tracer.drawCurrentArea();
        
        area = new String[height][width];
        areaColor = new COLOR[height][width];

        if (height != 0 && width != 0){
            for (int i=0; i<height; i++){
                for (int j=0; j<width; j++){
                    area[i][j] = ".";
                    areaColor[i][j] = COLOR.WHITE;
                }
            }
        }
        pixel_tracer.getCurrentArea().clearArea();
        assertArrayEquals(area,pixel_tracer.getCurrentArea().getArea());
        assertArrayEquals(areaColor,pixel_tracer.getCurrentArea().getAreaColors());
    }

    @Test
    public void testDestroyApp() {
        pixel_tracer.destroyApp();
        assertEquals(0, pixel_tracer.getListArea().size());
        assertEquals(null, pixel_tracer.getCurrentArea());
        assertEquals(null, pixel_tracer.getCurrentLayer());
        assertEquals(null, pixel_tracer.getFullChar());
        assertEquals(null, pixel_tracer.getEmptyChar());
    }

    @Test
    public void testEraseArea() {
        pixel_tracer.eraseArea();
        ArrayList<Layer> layerList = pixel_tracer.getCurrentArea().getAllLayers();

        for (int i=0; i<layerList.size(); i++){
            assertEquals(0, layerList.get(i).getListShapes().size());
        }
    }

    @Test
    public void testDrawCurrentArea() {
        Layer layer0 = pixel_tracer.getCurrentLayer();
        Layer layer1 = new Layer(1, "Layer 1");
        Layer layer2 = new Layer(2, "Layer 2");

        layer0.addShapeToLayer(new Point(0, COLOR.BLUE, 1, 0, 0));
        layer0.addShapeToLayer(new Rectangle(0, COLOR.BLUE, 1, new Point(5, 0), 3, 3));
        layer0.addShapeToLayer(new Circle(0, COLOR.BLUE, 1, new Point(9, 9), 3));
        layer1.addShapeToLayer(new Point(-1, -1));
        layer1.addShapeToLayer(new Circle(0, COLOR.BLUE, 1, new Point(0, 0),3));
        layer0.addShapeToLayer(new Point(0, COLOR.BLUE, 1, 0, 8));

        ArrayList<Point> listPointsP1 = new ArrayList<>();
        listPointsP1.add(new Point(0, 9));
        listPointsP1.add(new Point(1, 9));
        layer0.addShapeToLayer(new Polygon(0, COLOR.BLUE, 1, listPointsP1));

        ArrayList<Point> listPointsInPolygon = new ArrayList<>();
        listPointsInPolygon.add(new Point(6, 1));
        listPointsInPolygon.add(new Point(7, 1));
        listPointsInPolygon.add(new Point(7, 2));
        layer2.addShapeToLayer(new Polygon(0, COLOR.BLUE, 1, listPointsInPolygon));
        layer2.setLayerVisibility(false);

        pixel_tracer.getCurrentArea().addLayer(layer1);
        pixel_tracer.getCurrentArea().addLayer(layer2);
        pixel_tracer.drawCurrentArea();

        String[][] areaActual = pixel_tracer.getCurrentArea().getArea();
        String[][] areaExcepted = {
            {"#", ".", ".", "#", ".", "#", "#", "#", ".", "."},
            {".", ".", ".", "#", ".", "#", ".", "#", ".", "."},
            {".", ".", "#", ".", ".", "#", "#", "#", ".", "."},
            {"#", "#", ".", ".", ".", ".", ".", ".", ".", "."},
            {".", ".", ".", ".", ".", ".", ".", ".", ".", "."},
            {".", ".", ".", ".", ".", ".", ".", ".", ".", "."},
            {".", ".", ".", ".", ".", ".", ".", ".", "#", "#"},
            {".", ".", ".", ".", ".", ".", ".", "#", ".", "."},
            {"#", ".", ".", ".", ".", ".", "#", ".", ".", "."},
            {"#", "#", ".", ".", ".", ".", "#", ".", ".", "."}
        };

        assertArrayEquals(areaExcepted, areaActual);
        COLOR[][] areaColorActual = pixel_tracer.getCurrentArea().getAreaColors();
        COLOR[][] areaColorExpected = {
            {COLOR.BLUE, COLOR.WHITE, COLOR.WHITE, COLOR.BLUE, COLOR.WHITE, COLOR.BLUE, COLOR.BLUE, COLOR.BLUE, COLOR.WHITE, COLOR.WHITE},
            {COLOR.WHITE, COLOR.WHITE, COLOR.WHITE, COLOR.BLUE, COLOR.WHITE, COLOR.BLUE, COLOR.WHITE, COLOR.BLUE, COLOR.WHITE, COLOR.WHITE},
            {COLOR.WHITE, COLOR.WHITE, COLOR.BLUE, COLOR.WHITE, COLOR.WHITE, COLOR.BLUE, COLOR.BLUE, COLOR.BLUE, COLOR.WHITE, COLOR.WHITE},
            {COLOR.BLUE, COLOR.BLUE, COLOR.WHITE, COLOR.WHITE, COLOR.WHITE, COLOR.WHITE, COLOR.WHITE, COLOR.WHITE, COLOR.WHITE, COLOR.WHITE},
            {COLOR.WHITE, COLOR.WHITE, COLOR.WHITE, COLOR.WHITE, COLOR.WHITE, COLOR.WHITE, COLOR.WHITE, COLOR.WHITE, COLOR.WHITE, COLOR.WHITE},
            {COLOR.WHITE, COLOR.WHITE, COLOR.WHITE, COLOR.WHITE, COLOR.WHITE, COLOR.WHITE, COLOR.WHITE, COLOR.WHITE, COLOR.WHITE, COLOR.WHITE},
            {COLOR.WHITE, COLOR.WHITE, COLOR.WHITE, COLOR.WHITE, COLOR.WHITE, COLOR.WHITE, COLOR.WHITE, COLOR.WHITE, COLOR.BLUE, COLOR.BLUE},
            {COLOR.WHITE, COLOR.WHITE, COLOR.WHITE, COLOR.WHITE, COLOR.WHITE, COLOR.WHITE, COLOR.WHITE, COLOR.BLUE, COLOR.WHITE, COLOR.WHITE},
            {COLOR.BLUE, COLOR.WHITE, COLOR.WHITE, COLOR.WHITE, COLOR.WHITE, COLOR.WHITE, COLOR.BLUE, COLOR.WHITE, COLOR.WHITE, COLOR.WHITE},
            {COLOR.BLUE, COLOR.BLUE, COLOR.WHITE, COLOR.WHITE, COLOR.WHITE, COLOR.WHITE, COLOR.BLUE, COLOR.WHITE, COLOR.WHITE, COLOR.WHITE}
        };

        assertArrayEquals(areaColorExpected, areaColorActual);
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
        pixel_tracer = new Pixel_tracer(50, 20);
        ArrayList<Area> al1 = new ArrayList<>();
        Area a0 = new Area(0, 50, 20, "Default Area");
        Area a1 = new Area(1, 50, 20, "a1");
        Area a2 = new Area(2, 50, 20, "a2");
        Area a3 = new Area(3, 50, 20, "a3");

        al1.add(a0);
        al1.add(a1);
        al1.add(a2);
        al1.add(a3);

        pixel_tracer.createArea(1, "a1", 50, 20);
        pixel_tracer.createArea(2, "a2", 50, 20);
        pixel_tracer.createArea(3, "a3", 50, 20);
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
        pixel_tracer.createArea(1, "area 0", 50, 20);
        pixel_tracer.createArea(2, "area 1", 50, 20);
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
