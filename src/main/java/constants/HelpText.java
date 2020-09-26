package constants;

public enum HelpText {

    BYE(
            "bye",
            "Quit the program",
            new String[]{
                "bye"
            },
            new String[]{
                "1. \"bye\" >> quits the program"
            }),
    CLEAR(
            "clear",
            "Clear the task list",
            new String[]{
                "clear"
            },
            new String[]{
                "1. \"clear\" >> clears the task list"
            }),
    DEADLINE(
            "deadline",
            "Add a deadline to the task list",
            new String[]{
                "deadline [description] -by [time]"
            },
            new String[]{
                "1. \"deadline ddl -by 5:00pm\" >> adds a deadline with description \"ddl\" and time \"5:00pm\""
            }),
    DELETE(
            "delete",
            "Delete a task from the task list",
            new String[]{
                "delete [index]"
            },
            new String[]{
                "1. \"delete 1\" >> deletes the task with index 1 from the task list"
            }),
    DONE(
            "done",
            "Mark a task as done",
            new String[]{
                "done [index]"
            },
            new String[]{
                "1. \"done 1\" >> marks the task with index 1 as done"
            }),
    EVENT(
            "event",
            "Add an event to the task list",
            new String[]{
                "event [description] -at [time]"
            },
            new String[]{
                "1. \"event e -at 7:00am\" >> adds an event with description \"e\" and time \"7:00am\""
            }),
    HELP(
            "help",
            "Print the list of available commands, or print the details of a specified command",
            new String[]{
                "help [target]",
                "target: the name of the target command"
            },
            new String[]{
                "1. \"help\" >> prints the list of available commands",
                "2. \"help event\" >> prints the details of the \"event\" command"
            }),
    LIST(
            "list",
            "Print a list of all added tasks",
            new String[]{
                "list"
            },
            new String[]{
                "1. \"list\" >> list all added tasks"
            }),
    TODO(
            "todo",
            "Add a todo to the task list",
            new String[]{
                "todo [description]"
            },
            new String[]{
                "1. \"todo class\" >> adds a todo with description \"class\""
            }),
    UNDONE(
            "undone",
            "Mark a task as undone",
            new String[]{
                "undone [index]"
            },
            new String[]{
                "1. \"undone 1\" >> marks the task with index 1 as undone"
            }),
    UNKNOWN(
            "unknown",
            "Prints the error message for an unrecognized command",
            new String[]{
                "unknown"
            },
            new String[]{
                "1. \"unknown\" >> prints \"OOPS, I don't know what that means :-( Try \"help\"!\""
            }),
    NEXT(
            "next",
            "View next page: Switch the target region to the next page, keeping other regions unchanged.",
            new String[]{
                "next [-option]",
                "option: {-i(items, default), -s(selection), -a(all), -help}"
            },
            new String[]{
                "1. \"next\" >> switch item list to the next page (default)",
                "2. \"next -s\" >> switch the selection to the next page",
                "3. \"next -a\" >> switch both item list and selection to the next page",
                "4. \"next -help\" >> print the detailed help text for the \"next\" command"
            }),
    PREV(
            "prev",
            "View previous page: Switch the target region to the next page, keeping other regions unchanged.",
            new String[]{
                "prev [-option]",
                "option: {-i(items, default), -s(selection), -a(all), -help}"
            },
            new String[]{
                "1. \"prev\" >> switch item list to the previous page (default)",
                "2. \"prev -s\" >> switch the selection to the previous page",
                "3. \"prev -a\" >> switch both item list and selection to the previous page",
                "4. \"prev -help\" >> print the detailed help text for the \"prev\" command"
            }),
    SEL(
            "sel",
            "Make selection: Add specified items to the selection. If no target is specified, print help.",
            new String[]{
                "sel [-option] [target(s)]",
                "option: {-s(single, default), -m(multiple), -help}"
            },
            new String[]{
                "1. \"sel CS2113T\" >> add the item CS2113T on the item list to the selection",
                "2. \"sel -m CS1010 CS2113\" >> add the multiple items: "
                        + "CS1010 and CS2113 on the item list to the selection",
                "3. \"sel -help\" >> print the detailed help text for the \"sel\" command"
            }),
    ADD(
            "add",
            "Add item(s): Add specified item(s) to item list. If item already exists, update it.",
            new String[]{
                "add [-option] [-type] [target(s)] {[-type] [target(s)] ...}",
                "option: {-s(single, default), -m(multiple), -help}",
                "type: {-mod, -task, -help(default)}"
            },
            new String[]{
                "1. \"add -mod CS2113T\" >> adds a single module CS2113T to item list",
                "2. \"add -task deadline\" >> adds a single task deadline to the item list",
                "3. \"add -m -mod M1 M2 -task T1 T2 \" >> add multiple items: "
                        + "modules M1, M2 and tasks T1, T2 to the item list",
                "4. \"add -help\" >> print the detailed help text for the \"add\" command"
            }),
    MC(
            "mc",
            "Print MCs: Print the number of MCs based on selected option.",
            new String[]{
                "mc [-option] [-detail]",
                "option: {-c(current, default), -p(prospective), -help}",
                "detail: {-t(total, default), -d(detailed)}"
            },
            new String[]{
                "1. \"mc\" >> print the total number of MCs currently taking",
                "2. \"mc -p\" >> print the total number of MCs in the selection region",
                "3. \"mc -p -d \" >> print the detailed MC composition of the selection region",
                "4. \"mc -help\" >> print the detailed help text for the \"mc\" command"
            }),
    /*LIST(
            "list",
            "List items: print the list of items in the list region.",
            new String[]{
                "list [-option] [-range]",
                "option: {-mod, -task, -cmd(commands), -all, -help(default)}",
                "range: {-all(default), -sel(selected)}"
            },
            new String[]{
                "1. \"list -mod -all\" >> list all modules available",
                "2. \"list -task -sel\" >> list selected tasks",
                "3. \"list -cmd\" >> list all possible commands",
                "4. \"list -help\" >> print the detailed help text for the \"list\" command"
            })*/
    ;

    public String name;
    public String description;
    public String[] syntax;
    public String[] usages;

    HelpText(String name, String description, String[] syntax, String[] usages) {
        this.name = name;
        this.syntax = syntax;
        this.description = description;
        this.usages = usages;
    }

    public String arrayToString(String[] input) {
        StringBuilder stringBuilder = new StringBuilder();
        for (String string: input) {
            stringBuilder.append(string).append(Constants.WIN_NEWLINE);
        }
        return stringBuilder.toString();
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder("Name:");
        stringBuilder.append(Constants.SPACE).append(name).append(Constants.WIN_NEWLINE);
        stringBuilder.append("Description:").append(Constants.SPACE).append(
                description).append(Constants.WIN_NEWLINE);
        stringBuilder.append("Syntax:").append(Constants.WIN_NEWLINE).append(arrayToString(syntax));
        stringBuilder.append("Usages:").append(Constants.WIN_NEWLINE).append(arrayToString(usages));
        return stringBuilder.toString();
    }
}
