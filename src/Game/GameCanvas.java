package Game;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JPanel;
import javax.swing.Timer;

public class GameCanvas extends JPanel implements ActionListener {

	private static GameObject player1;
	private static GameObject player2;
	private static GameObject ball;

	public static Timer fps;

	private static String[] players = { "Player 1", "Player 2" }; // Or AI

	// COLLISION BUFFER
	private static int colTick;

	public GameCanvas() {

		fps = new Timer(5, this);

		this.setDoubleBuffered(true);
		this.setFocusable(true);
		this.addKeyListener(new KeyboardAdapter());

	}

	public static void turnToPVP() {
		GameCanvas.players[0] = "Player 1";
		GameCanvas.players[1] = "Player 2";
	}

	public static void turnToPVE() {
		GameCanvas.players[0] = "Player 1";
		GameCanvas.players[1] = "AI";
	}

	public static void restartMatch() {
		player1 = new PongRacket(players[0]);
		player2 = new PongRacket(players[1]);
		ball = new PongBall();

	}

	public static void restartGame() {
		restartMatch();

		Game.score1 = 0;
		Game.score2 = 0;

		colTick = 0;

		fps.start();

	}

	public void paint(Graphics g) {
		super.paint(g);
		Graphics2D graphs = (Graphics2D) g;
		graphs.fillRect(0, 0, Game.SCREEN_WIDTH, Game.SCREEN_HEIGHT);

		graphs.setColor(Color.white);

		graphs.fillRect(player1.getX(), player1.getY(), player1.getWidth(), player1.getHeight());
		graphs.fillRect(player2.getX(), player2.getY(), player2.getWidth(), player2.getHeight());

		graphs.setFont(new Font("TimesRoman", Font.PLAIN, 90));

		graphs.drawString(Game.score1.toString(), (int) ((int) Game.SCREEN_WIDTH / 4.5), 100);
		graphs.drawString(Game.score2.toString(), (int) ((int) Game.SCREEN_WIDTH - Game.SCREEN_WIDTH / 3), 100);

		graphs.fillOval(ball.getX(), ball.getY(), ball.getWidth(), ball.getHeight());

		graphs.setColor(Color.GREEN);

		/*
		 * graphs.draw(player1.getBounds()); graphs.draw(player2.getBounds());
		 * graphs.draw(ball.getBounds());
		 */ // COLLISION

		g.dispose();
	}

	public void checkCollisions() {

		Rectangle[] playersCol = { player1.getBounds(), player2.getBounds() };
		Rectangle ballCol = ball.getBounds();

		for (Rectangle playerCol : playersCol) {
			if (playerCol.intersects(ballCol)) {
				((PongBall) ball).change((int) playerCol.getY(), (int) playerCol.getHeight());
				colTick = 0;
			}
		}

	}

	@Override
	public void actionPerformed(ActionEvent arg0) {

		player1.move();
		player2.move();
		ball.move();
		repaint();
		colTick++;
		if (colTick > 60) {
			checkCollisions();
		}

	}

	private class KeyboardAdapter extends KeyAdapter {

		@Override
		public void keyPressed(KeyEvent key) {
			player1.keyPressed(key);
			player2.keyPressed(key);
		}

		@Override
		public void keyReleased(KeyEvent key) {
			player1.keyReleased(key);
			player2.keyReleased(key);
		}

	}

}
