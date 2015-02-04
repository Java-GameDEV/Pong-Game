import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;

public class MainMenu extends JFrame {
	private static final long serialVersionUID = 1L;

	int screenWidth = 200;
	int screenHeight = 150;

	int buttonWidth = 100;
	int buttonHeight = 40;

	JButton Play, Quit;
	JCheckBox twoPlayers, limitFrameRate;

	public MainMenu() {

		addButtons();
		addActions();

		getContentPane().setLayout(null);

		
		//button positioning
		Play.setBounds((screenWidth - buttonWidth) / 2, 5, buttonWidth,
				buttonHeight);
		Quit.setBounds((screenWidth - buttonWidth) / 2, 50, buttonWidth,
				buttonHeight);
		twoPlayers.setBounds((screenWidth - buttonWidth) / 2, 95, buttonWidth, buttonHeight);
		limitFrameRate.setBounds(0, 140, buttonWidth * 3, buttonHeight);

		getContentPane().add(Play);
		getContentPane().add(Quit);
		getContentPane().add(twoPlayers);
		getContentPane().add(limitFrameRate);

		pack();
		setVisible(true);
		setLocationRelativeTo(null);
		setSize(screenWidth, screenHeight);
		setTitle("Pong Menu");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);

	}

	private void addButtons() {
		Play = new JButton("Play");
		Quit = new JButton("Quit");
		twoPlayers = new JCheckBox("2 Players");
		limitFrameRate = new JCheckBox("Limit Frames/Second to Updates/Second");
	}

	private void addActions() {
		Play.addActionListener(new ActionListener() { // Take Play button, add
														// new actionListener
			public void actionPerformed(ActionEvent e) { // Turn the action
															// performed into a
															// variable for								// usage
				dispose();
				Game game = new Game();
				if (twoPlayers.isSelected()) {
					game.ai.isTwoPlayer= true;
				}
				
				else {
					game.ai.isTwoPlayer = false;
				}
				
				game.start();
			}
		}); // Play button

		Quit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0); // Game shutdown
			}
		}); // Quit button
	}
}
