
import java.util.*;

/**
 * 
 */
public class Layer {

    /**
     * 
     */
    private Integer id;

    /**
     * 
     */
    private String name;

    /**
     * 
     */
    private Boolean visible;

    /**
     * 
     */
    private List<Shape> listShapes;

    /**
     * @param parId 
     * @param parName
     */
    public Layer(int parId, String parName) {
        // TODO implement here
    }

    /**
     * @return
     */
    public void setLayerVisible() {
        // TODO implement here
        return;
    }

    /**
     * @return
     */
    public void setLayerUnvisible() {
        // TODO implement here
        return;
    }

    /**
     * @param shapeToAdd 
     * @return
     */
    public void addShapeToLayer(Shape shapeToAdd) {
        // TODO implement here
        return;
    }

    /**
     * @param shapeToRemove 
     * @return
     */
    public void removeShapeFromLayer(Shape shapeToRemove) {
        // TODO implement here
        return;
    }

    /**
     * @return
     */
    public void deleteAllShapeFromLayer() {
        // TODO implement here
        return;
    }

    public Integer getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public Boolean isVisible() {
        return this.visible;
    }

    public Boolean getVisible() {
        return this.visible;
    }


    public List<Shape> getListShapes() {
        return this.listShapes;
    }

}