package data;

public class SingleModule extends Item {

    public String moduleCode;
    public String moduleMC;
    public String moduleName;
    public String moduleDescription;
    public String modulePrerequisite;

    public SingleModule(String code, String name, String description, String mc, String prereq) {
        super(code); //moduleDescription is handle here.
        this.moduleDescription = description;
        this.moduleName = name;
        this.moduleMC = mc;
        this.modulePrerequisite = prereq;
    }

    @Override
    public String getName() {
        return moduleCode;
    }

    public String getModuleDescription() {
        return moduleDescription;
    }

    public String getModuleMC() {
        return moduleMC;
    }

    public String getModulePrerequisite() {
        return modulePrerequisite;
    }



}
