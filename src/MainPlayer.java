import java.awt.AWTException;
import java.awt.Desktop;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

import javax.swing.JFrame;

/**
 * This class designates a player for the game 16384 (found at
 * annimon.github.io/16384). Actions involved are a repeat of rightward and
 * downward keypresses, and a single left keypress when required. This AI is
 * "dumb" in the sense that it is performing mindless keypresses instead of
 * analyzing the actual blocks.
 * 
 * @author Tyler Ritchie
 * @date April 28, 2014
 */

@SuppressWarnings("serial")
public class MainPlayer extends JFrame {

	public MainPlayer() throws IOException, URISyntaxException, AWTException {

		// Navigate to the game
		if (Desktop.isDesktopSupported()) {
			Desktop.getDesktop().browse(
					new URI("http://annimon.github.io/16384/"));
		}
		Robot player = new Robot();
		player.delay(8000);

		int count = 0;
		int switchDir = 0;

		// Initiate a loop for block keypresses
		while (true) {
			if (count % 20 == 0 && switchDir == 0) 
			{
				player.delay(100);
				player.keyPress(KeyEvent.VK_LEFT);
				player.delay(100);
				player.keyPress(KeyEvent.VK_RIGHT);
				switchDir++;
			} 
			else if (count % 20 == 0 && (switchDir >= 1 && switchDir <= 4)) 
			{
				player.delay(100);
				player.keyPress(KeyEvent.VK_LEFT);
				player.delay(100);
				player.keyPress(KeyEvent.VK_DOWN);
				switchDir++;
				if (switchDir == 5) {
					switchDir = 0;
				}
			}
			player.delay(100);
			player.keyPress(KeyEvent.VK_RIGHT);
			player.delay(100);
			player.keyPress(KeyEvent.VK_DOWN);
			count++;
		}
	}

}
