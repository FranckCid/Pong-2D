package Game;

import java.awt.event.KeyEvent;

public class PongRacket extends GameObject {

	public PongRacket(String player) {

		if (player.equals("Player 1")) {

			this.x = (int) Game.SCREEN_HEIGHT / 8;
			this.y = (int) Game.SCREEN_HEIGHT / 3;
			this.height = (int) Game.SCREEN_HEIGHT / 4;

		} else {

			this.x = (int) (Game.SCREEN_WIDTH / 1.2);
			this.y = (int) Game.SCREEN_HEIGHT / 3;
			this.height = (int) Game.SCREEN_HEIGHT / 4;

			if (!player.equals("AI")) {
				keyUp = KeyEvent.VK_UP;
				keyDown = KeyEvent.VK_DOWN;
			} else {
				isNPC = true;
			}

		}

		this.width = 50;
		speed = 2;

	}

	private int dir = 1;

	public void move() {
		if (!isNPC) {
			if (this.y < 15)
				this.y = 15;
			else if (this.y > Game.SCREEN_HEIGHT - this.height - 15)
				this.y = Game.SCREEN_HEIGHT - this.height - 15;
			else
				this.y += dy * speed;
		} else {
			if (this.y <= 15)
				dir = 1;
			else if (this.y >= Game.SCREEN_HEIGHT - this.height - 15)
				dir = -1;
			this.y += speed * dir;
		}
	}

	/*
	 * public Rectangle getBounds(){ if(isNPC) return new Rectangle(this.x,
	 * this.y, 2, this.height); return new Rectangle(this.x + this.width,
	 * this.y, 2, this.height); }
	 */

}
