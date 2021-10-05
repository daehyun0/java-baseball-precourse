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
		this.targetNumber = baseballNumberGenerator.generate();
	}
}
