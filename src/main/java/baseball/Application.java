package baseball;

import baseball.utils.BaseballNumberGenerator;
import baseball.views.BaseballGameOutput;

public class Application {
	public static void main(String[] args) {
		BaseballNumberGenerator baseballNumberGenerator = new BaseballNumberGenerator();
		BaseballGameOutput baseballGameOutput = new BaseballGameOutput();

		BaseballGame baseballGame = new BaseballGame(baseballNumberGenerator, baseballGameOutput);
		baseballGame.play();
	}
}
