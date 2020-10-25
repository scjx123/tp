package constants;


import command.action.Action;
import command.action.AddAction;
import command.action.ByeAction;
import command.action.CalculateCapAction;
import command.action.ClearAction;
import command.action.DeadlineAction;
import command.action.DeleteAction;
import command.action.DetailAction;
import command.action.DoneAction;
import command.action.EventAction;
import command.action.FancyAction;
import command.action.FindAction;
import command.action.FocusAction;
import command.action.GradeAction;
import command.action.HelpAction;
import command.action.ListAction;
import command.action.McAction;
import command.action.NextAction;
import command.action.PlainAction;
import command.action.PostponeAction;
import command.action.PrevAction;
import command.action.RemindAction;
import command.action.ReminderAction;
import command.action.SelectAction;
import command.action.SnoozeAction;
import command.action.TakeAction;
import command.action.TodoAction;
import command.action.UndoneAction;
import command.action.UnknownAction;
import command.action.UnselectAction;
import command.action.UntakeAction;

import java.util.Map;

/**
 * The type Constants.
 */
public class Constants {

    /**
     * The constant LPAREN.
     */
    public static final char LPAREN = '(';
    /**
     * The constant RPAREN.
     */
    public static final char RPAREN = ')';
    /**
     * The constant PARAM.
     */
    public static final char PARAM = '/';
    /**
     * The constant PARAM_ALIAS.
     */
    public static final char PARAM_ALIAS = '-';
    /**
     * The constant CMD_END.
     */
    public static final char CMD_END = ';';
    /**
     * The constant CHAR_SPACE.
     */
    public static final char CHAR_SPACE = ' ';

    /**
     * The constant LINE_UNIT.
     */
    public static final String LINE_UNIT = "_";
    /**
     * The constant DOT.
     */
    public static final String DOT = ".";
    /**
     * The constant SPACE.
     */
    public static final String SPACE = " ";
    /**
     * The constant ICON_LEFT.
     */
    public static final String ICON_LEFT = "[";
    /**
     * The constant ICON_RIGHT.
     */
    public static final String ICON_RIGHT = "]";
    /**
     * The constant PARAM_LEFT.
     */
    public static final String PARAM_LEFT = "(";
    /**
     * The constant PARAM_RIGHT.
     */
    public static final String PARAM_RIGHT = ")";
    /**
     * The constant TODO_ICON.
     */
    public static final String TODO_ICON = ICON_LEFT + "T" + ICON_RIGHT;
    /**
     * The constant EVENT_ICON.
     */
    public static final String EVENT_ICON = ICON_LEFT + "E" + ICON_RIGHT;
    /**
     * The constant DDL_ICON.
     */
    public static final String DDL_ICON = ICON_LEFT + "D" + ICON_RIGHT;
    /**
     * The constant ICON_SIGNATURE.
     */
    public static final String ICON_SIGNATURE = ICON_RIGHT + ICON_LEFT;
    /**
     * The constant ICON_SEPARATOR.
     */
    public static final String ICON_SEPARATOR = ICON_RIGHT + LINE_UNIT + ICON_LEFT;
    /**
     * The constant BODY_SIGNATURE.
     */
    public static final String BODY_SIGNATURE = ICON_RIGHT + SPACE;
    /**
     * The constant BODY_SEPARATOR.
     */
    public static final String BODY_SEPARATOR = ICON_RIGHT + LINE_UNIT;
    /**
     * The constant PARAM_SIGNATURE.
     */
    public static final String PARAM_SIGNATURE = SPACE + PARAM_LEFT;
    /**
     * The constant PARAM_SEPARATOR.
     */
    public static final String PARAM_SEPARATOR = LINE_UNIT + PARAM_LEFT;
    /**
     * The constant DETAILS_SIGNATURE.
     */
    public static final String DETAILS_SIGNATURE = ": ";
    /**
     * The constant TICK.
     */
    public static final String TICK = "V"; //"\u2713";
    /**
     * The constant CROSS.
     */
    public static final String CROSS = "X"; //"\u2718";
    /**
     * The constant TICK_ICON.
     */
    public static final String TICK_ICON = ICON_LEFT + TICK + ICON_RIGHT;
    /**
     * The constant CROSS_ICON.
     */
    public static final String CROSS_ICON = ICON_LEFT + CROSS + ICON_RIGHT;
    /**
     * The constant TAB.
     */
    public static final String TAB = "\t";
    /**
     * The constant NEWLINE.
     */
    public static final String NEWLINE = "\n";
    /**
     * The constant RETURN.
     */
    public static final String RETURN = "\r";
    /**
     * The constant WIN_NEWLINE.
     */
    public static final String WIN_NEWLINE = RETURN + NEWLINE;
    /**
     * The constant ZERO_LENGTH_STRING.
     */
    public static final String ZERO_LENGTH_STRING = "";
    /**
     * The constant TEXT_PLACEHOLDER.
     */

