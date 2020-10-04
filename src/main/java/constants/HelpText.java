package constants;

/**
 * The enum Help text.
 */
public enum HelpText {

    /**
     * The Bye.
     */
    BYE(
            "bye",
            "Quit the program",
            new String[]{
                "bye"
            },
            new String[]{
                "1. \"bye\" >> quits the program"
            }),
    /**
     * The Clear.
     */
    CLEAR(
            "clear",
            "Clear the task list",
            new String[]{
                "clear"
            },
            new String[]{
                "1. \"clear\" >> clears the task list"
            }),
    /**
     * The Deadline.
     */
    DEADLINE(
            "deadline",
            "Add a deadline to the task list",
            new String[]{
                "deadline [description] -by [time]"
            },
            new String[]{
                "1. \"deadline ddl -by 21/9/15 1:12\" >> "
                        + "adds a deadline with description \"ddl\" and time \"Sep 15 2021 1:12\""
            }),
    /**
     * The Delete.
     */
    DELETE(
            "delete",
            "Delete a task from the task list",
            new String[]{
                "delete [index]"
            },
            new String[]{
                "1. \"delete 1\" >> deletes the task with index 1 from the current list"
            }),
    /**
     * The Done.
     */
    DONE(
            "done",
            "Mark a task as done",
            new String[]{
                "done [index]"
            },
            new String[]{
                "1. \"done 1\" >> marks the task with index 1 as done"
            }),
    /**
     * The Event.
     */
    EVENT(
            "event",
            "Add an event to the task list",
            new String[]{
                "event [description] -at [time]"
            },
            new String[]{
                "1. \"event e -at May 13 2020 8:00\" >> "
                        + "adds an event with description \"e\" and time \"May 13 2020 8:00\""
            }),
    /**
     * The Find.
     */
    FIND(
            "find",
            "Find an event in the task list with the specified keyword",
            new String[]{
                "find [keyword]"
            },
            new String[]{
                "1. \"find exam\" >> finds all tasks with the \"exam\" keyword from the task list"
            }),
    /**
     * The Help.
     */
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
    /**
     * The List.
     */
    LIST(
            "list",
            "Print a list of all added tasks/modules",
            new String[]{
                "list",
                "list date [asc / desc / spec \"date\"(any common date format)]",
                "list mod"
            },
            new String[]{
                "1. \"list\" >> list all added tasks",
                "2. \"list date asc\" >> list tasks with a \"date\" field in ascending order",
                "3. \"list date spec Oct 5 2020\" >> list tasks with specific \"date\" field of Oct 5 2020",
                "4. \"list mod\" >> list all the modules"
            }),
    /**
     * The Focus.
     */
    FOCUS(
            "focus",
            "Print a list of all added tasks/modules based on task type",
            new String[]{
                "focus",
                "focus [deadline / todo / event]"
            },
            new String[]{
                "1. \"focus\" >> list all tasks",
                "2. \"focus deadline\" >> list all deadline tasks"
            }),
    /**
     * The Todo.
     */
    TODO(
            "todo",
            "Add a todo to the task list",
            new String[]{
                "todo [description]"
            },
            new String[]{
                "1. \"todo class\" >> adds a todo with description \"class\""
            }),
    /**
     * The Undone.
     */
    UNDONE(
            "undone",
            "Mark a task as undone",
            new String[]{
                "undone [index]"
            },
            new String[]{
                "1. \"undone 1\" >> marks the task with index 1 as undone"
            }),
    /**
     * The Unknown.
     */
    UNKNOWN(
            "unknown",
            "Prints the error message for an unrecognized command for debugging purposes",
            new String[]{
                "unknown"
            },
            new String[]{
                "1. \"unknown\" >> prints \"OOPS, I don't know what that means :-( Try \"help\"!\""
            }),
    /**
     * The Next.
     */
    NEXT(
            "next",
            "Switch the target region to the next page, keeping other regions unchanged.",
            new String[]{
                "next [region]",
                "region: i(item list), s(selection), a(all, default)"
            },
            new String[]{
                "1. \"next\" >> switch both item list and selection region to the next page (default)",
                "2. \"next s\" >> switch only the selection region to the next page"
            }),
    /**
     * The Prev.
     */
    PREV(
            "prev",
            "Switch the target region to the previous page, keeping other regions unchanged.",
            new String[]{
                "prev [region]",
                "region: i(items, default), s(selection), a(all)"
            },
            new String[]{
                "1. \"prev\" >> switch item list to the previous page (default)",
                "2. \"prev s\" >> switch the selection to the previous page"
            }),
    /**
     * The Fancy.
     */
    FANCY(
            "fancy",
            "Switch to a fancy Cli (requires the shell to support ansi codes).",
            new String[]{
                "fancy"
            },
            new String[]{
                "1. \"fancy\" >> switch to a fancy Cli with graphics. Use \"plain\" to switch to plain Cli"
            }),
    /**
     * The Plain.
     */
    PLAIN(
            "plain",
            "Switch to a plain Cli.",
            new String[]{
                "plain"
            },
            new String[]{
                "1. \"plain\" >> switch to a plain pure-text Cli. Use \"fancy\" to switch to fancy Cli"
            }),
    /**
     * The Sel.
     */
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
    /**
     * The Add.
     */
    ADD(
            "add",
            "Add item(s): Add specified item(s) to item list. If item already exists, update it.",
            new String[]{
                "add [-option] [-type] [target(s)] {[-type] [target(s)] ...}",
                "option: {-s(single, default), -m(multiple), -help}",
                "type: {-mod, -task, -help(default)}"
            },
            new String[]{
                "1. \"add -mod CS2113T\" >> add a single module CS2113T to item list",
                "2. \"add -task deadline\" >> add a single task deadline to the item list",
                "3. \"add -m -mod M1 M2 -task T1 T2 \" >> add multiple items: "
                        + "modules M1, M2 and tasks T1, T2 to the item list",
                "4. \"add -help\" >> print the detailed help text for the \"add\" command"
            }),
    /**
     * The Mc.
     */
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
    /**
     * Help commands for CAP
     */
    CAP(
            "cap",
            "Calculate CAP: Calculate CAP for courses based on selected option.",
            new String[]{
                    "cap [-option] [module] [grade] {[module] [grade]...}",
                    "option: {-u(user, default), -m(multiple/custom modules), -help}"
            },
            new String[]{
                    "1. \"cap\" >> calculate user CAP from their past data",
                    "2. \"cap -m M1 G1 M2 G2 \" >> calculate cap based on input modules: "
                            + "modules M1 with grade G1, module M2 with grade G2 correspondingly.",
                    "3. \"cap -help\" >> print the detailed help text for the \"cap\" command"
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

    /**
     * The Name.
     */
    public String name;
    /**
     * The Description.
     */
    public String description;
    /**
     * The Syntax.
     */
    public String[] syntax;
    /**
     * The Usages.
     */
    public String[] usages;

    HelpText(String name, String description, String[] syntax, String[] usages) {
        this.name = name;
        this.syntax = syntax;
        this.description = description;
        this.usages = usages;
    }

    /**
     * Array to string string.
     *
     * @param input the input
     * @return the string
     */
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
