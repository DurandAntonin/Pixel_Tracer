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

    public String toString(){
        return null;
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
    public void printArea() {
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
    public void deleteLayersList() {
        // TODO implement here
        return;
    }

    /**
     * @return
     */
    public ArrayList<Layer> getAllLayers() {
        // TODO implement here
        return null;
    }

    @Override
    public boolean equals(Object object){
        return true;
    }

    /**
     * @return
     */
    public Integer getNumberOfLayers() {
        // TODO implement here
        return null;
    }

    public Integer getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public String[][] getArea() {
        return this.area;
    }

    public String getEmptyChar() {
        return this.emptyChar;
    }

    public String getFullChar() {
        return this.fullChar;
    }
}