package exceptions;

import constants.Constants;

/**
 * The type Module exception.
 */
public class ModuleException extends Exception {
    @Override
    public String getMessage() {
        return Constants.NO_DESCRIPTION;
    }
}
