package baseball.model;

public class AttackResult {
	private boolean isValidAttack;
	private long strikeCount;
	private long ballCount;

	public AttackResult(boolean isValidAttack, long strikeCount, long ballCount) {
		this.isValidAttack = isValidAttack;
		this.strikeCount = strikeCount;
		this.ballCount = ballCount;
	}

	public long getStrikeCount() {
		return strikeCount;
	}

	public void setStrikeCount(long strikeCount) {
		this.strikeCount = strikeCount;
	}

	public long getBallCount() {
		return ballCount;
	}

	public void setBallCount(long ballCount) {
		this.ballCount = ballCount;
	}

	public boolean isValidAttack() {
		return isValidAttack;
	}

	public void setValidAttack(boolean validAttack) {
		isValidAttack = validAttack;
	}

	public boolean isNothing() {
		if (isWrongAttack()) {
			return false;
		}

		return strikeCount == 0 && ballCount == 0;
	}

	public boolean hasStrike() {
		if (isWrongAttack()) {
			return false;
		}

		return strikeCount > 0;
	}

	public boolean hasBall() {
		if (isWrongAttack()) {
			return false;
		}

		return ballCount > 0;
	}

	public boolean isAllNumberStrike() {
		if (isWrongAttack()) {
			return false;
		}

		return strikeCount == 3;
	}

	public boolean isWrongAttack() {
		return !isValidAttack;
	}

	public boolean isAttackSuccess() {
		return !isWrongAttack() && isAllNumberStrike();
	}
}
