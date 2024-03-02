import java.util.ArrayList;
import java.util.Scanner;

import org.junit.Test.None;

/**
 * 
 */
public class Command {

    /**
     * 
     */
    private String name;

    /**
     * 
     */
    private ArrayList<Integer> intParams;

    /**
     * 
     */
    private ArrayList<String> strParams;

    /**
     * 
     */
    private ArrayList<Float> floatParams;

    /**
     * 
     */
    private final Integer maxParamNumber;

    /**
     * 
     */
    private final String[] listErrorMessages;


    public Command(String parName){
        //on initialise les champs
        this.name = parName;
        this.intParams = new ArrayList<>();
        this.floatParams = new ArrayList<>();
        this.strParams = new ArrayList<>();
        this.maxParamNumber = 30;
        this.listErrorMessages = new String[]{
            "",
            "commande inconnue",
            "commande manquante",
            "erreur paramètres, consulter la commande help",
            "exit",
            "clear",
            "plot",
            "~~~ Help ~~~",
            "done",
            "id inconnu dans la list"
        };
    }

    /**
     * @param intParam 
     * @return
     */
    public void addIntParam(Integer intParam) {
        this.intParams.add(intParam);
    }

    /**
     * @param floatParam 
     * @return
     */
    public void addFloatParam(Float floatParam) {
        this.floatParams.add(floatParam);
    }

    /**
     * @param stringParam 
     * @return
     */
    public void addStrParam(String stringParam) {
        this.strParams.add(stringParam);
    }

    public void clearParamList(){
        //on clear les listes des paramètres de la commande
        this.strParams = new ArrayList<>();
        this.intParams = new ArrayList<>();
        this.floatParams = new ArrayList<>();
    }

    public boolean checkNbParams(int nbStrParams, int nbIntParams, int nbFloatParams){
        //on vérifie que le nombre de paramètres est correct
        return this.strParams.size() == nbStrParams && this.intParams.size() == nbIntParams && this.floatParams.size() == nbFloatParams;
    }

    public boolean checkNbParamsPolygon(){
        //on vérifie que le nombre de paramètres d'une commande polygon est correct
        return this.getStrParams().size() == 1 && this.floatParams.size() == 0 && this.intParams.size() >= 2 && this.intParams.size() <= this.maxParamNumber && this.intParams.size()%2 == 0 ;
    }

    /**
     * @return
     */
    public void readFromStdin() {
        //on demande à l'utilisateur d'entrer une valeur
        Scanner scanner = new Scanner(System.in);
        System.out.print("-> Saisie : ");

        //on récupère la valeur entrée par l'utilisateur
        String input = scanner.nextLine();
        //System.out.println("-> Valeur entrée : " + input);
 
        //on arrete la mise à l'écoute de l'input
        //scanner.close();
        
        //on split la commande
        String[] command = input.split(" ");


        //pour chaque valeur de la commande, on regarde si c'est un string, int ou float
        for (String param : command) {
            boolean isInt = false;
            boolean isFloat = false;
            int intParam = -1;
            float fltParam = (float) -1.0;
            try{
                intParam = Integer.parseInt(param);
                isInt = true;
            }
            catch(NumberFormatException e){
                isInt = false;
            }

            try{
                fltParam = Float.parseFloat(param);
                isFloat = true;
            }
            catch(NumberFormatException e){
                isFloat = false;
            }

            if (isInt)
                this.addIntParam(intParam);
            else if (isFloat)
                this.addFloatParam(fltParam);
            else
                this.addStrParam(param);
        }
    }

