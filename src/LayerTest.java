import org.junit.Test;
import org.junit.Before;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

import org.junit.Assert;

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
        assertArrayEquals(emptyList, l1.getListShapes().toArray());
        l1.addShapeToLayer(rec1);
        l1.addShapeToLayer(cir1);
        assertArrayEquals(fullList, l1.getListShapes().toArray());
    }

    @Test
    public void testDeleteAllShapeFromLayer() {
        assertArrayEquals(fullList, l1.getListShapes().toArray());
        l1.deleteAllShapeFromLayer();
        assertArrayEquals(emptyList, l1.getListShapes().toArray());
    }

    @Test
    public void testGetId() {
        assertEquals(l1.getId(), i);
    }

    @Test
    public void testGetListShapes() {
        l1.addShapeToLayer(rec1);
        l1.addShapeToLayer(cir1);
        assertArrayEquals(fullList, l1.getListShapes().toArray());
    }

    @Test
    public void testGetName() {
        assertEquals("layer_1", l1.getName());
        assertEquals(s1, l2.getName());
    }

    @Test
    public void testGetVisible() {
        assertEquals(0, l1.getVisible());
        l1.setLayerUnvisible();
        assertEquals(1, l1.getVisible());
    }

    @Test
    public void testRemoveShapeFromLayer() {
        assertArrayEquals(fullList, l1.getListShapes().toArray());
        l1.removeShapeFromLayer(rec1);
        assertArrayEquals(partList, l1.getListShapes().toArray());
    }

    @Test
    public void testSetLayerUnvisible() {
        l2.setLayerUnvisible();
        assertEquals(1, l2.getVisible());
    }

    @Test
    public void testSetLayerVisible() {
        l2.setLayerVisible();
        assertEquals(0, l2.getVisible());
    }

    @Test
    public void testEquals(){
        //cas meme instance
        Assert.assertTrue(l2.equals(l2));

        //cas 2eme objet null
        Assert.assertFalse(l2.equals(null));

        //cas objets de classes différentes
        Assert.assertFalse(l2.equals(new String()));

        //cas objets de meme classe et valeur des champs différentes
        Layer l3 = new Layer(3, "Layer 3");
        l3.addShapeToLayer(cir1);
        Assert.assertFalse(l2.equals(l3));

        //cas objets de meme classe et valeur des champs identique
        Assert.assertTrue(l2.equals(l1));
    }
}
