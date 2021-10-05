package baseball;

import java.util.ArrayList;

import baseball.utils.BaseballNumberGenerator;

public class BaseballGame {
	private final BaseballNumberGenerator baseballNumberGenerator;
	private ArrayList<String> targetNumber;

	public BaseballGame(BaseballNumberGenerator baseballNumberGenerator) {
		this.baseballNumberGenerator = baseballNumberGenerator;
	}

	public void play() {
		boolean isContinueGame = true;
		while (isContinueGame) {
			this.targetNumber = baseballNumberGenerator.generate();

			attackBeforeSuccess();

			isContinueGame = !askGameEnd();
		}
	}

	private void attackBeforeSuccess() {
	}

	private boolean askGameEnd() {
		return false;
	}
}
