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
        area = new Area(id, width, height, name);
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

        int nbOfLayers = area.getNumberOfLayers();
        
        assertEquals(3, nbOfLayers);
    }

    @Test
    public void testAddLayer() {
        Layer layerToAdd = new Layer(0, "layer 0");
        area.addLayer(layerToAdd);

        int nbOfLayers = area.getNumberOfLayers();
        
        assertEquals(2, nbOfLayers);
    }

    @Test
    public void testRemoveLayerFromArea() {
        Layer layerToAdd = new Layer(0, "layer 0");
        area.addLayer(layerToAdd);

        area.removeLayerFromArea(0);
        int nbOfLayers = area.getNumberOfLayers();
        
        assertEquals(1, nbOfLayers);
    }

    @Test
    public void testDeleteLayersList() {
        Layer layerToAdd0 = new Layer(0, "layer 0");
        Layer layerToAdd1 = new Layer(1, "layer 1");
        area.addLayer(layerToAdd0);
        area.addLayer(layerToAdd1);

        area.deleteLayersList();
        int nbOfLayers = area.getNumberOfLayers();
        
        assertEquals(0, nbOfLayers);
    }

    @Test
    public void testSetLayerVisibility(){
        ArrayList<Layer> layers = area.getAllLayers();
        Layer layer0 = layers.get(0);

        area.setLayerVisibility(0, false);
        assertEquals(false, layer0.getVisible());

        area.setLayerVisibility(0, true);
        assertEquals(true, layer0.getVisible());
        
        
    }

    @Test
    public void testGetAllLayers() {
        Layer layerToAdd0 = new Layer(0, "layer 0");
        Layer layerToAdd1 = new Layer(1, "layer 1");
        area.addLayer(layerToAdd0);
        area.addLayer(layerToAdd1);

        ArrayList<Layer> listLayers = area.getAllLayers();
        
        assertEquals(3, listLayers.size());
    }

    @Test
    public void testChangeLayerPosition(){
        Layer layer0 = area.getAllLayers().get(0);
        Layer layer1 = new Layer(1, "layer 1");
        area.addLayer(layer1);
        ArrayList<Layer> listLayers = area.getAllLayers();

        assertEquals(layer1, listLayers.get(1));
        assertEquals(layer0, listLayers.get(0));

        area.changeLayerPosition(1, 0);
        listLayers = area.getAllLayers();
        assertEquals(layer1, listLayers.get(0));
        assertEquals(layer0, listLayers.get(1));
    }

    @Test
    public void testDrawArea() {
        ArrayList<Layer> layers = area.getAllLayers();
        Layer layer0 = layers.get(0);
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

        area.addLayer(layer1);
        area.addLayer(layer2);
        area.drawAllShapeFromLayer();

        String[][] areaActual = area.getArea();
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
        COLOR[][] areaColorActual = area.getAreaColors();
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
        Assert.assertFalse(area.equals(new Area(id, height, width, "test")));

        //cas objets de meme classe et valeur des champs identique
        Assert.assertTrue(area.equals(new Area(id, width, height, name)));
    }

    @Test
    public void testGetId() {
        assertEquals(id, area.getId());
    }

    @Test
    public void testGetName() {
        assertEquals(name, area.getName());
    }

    @Test
    public void testGetArea(){
        String[][] areaActual = area.getArea();
        String[][] areaExcepted = new String[height][width];
        for (int i=0;i<height;i++){
            for (int j=0;j<width;j++){
                areaExcepted[i][j] = ".";
            }
        }
        assertArrayEquals(areaExcepted, areaActual);
    }

    @Test
    public void testGetAreaColor(){
        COLOR[][] areaColorActual = area.getAreaColors();
        COLOR[][] areaColorExcepted = new COLOR[height][width];
        for (int i=0;i<height;i++){
            for (int j=0;j<width;j++){
                areaColorExcepted[i][j] = COLOR.WHITE;
            }
        }
        assertArrayEquals(areaColorExcepted, areaColorActual);
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
