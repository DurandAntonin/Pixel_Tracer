import org.junit.Test;
import org.junit.Before;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

public class LayerTest {

    int i,j;
    Layer l1, l2;
    String s1;
    Rectangle rec1;
    Circle cir1;
    Shape [] emptyList = {};
    Shape [] fullList = {rec1, cir1};
    Shape [] partList = {cir1};

    @Before
    public void init(){
        i = 1;
        j = 2;
        s1 = "testLayer1";
        l2 = new Layer(j, s1);
        rec1 = new Rectangle(new Point(4,4), 4, 4);
        cir1 = new Circle(new Point(4,4), 4);

    }

    @Test
    public void testAddShapeToLayer() {
        assertArrayEquals(l1.getListShapes().toArray(), emptyList);
        l1.addShapeToLayer(rec1);
        l1.addShapeToLayer(cir1);
        assertArrayEquals(l1.getListShapes().toArray(), fullList);
    }

    @Test
    public void testDeleteAllShapeFromLayer() {
        assertArrayEquals(l1.getListShapes().toArray(), fullList);
        l1.deleteAllShapeFromLayer();
        assertArrayEquals(l1.getListShapes().toArray(), emptyList);
    }

    @Test
    public void testGetId() {
        assertEquals((int)l1.getId(), i);
    }

    @Test
    public void testGetListShapes() {
        l1.addShapeToLayer(rec1);
        l1.addShapeToLayer(cir1);
        assertArrayEquals(l1.getListShapes().toArray(), fullList);
    }

    @Test
    public void testGetName() {
        assertEquals(l1.getName(), "layer_1");
        assertEquals(l2.getName(), s1);
    }

    @Test
    public void testGetVisible() {
        assertEquals(l1.getVisible(), 0);
        l1.setLayerUnvisible();
        assertEquals(l1.getVisible(), 1);
    }

    @Test
    public void testRemoveShapeFromLayer() {
        assertArrayEquals(l1.getListShapes().toArray(), fullList);
        l1.removeShapeFromLayer(rec1);
        assertArrayEquals(l1.getListShapes().toArray(), partList);
    }

    @Test
    public void testSetLayerUnvisible() {
        l2.setLayerUnvisible();
        assertEquals(l2.getVisible(), 1);
    }

    @Test
    public void testSetLayerVisible() {
        l2.setLayerVisible();
        assertEquals(l2.getVisible(), 0);
    }
}
