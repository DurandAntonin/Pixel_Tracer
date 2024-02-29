import java.util.ArrayList;

/**
 * 
 */
public class Pixel_tracer {

    /**
     * 
     */
    private ArrayList<Area> listArea;

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
     */
    public Pixel_tracer() {
        //on initialise les autre champs
        this.listArea = new ArrayList<>();
        this.currentShape = null;
        this.emptyChar = ".";
        this.fullChar = "#";

        //on créé une area par défaut
        this.createArea("Default Area");

        //le layer par défaut est le premier layer de l'area créée
        ArrayList<Layer> layerList = this.currentArea.getAllLayers();
        if (layerList.size() > 0)
            this.currentLayer = layerList.get(0);
    }

    public void createArea(String areaName){
        //on créé une nouvelle area et on l'ajoute dans la liste des area
        Area newArea = new Area(this.listArea.size(), 50, 80, areaName);
        this.listArea.add(newArea);

        //cette nouvelle area devient l'area sélectionnée
        this.currentArea = newArea;
    }

    /**
     * @return
     */
    public void destroyApp() {
        //on reinitialise les champs pour supprimer les valeurs
        this.listArea = new ArrayList<>();
        this.currentArea = null;
        this.currentLayer = null;
        this.fullChar = null;
        this.emptyChar = null;
    }

    /**
     * @return
     */
    public void eraseArea() {
        //on supprime toutes les formes de l'area sélectionnée
        ArrayList<Layer> layerList = this.currentArea.getAllLayers();

        for (int i=0; i<layerList.size(); i++){
            layerList.get(i).deleteAllShapeFromLayer();
        }
    }

    public void createLayerInCurrentArea(){
        //on créé un nouveau layer et on le sélectionne
        int idNewLayer = this.currentArea.getNumberOfLayers();
        Layer layer = new Layer(idNewLayer, "Layer " + idNewLayer);
        this.currentArea.addLayer(layer);

        this.currentLayer = layer;
    }

    public void addShapeToCurrentLayer(Shape shapeToAdd){
        this.currentLayer.addShapeToLayer(shapeToAdd);

        //on met à jour la forme sélectionnée
        this.currentShape = shapeToAdd;
    }

    public boolean selectArea(int areaIdToSelect){
        //on change l'area sélectionnée si cette derniere existe
        boolean isAreaeExists = false;

        for (Area area : listArea) {
            if (area.getId() == areaIdToSelect){
                this.currentArea = area;
                isAreaeExists = true;
                break;
            }
        }

        return isAreaeExists;
    }

    public boolean selectLayer(int layerIdToSelect){
        //on change le layer de l'area sélectionnée
        boolean isLayerExists = false;
        ArrayList<Layer> listLayerInCurrentArea = this.currentArea.getAllLayers();

        if (listLayerInCurrentArea.size() > 0){
            for (Layer layer : listLayerInCurrentArea) {
                if (layer.getId() == layerIdToSelect){
                    this.currentLayer = layer;
                    isLayerExists = true;
                    break;
                }
            }
        }
        
        return isLayerExists;
    }

    /**
     * @return
     */
    public boolean deleteArea(int areaIdToDelete) {
        boolean isAreaDeleted = false;

        //on supprime l'area ayant l'id indiqué en paramètre
        for (int i=0; i<this.listArea.size(); i++) {
            Area area = this.listArea.get(i);
            if (area.getId() == areaIdToDelete){
                isAreaDeleted = true;

                this.listArea.remove(i);

                //on change l'area sélectionnée 
                if (this.currentArea == area){
                    //la nouvelle area sélectionnée par défaut est la première de la liste
                    if (this.listArea.size() > 0)
                        this.currentArea = this.listArea.get(0);
                    
                    //il n'y a plus d'area, on met l'area par défaut à null
                    else
                        this.currentArea = null;

                }

                break;
            }
        }

        return isAreaDeleted;
    }

    public boolean deleteLayerInCurrentArea(int layerIdToDelete){
        boolean layerDeleted = false;

        //on vérifie que le layer n'est pas nul, i.e s'il existe
        if (currentArea != null){
            layerDeleted = this.currentArea.removeLayerFromArea(layerIdToDelete);

            //on change le layer sélectionné
            ArrayList<Layer> layerListInCurrentArea = this.currentArea.getAllLayers();
            if (layerListInCurrentArea.size() > 0)
                this.currentLayer = layerListInCurrentArea.get(layerListInCurrentArea.size()-1);
            else
                this.currentLayer = null;
        }

        return layerDeleted;
    } 

    public boolean deleteShapeInCurrentLayer(int shapeIdToDelete){
        boolean shapeDeleted = false;

        //on vérifie que la forme sélectionnée n'est pas nulle, i.e si elle existe
        if (currentLayer != null){
            shapeDeleted = this.currentLayer.removeShapeFromLayer(shapeIdToDelete);

            //on change la forme sélectionnée
            ArrayList<Shape> shapeListInCurrent = this.currentLayer.getListShapes();
            if (shapeListInCurrent.size() > 0)
                this.currentShape = shapeListInCurrent.get(shapeListInCurrent.size()-1);
            else
                this.currentShape = null;
        }

        return shapeDeleted;
    }

    public boolean changeLayerVisibilityInCurrentArea(int layerId, boolean newVisibility){
        boolean resultChangeLayerVisibility = this.currentArea.setLayerVisibility(layerId, newVisibility);

        //si le layer est maintenant invisible et que c'est le layer sélectionné, on change le layer sélectionné
        if (this.currentLayer.getId() == layerId && !newVisibility && this.currentArea.getNumberOfLayers() > 0){
            ArrayList<Layer> listLayersInCurrentArea = this.currentArea.getAllLayers();
            this.currentLayer = listLayersInCurrentArea.get(listLayersInCurrentArea.size()-1);
        }
        
        return resultChangeLayerVisibility;
    }
    

    public void drawCurrentArea(){
        //pour l'area sélectionnée, on convertit toutes les formes de chaque layer en pixels pour être ensuite affiché
        this.currentArea.drawAllShapeFromLayer();
    }

    public String toString(){
        String pixelTracerString = "Pixel_tracer [listArea: [";
        
        //on affiche chaque area de l'appli
        for (Area area : this.listArea) {
            pixelTracerString += area.toString() + ", ";
        }

        //on enleve la virgule et l'espace en trop s'il y a des layer
        if (this.listArea.size() > 0)
            pixelTracerString = pixelTracerString.substring(0, pixelTracerString.length()-2);

        pixelTracerString += "], currentArea : " + this.currentArea + ", currentLayer : " + this.currentLayer + ", currentShape : " + this.currentShape + ", emptyChar: " + this.emptyChar + ", fullChar: " + this.fullChar + "]";

        return pixelTracerString;
    }

    public ArrayList<Area> getListArea() {
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