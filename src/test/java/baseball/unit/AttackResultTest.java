package baseball.unit;

import static org.assertj.core.api.AssertionsForClassTypes.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import baseball.model.AttackResult;

public class AttackResultTest {
	@DisplayName("0스트라이크 0볼의 경우 isNothing 메서드가 true를 반환하는지 확인")
	@Test
	void testAttackResultIsNothingReturnTrue() {
		AttackResult attackResult = new AttackResult(true, 0, 0);
		assertThat(attackResult.isNothing()).isTrue();
	}

	@DisplayName("isValidAttack이 false일 경우 isNothing 메서드가 false를 반환하는지 확인")
	@Test
	void testAttackResultIsNothingReturnFalse01() {
		AttackResult attackResult = new AttackResult(false, 0, 0);
		AttackResult attackResult2 = new AttackResult(false, 1, 0);
		AttackResult attackResult3 = new AttackResult(false, 0, 1);
		AttackResult attackResult4 = new AttackResult(false, 1, 1);

		assertThat(attackResult.isNothing()).isFalse();
		assertThat(attackResult2.isNothing()).isFalse();
		assertThat(attackResult3.isNothing()).isFalse();
		assertThat(attackResult4.isNothing()).isFalse();
	}

	@DisplayName("isValidAttack가 true이고, 스트라이크, 볼이 있을 경우 isNothing 메서드가 false를 반환하는지 확인")
	@Test
	void testAttackResultIsNothingReturnFalse02() {
		AttackResult attackResult = new AttackResult(true, 1, 0);
		AttackResult attackResult2 = new AttackResult(true, 0, 1);
		AttackResult attackResult3 = new AttackResult(true, 1, 1);

		assertThat(attackResult.isNothing()).isFalse();
		assertThat(attackResult2.isNothing()).isFalse();
		assertThat(attackResult3.isNothing()).isFalse();
	}

	@DisplayName("isValidAttack이 true이고, 스트라이크가 1개 이상이면 true 반환")
	@Test
	void testAttackResultHasStrikeReturnTrue() {
		AttackResult attackResult = new AttackResult(true, 1, 0);
		AttackResult attackResult2 = new AttackResult(true, 2, 0);
		AttackResult attackResult3 = new AttackResult(true, 3, 0);

		assertThat(attackResult.hasStrike()).isTrue();
		assertThat(attackResult2.hasStrike()).isTrue();
		assertThat(attackResult3.hasStrike()).isTrue();
	}

	@DisplayName("isValidAttack이 false이면 false 반환")
	@Test
	void testAttackResultHasStrikeReturnFalse01() {
		AttackResult attackResult = new AttackResult(false, 1, 0);
		AttackResult attackResult2 = new AttackResult(false, 2, 0);
		AttackResult attackResult3 = new AttackResult(false, 3, 0);

		assertThat(attackResult.hasStrike()).isFalse();
		assertThat(attackResult2.hasStrike()).isFalse();
		assertThat(attackResult3.hasStrike()).isFalse();
	}

	@DisplayName("isValidAttack이 true이고, strikeCount가 0이면 false 반환")
	@Test
	void testAttackResultHasStrikeReturnFalse02() {
		AttackResult attackResult = new AttackResult(false, 0, 0);

		assertThat(attackResult.hasStrike()).isFalse();
	}

	@DisplayName("isValidAttack이 true이고, 볼이 1개 이상이면 hasBall()이 true 반환")
	@Test
	void testAttackResultHasBallReturnTrue() {
		AttackResult attackResult = new AttackResult(true, 0, 1);
		AttackResult attackResult2 = new AttackResult(true, 0, 2);
		AttackResult attackResult3 = new AttackResult(true, 0, 3);

		assertThat(attackResult.hasBall()).isTrue();
		assertThat(attackResult2.hasBall()).isTrue();
		assertThat(attackResult3.hasBall()).isTrue();
	}

	@DisplayName("isValidAttack이 false이면 hasBall()이 false 반환")
	@Test
	void testAttackResultHasBallReturnFalse01() {
		AttackResult attackResult = new AttackResult(false, 0, 0);
		AttackResult attackResult2 = new AttackResult(false, 0, 1);
		AttackResult attackResult3 = new AttackResult(false, 0, 2);
		AttackResult attackResult4 = new AttackResult(false, 0, 3);

		assertThat(attackResult.hasBall()).isFalse();
		assertThat(attackResult2.hasBall()).isFalse();
		assertThat(attackResult3.hasBall()).isFalse();
		assertThat(attackResult4.hasBall()).isFalse();
	}

