package data;

import command.action.Action;
import command.action.Port;
import constants.Constants;
import java.util.ArrayList;

public class Data implements Port {

    private ArrayList<Item> items;
    private ArrayList<Item> selection;
    private String listUI;
    private String selUI;
    public boolean isListUpdated;
    public boolean isSelUpdated;

    public Data() {
        items = new ArrayList<>();
        selection = new ArrayList<>();
        isListUpdated = false;
        isSelUpdated = false;
        listUI = "";
        selUI = "";
    }

    public void addItem(Item item) {
        items.add(item);
    }

    public void removeItem(Item item) {
        items.remove(item);
    }

    public void clearList() {
        items.clear();
    }

    public void updateListUI(String string) {
        if (string == null) {
            StringBuilder stringBuilder = new StringBuilder();
            for (Item i : items) {
                stringBuilder.append(i.getName()).append(Constants.LINE_UNIT);
            }
            listUI = stringBuilder.toString();
        } else {
            listUI = string;
        }
        isListUpdated = true;
    }

    public void updateSelUI(String string) {
        if (string == null) {
            StringBuilder stringBuilder = new StringBuilder();
            for (Item i : selection) {
                stringBuilder.append(i.getName()).append(Constants.LINE_UNIT);
            }
            selUI = stringBuilder.toString();
        } else {
            selUI = string;
        }
        isSelUpdated = true;
    }

    public void refresh() {

    }

    public String getListUI() {
        return listUI;
    }

    public String getSelUI() {
        return selUI;
    }

    @Override
    public void accept(Action action) {
        action.act(this);
    }

}
