import java.awt.Shape;
import java.util.ArrayList;
import java.util.List;

public class Layer {
    private Integer id;
    private String name;
    private List<Shape> listShapes;

    /**
     * Attribut indiquant si le layer est visible ou non (s'il est affiché à l'écran)
     */
    private boolean visible;

    public Layer(int parId, String parName){
        id = parId;
        name = parName;
        listShapes = new ArrayList<>();
        visible = true;
    }

    public void setLayerVisible(){
        visible = true;
    }

    public void setLayerUnvisible(){
        visible = false;
    }

    public void addShapeToLayer(Shape shapeToAdd){
        listShapes.add(shapeToAdd);
    }

    public void removeShapeFromLayer(Shape shapeToRemove){
        listShapes.remove(shapeToRemove);
    }

    public void deleteAllShapeFromLayer(){
        listShapes = new ArrayList<>();
    }
}
