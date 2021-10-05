package baseball.model;

import java.util.List;

public class Attack {
	private final List<String> targetNumberList;
	private final List<String> attackNumberList;

	public Attack(List<String> targetNumber, List<String> attackNumber) {
		this.targetNumberList = targetNumber;
		this.attackNumberList = attackNumber;
	}
}
