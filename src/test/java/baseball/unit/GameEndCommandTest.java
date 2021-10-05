package baseball.unit;

import static org.assertj.core.api.AssertionsForClassTypes.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import baseball.model.GameEndCommand;

public class GameEndCommandTest {
	@DisplayName("command가 2일 경우 isGameEnd가 true 반환")
	@Test
	void testIsGameEndReturnTrue() {
		GameEndCommand gameEndCommand = new GameEndCommand("2");

		assertThat(gameEndCommand.isGameEnd()).isTrue();
	}

	@DisplayName("command가 2이 아닐경우 isGameEnd가 false 반환")
	@Test
	void testIsGameEndReturnFalse() {
		GameEndCommand gameEndCommand1 = new GameEndCommand("1");
		GameEndCommand gameEndCommand2 = new GameEndCommand("3");
		GameEndCommand gameEndCommand3 = new GameEndCommand("4");

		assertThat(gameEndCommand1.isGameEnd()).isFalse();
		assertThat(gameEndCommand2.isGameEnd()).isFalse();
		assertThat(gameEndCommand3.isGameEnd()).isFalse();
	}

	@DisplayName("command가 1일 경우 isGameRetry가 true 반환")
	@Test
	void testIsGameRetryReturnTrue() {
		GameEndCommand gameEndCommand = new GameEndCommand("1");

		assertThat(gameEndCommand.isGameRetry()).isTrue();
	}

	@DisplayName("command가 1이 아닐경우 isGameRetry가 false 반환")
	@Test
	void testIsGameRetryReturnFalse() {
		GameEndCommand gameEndCommand1 = new GameEndCommand("2");
		GameEndCommand gameEndCommand2 = new GameEndCommand("3");
		GameEndCommand gameEndCommand3 = new GameEndCommand("4");

		assertThat(gameEndCommand1.isGameRetry()).isFalse();
		assertThat(gameEndCommand2.isGameRetry()).isFalse();
		assertThat(gameEndCommand3.isGameRetry()).isFalse();
	}

	@DisplayName("command가 1, 2인 경우 isValid가 true 반환")
	@Test
	void testIsValidReturnTrue() {
		GameEndCommand gameEndCommand1 = new GameEndCommand("1");
		GameEndCommand gameEndCommand2 = new GameEndCommand("2");

		assertThat(gameEndCommand1.isValid()).isTrue();
		assertThat(gameEndCommand2.isValid()).isTrue();
	}

	@DisplayName("command가 1, 2가 아닌경우 isValid가 false 반환")
	@Test
	void testIsValidReturnFalse() {
		GameEndCommand gameEndCommand0 = new GameEndCommand("0");
		GameEndCommand gameEndCommand1 = new GameEndCommand("1");
		GameEndCommand gameEndCommand2 = new GameEndCommand("2");
		GameEndCommand gameEndCommand3 = new GameEndCommand("3");
		GameEndCommand gameEndCommand4 = new GameEndCommand("4");

		assertThat(gameEndCommand0.isValid()).isFalse();
		assertThat(gameEndCommand3.isValid()).isFalse();
		assertThat(gameEndCommand4.isValid()).isFalse();
	}
}
