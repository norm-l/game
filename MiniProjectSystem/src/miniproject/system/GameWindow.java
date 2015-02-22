package miniproject.system;

import javax.swing.JFrame;

public class GameWindow extends JFrame {

	public GameWindow(String title, int width, int height) {
		setTitle(title);
		setSize(width, height);
		setLocationRelativeTo(null);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}

}
