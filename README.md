# Refactoring GildedRose code in Java

[GildedRose-Kata](https://github.com/emilybache/GildedRose-Refactoring-Kata/blob/main/GildedRoseRequirements.txt) code refactored in Java, respecting all specifications, with unit tests implemented and working fine.

For this, i used:

- [IntelliJ IDEA](https://www.jetbrains.com/fr-fr/idea/download) to open and edit the project.
- **jUnit5** for the unit tests.
- **Git/Github** for code versioning.

### First: the GildedRose class
I tried to reduce the nesting level of If/Else by refactoring the logic et the use of the functions.

### Second: the Item class
Must remains at it is, i didn't change anything (as mentionned).

### Third: Unit Tests
i used **jUnit5** , i have added an **itemTestHelper class** and used `assertEquals` inside in order to implement a new method `assertItemEquals` and use it later in all the tests.

## Project requirements

- Java installed.
- [IntelliJ IDEA](https://www.jetbrains.com/fr-fr/idea/download)

## Getting Started

- Download the source code or clone it using Git. 
- Import/Open project in **IntelliJ IDEA**
- To see the refactored **GildedRose class** `main/Java/src/main/java/com/gildedrose/GildedRose.java`
- To run the tests open `main/Java/src/test/java/com/gildedrose` ,then select the test you want and click on **Run** , the result will be displayed in the output console.
