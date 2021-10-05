package baseball.unit;

import static org.assertj.core.api.Assertions.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import baseball.model.Attack;
import baseball.model.AttackResult;

public class AttackTest {
	@DisplayName("calc 메서드가 AttackResult를 반환하는지 확인")
	@Test
	void testCalcReturnAttackResultClass() {
		List<String> targetNumber = Arrays.asList("1", "2", "3");
		List<String> attackNumber = Arrays.asList("1", "2", "3");

		Attack attack = new Attack(targetNumber, attackNumber);

		assertThat(attack.calc()).isInstanceOf(AttackResult.class);
	}

	@DisplayName("attackNumber에 숫자만 포함되어 있을 경우 AttackResult가 true인지 확인")
	@Test
	void testCalcReturnAttackResultTrue() {
		List<String> targetNumber = Arrays.asList("1", "2", "3");
		List<String> attackNumber = Arrays.asList("1", "2", "3");

		Attack attack = new Attack(targetNumber, attackNumber);

		assertThat(attack.calc().isValidAttack()).isTrue();
	}

	@DisplayName("attackNumber의 길이가 3이 아닐 경우 AttackResult가 false인지 확인")
	@Test
	void testCalcReturnAttackResultFalse_01() {
		List<String> targetNumber = Arrays.asList("1", "2", "3");
		List<List<String>> attackNumberList = new ArrayList<>();

		for (int i = 0; i < 100; ++i) {
			List<String> innerList = new ArrayList<>();
			for (int j = 0; j <= i; ++j) {
				innerList.add(Integer.toString(j));
			}

			attackNumberList.add(innerList);

			Attack attack = new Attack(targetNumber, innerList);
			assertThat(attack.calc().isValidAttack()).isEqualTo(i == 2);
		}
	}

	@DisplayName("attackNumber에 숫자가 아닌 값이 포함되어 있을 경우 AttackResult가 false인지 확인")
	@Test
	void testCalcReturnAttackResultFalse_02() {
		List<String> targetNumber = Arrays.asList("1", "2", "3");
		List<String> attackNumber = Arrays.asList("a", "2", "3");
		List<String> attackNumber2 = Arrays.asList("가", "2", "3");

		Attack attack = new Attack(targetNumber, attackNumber);
		Attack attack2 = new Attack(targetNumber, attackNumber2);

		assertThat(attack.calc().isValidAttack()).isFalse();
		assertThat(attack2.calc().isValidAttack()).isFalse();
	}
}
