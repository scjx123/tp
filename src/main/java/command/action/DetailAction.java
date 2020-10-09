package command.action;

import command.ParamNode;
import constants.Constants;
import data.Item;
import data.SingleModule;
import data.Data;
import data.jobs.Task;
import exceptions.CommandException;
import exceptions.InvalidCommandException;
import exceptions.ModuleNotFoundException;

import java.net.MalformedURLException;
import java.util.ArrayList;

public class DetailAction extends TakeAction {

    @Override
    protected void modifyObject(Item item) {
        // do nothing
    }

    @Override
    protected String getObjectInfo(Item item) {
        return item.getDetails();
    }

}
