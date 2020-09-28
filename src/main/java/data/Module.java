package data;

/**
 * The type Module.
 */
public class Module extends Item {

    private String code;

    /**
     * Instantiates a new Module.
     *
     * @param code        the code
     * @param description the description
     */
    public Module(String code, String description) {
        super(description);
        this.code = code;
    }

    @Override
    public String getName() {
        return code;
    }

}
