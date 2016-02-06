package Game;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

public class Game extends JFrame {

	public static Integer score1 = 0;
	public static Integer score2 = 0;

	public static final int SCREEN_WIDTH;
	public static final int SCREEN_HEIGHT;

	static {
		SCREEN_WIDTH = 700;
		SCREEN_HEIGHT = 500;

	}

	public Game(String mode) {

		// MENU BAR
		JMenuBar bar = new JMenuBar();

		JMenu menu = new JMenu("Options");

		JMenuItem sobre = new JMenuItem("About");
		JMenuItem pvp = new JMenuItem("PVP");
		JMenuItem pve = new JMenuItem("PVE");
		JMenuItem sair = new JMenuItem("Exit");

		sobre.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "Made by Franck Cid");
			}
		});

		pvp.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				GameCanvas.turnToPVP();
				GameCanvas.restartGame();
			}
		});

		pve.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				GameCanvas.turnToPVE();
				GameCanvas.restartGame();
			}
		});

		sair.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});

		menu.add(sobre);
		menu.addSeparator();
		menu.add(pvp);
		menu.add(pve);
		menu.addSeparator();
		menu.add(sair);

		bar.add(menu);

		this.setJMenuBar(bar);

		// GAME

		add(new GameCanvas());
		if (mode.equals("PVP"))
			GameCanvas.turnToPVP();
		else
			GameCanvas.turnToPVE();
		GameCanvas.restartGame();

		this.setTitle("Pong 2D");
		this.setSize(SCREEN_WIDTH, SCREEN_HEIGHT);
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		this.setVisible(true);

		this.addWindowListener(new java.awt.event.WindowAdapter() {
			@Override
			public void windowClosing(java.awt.event.WindowEvent windowEvent) {
				GameCanvas.fps.stop();
				new Menu();
			}

		});
	}
}
