import java.io.ByteArrayInputStream;
import java.util.ArrayList;

import org.junit.Test;
import org.junit.Before;
import org.junit.After;
import org.junit.Assert;


public class CommandTest {

    public final String commandName = "Command test";
    public Command command;

    @Before
    public void beforeTest(){
        command = new Command(commandName);
    }


    @After
    public void afterTest(){
        command = null;
    }

    public void provideInput(String data) {
        ByteArrayInputStream testIn = new ByteArrayInputStream(data.getBytes());
        System.setIn(testIn);
    }   

    @Test
    public void testGetIntParams() {
        command.addIntParam(1);
        command.addIntParam(2);
        command.addIntParam(3);

        ArrayList<Integer> listIntParamsActual = command.getIntParams();
        ArrayList<Integer> listIntParamsExcepted = new ArrayList<>();
        listIntParamsExcepted.add(1);
        listIntParamsExcepted.add(2);
        listIntParamsExcepted.add(3);

        Assert.assertEquals(listIntParamsExcepted, listIntParamsActual);
        
    }

    @Test
    public void testGetStrParams() {
        command.addStrParam("point");
        command.addStrParam("px");
        command.addStrParam("px");

        ArrayList<String> listStrParamsActual = command.getStrParams();
        ArrayList<String> listStrParamsExcepted = new ArrayList<>();
        listStrParamsExcepted.add("point");
        listStrParamsExcepted.add("px");
        listStrParamsExcepted.add("px");

        Assert.assertEquals(listStrParamsExcepted, listStrParamsActual); 
    }

    @Test
    public void testGetMaxParamNumber() {
        Assert.assertEquals(30, command.getMaxParamNumber());  
    }

    @Test
    public void testGetListErrorMessages() {
        command.addFloatParam((float) 5.12);
    }

    @Test
    public void testGetFloatParams() {
        command.addFloatParam((float) 1.2);
        command.addFloatParam((float) 2.5);
        command.addFloatParam((float) 3.9);

        ArrayList<Float> listFloatParamsActual = command.getFloatParams();
        ArrayList<Float> listFloatParamsExcepted = new ArrayList<>();
        listFloatParamsExcepted.add((float) 1.2);
        listFloatParamsExcepted.add((float) 2.5);
        listFloatParamsExcepted.add((float) 3.9);

        Assert.assertEquals(listFloatParamsExcepted, listFloatParamsActual);
    }

    @Test
    public void testAddFloatParam() {
        command.addFloatParam((float) 5.12);
        ArrayList<Float> listFloatParamsActual = command.getFloatParams();
        ArrayList<Float> listFloatParamsExcepted = new ArrayList<>();
        listFloatParamsExcepted.add((float) 5.12);

        Assert.assertEquals(1, listFloatParamsActual.size());
        Assert.assertEquals( listFloatParamsExcepted, listFloatParamsActual);
    }

    @Test
    public void testAddIntParam() {
        command.addIntParam(5);
        ArrayList<Integer> listIntParamsActual = command.getIntParams();
        ArrayList<Integer> listIntParamsExcepted = new ArrayList<>();
        listIntParamsExcepted.add(5);

        Assert.assertEquals(1, listIntParamsActual.size());
        Assert.assertEquals( listIntParamsExcepted, listIntParamsActual);
    }

    @Test
    public void testAddStrParam() {
        command.addStrParam("rectangle");
        ArrayList<String> listStrParamsActual = command.getStrParams();
        ArrayList<String> listStrParamsExcepted = new ArrayList<>();
        listStrParamsExcepted.add("rectangle");

        Assert.assertEquals(1, listStrParamsActual.size());
        Assert.assertEquals( listStrParamsExcepted, listStrParamsActual);
    }

    @Test
    public void testCheckNbParams(){
        Assert.assertTrue(command.checkNbParams(0, 0, 0));

        command.addStrParam("point");
        Assert.assertTrue(command.checkNbParams(1, 0, 0));

        command.addIntParam(5);
        command.addIntParam(2);
        Assert.assertTrue(command.checkNbParams(1, 2, 0));

        command.addFloatParam((float) 5.2);
        Assert.assertTrue(command.checkNbParams(1, 2, 1));
    }

