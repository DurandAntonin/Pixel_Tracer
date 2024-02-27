import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

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
    private List<Integer> intParams;

    /**
     * 
     */
    private List<String> strParams;

    /**
     * 
     */
    private List<Float> floatParams;

    /**
     * 
     */
    private Integer maxParamNumber;

    /**
     * 
     */
    private List<String> listErrorMessages;

    public Command(String parName){
        
    }

    /**
     * @param p 
     * @return
     */
    public void addIntParam(Integer p) {
        // TODO implement here
        return;
    }

    /**
     * @param p 
     * @return
     */
    public void addFloatParam(Float p) {
        // TODO implement here
        return;
    }

    /**
     * @param p 
     * @return
     */
    public void addStrParam(String p) {
        // TODO implement here
        return;
    }

    /**
     * @return
     */
    public void freeCmd() {
        // TODO implement here
        return;
    }

    public boolean checkNbParams(Integer nbStrParams, Integer nbIntParams, Integer nbFloatParams){
        return true;
    }

    public boolean checkNbParamsPolygon(Integer nbStrParams, Integer nbIntParams, Integer nbFloatParams){
        return true;
    }

    /**
     * @param app 
     * @return
     */
    public Integer readExecCommand(Pixel_tracer app) {
        int resultCommand = 7;

        //on demande à l'utilisateur d'entrer une valeur
        Scanner scanner = new Scanner(System.in);

        //on récupère la valeur entrée par l'utilisateur
        String input = scanner.nextLine();
        System.out.println("Valeur entrée : " + input);

        //on arrete la mise à l'écoute de l'input
        //scanner.close();

        return resultCommand;
    }

    /**
     * @return
     */
    public void readFromStdin() {
        // TODO implement here
        return;
    }

    public String getName() {
        return this.name;
    }

    public ArrayList<Integer> getIntParams() {
        return (ArrayList<Integer>) this.intParams;
    }

    public ArrayList<String> getStrParams() {
        return (ArrayList<String>) this.strParams;
    }


    public ArrayList<Float> getFloatParams() {
        return (ArrayList<Float>) this.floatParams;
    }

    public Integer getMaxParamNumber() {
        return this.maxParamNumber;
    }

    public ArrayList<String> getListErrorMessages() {
        return (ArrayList<String>) this.listErrorMessages;
    }
}