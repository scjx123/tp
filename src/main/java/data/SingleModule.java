package data;

import constants.Constants;

/**
 * The type Single module.
 */
public class SingleModule extends Item {

    /**
     * The Module code.
     */
    public String moduleCode;
    /**
     * The Module mc.
     */
    public String moduleMC;
    /**
     * The Module name.
     */
    public String moduleName;
    /**
     * The Module description.
     */
    public String moduleDescription;
    /**
     * The Module prerequisite.
     */
    public String modulePrerequisite;

    /**
     * Instantiates a new Single module.
     *
     * @param code        the code
     * @param name        the name
     * @param description the description
     * @param mc          the mc
     * @param prereq      the prereq
     */
    public SingleModule(String code, String name, String description, String mc, String prereq) {
        super(code); //moduleDescription is handle here.
        this.moduleCode = code;
        this.moduleDescription = description;
        this.moduleName = name;
        this.moduleMC = mc;
        this.modulePrerequisite = prereq;
    }

    @Override
    public String getName() {
        return moduleCode;
    }

    @Override
    public String toString() {
        return moduleCode + Constants.SPACE + moduleName + Constants.SPACE + moduleMC;
    }

    /**
     * Gets module description.
     *
     * @return the module description
     */
    public String getModuleDescription() {
        return moduleDescription;
    }

    /**
     * Gets module mc.
     *
     * @return the module mc
     */
    public String getModuleMC() {
        return moduleMC;
    }

    /**
     * Gets module prerequisite.
     *
     * @return the module prerequisite
     */
    public String getModulePrerequisite() {
        return modulePrerequisite;
    }



}
