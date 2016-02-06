package Game;

import java.util.Random;

public class PongBall extends GameObject {

	Random random = new Random();

	public PongBall() {

		this.dx = random.nextInt(3) - 2 == 0 ? 1 : -1;
		this.dy = random.nextInt(3) - 2 == 0 ? 1 : -1;

		this.x = Game.SCREEN_WIDTH / 2;
		this.y = Game.SCREEN_HEIGHT / 2;
		this.width = 20;
		this.height = 20;

	}

	public void move() {

		if (this.x > Game.SCREEN_WIDTH - 15) {
			GameCanvas.restartMatch();
			Game.score1++;
		} else if (this.x < 15) {
			GameCanvas.restartMatch();
			Game.score2++;
		} else if (this.y > Game.SCREEN_HEIGHT - 35) {
			this.dy = -1;
			this.y = Game.SCREEN_HEIGHT - this.height - 35;
		} else if (this.y < 15) {
			dy = 1;
			this.y = 16;
		} else {
			this.x += speed * dx;
			this.y += speed * dy;
		}
	}

	public void change(int y, int h) {
		if (this.y < y - 2 || this.y >= y + h)
			this.dy *= -1;
		else
			this.dx *= -1;
	}

}
