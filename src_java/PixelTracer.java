import java.util.List;
import java.util.ArrayList;

public class PixelTracer {
    private List<Area> listArea;
    private Area currentArea;
    private Layer currentLayer;
    private Shape currentShape;
    private final String emptyChar = ".";
    private final String fullChar = "@"; 

    public PixelTracer(){
        //on créé une area par défaut
        listArea = new ArrayList<>();
        Area defaultArea = new Area(80, 40, listArea.size(), "Area1");
        listArea.add(defaultArea);

        //on créé un layer par défaut dans l'area
        Layer defaultLayer = new Layer(defaultArea.getNumberOfLayers(), "Layer 1");
        defaultArea.addLayerToList(defaultLayer);

        //on sélectionne l'area et le layer par défaut
        currentArea = defaultArea;
        currentLayer = defaultLayer;
        currentShape = null;
    }

    public void destroyApp(){
        //on supprime l'area et on remet à zero 
        listArea = new ArrayList<>();
        currentArea = null;
        currentLayer = null;
        currentShape = null;
    }

    public void clearScreen(){
        final String os = System.getProperty("os.name");
        
        try{
            if (os.contains("Windows"))
            {
                Runtime.getRuntime().exec("cls");
            }
            else
            {
                Runtime.getRuntime().exec("clear");
            }
        }
        catch(Exception e){
            System.out.println(e);
        }
    }

    public void drawArea(){
        
    }

    public void printArea(){
        //on affiche l'area
        if (currentArea != null){
            currentArea.printArea();
        }
    }

    public void clearArea(){
        //on remet l'affichage a zero sans les shapes
        if (currentArea != null){
            currentArea.initArea();
        }
    }

    public void eraseArea(){
        //on supprime les shapes de chaque layer pour l'area actuelle
        if (currentArea != null){
            ArrayList<Layer> listLayers = currentArea.getAllLayers();
            for (Layer layer : listLayers){
                layer.deleteAllShapeFromLayer();
            }

        }
    }

    public void deleteArea(){
        //supprime l'area actuelle 
        if (currentArea != null){
            listArea.remove(currentArea);
            currentArea = null;
        }
    }
}
