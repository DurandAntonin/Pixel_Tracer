import java.util.ArrayList;

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
    private ArrayList<Shape> listShapes;

    /**
     * @param parId 
     * @param parName
     */
    public Layer(int parId, String parName) {
        //on initialise les champs
        this.id = parId;
        this.name = parName;
        this.listShapes = new ArrayList<>();

        //le layer est par défaut visible
        this.visible = true;
    }

    /**
     * @return
     */
    public void setLayerVisibility(boolean newVisibility) {
        this.visible = newVisibility;
    }

    /**
     * @param shapeToAdd 
     * @return
     */
    public void addShapeToLayer(Shape shapeToAdd) {
        this.listShapes.add(shapeToAdd);
    }

    /**
     * @param shapeIdToRemove 
     * @return
     */
    public boolean removeShapeFromLayer(int shapeIdToRemove) {
        boolean isShapeDeleted = false;

        //on supprime la forme en fonction de son id
        for (int i=0; i<this.listShapes.size(); i++){
            if (this.listShapes.get(i).getId() == shapeIdToRemove){
                this.listShapes.remove(i);
                isShapeDeleted = true;
                break;
            }
        }

        return isShapeDeleted;
    }

    /**
     * @return
     */
    public void deleteAllShapeFromLayer() {
        this.listShapes = new ArrayList<>();
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
        return this.id == ((Layer) object).getId() && this.name == ((Layer) object).getName() && this.visible == ((Layer) object).getVisible() && this.listShapes.equals(((Layer) object).getListShapes());

    }

    public String toString(){
        String layerString = "Layer [id: " + this.id + ", name: " + this.name + ", visible: " + this.visible + ", listShapes: [";
        
        //on affiche chaque forme du layer
        for (Shape shape : this.listShapes) {
            layerString += shape.toString() + ", ";
        }

        //on enleve la virgule et l'espace en trop s'il y a des formes
        if (this.listShapes.size() > 0)
            layerString = layerString.substring(0, layerString.length()-2);

        layerString += "]]";

        return layerString;
    }

    public int getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public Boolean getVisible() {
        return this.visible;
    }


    public ArrayList<Shape> getListShapes() {
        return this.listShapes;
    }

}