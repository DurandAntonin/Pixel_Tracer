import java.util.ArrayList;
import java.util.Arrays;

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
    private ArrayList<Layer> listLayers;

    /**
     * 
     */
    private String emptyChar;

    /**
     * 
     */
    private String fullChar;

    /**
     * @param parId 
     * @param parWidth 
     * @param parHeight 
     * @param parName
     */
    public Area(Integer parId, Integer parWidth, Integer parHeight, String parName) {
        //on initialise les champs
        this.id = parId;
        this.name = parName;
        this.area = new String[parHeight][parWidth];
        this.listLayers = new ArrayList<>();
        this.emptyChar = ".";
        this.fullChar = "#";

        for (int i=0; i<parHeight; i++){
            for (int j=0; j<parWidth; j++){
                area[i][j] = this.emptyChar;
            }
        }

        //on créé une layer par défaut
        Layer defaultLayer = new Layer(this.listLayers.size(), "Default layer");
        this.listLayers.add(defaultLayer);
    }

    public String toString(){
        String areaString = "Area [id: " + this.id + ", name: " + this.name + ", area : , listLayers: [";
        
        //on affiche chaque layer de l'area
        for (Layer layer : this.listLayers) {
            areaString += layer.toString() + ", ";
        }

        //on enleve la virgule et l'espace en trop s'il y a des layer
        if (this.listLayers.size() > 0)
            areaString = areaString.substring(0, areaString.length()-2);

        areaString += "], emptyChar: " + this.emptyChar + ", fullChar: " + this.fullChar + "]";

        return areaString;
    }

    public void clearArea () {
        int height = this.area.length;
        int width = this.area[0].length;
        this.area = new String[height][width];

        if (height != 0 && width != 0){
            for (int i=0; i<height; i++){
                for (int j=0; j<width; j++){
                    area[i][j] = this.emptyChar;
                }
            }
        }
    }

    /**
     * @return
     */
    public void drawAllShapeFromLayer() {
        //pour chaque layer, on transforme les shapes en pixels pour les stocker dans le champ area
        for (Layer layer : this.listLayers) {
            continue;
        }
    }

    /**
     * @param layerToAdd 
     * @return
     */
    public void addLayer(Layer layerToAdd) {
        //on ajoute un nouveau layer
        this.listLayers.add(layerToAdd);
    }

    /**
     * @param layerIdToDelete 
     * @return
     */
    public boolean removeLayerFromArea(int layerIdToDelete) {
        boolean isLayerDeleted = false;

        //on supprime le layer en fonction de son id
        for (int i=0; i<this.listLayers.size(); i++){
            if (this.listLayers.get(i).getId() == layerIdToDelete){
                this.listLayers.remove(i);
                isLayerDeleted = true;
                break;
            }
        }

        return isLayerDeleted;
    }

    /**
     * @return
     */
    public void deleteLayersList() {
        //on supprime tous les layers
        this.listLayers = new ArrayList<>();
    }

    public boolean setLayerVisibility(int layerId, boolean newVisibility){
        boolean layerVisibilityChanged = false;

        //on modifie la visibilité d'un layer
        for (int i=0; i<this.listLayers.size(); i++){
            if (this.listLayers.get(i).getId() == layerId){
                this.listLayers.get(i).setLayerVisibility(newVisibility);;
                layerVisibilityChanged = true;
                break;
            }
        }

        return layerVisibilityChanged;
    } 

    /**
     * @return
     */
    public ArrayList<Layer> getAllLayers() {
        //on renvoie tous les layers
        return this.listLayers;
    }

    @Override
    public boolean equals(Object object){
        //on regarde si les 2 variables font référence au meme objet
        if (this == object)
            return true;

        //on regarde si l'objet à comparer est null ou qu'il n'est pas de la meme classe que this
        if (object == null || !this.getClass().equals(object.getClass()))
            return false;
        
        //on vérifie que les valeurs des champs sont identiques
        return this.id == ((Area) object).getId() && this.name == ((Area) object).getName() && Arrays.deepEquals(this.area, ((Area) object).getArea()) && this.listLayers.equals(((Area) object).getAllLayers()) && this.emptyChar == ((Area) object).getEmptyChar() && this.fullChar == ((Area) object).getFullChar();
    }

    /**
     * @return
     */
    public int getNumberOfLayers() {
        //on renvoie le nombre de layers
        return this.listLayers.size();
    }

    public int getId() {
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