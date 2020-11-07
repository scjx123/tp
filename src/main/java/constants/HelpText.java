//@@author TomLBZ

package constants;

/**
 * The enum Help text.
 */
public enum HelpText {

    /**
     * The Add.
     */
    ADD(
        "add",
        "Add task(s) to module(s): Add specified task(s) to specified module(s).",
        new String[]{
            "add -task [index(es)] -mod [module code(s)]",
        },
        new String[]{
            "1. Index should be a positive integer. Otherwise you should expect an \"invalid command\" error message",
            "2. You must reference existing tasks or modules when using this command. For example:",
            "2.1. If \"list\" shows only 2 tasks but you try to use \"-task 3\" as a parameter for \"add\", you should "
                + "expect an \"index out of range\" error message because \"3\" is out of range for your task list.",
            "2.2. Similarly, if there is no mod called CS9999 in the module list and you try to use "
                + "\"-mod CS9999\" as a parameter for \"add\", you should expect a \"not found\" error message.",
        },
        new String[]{
            "1. \"add -task 1 2 -mod CS2113 CS2113T \" >> add task 1 and task 2 in the current list to "
                + "the modules CS2113 and CS2113T",
        }),
    /**
     * The Bye.
     */
    BYE(
        "bye",
        "Quit the program",
        new String[]{
            "bye"
        },
        new String[]{ "", },
        new String[]{
            "1. \"bye\" >> quits the program"
        }),
    /**
     * Help commands for CAP.
     */
    CAP(
        "cap",
        "Calculate CAP for courses based on selected option.",
        new String[]{
            "cap [index / code (for modules only)] [grade] ...",
            "cap [index(es) / codes (for modules only)]",
            "cap"
        },
        new String[]{ "", },
        new String[]{
            "1. \"cap CS2113 A CG1112 A-\" >> calculate the cap using A for CS2113 and A- for CG1112",
            "2. \"cap CS2113 CG1112\" >> calculate the cap using existing grades for CS2113 and CG1112 "
                    + "if they have already been assigned a grade using the \"grade\" command",
            "3. \"cap\" >> calculate the cap using all taken and graded modules",
            "4. \"cap CG1111 CG1112 A\" >> calculated cap using existing grade for CG1111, and using A for CG1112",
        }),
    /**
     * The Clear.
     */
    CLEAR(
        "clear",
        "Clear the task list, or clear the bottom text region for the fancy UI.",
        new String[]{
            "clear",
            "clear fancy",
        },
        new String[]{ "", },
        new String[]{
            "1. \"clear\" >> clears the task list",
            "2. \"clear fancy\" >> clears the bottom region of the fancy UI",
        }),
    /**
     * The Complete.
     */
    COMPLETE(
        "complete",
        "Mark a module as completed",
        new String[]{
            "complete [index / code]"
        },
        new String[]{ "", },
        new String[]{
            "1. \"complete CS2113\" >> marks module CS2113 as completed",
            "2. \"complete 1\" >> marks the 1st item in the list as completed if it is a module"
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
        new String[]{ "", },
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
        new String[]{ "", },
        new String[]{
            "1. \"delete 1\" >> deletes the task with index 1 from the current list"
        }),
    /**
     * The Detail.
     */
    DETAIL(
        "detail",
        "Print the details of a specified item.",
        new String[]{
            "detail [module code (for modules only) / index]",
        },
        new String[]{ "", },
        new String[]{
            "1. \"detail 1\" >> print the detail of item 1 in the list",
            "2. \"detail CS2113T\" >> print the detail of module CS2113T",
        }),
    /**
     * Goal Planner.
     */
    GOAL(
        "goal",
        "Calculate how far the user is from his/her target CAP",
        new String[]{
            "goal -total [total MC] [target CAP] {-taken [taken MC] [current CAP]}",
        },
        new String[]{ "", },
        new String[]{
            "1. \"goal -total 160 4.9\" >> comment on required average grade to achieve CAP of 4.9 with 160MC in total",
            "2. \"goal -total 160 4.9 -taken 100 4.5\" >> "
                + "comment on required average grade needed for:\r\n"
                + "- MC total for graduation: 160\r\n" + "- Target CAP: 4.9\r\n"
                + "- MC taken: 100\r\n" + "- Current CAP: 4.5\r\n"
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
            "1. Index must be a positive integer referencing an existing item.",
            "2. If the index starts with a letter, it will be treated as a numerical value mapped A to 1 and Z to 26. "
                + "For example, \"done apple\" is equivalent to \"done 1\" and \"done C4\" is equivalent to \"done 3\"."
        },
        new String[]{
            "1. \"done 1\" >> marks the task with index 1 as done"
        }),
    /**
     * The Edit.
     */
    EDIT(
        "edit",
        "Modify the attributes of an item (task / module)",
        new String[]{
            "edit [-mod / -task] [index / code (for module only)] [field=new value] ...",
            "No space allowed around \"=\". Use \"_\" in place of space for the \"[field=new value]\" parameters"
        },
        new String[]{ "", },
        new String[]{
            "1. \"edit -mod CS2113T grade=A\" >> changes the \"grade\" field of module \"CS2113T\" to be \"A\"",
            "2. \"edit -task 1 description=do_homework\" >> "
                + "changes the \"description\" field of the 1st task in the current list to \"do homework\"",
            "3. \"edit -task 1 type=event\" >> changes the \"type\" of the 1st task in the current list to \"event\"",
            "4. \"edit -mod CS2113 grade=A -task 1 description=do_homework type=event\" >> do 1 to 3 sequentially"
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
        new String[]{ "", },
        new String[]{
            "1. \"event e -at May 13 2020 8:00\" >> "
                + "adds an event with description \"e\" and time \"May 13 2020 8:00\""
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
        new String[]{ "", },
        new String[]{
            "1. \"fancy\" >> switch to a fancy Cli with graphics. Use \"plain\" to switch to plain Cli"
        }),
    /**
     * Help text to add grade to a course.
     */
    GRADE(
        "grade",
        "Modify grade to the user's taken course/module.",
        new String[]{
            "grade [index / code (for modules only)] [grade] ...",
            "grade [index(es) / codes (for modules only)]",
            "grade"
        },
        new String[]{ "", },
        new String[]{
            "1. \"grade CS2113 A CG1112 A-\" >> make A and A- the grades of modules CS2113 and CG1112 respectively",
            "2. \"grade CS2113 CG1112\" >> delete grade[s] of modules CS2113 and CG1112",
            "3. \"grade\" >> show grades of all taken modules",
            "4. \"grade CG1111 CG1112 A\" >> delete the grade of CG1111, and then set the grade of CG1112 to A, "
                + "equivalent of executing \"grade CG1111\" followed by \"grade CG1112 A\" sequentially",
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
        new String[]{ "", },
        new String[]{
            "1. \"find exam\" >> finds all tasks with the \"exam\" keyword from the task list"
        }),
    /**
     * The Focus.
     */
    FOCUS(
        "focus",
        "Change context. Changes the target of other commands to the specified target",
        new String[]{
            "focus",
            "focus [deadline / todo / event / task / mod / selected / taken]"
        },
        new String[]{ "", },
        new String[]{
            "1. \"focus\" >> focus on \"task\". e.g. \"list\" will list all tasks from now on",
            "2. \"focus mod\" >> focus on \"mod\". e.g. \"list\" will list all modules from now on",
            "3. \"focus selected\" >> focus on \"selected\". e.g. \"list\" will list selected items from now on"
        }),
    /**
     * The Postpone.
     */
    POSTPONE(
        "postpone",
        "postpone task a day by default",
        new String[]{
            "postpone [index]",
            "postpone [h / w / y] [index]"
        },
        new String[]{ "", },
        new String[]{
            "1. \"postpone 1\" >> postpone the task with index 1 by a day",
            "2. \"postpone h 1\" >> postpone the task with index 1 by an hour",
            "3. \"postpone w 1\" >> postpone the task with index 1 by a week",
            "4. \"postpone y 1\" >> postpone the task with index 1 by a year"
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
        new String[]{ "", },
        new String[]{
            "1. \"help\" >> prints the list of available commands",
            "2. \"help event\" >> prints the details of the \"event\" command"
        }),
    /**
     * Statistics help text.
     */
    STATS(
        "stats",
        "Print statistics for a given modules/tasks",
        new String[]{
            "stats [target]",
            "target: todo / deadline / event / <module code>"
        },
        new String[]{ "", },
        new String[]{
            "1. \"stats\" >> prints statistics of task completed",
            "2. \"stats -mod CS2113\" >> prints statistics of tasks completed under tasks of CS2113"
        }),
    /**
     * The List.
     */
    LIST(
        "list",
        "Print a list of items depending on the current Focus",
        new String[]{
            "list",
            "list date [asc / desc / spec \"date\"(any common date format)]"
        },
        new String[]{ "", },
        new String[]{
            "1. \"list\" >> list all added items",
            "2. \"list date asc\" >> list items with a \"date\" field in ascending order",
            "3. \"list date spec Oct 5 2020\" >> list items with specific \"date\" field of Oct 5 2020"
        }),
    /**
     * The Mc.
     */
    MC(
        "mc",
        "Print the number of MCs based on selected option.",
        new String[]{
            "mc [-option]",
            "option: -d(detailed)"
        },
        new String[]{ "", },
        new String[]{
            "1. \"mc\" >> print the total number of MCs currently taking",
            "2. \"mc -d\" >> print the detailed MC composition of the selection region"
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
        new String[]{ "", },
        new String[]{
            "1. \"next\" >> switch both item list (top) and selection (bottom) region to the next page (default)",
            "2. \"next s\" >> switch only the selection (bottom) region to the next page"
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
        new String[]{ "", },
        new String[]{
            "1. \"plain\" >> switch to a plain pure-text Cli. Use \"fancy\" to switch to fancy Cli"
        }),
    /**
     * The Prev.
     */
    PREV(
        "prev",
        "Switch the target region to the previous page, keeping other regions unchanged.",
        new String[]{
            "prev [region]",
            "region: i(items), s(selection), a(all, default)"
        },
        new String[]{ "", },
        new String[]{
            "1. \"prev\" >> switch both item list (top) and selection (bottom) to the previous page (default)",
            "2. \"prev s\" >> switch the selection (bottom) to the previous page"
        }),
    /**
     * The Reminder.
     */
    REMINDER(
        "reminder",
        "List out events and deadlines tasks that are due within " + Constants.REMINDER_RANGE + " days",
        new String[]{
            "reminder",
            "reminder on",
            "reminder off"
        },
        new String[]{ "", },
        new String[]{
            "1. \"reminder\" >> list tasks that are due within the set period of time",
            "2. \"reminder on\" >> Switch on reminder",
            "3. \"reminder off\" >> Switch off reminder"
        }),
    /**
     * The Sel.
     */
    SEL(
        "sel",
        "Make selection: Add specified item(s) to the selection.",
        new String[]{
            "sel [index(es) (for the currently listed items) / module code(s) (for modules only)]",
        },
        new String[]{ "", },
        new String[]{
            "1. \"sel 1 2 3\" >> add the item with indices 1, 2and 3 from the item list to the selection",
            "2. \"sel CS1010 CS2113\" >> add the modules CS1010 and CS2113 on the item list to the selection",
            "3. \"sel 5 CS2113\" >> add the item with index 5 and module CS2113 on the item list to the selection"
        }),
    /**
     * The Snooze.
     */
    SNOOZE(
        "snooze",
        "Delay the reminder pop up by 1 minute.",
        new String[]{
            "snooze",
        },
        new String[]{ "", },
        new String[]{
            "1. \"snooze\" >> Delay reminder popup by 1 minute"
        }),
    /**
     * The Take.
     */
    TAKE(
        "take",
        "Take module(s): Mark specified module(s) as taken.",
        new String[]{
            "take [index(es) / module code(s) (for modules only)]",
        },
        new String[]{ "", },
        new String[]{
            "1. \"take\" >> if there is any module selected but not taken, mark it as taken",
            "2. \"take 1 2\" >> mark module 1 and module 2 as taken",
            "3. \"take CS2113T\" >> mark module CS2113T as taken",
            "4. \"take 1 2 CS2113T\" >> mark module 1, module 2 and module CS2113T as taken",
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
        new String[]{ "", },
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
            "1. Index must be a positive integer referencing an existing item.",
            "2. If the index starts with a letter, it will be treated as a numerical value mapped A to 1 and Z to 26. "
                    + "For example, \"undone apple\" is equivalent to \"undone 1\" "
                    + "and \"undone C4\" is equivalent to \"undone 3\".",
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
        new String[]{ "", },
        new String[]{
            "1. \"unknown\" >> prints \"OOPS, I don't know what that means :-( Try \"help\"!\""
        }),
    /**
     * The Unsel.
     */
    UNSEL(
        "unsel",
        "Cancel selection: Make specified item(s) no longer selected.",
        new String[]{
            "unsel [index(es) (for the currently listed items) / module code(s) (for modules only)]",
        },
        new String[]{ "", },
        new String[]{
            "1. \"unsel 1 2 3\" >> make items with indices 1, 2and 3 no longer selected",
            "2. \"unsel CS1010 CS2113\" >> make modules CS1010 and CS2113 no longer selected",
            "2. \"unsel 5 CS2113\" >> make the item with index 5 and module CS2113 no longer selected"
        }),
    /**
     * The Untake.
     */
    UNTAKE(
        "untake",
        "Untake module(s): Mark specified module(s) as not taken.",
        new String[]{
            "untake [index(es) / module code(s) (for modules only)]",
        },
        new String[]{ "", },
        new String[]{
            "1. \"untake\" >> if there is any module selected and taken, mark it as not taken",
            "2. \"untake 1 2\" >> mark module 1 and module 2 as not taken",
            "3. \"untake CS2113T\" >> mark module CS2113T as not taken",
            "4. \"untake 1 2 CS2113T\" >> mark module 1, module 2 and module CS2113T as not taken"
        });

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
     * The Notes. Includes pre-requisites, and errors expected in different cases. See add as an example.
     */
    public String[] notes;
    /**
     * The Usages.
     */
    public String[] usages;

    HelpText(String name, String description, String[] syntax, String[] notes, String[] usages) {
        this.name = name;
        this.syntax = syntax;
        this.notes = notes;
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
        stringBuilder.append("Notes:").append(Constants.WIN_NEWLINE).append(arrayToString(notes));
        stringBuilder.append("Usages:").append(Constants.WIN_NEWLINE).append(arrayToString(usages));
        return stringBuilder.toString();
    }
}
