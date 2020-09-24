package command.action;

import command.ParamNode;
import data.Data;

public interface Action {

    void act(Data tasks);
    void prepare(ParamNode args);

}
