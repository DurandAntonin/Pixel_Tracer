import java.util.ArrayList;
import java.util.List;

public class Command{
    private String name;
    private final int maxParams = 30;
    private List<Integer> intParams;
    private List<String> strParams;
    private List<Float> floatParams;
    private int errorNum;
    private String errorMessages[];

    public Command(){
        intParams = new ArrayList<>();
        strParams = new ArrayList<>();
        floatParams = new ArrayList<>();
        errorNum = 0;
        errorMessages = new String[] {"", "commande inconnue", "commande manquante", "erreur paramètres, consulter la commande help", "exit", "clear", "plot", "~~~ Help ~~~", "done", "id inconnu dans la list"};
    }

    public void addIntParam(Integer newIntParam){
        //on vérifie qu'on n'a pas dépassé le nombre max de paramètres
        if (intParams.size() < maxParams-1){
            intParams.add(newIntParam);
        }
    }

    public void addStrParam(String newStrParam){
        //on vérifie qu'on n'a pas dépassé le nombre max de paramètres
        if (strParams.size() < maxParams-1){
            strParams.add(newStrParam);
        }
    }

    public void addFloatParam(Float newFloatParam){
        //on vérifie qu'on n'a pas dépassé le nombre max de paramètres
        if (floatParams.size() < maxParams-1){
            floatParams.add(newFloatParam);
        }
    }
}