    public static final String TEXT_PLACEHOLDER = "_t_";
    /**
     * The constant NUMBER_PLACEHOLDER.
     */
    public static final String NUMBER_PLACEHOLDER = "_n_";
    /**
     * The constant SYNTAX_OR.
     */
    public static final String SYNTAX_OR = "    OR    ";
    /**
     * The constant NOT_FOUND.
     */
    public static final String NOT_FOUND = "[NOT FOUND]";

    /**
     * The constant PATH.
     */
    public static final String PATH = "./data";
    /**
     * Duke FILENAME.
     */
    public static final String TASK_FILENAME = "duke.txt";
    /**
     * Module FILENAME.
     */
    public static final String COURSE_FILENAME = "course.txt";
    /**
     * Test Duke TASK_FILENAME.
     */
    public static final String TEST_TASK_FILENAME = "duke_task_test.txt";
    /**
     * Test Duke COURSE_FILENAME.
     */
    public static final String TEST_COURSE_FILENAME = "duke_course_test.txt";

    /**
     * The constant BYE.
     */
    public static final String BYE = "bye";
    /**
     * The constant CLEAR.
     */
    public static final String CLEAR = "clear";
    /**
     * The constant DEADLINE.
     */
    public static final String DEADLINE = "deadline";
    /**
     * The constant DELETE.
     */
    public static final String DELETE = "delete";
    /**
     * The constant DONE.
     */
    public static final String DONE = "done";
    /**
     * The constant EVENT.
     */
    public static final String EVENT = "event";
    /**
     * The constant FIND.
     */
    public static final String FIND = "find";
    /**
     * The constant FOCUS.
     */
    public static final String FOCUS = "focus";
    /**
     * The constant REMINDER.
     */
    public static final String REMINDER = "reminder";
    /**
     * The constant REMIND.
     */
    public static final String REMIND = "remind";
    /**
     * The constant POSTPONE.
     */
    public static final String POSTPONE = "postpone";
    /**
     * The constant SNOOZE.
     */
    public static final String SNOOZE = "snooze";
    /**
     * The constant HELP.
     */
    public static final String HELP = "help";
    /**
     * The constant LIST.
     */
    public static final String LIST = "list";
    /**
     * The constant TODO.
     */
    public static final String TODO = "todo";
    /**
     * The constant ALL.
     */
    public static final String ALL = "all";
    /**
     * The constant UNDONE.
     */
    public static final String UNDONE = "undone";
    /**
     * The constant UNKNOWN.
     */
    public static final String UNKNOWN = "unknown";

