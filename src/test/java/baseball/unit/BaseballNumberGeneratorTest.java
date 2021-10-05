package baseball.unit;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.*;

import java.util.ArrayList;

import baseball.utils.BaseballNumberGenerator;

public class BaseballNumberGeneratorTest {

	@DisplayName("generate 메서드의 반환값이 길이가 3인지 확인")
	@Test
	void testGenerateReturnLength3List() {
		BaseballNumberGenerator baseballNumberGenerator = new BaseballNumberGenerator();
		ArrayList<String> generatedNumberList = baseballNumberGenerator.generate();

		assertThat(generatedNumberList).hasSize(3);
	}

	@DisplayName("generate 메서드가 ArrayList를 반환하는지 확인")
	@Test
	void testGenerateReturnArrayList() {
		BaseballNumberGenerator baseballNumberGenerator = new BaseballNumberGenerator();
		ArrayList<String> generatedNumberList = baseballNumberGenerator.generate();

		assertThat(generatedNumberList).isInstanceOf(ArrayList.class);
	}
}
