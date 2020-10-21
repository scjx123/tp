# Developer Guide

## Design
The Architecture Diagram below represents a high-level design overview of the App. Specifically, it is done with an n-tier architectural style, where the higher layers make use of services provided by lower layers. 

![here](Architecture_Diagram.PNG)

**Main**<br>
For the main layer, it contains a single class known as *Duke*. 
Main's interaction with Storage<br>
When the app launches, Duke loads any previous data from storage and then connects the components of the app in sequence. Upon shutting down,  Duke calls upon method to save user's data automatically.  

Main's interaction with UI<br>
Main gets user input and displays messages through the use of UI component. 

Main's interaction with Command Interpreter<br>
Upon receiving command from the UI, Duke would pass the entire user input into Command Interpreter (CI)

Main's interaction with Execute<br>
Once CI processed the user input, duke proceeds to redirect the input to Execute for execution of action. 

**UI**<br>
**Command Interpreter**<br>
**Executer**<br>
**Storage**<br>

## Implementation<br>
[add ur individual features here]

### CAP calculator feature

The proposed undo/redo mechanism is facilitated by `CalculateCapAction`. It extends `Action` to execute command given by the user, output are then passed on to `Ui` fod display. 
Additionally, it implements the following operations:

* `CalculateCapAction#act()` - Calculate the user CAP based on stored user grades / input modules.
* `CalculateCapAction#prepare()` - Parse user command to suitable parameter for `CalculateCapAction#act()` function.

Given below is an example usage scenario and how thecap calculator mechanism behaves at each step.

Step 1. The user executes `cap` command find his current CAP grade. Command is then parsed by `CalculateCapAction#prepare()` to be passed as arguments for `CalculateCapAction#act()`.

Step 2. `CalculateCapAction#act()` retrieves data from the stored user's grades.

Step 3. `CalculateCapAction#act()` then retrieves module data from the `modulelist.txt` to determine Modular Credit (MC) allocation.

Step 4. CAP value is calculated and returned to the user through `Ui`.

The following activity diagram summarizes what happens when a user executes a new command:

![cap uml diagram](./Cap_Calculator_Diagram.JPG)

## Product scope
### Target user profile

{Describe the target user profile}

### Value proposition

{Describe the value proposition: what problem does it solve?}

## User Stories

|Version| As a ... | I want to ... | So that I can ...|
|--------|----------|---------------|------------------|
|v1.0|new user|see usage instructions|refer to them when I forget how to use the application|
|v2.0|user|find a to-do item by name|locate a to-do without having to go through the entire list|

## Non-Functional Requirements

{Give non-functional requirements}

## Glossary

* *glossary item* - Definition

## Instructions for manual testing

{Give instructions on how to do a manual product testing e.g., how to load sample data to be used for testing}
