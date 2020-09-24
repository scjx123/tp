package data;

public class Module extends Item {

    private String code;

    public Module(String code, String description) {
        super(description);
        this.code = code;
    }

    @Override
    public String getName() {
        return code;
    }

}
