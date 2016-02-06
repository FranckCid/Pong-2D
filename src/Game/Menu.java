package Game;

import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

public class Menu extends JFrame {

	private Game g;

	public Menu() {

		this.setLayout(new FlowLayout());

		JButton pvp = new JButton("PVP");
		JButton pve = new JButton("PVE");
		JButton exit = new JButton("EXIT");

		final Frame[] frames = JFrame.getFrames();

		pvp.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				for (Frame f : frames)
					f.dispose();
				g = new Game("PVP");

			}
		});

		pve.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				for (Frame f : frames)
					f.dispose();
				g = new Game("PVE");
			}
		});

		exit.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				for (Frame f : frames)
					f.dispose();
				System.exit(0);
			}
		});

		this.add(pvp);
		this.add(pve);
		this.add(exit);

		this.setTitle("Pong 2D Menu");
		this.setSize(180, 95);
		this.setVisible(true);
		this.setResizable(false);
		this.setLocation(180, 200);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}

	public static void main(String[] args) {
		new Menu();
	}

}