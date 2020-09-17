package constants;

public enum HelpText {
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
                "2. \"sel -m CS1010 CS2113\" >> add the multiple items: CS1010 and CS2113 on the item list to the selection",
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
                "3. \"add -m -mod M1 M2 -task T1 T2 \" >> add multiple items: modules M1, M2 and tasks T1, T2 to the item list",
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
    LIST(
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
            });

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
}
