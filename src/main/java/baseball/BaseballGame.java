package baseball;

import java.util.ArrayList;

import baseball.utils.BaseballNumberGenerator;
import baseball.views.BaseballGameOutput;

public class BaseballGame {
	private final BaseballNumberGenerator baseballNumberGenerator;
	private final BaseballGameOutput baseballGameOutput;
	private ArrayList<String> targetNumber;

	public BaseballGame(BaseballNumberGenerator baseballNumberGenerator,
		BaseballGameOutput baseballGameOutput) {
		this.baseballNumberGenerator = baseballNumberGenerator;
		this.baseballGameOutput = baseballGameOutput;
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
		boolean isAttackSuccess = false;
		while (!isAttackSuccess) {
			baseballGameOutput.showInputNumberMsg();
			attack();

			isAttackSuccess = true;
		}
	}

	private void attack() {

	}

	private boolean askGameEnd() {
		return true;
	}
}
