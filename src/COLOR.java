
/**
 * 
 */
public enum COLOR {
    RESET("\033[0m"),
    WHITE("\033[0;37m"),
    BLACK("\033[0;30m"),
    RED("\033[0;31m"),
    GREEN("\033[0;32m"),
    PURPLE("\033[0;35m"),
    YELLOW("\033[0;33m"),
    BLUE("\033[0;34m"),
    CYAN("\033[0;36m");

    private String value;

    private COLOR(String parValue) {
        this.value = parValue;
    }

    public String getValue() {
        return this.value;
    }
}