# Li Bozhao (@TomLBZ) - PPP
## 1. Overview
### 1.1 Project Overview 
DOMNUS - is a desktop application that helps in module and task tracking. It was developed under the module CS2113 Software Engineering & Object Oriented Programming. Within the schedule of approximately 7 weeks, my team of 5 Computer Engineering students successfully created DOMNUS to help students to stay organize with respective to the modules they take in NUS. 

DOMNUS is written in Java and designed to run on Java11 JVM, which makes it cross-platform. It also has two different UI modes to cater to different user needs.

This is what out product looks like: <br>

Plain Mode UI | Fancy Mode UI
--- | ---
![plain](../Images/textui.png)|![ui](../Images/newUI.png)

## 2. Summary of Contributions
Given below are my contributions to the project. 

### 2.1 Enhancements Implemented: 

New Features in ver 2.1: 

Name | What it does | Justification | Highlights
--- | --- | --- | --- 
`edit`|Edit the fields of a Module or Task|The user may want to change the description, type or state of a task after its creation, or modify the grade or linked tasks of a module manually|Supports converting Todos to Events or Deadlines
`load`|Loads tasks to the linked task list of one specified Module without modifying the main task list|Allows the program to store linked tasks with the modules and load them on start-up so that users do not need to add tasks to modules everytime he / she restarts Domsun|The main task list is unaffected by the load command

Enhancements in ver 2.1:

Description | Justification | Highlights
--- | --- | --- 
Improved error messages|Makes it easier for the users to find out what is actually wrong|When an error happens the program may provide correct syntax together with `Notes` to the user depending on the command
Implemented automatic word wrapping for the text region of the fancy UI mode|Makes the UI more readable|The paged view also has improved headings
Added restrictions to non-applicable commands|Give the user an error message instead of ignoring the input so that users can learn the commands better|Some commands now suggests the user to use other commands based on the scenario

**Code Contributed**: [Reposense link](https://nus-cs2113-ay2021s1.github.io/tp-dashboard/#breakdown=true&search=tomlbz&sort=groupTitle&sortWithin=title&since=2020-09-27&timeframe=commit&mergegroup=&groupSelect=groupByRepos&checkedFileTypes=docs~functional-code~test-code~other&tabOpen=true&tabType=authorship&tabAuthor=TomLBZ&tabRepo=AY2021S1-CS2113-T13-2%2Ftp%5Bmaster%5D&authorshipIsMergeGroup=false&authorshipFileTypes=docs~functional-code~test-code~other "My Reposense") 

### 2.2 Contributions to UG: 

Completed the ***Installation*** section of our UG, added pictures to aid understanding.<br>
Wrote parts of the ***Domsun Tutorial***.<br>
Wrote the initial update for all features in the feature list. Those are updated progressively by my Teammates later after each iteration.<br>

### 2.3 Contributions to DG:
{include some extracts from the document here}
### 2.4 Contributions to team-based tasks: 
