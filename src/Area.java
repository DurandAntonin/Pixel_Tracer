import java.util.*;

/**
 * 
 */
public class Area {

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
    private String[][] area;

    /**
     * 
     */
    private List<Layer> listLayers;

    /**
     * 
     */
    private String emptyChar;

    /**
     * 
     */
    private String fullChar;

    /**
     * @param width 
     * @param height 
     * @param id 
     * @param name
     */
    public Area(Integer width, Integer height, Integer id, String name) {
        // TODO implement here
    }

    /**
     * @return
     */
    public void printArea() {
        // TODO implement here
        return;
    }

    /**
     * @param layerToDelete 
     * @return
     */
    public void deleteLayer(Layer layerToDelete) {
        // TODO implement here
        return;
    }

    /**
     * @return
     */
    public List<Layer> getAllLayers() {
        // TODO implement here
        return null;
    }

    /**
     * @return
     */
    public Integer getNumberOfLayers() {
        // TODO implement here
        return null;
    }

    /**
     * @return
     */
    public void deleteLayersList() {
        // TODO implement here
        return;
    }

    /**
     * @param layerToAdd 
     * @return
     */
    public void addLayer(Layer layerToAdd) {
        // TODO implement here
        return;
    }

    /**
     * @return
     */
    public void drawArea() {
        // TODO implement here
        return;
    }

    /**
     * @return
     */
    public void initArea() {
        // TODO implement here
        return;
    }

    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String[][] getArea() {
        return this.area;
    }

    public List<Layer> getListLayers() {
        return this.listLayers;
    }

    public String getEmptyChar() {
        return this.emptyChar;
    }

    public String getFullChar() {
        return this.fullChar;
    }
}