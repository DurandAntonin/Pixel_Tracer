import static org.junit.Assert.assertEquals;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class RenderTest {

    Area a1;
    Rectangle r1;
    Layer l1;
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;

    @Before
    public void init(){
        a1 = new Area(1, 5, 5, "area1");
        r1 = new Rectangle(new Point(0, 0), 3, 3);
        l1 = new Layer(1, "layer1");
        l1.addShapeToLayer(r1);
        a1.addLayer(l1);
        a1.drawAllShapeFromLayer();
        System.setOut(new PrintStream(outContent));
    }

    @After
    public void restoreStreams() {
        System.setOut(originalOut);
    }

    @Test
    public void testClearScreen() {

    }

    @Test
    public void testPrintArea() {
        Render.printArea(a1);
        String[][] areaExcepted = {
            {"#", "#", "#", ".", "."},
            {"#", ".", "#", ".", "."},
            {"#", "#", "#", ".", "."},
            {".", ".", ".", ".", "."},
            {".", ".", ".", ".", "."},
        };

        assertEquals(areaExcepted, outContent.toString());
    }
}
