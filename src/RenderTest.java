import static org.junit.Assert.assertArrayEquals;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.io.UnsupportedEncodingException;

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
        r1 = new Rectangle(0, COLOR.BLUE, 1, new Point(0, 0), 3, 3);
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
    public void testPrintArea() throws UnsupportedEncodingException {
        Render.printArea(a1);

        String[][] area = a1.getArea();
        COLOR[][] areaColor = a1.getAreaColors();

        String areaExceptedStr = "";
        for (int i=0; i< area.length; i++){
            areaExceptedStr += "|";
            for (int j=0; j<area[i].length; j++){
                //on affiche la case avec la couleur associée à cette dernière
                areaExceptedStr += areaColor[i][j].getValue() + area[i][j] + COLOR.RESET.getValue();
            }
            areaExceptedStr += "|\n";
        }

        assertArrayEquals(areaExceptedStr.getBytes(), outContent.toByteArray());
    }
}
