package baseball.views;

import java.util.ArrayList;
import java.util.Optional;

import baseball.model.AttackResult;

public class BaseballGameOutput {
	private final static String MSG_INPUT_NUMBER = "숫자를 입력해주세요 : ";
	private final static String MSG_WRONG_INPUT = "[ERROR]: 사용자의 입력이 올바르지 않습니다. 3자리의 숫자를 입력해주세요.";
	private final static String TERM_STRIKE = "스트라이크";
	private final static String TERM_BALL = "볼";
	private final static String TERM_NOTHING = "낫싱";

	public void showMsgLn(String msg) {
		System.out.println(msg);
	}

	public void showMsg(String msg) {
		System.out.print(msg);
	}

	public void showInputNumberMsg() {
		showMsg(MSG_INPUT_NUMBER);
	}

	public void showAttackResult(AttackResult attackResult) {
		ArrayList<String> attackResultMsgList = new ArrayList<>();

		getStrikeOutputMsg(attackResult).ifPresent(attackResultMsgList::add);
		getBallOutputMsg(attackResult).ifPresent(attackResultMsgList::add);
		getNothingOutputMsg(attackResult).ifPresent(attackResultMsgList::add);
		getWrongOutputMsg(attackResult).ifPresent(attackResultMsgList::add);

		String resultMsg = String.join(" ", attackResultMsgList);
		showMsgLn(resultMsg);
	}

	private Optional<String> getWrongOutputMsg(AttackResult attackResult) {
		if (!attackResult.isWrongAttack()) {
			return Optional.empty();
		}

		return Optional.of(MSG_WRONG_INPUT);
	}

	private Optional<String> getStrikeOutputMsg(AttackResult attackResult) {
		if (!attackResult.hasStrike()) {
			return Optional.empty();
		}

		return Optional.of(String.format("%d%s", attackResult.getStrikeCount(), TERM_STRIKE));
	}

	private Optional<String> getBallOutputMsg(AttackResult attackResult) {
		if (!attackResult.hasBall()) {
			return Optional.empty();
		}

		return Optional.of(String.format("%d%s", attackResult.getBallCount(), TERM_BALL));
	}

	private Optional<String> getNothingOutputMsg(AttackResult attackResult) {
		if (!attackResult.isNothing()) {
			return Optional.empty();
		}

		return Optional.of(TERM_NOTHING);
	}
}
