README for 16384 Player
================================================================================
Required Installations
================================================================================
Install the following in the listed order:
-Java
-Any web browser
================================================================================
Execution
================================================================================
-To run, execute the JAR file "16384Player.jar" by double clicking on it
-Alternatively, to run it through the command line, execute "java -jar 16384Player.jar"
-Alternatively, the source code (Java) can be found in the "src" directory

================================================================================
Usage (Front-End)
================================================================================
--------------------------------------------------------------------------------
Behavior
--------------------------------------------------------------------------------
After displaying a welcome message, the program will generate a small "exit menu" window
in the lower right corner of the screen.  The program will then open the default web
browser and navigate to the game 16384 (http://annimon.github.io/16384/) and will "play"
the game after an 8 second delay.

--------------------------------------------------------------------------------
Stopping
--------------------------------------------------------------------------------
To stop the program at any time after the welcome message, hit the "Stop Player" button
located in the exit menu window.

================================================================================
Problems
================================================================================
-The program relies on the 8-second delay from when the welcome message is closed to when
the game in the browser is loaded.  After this delay the keystrokes will be fired regardless
of the current focused window.