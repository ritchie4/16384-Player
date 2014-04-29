import java.awt.AWTException;
import java.awt.Dimension;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.URISyntaxException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 * This class designates a player for the game 16384 (found at annimon.github.io/16384).
 * Actions involved are a repeat of rightward and downward keypresses, and a single left
 * keypress when required.  This AI is "dumb" in the sense that it is performing mindless
 * keypresses instead of analyzing the actual blocks.
 * 
 * @author Tyler Ritchie
 * @date April 28, 2014
 */

public class MainMethod {

	/**
	 * Set up the exit menu and start the player.
	 * @param args Command line arguments (not utilized)
	 */
	@SuppressWarnings("serial")
	public static void main(String[] args) throws AWTException, IOException, URISyntaxException {

		// Welcome message
		JOptionPane.showMessageDialog(
			null,
			"This player will now open your browser and automate the game 16384.\n"
			+ "A small window will appear in the bottom right of the screen to allow you to\n"
			+ "stop the program at any time by hitting the \"Stop Player\" button.\nHit OK to begin.");

		// Build the exit menu
		JFrame f = new JFrame("Stop Player Menu");
		JPanel mainPanel = new JPanel() {
            @Override
            public Dimension getPreferredSize() {
                return new Dimension(160, 80);
            }
        };
        JButton stopButton = new JButton();
        stopButton.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
        });
        stopButton.setPreferredSize(new Dimension(100, 30));
        stopButton.setText("Stop Player");
        mainPanel.add(stopButton);
        
        f.add(mainPanel);
        f.pack();
        f.setAlwaysOnTop(true);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        // Position the exit menu in the bottom right corner
        GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
        GraphicsDevice defaultScreen = ge.getDefaultScreenDevice();
        Rectangle rect = defaultScreen.getDefaultConfiguration().getBounds();
        int x = (int) rect.getMaxX() - f.getWidth();
        int y = (int) rect.getMaxY() - f.getHeight();
        f.setLocation(x, y);
        
        f.setVisible(true);
        
		new MainPlayer();
	}
}