    /**
     * @param app 
     * @return
     */
    public int readExecCommand(Pixel_tracer app) {
        int resultCommand = 3;

        //on récupère ce que le user a saisi
        this.readFromStdin();

        //System.out.println("\n");
        //System.out.println("Liste stringParam : " + this.strParams);
        //System.out.println("Liste intParam : " + this.intParams);
        //System.out.println("Liste floatParam : " + this.floatParams);

        //on vérifie que le user a au moins entré le nom d'une commande
        if (this.strParams.size() > 0){
            String commandName = this.strParams.get(0);

            //on regarde quelle commande le user a entré
            switch (commandName) {
                case "clear":
                    //on vérifie que le nombre de paramètres est correct
                    if (this.checkNbParams(1, 0, 0)){
                        resultCommand = 5;
                    }
                    else{
                        resultCommand = 3;
                    }
                    break;

                case "exit":
                    if (this.checkNbParams(1, 0, 0)){
                        resultCommand = 4;
                    }
                    else{
                        resultCommand = 3;
                    }
                    break;

                case "help":
                    if (this.checkNbParams(1, 0, 0)){
                        resultCommand = 7;
                    }
                    else{
                        resultCommand = 3;
                    }
                    break;

                case "plot":
                    if (this.checkNbParams(1, 0, 0)){
                        //on affiche l'area actuelle
                        app.drawCurrentArea();
                        resultCommand = 6;
                    }
                    else{
                        resultCommand = 3;
                    }
                    break;

                case "point":
                    if (this.checkNbParams(1, 2, 0)){
                        //on récupère les id de chaque form pris
                        ArrayList<Shape> listShapesInLayer = app.getCurrentLayer().getListShapes();
                        ArrayList<Integer> listId = new ArrayList<>();
                        for (Shape shape : listShapesInLayer) {
                            listId.add(shape.getId());
                        }

                        int pointId = app.getIdForNewElem(listId);

                        //on créé une nouvelle forme qu'on ajoute dans le layer sélectionnée
                        Point point = new Point(pointId, COLOR.BLACK, 1, this.intParams.get(0), this.intParams.get(1));
                        app.addShapeToCurrentLayer(point);
                        resultCommand = 0;
                    }
                    else{
                        resultCommand = 3;
                    }
                    break;

                case "line":
                    if (this.checkNbParams(1, 4, 0)){
                        //on récupère les id de chaque form pris
                        ArrayList<Shape> listShapesInLayer = app.getCurrentLayer().getListShapes();
                        ArrayList<Integer> listId = new ArrayList<>();
                        for (Shape shape : listShapesInLayer) {
                            listId.add(shape.getId());
                        }
                        
                        int lineId = app.getIdForNewElem(listId);

                        //on créé une nouvelle forme qu'on ajoute dans le layer sélectionnée
                        Point point1 = new Point(this.intParams.get(0), this.intParams.get(1));
                        Point point2 = new Point(this.intParams.get(2), this.intParams.get(3));
                        Line line = new Line(lineId, COLOR.BLACK, 1, point1, point2);
                        app.addShapeToCurrentLayer(line);

                        resultCommand = 0;
                    }
                    else{
                        resultCommand = 3;
                    }
                    break;

                case "square":
                    if (this.checkNbParams(1, 3, 0)){
                        //on créé l'id pour cette forme
                        ArrayList<Shape> listShapesInLayer = app.getCurrentLayer().getListShapes();
                        ArrayList<Integer> listId = new ArrayList<>();
                        for (Shape shape : listShapesInLayer) {
                            listId.add(shape.getId());
                        }

                        int squareId = app.getIdForNewElem(listId);

                        //on créé une nouvelle forme qu'on ajoute dans le layer sélectionnée
                        Point point = new Point(this.intParams.get(0), this.intParams.get(1));
                        int length = this.intParams.get(2);
                        Square square = new Square(squareId, COLOR.BLACK, 1, point, length);
                        app.addShapeToCurrentLayer(square);

                        resultCommand = 0;
                    }
                    else{
                        resultCommand = 3;
                    }
                    break;

                case "rectangle":
                    if (this.checkNbParams(1, 4, 0)){
                        //on créé un id pour cette forme
                        ArrayList<Shape> listShapesInLayer = app.getCurrentLayer().getListShapes();
                        ArrayList<Integer> listId = new ArrayList<>();
                        for (Shape shape : listShapesInLayer) {
                            listId.add(shape.getId());
                        }

                        int newRectangleId = app.getIdForNewElem(listId);

                        //on créé une nouvelle forme qu'on ajoute dans le layer sélectionnée
                        Point point = new Point(this.intParams.get(0), this.intParams.get(1));
                        int width = this.intParams.get(2);
                        int height = this.intParams.get(3);
                        Rectangle rectangle = new Rectangle(newRectangleId, COLOR.BLACK, 1, point, width, height);
                        app.addShapeToCurrentLayer(rectangle);

                        resultCommand = 0;
                    }
                    else{
                        resultCommand = 3;
                    }
                    break;

                case "circle":
                    if (this.checkNbParams(1, 3, 0)){
                        //on créé l'id pour cette forme
                        ArrayList<Shape> listShapesInLayer = app.getCurrentLayer().getListShapes();
                        ArrayList<Integer> listId = new ArrayList<>();
                        for (Shape shape : listShapesInLayer) {
                            listId.add(shape.getId());
                        }
 
                        int circleId = app.getIdForNewElem(listId);

                        //on créé une nouvelle forme qu'on ajoute dans le layer sélectionnée
                        Point point = new Point(this.intParams.get(0), this.intParams.get(1));
                        int radius = this.intParams.get(2);
                        Circle circle = new Circle(circleId, COLOR.BLACK, 1, point, radius);
                        app.addShapeToCurrentLayer(circle);

                        resultCommand = 0;
                    }
                    else{
                        resultCommand = 3;
                    }
                    break;

                case "polygon":
                    if (this.checkNbParamsPolygon()){
                        //on créé une nouvelle forme qu'on ajoute dans le layer sélectionnée

                        //on créé l'id pour cette forme
                        ArrayList<Shape> listShapesInLayer = app.getCurrentLayer().getListShapes();
                        ArrayList<Integer> listId = new ArrayList<>();
                        for (Shape shape : listShapesInLayer) {
                            listId.add(shape.getId());
                        }

                        int polygonId = app.getIdForNewElem(listId);

                        //on créé une liste de points en fonction des coordonnées entrées dans la commande
                        ArrayList<Point> pointList = new ArrayList<>();
                        for (int i=0; i<this.intParams.size()-1; i+=2){
                            pointList.add(new Point(this.intParams.get(i), this.intParams.get(i+1)));
                        }
                        Polygon polygon = new Polygon(polygonId, COLOR.BLACK, 1, pointList);
                        app.addShapeToCurrentLayer(polygon);

                        resultCommand = 0;
                    }
                    else{
                        resultCommand = 3;
                    }
                    break;

                case "curve":
                    if (this.checkNbParams(1, 8, 0)){
                        //on créé une nouvelle forme qu'on ajoute dans le layer sélectionnée
                        Point point1 = new Point(this.intParams.get(0), this.intParams.get(1));
                        Point point2 = new Point(this.intParams.get(2), this.intParams.get(3));
                        Point point3 = new Point(this.intParams.get(4), this.intParams.get(5));
                        Point point4 = new Point(this.intParams.get(6), this.intParams.get(7));

                        Curve curve = new Curve(point1, point2, point3, point4);
                        app.addShapeToCurrentLayer(curve);

                        resultCommand = 0;
                    }
                    else{
                        resultCommand = 3;
                    }
                    break;

                case "list":
                    if (this.checkNbParams(2, 0, 0)){
                        //on regarde s'il faut affiche la liste des areas, layers de l'area sélectionnée ou shape de l'area sélectionnée
                        String elemToDisplay = this.strParams.get(1).toLowerCase();

                        switch (elemToDisplay) {
                            case "layers":
                                //on affiche la liste des layers de l'area sélectionnée
                                ArrayList<Layer> listLayers = app.getCurrentArea().getAllLayers();
                                for(int i=0;i<listLayers.size();i++){
                                    System.out.println(listLayers.get(i) + "\n");
                                }
                                resultCommand = 8;
                                break;

                            case "areas":
                                //on affiche la liste des areas
                                ArrayList<Area> listAreas = app.getListArea();
                                for(int i=0;i<listAreas.size();i++){
                                    System.out.println(listAreas.get(i) + "\n");
                                }
                                resultCommand = 8;
                                break;

                            case "shapes":
                                //on affiche la liste des formes de l'ara sélectionnée
                                ArrayList<Shape> listeShapes = app.getCurrentLayer().getListShapes();
                                for(int i=0;i<listeShapes.size();i++){
                                    System.out.println(listeShapes.get(i) + "\n");
                                }
                                resultCommand = 8;
                                break;
                        
                            default:
                                resultCommand = 3;
                                break;
                        }
                    }
                    else{
                        resultCommand = 3;
                    }
                    break;

                case "select":
                    if (this.checkNbParams(2, 1, 0)){
                        //on regarde quel élément sélectionner
                        String elemToSelect = this.strParams.get(1).toLowerCase();
                        int idElemToSelect = this.intParams.get(0);
                        boolean resultSelectElem = false;

                        switch (elemToSelect) {
                            case "area":
                                //on sélectionne une nouvelle area et on retourne une erreur si cette dernière n'existe pas
                                resultSelectElem = app.selectArea(idElemToSelect);
                                resultCommand = 8;
                                break;

                            case "layer":
                                //on sélectionne un nouveau layer de l'area sélectionnée et on retourne une erreur si ce dernier n'existe pas
                                resultSelectElem = app.selectLayer(idElemToSelect);
                                resultCommand = 8;
                                break;
                        
                            default:
                                resultCommand = 3;
                                break;
                        }

                        //on regarde s'il y a eu une erreur ou non
                        if (resultCommand != 3 && resultSelectElem)
                            resultCommand = 8;
                        else if (resultCommand != 3 && !resultSelectElem)
                            resultCommand = 9;
                        
                    }
                    else{
                        resultCommand = 3;
                    }
                    break;

                case "delete":
                    if (this.checkNbParams(2, 1, 0)){
                        //on regarde quel élément il faut supprimer
                        String elemToDelete = this.strParams.get(1).toLowerCase();
                        int idElemToDelete = this.intParams.get(0);

                        switch (elemToDelete) {
                            case "area":
                                //on affiche la liste des layers de l'area sélectionnée
                                boolean isAreadDeleted = app.deleteArea(idElemToDelete);

                                //on vérifie que la suppression a bien été effectuée
                                if (isAreadDeleted)
                                    resultCommand = 8;
                                else
                                    resultCommand = 9;
                                break;

                            case "layer":
                                //on supprime le layer de l'area sélectionnée
                                boolean isLayerDeleted = app.deleteLayerInCurrentArea(idElemToDelete);
                                
                                //on vérifie que la suppression a bien été effectuée
                                if (isLayerDeleted)
                                    resultCommand = 8;
                                else
                                    resultCommand = 9;
                                break;

                            case "shape":
                                //on supprime la shape du layer sélectionnée
                                boolean isShapeDeleted = app.deleteShapeInCurrentLayer(idElemToDelete);

                                //on vérifie que la suppression a bien été effectuée
                                if (isShapeDeleted)
                                    resultCommand = 8;
                                else
                                    resultCommand = 10;
                                break;
                        
                            default:
                                resultCommand = 3;
                                break;
                        }
                    }
                    else{
                        resultCommand = 3;
                    }
                    break;

                case "new":
                    if (this.checkNbParams(2, 0, 0)){
                        //on regarde quel élément il faut créer
                        String elemToCreate = this.strParams.get(1).toLowerCase();
                        ArrayList<Integer> listId;

                        switch (elemToCreate) {
                            case "area":
                                //on calcule l'id pour la nouvelle area
                                ArrayList<Area> listAreaInLayer = app.getListArea();
                                listId = new ArrayList<>();
                                for (Area area : listAreaInLayer) {
                                    listId.add(area.getId());
                                }

                                int newAreaId = app.getIdForNewElem(listId);

                                //on créé une nouvelle area
                                app.createArea(newAreaId, "Area " + newAreaId);
                                resultCommand = 8;
                                break;

                            case "layer":
                                //on calcule l'id pour le nouveau layer
                                ArrayList<Layer> listLayerInLayer = app.getCurrentArea().getAllLayers();
                                listId = new ArrayList<>();
                                for (Layer layer : listLayerInLayer) {
                                    listId.add(layer.getId());
                                }

                                int newLayerId = app.getIdForNewElem(listId);

                                //on créé un nouveau layer dans l'area sélectionnée
                                app.createLayerInCurrentArea(newLayerId);
                                resultCommand = 8;
                                break;
                        
                            default:
                                resultCommand = 3;
                                break;
                        }
                    }
                    else{
                        resultCommand = 3;
                    }
                    break;

                case "set":
                    if (this.checkNbParams(3, 1, 0)){
                        //on regarde si le set concerne un layer ou un char
                        String elemToSet = this.strParams.get(1).toLowerCase();

                        switch (elemToSet) {
                            case "char":
                                //TODO
                                break;

                            case "layer":
                                int idLayer = this.intParams.get(0);
                                String newLayerVisibility = this.strParams.get(2).toLowerCase();
                                boolean resultChangeLayerVisibility = false;

                                //on regarde s'il faut rendre visible le layer ou non
                                switch (newLayerVisibility) {
                                    case "visible":
                                        //on met le layer visible
                                        resultChangeLayerVisibility = app.changeLayerVisibilityInCurrentArea(idLayer, true);
                                        break;

                                    case "unvisible":
                                        //on met le layer invisible
                                        resultChangeLayerVisibility = app.changeLayerVisibilityInCurrentArea(idLayer, false);
                                        break;
                                
                                    default:
                                        resultCommand = 3;
                                        break;
                                }

                                //on vérifie que le changement a bien été effectué
                                if (resultChangeLayerVisibility)
                                    resultCommand = 8;
                                else
                                    resultCommand = 9;
                                break;
                        
                            default:
                                resultCommand = 3;
                                break;
                        }
                    }
                    else{
                        resultCommand = 3;
                    }
                    break;
            
                default:
                    break;
            }
       }
       else{
            resultCommand = 2;
       }

       //on clear les listes des paramètres de la commande
       this.clearParamList();

        return resultCommand;
    }

    public String getName() {
        return this.name;
    }

    public ArrayList<Integer> getIntParams() {
        return this.intParams;
    }

    public ArrayList<String> getStrParams() {
        return this.strParams;
    }


    public ArrayList<Float> getFloatParams() {
        return this.floatParams;
    }

    public int getMaxParamNumber() {
        return this.maxParamNumber;
    }

    public String[] getListErrorMessages() {
        return this.listErrorMessages;
    }
}