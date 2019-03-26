# Dealer Application
This java program uses gradle to build. It runs from the command line. The app deals random cards from a 52 card deck. It deals one card and asks the user if they want another card. After 52 cards are dealt it will ask if you want to play again and it will shuffle and restart dealing cards.

To build the program open a terminal window, cd to the directory root and enter the following:

$ gradle clean build

The jar will be located in build/libs.

This will run tests by default. There is one test currently. To obtain output of the test run:

$ gradle clean test --info

The test report is located here: build/reports/tests/test/index.html

To run the application (for directory root prefix with build/libs):

$ java -jar dealer-0.0.1-SNAPSHOT.jar