    @Test
    public void testCheckNbParamsPolygon(){
        command.addStrParam("polygon");
        Assert.assertFalse(command.checkNbParamsPolygon());
        command.clearParamList();

        command.addStrParam("polygon");
        command.addStrParam("test");
        Assert.assertFalse(command.checkNbParamsPolygon());
        command.clearParamList();

        command.addStrParam("polygon");
        command.addFloatParam((float)1.00);
        Assert.assertFalse(command.checkNbParamsPolygon());
        command.clearParamList();

        command.addStrParam("polygon");
        command.addIntParam(1);
        Assert.assertFalse(command.checkNbParamsPolygon());
        command.clearParamList();

        command.addStrParam("polygon");
        command.addIntParam(1);
        command.addIntParam(2);
        Assert.assertTrue(command.checkNbParamsPolygon());
        command.clearParamList();

        command.addStrParam("polygon");
        command.addIntParam(1);
        command.addIntParam(2);
        command.addIntParam(3);
        Assert.assertFalse(command.checkNbParamsPolygon());
        command.clearParamList();

        command.addStrParam("polygon");
        for (int i=0;i<30;i++){
            command.addIntParam(i);
        }
        Assert.assertTrue(command.checkNbParamsPolygon());
        command.clearParamList();

        command.addStrParam("polygon");
        for (int i=0;i<31;i++){
            command.addIntParam(i);
        }
        Assert.assertFalse(command.checkNbParamsPolygon());
        command.clearParamList();
    }

    @Test
    public void testReadFromStdin() {
        provideInput("rectangle 1 1 5 4");
        command.readFromStdin();

        ArrayList<Integer> listIntParamsActual = command.getIntParams();
        ArrayList<Float> listFloatParamsActual = command.getFloatParams();
        ArrayList<String> listStrParamsActual = command.getStrParams();

        ArrayList<Integer> listIntParamsExcepted = new ArrayList<>();
        listIntParamsExcepted.add(1);
        listIntParamsExcepted.add(1);
        listIntParamsExcepted.add(5);
        listIntParamsExcepted.add(4);
        ArrayList<Float> listFloatParamsExcepted = new ArrayList<>();
        ArrayList<String> listStrParamsExcepted = new ArrayList<>();
        listStrParamsExcepted.add("rectangle");

        Assert.assertEquals(listIntParamsExcepted, listIntParamsActual);
        Assert.assertEquals(listFloatParamsExcepted, listFloatParamsActual);
        Assert.assertEquals(listStrParamsExcepted, listStrParamsActual);
    }

