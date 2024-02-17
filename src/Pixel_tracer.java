import java.util.*;

/**
 * 
 */
public class Pixel_tracer {

    /**
     * 
     */
    private List<Area> listArea;

    /**
     * 
     */
    private Area currentArea;

    /**
     * 
     */
    private Layer currentLayer;

    /**
     * 
     */
    private Shape currentShape;

    /**
     * 
     */
    private String emptyChar;

    /**
     * 
     */
    private String fullChar;

    /**
     * @return
     */
    public void Pixel_Tracer() {
        // TODO implement here
    }

    public void createArea(String areaName){
        return;
    }

    /**
     * @return
     */
    public void destroyApp() {
        // TODO implement here
        return;
    }

    /**
     * @return
     */
    public void clearArea() {
        // TODO implement here
        return;
    }

    /**
     * @return
     */
    public void eraseArea() {
        // TODO implement here
        return;
    }

    /**
     * @return
     */
    public void deleteArea(Integer areaIdToDelete) {
        // TODO implement here
        return;
    }

    public List<Area> getListArea() {
        return this.listArea;
    }

    public Area getCurrentArea() {
        return this.currentArea;
    }

    public Layer getCurrentLayer() {
        return this.currentLayer;
    }

    public Shape getCurrentShape() {
        return this.currentShape;
    }

    public String getEmptyChar() {
        return this.emptyChar;
    }

    public String getFullChar() {
        return this.fullChar;
    }
}