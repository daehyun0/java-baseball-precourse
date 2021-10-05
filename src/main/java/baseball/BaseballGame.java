package baseball;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import baseball.model.Attack;
import baseball.model.AttackResult;
import baseball.utils.BaseballNumberGenerator;
import baseball.views.BaseballGameOutput;
import nextstep.utils.Console;

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
			Attack attack = attack();
			AttackResult attackResult = attack.calc();

			isAttackSuccess = attackResult.isAttackSuccess();
			showAttackResult(attackResult);
		}
		showAttackSuccess();
	}

	private void showAttackSuccess() {
		baseballGameOutput.showAttackSuccess();
	}

	private void showAttackResult(AttackResult attackResult) {
		baseballGameOutput.showAttackResult(attackResult);
	}

	private Attack attack() {
		List<String> attackNumber = Arrays.asList(Console.readLine().split(""));
		return new Attack(targetNumber, attackNumber);
	}

	private boolean askGameEnd() {
		boolean isValidCommand = false;
		String gameEndCommand = null;

		while (!isValidCommand) {
			baseballGameOutput.showAskingCommandForGameEnd();
			gameEndCommand = Console.readLine();
			isValidCommand = showErrorMsgIfGameEndCommandWrong(gameEndCommand);
		}

		return gameEndCommand.equals("2");
	}

	private boolean showErrorMsgIfGameEndCommandWrong(String gameEndCommand) {
		boolean isOK = gameEndCommand.equals("1") || gameEndCommand.equals("2");
		if (!isOK) {
			baseballGameOutput.showWrongInputOnGameEndCommand();
		}

		return isOK;
	}
}
