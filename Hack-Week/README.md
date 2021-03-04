# Overview

This program is called Temple Search 

# Development Environment

* Visual Studio Code 
* Java
* github
* git

# Execution

To execute the program, you must download the included list of data. 
Then hit run in visual studio code.

## Beginning and setup
The project welcomes the user and asks whether they would like a male name, female name, or a last name. User will type in their answer and hit enter.

![Beginning and first choice](beginning.JPG)

## Background work
After hitting enter, the program will display instructions. Then the program proceeds to import the 3 files with names into ArrayLists. 

These files are: femalenames.txt, malenames.txt, and Lastnames.txt. They are included in this repository.

ArrayLists allow the program to access the names better and are an important part of how the random generator works. The program will use the Random class to generate a random number. It grabs that name at that number in the list and displays it as the first name generated.

![Instructions and first name](backcodecomplete.JPG)

## Choice selection
After the first name is generated, a user can type either 'g' or 'q'. 

Typing 'g' will continue generating names with the previous specifications as the first name.

![Continue generating names](typingg.JPG)

Typing 'q' will thank the user and end the program.

![Ending program](typingq.JPG)

## Protection
Each input is protected with while loops to be sure that the correct input is put into the program. Exception errors are thrown if the file can't be read or found.

![Protection in code](protection.JPG)

# Useful Websites and other Resources
* https://www.churchofjesuschrist.org/temples/list?lang=eng
* http://tutorials.jenkov.com/java/arrays.html
* https://stackoverflow.com/questions/24104313/how-do-i-make-a-delay-in-java
* https://www.javatpoint.com/post/java-scanner-skip-method
* https://kbroman.org/github_tutorial/pages/init.html
* 