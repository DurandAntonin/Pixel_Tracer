import java.util.ArrayList;
import java.util.List;

public class Area{
    private String id;
    private String name;
    private int width;
    private int height;
    private List<List<String>> area;
    private List<Layer> listLayers;
    private String emptyChar;
    private String fullChar;

    public Area(int parWidth, int parWeight, String parId, String parName){
        id = parId;
        name = parName;
        width = parWidth;
        height = parWeight;
        area = new ArrayList<>();
        listLayers = new ArrayList<>();
        emptyChar = ".";
        fullChar = "@";
    }

    public void deleteLayer(Layer layerToDelete){
        //on supprime de la liste le layer
        listLayers.remove(layerToDelete);
    }

    public void deleteLayersList(){
        //on supprime les layers de l'area
        listLayers = new ArrayList<>();
    }

    public void addLayerToList(Layer layerToAdd){
        //on ajoute un nouveau layer à l'area
        listLayers.add(layerToAdd);
    }
}