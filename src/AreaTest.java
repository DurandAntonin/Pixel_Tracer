import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

import java.util.ArrayList;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class AreaTest {

    private final int width = 10;
    private final int height = 10;
    private final int id = 0;
    private final String name = "area test";
    private Area area;

    @Before
    public void beforeTest(){
        area = new Area(width, height, id, name);
    }


    @After
    public void afterTest(){
        area = null;
    }

    @Test
    public void testGetNumberOfLayers() {
        Layer layerToAdd0 = new Layer(0, "layer 0");
        Layer layerToAdd1 = new Layer(1, "layer 1");
        area.addLayer(layerToAdd0);
        area.addLayer(layerToAdd1);

        Integer nbOfLayers = area.getNumberOfLayers();
        
        assertEquals((Integer)2, nbOfLayers);
    }

    @Test
    public void testAddLayer() {
        Layer layerToAdd = new Layer(0, "layer 0");
        area.addLayer(layerToAdd);

        Integer nbOfLayers = area.getNumberOfLayers();
        
        assertEquals((Integer)1, nbOfLayers);
    }

    @Test
    public void testDeleteLayer() {
        Layer layerToAdd = new Layer(0, "layer 0");
        area.addLayer(layerToAdd);

        area.deleteLayer(layerToAdd);
        Integer nbOfLayers = area.getNumberOfLayers();
        
        assertEquals((Integer)0, nbOfLayers);
    }

    @Test
    public void testDeleteLayersList() {
        Layer layerToAdd0 = new Layer(0, "layer 0");
        Layer layerToAdd1 = new Layer(1, "layer 1");
        area.addLayer(layerToAdd0);
        area.addLayer(layerToAdd1);

        area.deleteLayersList();
        Integer nbOfLayers = area.getNumberOfLayers();
        
        assertEquals((Integer)0, nbOfLayers);
    }

    @Test
    public void testGetAllLayers() {
        Layer layerToAdd0 = new Layer(0, "layer 0");
        Layer layerToAdd1 = new Layer(1, "layer 1");
        area.addLayer(layerToAdd0);
        area.addLayer(layerToAdd1);

        ArrayList<Layer> listLayers = area.getAllLayers();
        
        assertEquals(2, listLayers.size());
    }

    @Test
    public void testDrawArea() {
        Layer layer0 = new Layer(0, "Layer 0");
        Layer layer1 = new Layer(1, "Layer 1");
        Layer layer2 = new Layer(2, "Layer 2");
        ArrayList<Point> listPointsInPolygon = new ArrayList<>();
        listPointsInPolygon.add(new Point(6, 1));
        listPointsInPolygon.add(new Point(7, 1));
        listPointsInPolygon.add(new Point(7, 2));

        layer0.addShapeToLayer(new Point(5, 5));
        layer0.addShapeToLayer(new Rectangle(new Point(5, 0), 3, 3));
        layer0.addShapeToLayer(new Circle(new Point(0, 0), 3));
        layer1.addShapeToLayer(new Line(new Point(6, 6), new Point(6, 10)));
        layer1.addShapeToLayer(new Point(-1, -1));
        layer1.addShapeToLayer(new Polygon(3, null));
        layer2.addShapeToLayer(new Circle(new Point(5, 5), 10));
        layer2.setLayerUnvisible();

        String[][] areaActual = area.getArea();
        String[][] areaExcepted = {
            {".", ".", ".", "#", ".", "#", "#", "#", ".", "."},
            {".", ".", ".", "#", ".", "#", ".", "#", ".", "."},
            {".", ".", "#", ".", ".", "#", "#", "#", ".", "."},
            {"#", "#", ".", ".", ".", ".", ".", ".", ".", "."},
            {".", ".", ".", ".", ".", ".", ".", ".", ".", "."},
            {".", ".", ".", ".", "#", ".", ".", ".", ".", "."},
            {".", "#", ".", ".", ".", "#", "#", "#", "#", "#"},
            {".", "#", "#", ".", ".", ".", ".", ".", ".", "."},
            {".", ".", ".", ".", ".", ".", ".", ".", ".", "."},
            {".", ".", ".", ".", ".", ".", ".", ".", ".", "."}
        };

        assertArrayEquals(areaExcepted, areaActual);
    }

    @Test
    public void testToString(){
        String areaStringActual = area.toString();

        ArrayList<Layer> listLayers = area.getAllLayers();
        String areaStringExcepted = "Area [id: " + area.getId() + ", name: " + area.getName() + ", area : , listLayers: [";
        for (Layer layer : listLayers) {
            areaStringExcepted += layer.toString() + ", ";
        }
        areaStringExcepted = areaStringExcepted.substring(0, areaStringExcepted.length()-2);
        areaStringExcepted += "], emptyChar: " + area.getEmptyChar() + ", fullChar: " + area.getFullChar() + "]";

        assertEquals(areaStringExcepted, areaStringActual);
    }

    @Test
    public void testEquals(){
        //cas meme instance
        Assert.assertTrue(area.equals(area));

        //cas 2eme objet null
        Assert.assertFalse(area.equals(null));

        //cas objets de classes différentes
        Assert.assertFalse(area.equals(new String()));

        //cas objets de meme classe et valeur des champs différentes
        Assert.assertFalse(area.equals(new Area(width, height, 2, name)));

        //cas objets de meme classe et valeur des champs identique
        Assert.assertTrue(area.equals(new Area(width, height, id, name)));
    }

    @Test
    public void testgetId() {
        assertEquals((Integer)id, area.getId());
    }

    @Test
    public void testGetName() {
        assertEquals(name, area.getName());
    }

    @Test
    public void testGetArea(){
        String[][] areaActual = area.getArea();
        String[][] areaExcepted = new String[width][height];
        for (int i=0;i<height;i++){
            for (int j=0;j<width;j++){
                areaExcepted[i][j] = ".";
            }
        }
        assertArrayEquals(areaExcepted, areaActual);
    }

    @Test
    public void testGetEmptyChar() {
        assertEquals(".", area.getEmptyChar());
    }

    @Test
    public void testGetFullChar() {
        assertEquals("#", area.getFullChar());
    }
}
