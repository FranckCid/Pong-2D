package Game;

import java.awt.Rectangle;
import java.awt.event.KeyEvent;

public class GameObject {

	protected int x, y;
	protected int dx, dy;
	protected int width, height;
	protected int speed;
	protected boolean isAlive;

	protected boolean isNPC;

	// INPUT
	protected int keyUp = KeyEvent.VK_W;
	protected int keyDown = KeyEvent.VK_S;
	protected int keyLeft = KeyEvent.VK_A;
	protected int keyRight = KeyEvent.VK_D;

	public GameObject() {

		speed = 1;

		this.height = 50;
		this.width = 50;
	}

	public void move() {

		this.x += dx * speed;
		this.y += dy * speed;

	}

	public void keyPressed(KeyEvent key) {
		int code = key.getKeyCode();

		if (code == keyUp) {
			dy = -1;
		} else if (code == keyDown) {
			dy = 1;
		}

		if (code == keyLeft) {
			dx = -1;
		} else if (code == keyRight) {
			dx = 1;
		}

	}

	public void keyReleased(KeyEvent key) {
		int code = key.getKeyCode();

		if (code == keyUp || code == keyDown) {
			dy = 0;
		}
		if (code == keyLeft || code == keyRight) {
			dx = 0;
		}

	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public int getWidth() {
		return width;
	}

	public int getHeight() {
		return height;
	}

	public Rectangle getBounds() {
		return new Rectangle(x, y, width, height);
	}

}