    /**
     * The constant ATOMIC.
     */
    public static final String ATOMIC = "_atom_";
    /**
     * The constant DEFAULT.
     */
    public static final String DEFAULT = "1";
    /**
     * The constant EMPTY.
     */
    public static final String EMPTY = "0";
    /**
     * The constant NEXT.
     */
    public static final String NEXT = "next";
    /**
     * The constant PREV.
     */
    public static final String PREV = "prev";
    /**
     * The constant FANCY.
     */
    public static final String FANCY = "fancy";
    /**
     * The constant PLAIN.
     */
    public static final String PLAIN = "plain";
    /**
     * The constant SEL.
     */
    public static final String SEL = "sel";
    /**
     * The constant ADD.
     */
    public static final String ADD = "add";
    /**
     * The constant MC.
     */
    public static final String MC = "mc";
    public static final String TAKE = "take";
    public static final String UNSEL = "unsel";
    public static final String UNTAKE = "untake";
    /**
     * The constant DETAIL.
     */
    public static final String DETAIL = "detail";
    /**
     * Signals CAP command.
     */
    public static final String CAP = "cap";
    public static final String MOD = "mod";
    public static final String SU = "su";
    public static final String GRADE = "grade";
    public static final String TASK = "task";
    public static final String SELECTED = "selected";
    public static final String TAKEN = "taken";
    public static final String FOUND = "found";
    /**
     * The constant INDEX_OUT.
     */
    public static final String INDEX_OUT = "Index out of range.";
    /**
     * The constant ADDED.
     */
    public static final String ADDED = "Got it. I've added this task:";
    /**
     * The constant REMOVED.
     */
    public static final String REMOVED = "Noted. I've removed this task:";
    public static final String REMOVE_MOD = "Noted. I've removed this module from your current list:";
    /**
     * The constant COUNT_PREFIX.
     */
    public static final String COUNT_PREFIX = "Now you have ";
    /**
     * The constant COUNT_SUFFIX.
     */
    public static final String COUNT_SUFFIX = " tasks in the list.";
    /**
     * The constant CHANGED.
     */
    public static final String CHANGED = WIN_NEWLINE + TEXT_PLACEHOLDER
            + WIN_NEWLINE + COUNT_PREFIX + NUMBER_PLACEHOLDER + COUNT_SUFFIX;
    /**
     * The constant INVALID.
     */
    public static final String INVALID = "Invalid Command! Please check the syntax." + WIN_NEWLINE;
    /**
     * The constant WELCOME.
     */
    public static final String WELCOME = "Hello, I'm Duke. What can I do for you?";
    /**
     * The constant HELP_PROMPT.
     */
    public static final String HELP_PROMPT = "Use \"help [target]\" to see details :) Try \"help help\"!";
    /**
     * The constant DATE_PATTERNS.
     */
    public static final String[] DATE_PATTERNS = {
        "yyyy-MMM-dd", "yyyy-MMM-d", "yyyy-MM-dd", "yyyy-MM-d", "yyyy-M-dd", "yyyy-M-d",
        "yy-MMM-dd", "yy-MMM-d", "yy-MM-dd", "yy-MM-d", "yy-M-dd", "yy-M-d",
        "MMM-dd-yyyy", "MMM-d-yyyy", "MM-dd-yyyy", "MM-d-yyyy", "M-dd-yyyy", "M-d-yyyy",
        "MMM-dd-yy", "MMM-d-yy", "MM-dd-yy", "MM-d-yy", "M-dd-yy", "M-d-yy",
        "dd-MMM-yyyy", "d-MMM-yyyy", "dd-MM-yyyy", "d-MM-yyyy", "dd-M-yyyy", "d-M-yyyy",
        "dd-MMM-yy", "d-MMM-yy", "dd-MM-yy", "d-MM-yy", "dd-M-yy", "d-M-yy"};
    /**
     * The constant TIME_PATTERNS.
     */
    public static final String[] TIME_PATTERNS = {"HH:mm:ss", "H:mm:ss", "HH:m:ss", "HH:mm:s", "H:m:ss",
        "HH:m:s", "H:mm:s", "H:m:s", "HH:mm", "H:mm", "HH:m", "H:m", "HH", "H", ""};

