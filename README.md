NBA scraper task

The code is written in Java using Selenium.

First it connects to the NBA stats website.

Then it accesses the searchbox at the top and inputs the name provided by the user as a command line argument. After the search there are 2 scenarios:

there is a list of players which can be clicked (the program clicks on the first one)
we are immediately redirected to the page of the player
From the player page we take the season and 3pa from the table with title "Per 36 Minutes" and display the results to the user

The program was executed in the command prompt of Windows by running: mvn exec:java -Dexec.args="Stephen Curry"
