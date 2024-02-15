import java.util.*;

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

    /**
     * @param app 
     * @return
     */
    public Integer readExecCommand(Pixel_tracer app) {
        // TODO implement here
        return null;
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

    public List<Integer> getIntParams() {
        return this.intParams;
    }

    public List<String> getStrParams() {
        return this.strParams;
    }


    public List<Float> getFloatParams() {
        return this.floatParams;
    }

    public Integer getMaxParamNumber() {
        return this.maxParamNumber;
    }

    public List<String> getListErrorMessages() {
        return this.listErrorMessages;
    }
}