    /**
     * The constant NO_KEYWORD.
     */
    public static final String NO_KEYWORD = "No keyword provided, listing all items:" + WIN_NEWLINE;
    public static final String MOD_NOT_FOUND =
        "Module Not Found! Did you put the module code (e.g. CS2113) correctly?" + WIN_NEWLINE;
    public static final String MOD_NOT_TAKEN = "You have not taken this module yet" + WIN_NEWLINE;
    public static final String MOD_NO_GRADE = "You have not input grade for this module yet" + WIN_NEWLINE;
    public static final String NO_MOD_GRADED = "You have not input grade for any module yet" + WIN_NEWLINE;
    public static final String TASK_NOT_SPEC = "You forgot to specify tasks by index!" + WIN_NEWLINE;
    public static final String ITEM_NOT_SPEC = "No item is specified, skipping this command." + WIN_NEWLINE;
    public static final String GRADE_NOT_SPEC = "You have not entered grade for some of your past modules."
        + WIN_NEWLINE;
    public static final String COURSE_NOT_SPEC = "You have not registered modules that you have taken."
        + WIN_NEWLINE;
    /**
     * The constant NO_TASK_TYPE.
     */
    public static final String NO_TASK_TYPE = "No task type provided, listing all tasks:" + WIN_NEWLINE;
    /**
     * The constant NO_URGENT_TASKS.
     */
    public static final String NO_URGENT_TASKS = "No task within 3 days from now" + WIN_NEWLINE;
    /**
     * The constant UNIDENTIFIED_TYPE.
     */
    public static final String UNIDENTIFIED_TYPE = "Unidentified task type! Please provide the correct task type."
        + WIN_NEWLINE;
    /**
     * The constant DETAIL.
     */
    public static final String NO_MODULE = "Sorry, no such module in the list!" + WIN_NEWLINE;
    /**
     * The constant NOT_DEADLINE_OR_EVENT.
     */
    public static final String NOT_DEADLINE_OR_EVENT = "Sorry, there is no date in todo task!" + WIN_NEWLINE;
    /**
     * The constant ITEM_EXIST.
     */
    public static final String ITEM_EXIST = "Sorry, this item is already in your list!" + WIN_NEWLINE;
    /**
     * The constant FOCUS_HELP.
     */
    public static final String FOCUS_HELP = FOCUS + SYNTAX_OR + FOCUS + CHAR_SPACE + ICON_LEFT + DEADLINE + CHAR_SPACE
            + PARAM + CHAR_SPACE + TODO + CHAR_SPACE + PARAM + CHAR_SPACE + EVENT + CHAR_SPACE + PARAM + CHAR_SPACE
            + ALL + ICON_RIGHT + WIN_NEWLINE;
    /**
     * The constant CONTEXT_MSG.
     */
    public static final String CONTEXT_MSG = "Changing context to ";
    /**
     * The constant ADD_HEAD.
     */
    public static final String ADD_HEAD = "I've added this module to your list:" + WIN_NEWLINE;
    /**
     * The constant LIST_HEAD.
     */
    public static final String LIST_HEAD = "Here is the list of items:" + WIN_NEWLINE;
    /**
     * The constant GRADE_HEAD.
     */
    public static final String GRADE_HEAD = "These are your grades so far:" + WIN_NEWLINE;
    /**
     * The constant REMINDER_HEAD.
     */
    public static final String REMINDER_HEAD = "Here are the tasks due within " + Constants.REMINDER_RANGE + " days: "
            + WIN_NEWLINE;
    /**
     * The constant MC_HEAD.
     */
    public static final String MC_HEAD = "Here is the total MC:" + WIN_NEWLINE;
    /**
     * The constant DETAIL.
     */
    public static final String DETAIL_HEAD = "Here are the details you requested:" + WIN_NEWLINE;
    /**
     * The constant HELP_HEADING.
     */
    public static final String HELP_HEADING = "Here are all available commands:" + WIN_NEWLINE;
    /**
     * The constant HELP_HEADING.
     */
    public static final String SHOW_CAP = "Here is your existing CAP: ";
    public static final String GRADE_REGISTERED = "Here are your existing grades:";
    public static final String NOT_TASK = "The specified item is not a Task, "
            + "so it cannot be marked as done or undone." + WIN_NEWLINE;
    public static final String INIT_LIST = "Welcome to DomSun! This is the item list.";
    public static final String INIT_SEL = "This is the selection list.";
    /**
     * The constant BMP_LIST_SWITCH.
     */
    public static final String BMP_LIST_SWITCH = "LIST";
    /**
     * The constant BMP_SEL_SWITCH.
     */
    public static final String BMP_SEL_SWITCH = "SEL";