	@DisplayName("isValidAttack이 true이고, ballCount가 0이면 hasBall()이 false 반환")
	@Test
	void testAttackResultHasBallReturnFalse02() {
		AttackResult attackResult = new AttackResult(true, 0, 0);

		assertThat(attackResult.hasBall()).isFalse();
	}

	@DisplayName("isValidAttack이 true이고, strikeCount가 3이면 isAllNumberStrike()가 true 반환")
	@Test
	void testIsAllNumberStrikeReturnTrue() {
		AttackResult attackResult = new AttackResult(true, 3, 0);
		assertThat(attackResult.isAllNumberStrike()).isTrue();
	}

	@DisplayName("isValidAttack이 false이면 isAllNumberStrike()가 false 반환")
	@Test
	void testIsAllNumberStrikeReturnFalse01() {
		AttackResult attackResult1 = new AttackResult(false, 0, 0);
		AttackResult attackResult2 = new AttackResult(false, 3, 0);
		AttackResult attackResult3 = new AttackResult(false, 0, 3);
		AttackResult attackResult4 = new AttackResult(false, 3, 3);

		assertThat(attackResult1.isAllNumberStrike()).isFalse();
		assertThat(attackResult2.isAllNumberStrike()).isFalse();
		assertThat(attackResult3.isAllNumberStrike()).isFalse();
		assertThat(attackResult4.isAllNumberStrike()).isFalse();
	}

	@DisplayName("isValidAttack이 true이고, strikeCount가 3이 아니면 isAllNumberStrike()가 false 반환")
	@Test
	void testIsAllNumberStrikeReturnFalse02() {
		AttackResult attackResult1 = new AttackResult(true, 0, 0);
		AttackResult attackResult2 = new AttackResult(true, 1, 0);
		AttackResult attackResult3 = new AttackResult(true, 2, 0);

		assertThat(attackResult1.isAllNumberStrike()).isFalse();
		assertThat(attackResult2.isAllNumberStrike()).isFalse();
		assertThat(attackResult3.isAllNumberStrike()).isFalse();
	}

	@DisplayName("isValidAttack이 false이면, isWrongAttack()가 true 반환")
	@Test
	void testIsWrongAttackReturnTrue() {
		AttackResult attackResult = new AttackResult(false, 0, 0);

		assertThat(attackResult.isWrongAttack()).isTrue();
	}

	@DisplayName("isValidAttack이 true, isWrongAttack()가 false 반환")
	@Test
	void testIsWrongAttackReturnFalse() {
		AttackResult attackResult = new AttackResult(true, 0, 0);

		assertThat(attackResult.isWrongAttack()).isFalse();
	}

	/**
	 * 	public boolean isAttackSuccess() {
	 * 		return !isWrongAttack() && isAllNumberStrike();
	 *    }
	 */

	@DisplayName("isValidAttack이 true이고, strikeCount가 3이면 true 반환")
	@Test
	void testIsAttackSuccessReturnTrue() {
		AttackResult attackResult = new AttackResult(true, 3, 0);

		assertThat(attackResult.isAttackSuccess()).isTrue();
	}

	@DisplayName("isValidAttack이 false면 false 반환")
	@Test
	void testIsAttackSuccessReturnFalse01() {
		AttackResult attackResult1 = new AttackResult(false, 0, 0);
		AttackResult attackResult2 = new AttackResult(false, 1, 0);
		AttackResult attackResult3 = new AttackResult(false, 2, 0);
		AttackResult attackResult4 = new AttackResult(false, 3, 0);

		assertThat(attackResult1.isAttackSuccess()).isFalse();
		assertThat(attackResult2.isAttackSuccess()).isFalse();
		assertThat(attackResult3.isAttackSuccess()).isFalse();
		assertThat(attackResult4.isAttackSuccess()).isFalse();
	}

	@DisplayName("isValidAttack이 true이고, strike가 3이 아니면 false 반환")
	@Test
	void testIsAttackSuccessReturnFalse02() {
		AttackResult attackResult1 = new AttackResult(false, 0, 0);
		AttackResult attackResult2 = new AttackResult(false, 1, 0);
		AttackResult attackResult3 = new AttackResult(false, 2, 0);

		assertThat(attackResult1.isAttackSuccess()).isFalse();
		assertThat(attackResult2.isAttackSuccess()).isFalse();
		assertThat(attackResult3.isAttackSuccess()).isFalse();
	}
}
