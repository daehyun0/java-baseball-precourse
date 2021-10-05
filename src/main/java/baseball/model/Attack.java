package baseball.model;

import java.util.List;

import baseball.utils.ListUtils;

public class Attack {
	private final List<String> targetNumberList;
	private final List<String> attackNumberList;

	public Attack(List<String> targetNumber, List<String> attackNumber) {
		this.targetNumberList = targetNumber;
		this.attackNumberList = attackNumber;
	}

	public AttackResult calc() {
		AttackResult attackResult = validate();

		if (attackResult.isWrongAttack()) {
			return attackResult;
		}

		attackResult.setStrikeCount(calcStrikeCount());
		attackResult.setBallCount(calcBallCount());

		return attackResult;
	}

	private AttackResult validate() {
		AttackResult attackResult = new AttackResult(false, 0, 0);
		if (targetNumberList.size() != attackNumberList.size()) {
			return attackResult;
		}

		if (ListUtils.some(attackNumberList, (attackNumber -> !Character.isDigit(attackNumber.charAt(0))))) {
			return attackResult;
		}

		attackResult.setValidAttack(true);
		return attackResult;
	}

	private boolean isStrike(int idx) {
		return targetNumberList.get(idx).equals(attackNumberList.get(idx));
	}

	private boolean isBall(int idx) {
		return !isStrike(idx) && targetNumberList.contains(attackNumberList.get(idx));
	}

	private int calcStrikeCount() {
		int strikeCount = 0;
		for (int i = 0; i < targetNumberList.size(); ++i) {
			strikeCount += isStrike(i) ? 1 : 0;
		}
		return strikeCount;
	}

	private int calcBallCount() {
		int ballCount = 0;
		for (int i = 0; i < targetNumberList.size(); ++i) {
			ballCount += isBall(i) ? 1 : 0;
		}
		return ballCount;
	}
}