    /**
     * The constant LINE_REPETITION.
     */
    public static final int LINE_REPETITION = 60;
    /**
     * The constant NO_INDENT.
     */
    public static final int NO_INDENT = 0;
    /**
     * The constant INDENT_1.
     */
    public static final int INDENT_1 = 1;
    /**
     * The constant INDENT_2.
     */
    public static final int INDENT_2 = 2;
    /**
     * The constant INDENT_3.
     */
    public static final int INDENT_3 = 3;
    /**
     * The constant LETTER_OFFSET.
     */
    public static final int LETTER_OFFSET = 64;
    /**
     * The constant BITMAP_W.
     */
    public static final int BITMAP_W = 100;
    /**
     * The constant BITMAP_LIST_H.
     */
    public static final int BITMAP_LIST_H = 15;
    /**
     * The constant BITMAP_SEL_H.
     */
    public static final int BITMAP_SEL_H = 6;
    /**
     * The constant CELL_W.
     */
    public static final int CELL_W = 20;
    /**
     * The constant CELL_H.
     */
    public static final int CELL_H = 2;
    /**
     * The constant BANNER.
     */
    public static final int BANNER = 1;
    /**
     * The constant REMINDER_RANGE.
     */
    public static final int REMINDER_RANGE = 3;
    /**
     * The constant REMINDER_INTERVAL.
     */
    public static final String REMINDER_INTERVAL = "60000";

    /**
     * The constant REMINDER_DELAY.
     */
    public static final int REMINDER_DELAY = 0;

