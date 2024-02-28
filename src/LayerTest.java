import org.junit.Test;
import org.junit.Before;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

import java.util.ArrayList;

import org.junit.Assert;

public class LayerTest {

    int layerId;
    Layer l1;
    String layerName;
    Rectangle rec1;
    Circle cir1;
    Point pnt1;
    Shape [] emptyList = {};
    Shape [] partList;
    Shape [] fullList1;
    Shape [] fullList2;

    @Before
    public void init(){
        layerId = 1;
        layerName = "testLayer1";
        rec1 = new Rectangle(new Point(4,4), 4, 4);
        cir1 = new Circle(new Point(4,4), 4);
        pnt1 = new Point(1, 2);

        l1 = new Layer(layerId, layerName);
        l1.addShapeToLayer(rec1);
        l1.addShapeToLayer(cir1);

        partList = new Shape[]{cir1};
        fullList1 = new Shape[]{rec1, cir1};
        fullList2 = new Shape[]{rec1, cir1, pnt1};
    }

    @Test
    public void testAddShapeToLayer() {
        assertArrayEquals(fullList1, l1.getListShapes().toArray());
        l1.addShapeToLayer(pnt1);
        assertArrayEquals(fullList2, l1.getListShapes().toArray());
    }

    @Test
    public void testDeleteAllShapeFromLayer() {
        assertArrayEquals(fullList1, l1.getListShapes().toArray());
        l1.deleteAllShapeFromLayer();
        assertArrayEquals(emptyList, l1.getListShapes().toArray());
    }

    @Test
    public void testGetId() {
        assertEquals(layerId, l1.getId());
    }

    @Test
    public void testGetListShapes() {
        assertArrayEquals(fullList1, l1.getListShapes().toArray());
    }

    @Test
    public void testGetName() {
        assertEquals(layerName, l1.getName());
    }

    @Test
    public void testGetVisible() {
        assertEquals(true, l1.getVisible());
        l1.setLayerUnvisible();
        assertEquals(false, l1.getVisible());
    }

    @Test
    public void testRemoveShapeFromLayer() {
        assertArrayEquals(fullList1, l1.getListShapes().toArray());
        l1.removeShapeFromLayer(rec1);
        assertArrayEquals(partList, l1.getListShapes().toArray());
    }

    @Test
    public void testSetLayerUnvisible() {
        l1.setLayerUnvisible();
        assertEquals(false, l1.getVisible());
    }

    @Test
    public void testSetLayerVisible() {
        l1.setLayerVisible();
        assertEquals(true, l1.getVisible());
    }

    @Test
    public void testEquals(){
        //cas meme instance
        Assert.assertTrue(l1.equals(l1));

        //cas 2eme objet null
        Assert.assertFalse(l1.equals(null));

        //cas objets de classes différentes
        Assert.assertFalse(l1.equals(new String()));

        //cas objets de meme classe et valeur des champs différentes
        Layer l2 = new Layer(1, "Layer 2");
        l2.addShapeToLayer(cir1);
        Assert.assertFalse(l1.equals(l2));

        //cas objets de meme classe et valeur des champs identique
        Layer l3 = new Layer(layerId, layerName);
        l3.addShapeToLayer(rec1);
        l3.addShapeToLayer(cir1);
        Assert.assertTrue(l1.equals(l3));
    }

    @Test
    public void testToString(){
        String l1StringActual = l1.toString();
        String l1StringExcepted = "Layer [id: " + l1.getId() + ", name: " + l1.getName() + ", visible: " + l1.getVisible() + ", listShapes: [";

        ArrayList<Shape> listShapeL1 = l1.getListShapes();
        for (Shape shape : listShapeL1) {
            l1StringExcepted += shape.toString() + ", ";
        }
        if (listShapeL1.size() > 0 )
            l1StringExcepted = l1StringExcepted.substring(0, l1StringExcepted.length()-2);
        
        l1StringExcepted += "]]";

        assertEquals(l1StringExcepted, l1StringActual);
    }
}