    @Test
    public void testReadExecCommand() {
        Pixel_tracer app = new Pixel_tracer();
        Integer errorNum;

        //// CAS EXIT ////
        //cas erreur 4
        provideInput("exit");
        errorNum = command.readExecCommand(app);
        Assert.assertTrue(errorNum == 4);

        //cas erreur 3
        provideInput("exit 1");
        errorNum = command.readExecCommand(app);
        Assert.assertTrue(errorNum == 3);

        provideInput("exit 1.5");
        errorNum = command.readExecCommand(app);
        Assert.assertTrue(errorNum == 3);

        provideInput("exit test");
        errorNum = command.readExecCommand(app);
        Assert.assertTrue(errorNum == 3);

        
        //// CAS CLEAR ////
        //cas erreur 4
        provideInput("clear");
        errorNum = command.readExecCommand(app);
        Assert.assertTrue(errorNum == 5);

        //cas erreur 3
        provideInput("clear 1");
        errorNum = command.readExecCommand(app);
        Assert.assertTrue(errorNum == 3);

        provideInput("clear 1.5");
        errorNum = command.readExecCommand(app);
        Assert.assertTrue(errorNum == 3);

        provideInput("clear test");
        errorNum = command.readExecCommand(app);
        Assert.assertTrue(errorNum == 3);


        //// CAS PLOT ////
        //cas erreur 6
        provideInput("plot");
        errorNum = command.readExecCommand(app);
        Assert.assertTrue(errorNum == 6);

        //cas erreur 3
        provideInput("plot 1");
        errorNum = command.readExecCommand(app);
        Assert.assertTrue(errorNum == 3);

        provideInput("plot 1.5");
        errorNum = command.readExecCommand(app);
        Assert.assertTrue(errorNum == 3);

        provideInput("plot test");
        errorNum = command.readExecCommand(app);
        Assert.assertTrue(errorNum == 3);


        //// CAS HELP ////
        //cas erreur 7
        provideInput("help");
        errorNum = command.readExecCommand(app);
        Assert.assertTrue(errorNum == 7);

        //cas erreur 3
        provideInput("help 1");
        errorNum = command.readExecCommand(app);
        Assert.assertTrue(errorNum == 3);

        provideInput("help 1.5");
        errorNum = command.readExecCommand(app);
        Assert.assertTrue(errorNum == 3);

        provideInput("help test");
        errorNum = command.readExecCommand(app);
        Assert.assertTrue(errorNum == 3);


        //// CAS POINT ////
        //cas erreur 0
        provideInput("point 1 2");
        errorNum = command.readExecCommand(app);
        Assert.assertTrue(errorNum == 0);

        provideInput("point 1 2 cyan");
        errorNum = command.readExecCommand(app);
        Assert.assertTrue(errorNum == 0);

        //cas erreur 3
        provideInput("point 1");
        errorNum = command.readExecCommand(app);
        Assert.assertTrue(errorNum == 3);

        provideInput("point");
        errorNum = command.readExecCommand(app);
        Assert.assertTrue(errorNum == 3);

        provideInput("point test");
        errorNum = command.readExecCommand(app);
        Assert.assertTrue(errorNum == 3);

        provideInput("point 1.2");
        errorNum = command.readExecCommand(app);
        Assert.assertTrue(errorNum == 3);

        //// CAS LINE ////
        //cas erreur 0
        provideInput("line 1 2 4 1");
        errorNum = command.readExecCommand(app);
        Assert.assertTrue(errorNum == 0);

        provideInput("line 1 2 4 1 black");
        errorNum = command.readExecCommand(app);
        Assert.assertTrue(errorNum == 0);

        //cas erreur 3
        provideInput("line 1 2");
        errorNum = command.readExecCommand(app);
        Assert.assertTrue(errorNum == 3);

        provideInput("line");
        errorNum = command.readExecCommand(app);
        Assert.assertTrue(errorNum == 3);

        provideInput("line test");
        errorNum = command.readExecCommand(app);
        Assert.assertTrue(errorNum == 3);

        provideInput("line 1.2");
        errorNum = command.readExecCommand(app);
        Assert.assertTrue(errorNum == 3);


        //// CAS CIRCLE ////
        //cas erreur 0
        provideInput("circle 1 2 3");
        errorNum = command.readExecCommand(app);
        Assert.assertTrue(errorNum == 0);

        provideInput("circle 1 2 3 green");
        errorNum = command.readExecCommand(app);
        Assert.assertTrue(errorNum == 0);

        //cas erreur 3
        provideInput("circle 1 2");
        errorNum = command.readExecCommand(app);
        Assert.assertTrue(errorNum == 3);

        provideInput("circle");
        errorNum = command.readExecCommand(app);
        Assert.assertTrue(errorNum == 3);

        provideInput("circle test");
        errorNum = command.readExecCommand(app);
        Assert.assertTrue(errorNum == 3);

        provideInput("circle 1.2");
        errorNum = command.readExecCommand(app);
        Assert.assertTrue(errorNum == 3);


        //// CAS SQUARE ////
        //cas erreur 0
        provideInput("square 1 2 3");
        errorNum = command.readExecCommand(app);
        Assert.assertTrue(errorNum == 0);

        provideInput("square 1 2 3 purple");
        errorNum = command.readExecCommand(app);
        Assert.assertTrue(errorNum == 0);

        //cas erreur 3
        provideInput("square 1 2");
        errorNum = command.readExecCommand(app);
        Assert.assertTrue(errorNum == 3);

        provideInput("square");
        errorNum = command.readExecCommand(app);
        Assert.assertTrue(errorNum == 3);

        provideInput("square test");
        errorNum = command.readExecCommand(app);
        Assert.assertTrue(errorNum == 3);

        provideInput("square 1.2");
        errorNum = command.readExecCommand(app);
        Assert.assertTrue(errorNum == 3);


        //// CAS RECTANGLE ////
        //cas erreur 0
        provideInput("rectangle 1 2 3 3");
        errorNum = command.readExecCommand(app);
        Assert.assertTrue(errorNum == 0);

        provideInput("rectangle 1 2 3 3 yellow");
        errorNum = command.readExecCommand(app);
        Assert.assertTrue(errorNum == 0);

        //cas erreur 3
        provideInput("rectangle 1 2");
        errorNum = command.readExecCommand(app);
        Assert.assertTrue(errorNum == 3);

        provideInput("rectangle");
        errorNum = command.readExecCommand(app);
        Assert.assertTrue(errorNum == 3);

        provideInput("rectangle test");
        errorNum = command.readExecCommand(app);
        Assert.assertTrue(errorNum == 3);

        provideInput("rectangle 1.2");
        errorNum = command.readExecCommand(app);
        Assert.assertTrue(errorNum == 3);


        //// CAS POLYGON ////
        //cas erreur 0
        provideInput("polygon 1 2 3 3");
        errorNum = command.readExecCommand(app);
        Assert.assertTrue(errorNum == 0);

        provideInput("polygon 1 2 3 3 blue");
        errorNum = command.readExecCommand(app);
        Assert.assertTrue(errorNum == 0);

        //cas erreur 3
        provideInput("polygon 1 2 3 3 4 6 7 8 9 10 12 6 8 12 2 3 3 4 7 6 2 1 0 4 3 2 1 2 8 10 12");
        errorNum = command.readExecCommand(app);
        Assert.assertTrue(errorNum == 3);

        provideInput("polygon 1 2 3");
        errorNum = command.readExecCommand(app);
        Assert.assertTrue(errorNum == 3);

        provideInput("polygon");
        errorNum = command.readExecCommand(app);
        Assert.assertTrue(errorNum == 3);

        provideInput("polygon test");
        errorNum = command.readExecCommand(app);
        Assert.assertTrue(errorNum == 3);

        provideInput("polygon 1.2");
        errorNum = command.readExecCommand(app);
        Assert.assertTrue(errorNum == 3);


        //// CAS CURVE ////
        //cas erreur 0
        provideInput("curve 1 2 3 3 6 8 10 10");
        errorNum = command.readExecCommand(app);
        Assert.assertTrue(errorNum == 0);

        provideInput("curve 1 2 3 3 6 8 10 10 white");
        errorNum = command.readExecCommand(app);
        Assert.assertTrue(errorNum == 0);

        //cas erreur 3
        provideInput("curve 1 2");
        errorNum = command.readExecCommand(app);
        Assert.assertTrue(errorNum == 3);

        provideInput("curve");
        errorNum = command.readExecCommand(app);
        Assert.assertTrue(errorNum == 3);

        provideInput("curve test");
        errorNum = command.readExecCommand(app);
        Assert.assertTrue(errorNum == 3);

        provideInput("curve 1.2");
        errorNum = command.readExecCommand(app);
        Assert.assertTrue(errorNum == 3);


        //// CAS LIST  ////
        //cas erreur 8
        provideInput("list layers");
        errorNum = command.readExecCommand(app);
        Assert.assertTrue(errorNum == 8);

        provideInput("list areas");
        errorNum = command.readExecCommand(app);
        Assert.assertTrue(errorNum == 8);

        provideInput("list shapes");
        errorNum = command.readExecCommand(app);
        Assert.assertTrue(errorNum == 8);

        //cas erreur 3
        provideInput("list");
        errorNum = command.readExecCommand(app);
        Assert.assertTrue(errorNum == 3);

        provideInput("list test");
        errorNum = command.readExecCommand(app);
        Assert.assertTrue(errorNum == 3);

        provideInput("list 1.2");
        errorNum = command.readExecCommand(app);
        Assert.assertTrue(errorNum == 3);


        //// CAS NEW  ////
        //cas erreur 8
        provideInput("new layer layerTest");
        errorNum = command.readExecCommand(app);
        Assert.assertTrue(errorNum == 8);

        provideInput("new area areaTest");
        errorNum = command.readExecCommand(app);
        Assert.assertTrue(errorNum == 8);

        //cas erreur 9
        provideInput("new layer");
        errorNum = command.readExecCommand(app);
        Assert.assertTrue(errorNum == 3);
        
        provideInput("new area");
        errorNum = command.readExecCommand(app);
        Assert.assertTrue(errorNum == 3);

        provideInput("new");
        errorNum = command.readExecCommand(app);
        Assert.assertTrue(errorNum == 3);

        provideInput("new test");
        errorNum = command.readExecCommand(app);
        Assert.assertTrue(errorNum == 3);

        provideInput("new test test");
        errorNum = command.readExecCommand(app);
        Assert.assertTrue(errorNum == 3);

        provideInput("new 1.2");
        errorNum = command.readExecCommand(app);
        Assert.assertTrue(errorNum == 3);


        //// CAS SELECT  ////
        //on créé une nouvelle area 
        app.createLayerInCurrentArea(1, "Layer 1");
        //on créé une shape dans le layer actuel
        app.addShapeToCurrentLayer(new Point(10, 2));

        //cas erreur 8
        provideInput("select area 0");
        errorNum = command.readExecCommand(app);
        Assert.assertTrue(errorNum == 8);

        provideInput("select layer 1");
        errorNum = command.readExecCommand(app);
        Assert.assertTrue(errorNum == 8);

        //cas erreur 9
        provideInput("select area 2");
        errorNum = command.readExecCommand(app);
        Assert.assertTrue(errorNum == 9);

        provideInput("select layer 2");
        errorNum = command.readExecCommand(app);
        Assert.assertTrue(errorNum == 9);

        //cas erreur 3
        provideInput("select");
        errorNum = command.readExecCommand(app);
        Assert.assertTrue(errorNum == 3);

        provideInput("select 1");
        errorNum = command.readExecCommand(app);
        Assert.assertTrue(errorNum == 3);

        provideInput("select test");
        errorNum = command.readExecCommand(app);
        Assert.assertTrue(errorNum == 3);

        provideInput("select test 1");
        errorNum = command.readExecCommand(app);
        Assert.assertTrue(errorNum == 3);

        provideInput("select 1.2");
        errorNum = command.readExecCommand(app);
        Assert.assertTrue(errorNum == 3);


        //// CAS DELETE  ////
        //on créé une nouvelle area 
        app.createArea(2, "area test");
        //on créé une shape dans le layer actuel
        app.addShapeToCurrentLayer(new Point(0, COLOR.BLACK, 1, 1, 2));

        //cas erreur 8
        provideInput("delete shape 0");
        errorNum = command.readExecCommand(app);
        Assert.assertTrue(errorNum == 8);

        provideInput("delete layer 0");
        errorNum = command.readExecCommand(app);
        Assert.assertTrue(errorNum == 8);

        provideInput("delete area 2");
        errorNum = command.readExecCommand(app);
        Assert.assertTrue(errorNum == 8);

        //cas erreur 10
        app.createArea(2, "area test");
        provideInput("delete shape 0");
        errorNum = command.readExecCommand(app);
        Assert.assertTrue(errorNum == 10);

        //cas erreur 9
        provideInput("delete layer 1");
        errorNum = command.readExecCommand(app);
        Assert.assertTrue(errorNum == 9);

        provideInput("delete area 3");
        errorNum = command.readExecCommand(app);
        Assert.assertTrue(errorNum == 9);
        
        //cas erreur 3
        provideInput("delete");
        errorNum = command.readExecCommand(app);
        Assert.assertTrue(errorNum == 3);

        provideInput("delete 1");
        errorNum = command.readExecCommand(app);
        Assert.assertTrue(errorNum == 3);

        provideInput("delete test");
        errorNum = command.readExecCommand(app);
        Assert.assertTrue(errorNum == 3);

        provideInput("delete test 2");
        errorNum = command.readExecCommand(app);
        Assert.assertTrue(errorNum == 3);

        provideInput("delete 1.2");
        errorNum = command.readExecCommand(app);
        Assert.assertTrue(errorNum == 3);


        //// CAS SET  ////
        //cas erreur 8
        provideInput("set layer visible 0");
        errorNum = command.readExecCommand(app);
        Assert.assertTrue(errorNum == 8);

        provideInput("set layer unvisible 0");
        errorNum = command.readExecCommand(app);
        Assert.assertTrue(errorNum == 8);

        //cas erreur 9
        provideInput("set layer visible 1");
        errorNum = command.readExecCommand(app);
        Assert.assertTrue(errorNum == 9);

        provideInput("set layer unvisible 1");
        errorNum = command.readExecCommand(app);
        Assert.assertTrue(errorNum == 9);

        //cas erreur 3
        provideInput("set shape 0");
        errorNum = command.readExecCommand(app);
        Assert.assertTrue(errorNum == 3);

        provideInput("set layer 0");
        errorNum = command.readExecCommand(app);
        Assert.assertTrue(errorNum == 3);

        provideInput("set area 1");
        errorNum = command.readExecCommand(app);
        Assert.assertTrue(errorNum == 3);

        provideInput("set char");
        errorNum = command.readExecCommand(app);
        Assert.assertTrue(errorNum == 3);

        provideInput("set layer");
        errorNum = command.readExecCommand(app);
        Assert.assertTrue(errorNum == 3);

        provideInput("set char border");
        errorNum = command.readExecCommand(app);
        Assert.assertTrue(errorNum == 3);

        provideInput("set layer visible");
        errorNum = command.readExecCommand(app);
        Assert.assertTrue(errorNum == 3);

        provideInput("set layer border");
        errorNum = command.readExecCommand(app);
        Assert.assertTrue(errorNum == 3);

        provideInput("set char visible");
        errorNum = command.readExecCommand(app);
        Assert.assertTrue(errorNum == 3);

        provideInput("set test");
        errorNum = command.readExecCommand(app);
        Assert.assertTrue(errorNum == 3);

        provideInput("set test 2");
        errorNum = command.readExecCommand(app);
        Assert.assertTrue(errorNum == 3);

        provideInput("set 1.2");
        errorNum = command.readExecCommand(app);
        Assert.assertTrue(errorNum == 3);
    }
}