    /**
     * The constant actionMap.
     */
    public static final Map<String, Action> actionMap = Map.ofEntries(
            Map.entry(BYE, new ByeAction()),
            Map.entry(CLEAR, new ClearAction()),
            Map.entry(DEADLINE, new DeadlineAction()),
            Map.entry(DELETE, new DeleteAction()),
            Map.entry(DONE, new DoneAction()),
            Map.entry(EVENT, new EventAction()),
            Map.entry(FIND, new FindAction()),
            Map.entry(ADD, new AddAction()),
            Map.entry(HELP, new HelpAction()),
            Map.entry(GRADE, new GradeAction()),
            Map.entry(LIST, new ListAction()),
            Map.entry(FOCUS, new FocusAction()),
            Map.entry(REMINDER, new ReminderAction()),
            Map.entry(REMIND, new RemindAction()),
            Map.entry(POSTPONE, new PostponeAction()),
            Map.entry(SNOOZE, new SnoozeAction()),
            Map.entry(MC, new McAction()),
            Map.entry(DETAIL, new DetailAction()),
            Map.entry(TODO, new TodoAction()),
            Map.entry(UNDONE, new UndoneAction()),
            Map.entry(UNKNOWN, new UnknownAction()),
            Map.entry(PREV, new PrevAction()),
            Map.entry(NEXT, new NextAction()),
            Map.entry(CAP, new CalculateCapAction()),
            Map.entry(FANCY, new FancyAction()),
            Map.entry(PLAIN, new PlainAction()),
            Map.entry(TAKE, new TakeAction()),
            Map.entry(SEL, new SelectAction()),
            Map.entry(UNSEL, new UnselectAction()),
            Map.entry(UNTAKE, new UntakeAction()));
    /**
     * The constant helpMap.
     */
    public static final Map<String, HelpText> helpMap = Map.ofEntries(
            Map.entry(BYE, HelpText.BYE),
            Map.entry(CLEAR, HelpText.CLEAR),
            Map.entry(DEADLINE, HelpText.DEADLINE),
            Map.entry(DELETE, HelpText.DELETE),
            Map.entry(DONE, HelpText.DONE),
            Map.entry(EVENT, HelpText.EVENT),
            Map.entry(FIND, HelpText.FIND),
            Map.entry(FOCUS, HelpText.FOCUS),
            Map.entry(REMINDER, HelpText.REMINDER),
            Map.entry(POSTPONE, HelpText.POSTPONE),
            Map.entry(HELP, HelpText.HELP),
            Map.entry(GRADE, HelpText.GRADE),
            Map.entry(LIST, HelpText.LIST),
            Map.entry(TODO, HelpText.TODO),
            Map.entry(UNDONE, HelpText.UNDONE),
            Map.entry(UNKNOWN, HelpText.UNKNOWN),
            Map.entry(PREV, HelpText.PREV),
            Map.entry(NEXT, HelpText.NEXT),
            Map.entry(CAP, HelpText.CAP),
            Map.entry(FANCY, HelpText.FANCY),
            Map.entry(PLAIN, HelpText.PLAIN),
            Map.entry(MC,HelpText.MC),
            Map.entry(DETAIL,HelpText.DETAIL),
            Map.entry(TAKE, HelpText.TAKE),
            Map.entry(ADD, HelpText.ADD),
            Map.entry(SEL, HelpText.SEL),
            Map.entry(UNSEL, HelpText.UNSEL),
            Map.entry(UNTAKE, HelpText.UNTAKE));
    /**
     * The constant paramMap.
     */
    public static final Map<String, String[]> paramMap = Map.ofEntries(
            Map.entry(DEADLINE, new String[]{"by"}),
            Map.entry(EVENT, new String[]{"at"}),
            Map.entry(ADD, new String[]{MOD, TASK}));
    /**
     * The constant optionalParamMap.
     */
    public static final Map<String, String[]> optionalParamMap = Map.ofEntries(
            Map.entry(CAP, new String[]{"u", "m"}),
            Map.entry(GRADE, new String[]{"a", "s"}),
            Map.entry(MC, new String[]{"d"}),
            Map.entry(DETAIL, new String[]{"mod","task","cmd"}),
            Map.entry(ADD, new String[]{"mod","task","cmd"}),
            Map.entry(LIST, new String[]{"date", "asc", "desc", "spec"}),
            Map.entry(FOCUS, new String[]{DEADLINE, TODO, EVENT, MOD, TASK, SELECTED, TAKEN, SU}),
            Map.entry(POSTPONE, new String[]{"h", "d", "w", "m", "y"}),
            Map.entry(REMIND, new String[]{"one day after"}),
            Map.entry(PREV, new String[]{"i", "s", "a"}),
            Map.entry(NEXT, new String[]{"i", "s", "a"}));
    /**
     * The constant messageMap.
     */
    public static final Map<String, String> messageMap = Map.ofEntries(
            Map.entry(BYE, "Bye. Hope to see you again soon!"),
            Map.entry(CLEAR, "Nice! I've cleared all tasks from the list and left modules alone."),
            Map.entry(DEADLINE, ADDED + CHANGED),
            Map.entry(DELETE, REMOVED + CHANGED),
            Map.entry(DONE, "Nice! I've marked this task as done:"
                    + WIN_NEWLINE + TEXT_PLACEHOLDER),
            Map.entry(EVENT, ADDED + CHANGED),
            Map.entry(FIND, "Tasks with the specified keyword are:"
                    + WIN_NEWLINE + TEXT_PLACEHOLDER),
            Map.entry(FOCUS, "Now we are focusing on:"
                    + WIN_NEWLINE + TEXT_PLACEHOLDER),
            Map.entry(HELP, TEXT_PLACEHOLDER),
            Map.entry(LIST, TEXT_PLACEHOLDER),
            Map.entry(TODO, ADDED + CHANGED),
            Map.entry(UNDONE, "Nice! I've marked this task as undone:" + WIN_NEWLINE + TEXT_PLACEHOLDER),
            Map.entry(UNKNOWN, "OOPS, I don't know what that means :-( Try \"help\"!"),
            Map.entry(PREV, TEXT_PLACEHOLDER),
            Map.entry(NEXT, TEXT_PLACEHOLDER),
            Map.entry(FANCY, FANCY),
            Map.entry(PLAIN, PLAIN),
            Map.entry(TAKE, "I have marked these modules as taken:" + WIN_NEWLINE + TEXT_PLACEHOLDER),
            Map.entry(ADD, "I have added the specified tasks to the specified modules."
                    + WIN_NEWLINE + TEXT_PLACEHOLDER),
            Map.entry(SEL, "I have selected the items you specified:" + WIN_NEWLINE + TEXT_PLACEHOLDER),
            Map.entry(DETAIL, DETAIL_HEAD + TEXT_PLACEHOLDER),
            Map.entry(UNSEL, "I have un-selected these items you specified. "
                    + "The list is obsolete, please \"list\" again." + WIN_NEWLINE + TEXT_PLACEHOLDER),
            Map.entry(UNTAKE, "I have un-taken these modules you specified. "
                    + "The list is obsolete, please \"list\" again." + WIN_NEWLINE + TEXT_PLACEHOLDER),
            Map.entry(POSTPONE, "I've postpone this task:" + WIN_NEWLINE + TEXT_PLACEHOLDER),
            Map.entry(SNOOZE, "I've snoozed the reminder for 30 seconds."),
            Map.entry(REMIND, "Will remind you at " + TEXT_PLACEHOLDER));

}
