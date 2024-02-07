import java.util.ArrayList;

public class Area{
    private Integer id;
    private String name;
    private String[][] area;
    private ArrayList<Layer> listLayers;
    private final String emptyChar = ".";
    private final String fullChar = "@";

    public Area(int parWidth, int parWeight, Integer parId, String parName){
        id = parId;
        name = parName;
        area = new String[parWeight][parWidth];
        listLayers = new ArrayList<>();

        //on initialise l'area avec des pixels vide
        initArea();
    }

    public void initArea(){
        for (int i=0; i<area.length;i++){
            for (int j=0;j<area[i].length;j++){
                area[i][j] = emptyChar;
            }
        }
    }

    public void drawArea(){
        //fonctions draw_all_layers + draw_layer_shapes
        //stocke dans l'area chaque forme de chaque layers
    }

    public void printArea(){
        for (int i=0;i<area.length;i++){
            for (int j=0;j<area[i].length;i++){
                System.out.println(area[i][j]);
            }
            System.out.println("\n");
        }
    }

    public void deleteLayer(Layer layerToDelete){
        //on supprime de la liste le layer
        listLayers.remove(layerToDelete);
    }

    public ArrayList<Layer> getAllLayers(){
        return listLayers;
    }

    public Integer getNumberOfLayers(){
        return listLayers.size();
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