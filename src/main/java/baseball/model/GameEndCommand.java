package baseball.model;

import java.util.Arrays;
import java.util.List;

public class GameEndCommand {
	private static final String CMD_GAME_RETRY = "1";
	private static final String CMD_GAME_END = "2";
	private static final List<String> PERMIT_CMD_LIST = Arrays.asList(CMD_GAME_RETRY, CMD_GAME_END);

	private final String command;

	public GameEndCommand(String command) {
		this.command = command;
	}

	public boolean isGameRetry() {
		return command.equals(CMD_GAME_RETRY);
	}

	public boolean isGameEnd() {
		return command.equals(CMD_GAME_END);
	}

	public boolean isValid() {
		return PERMIT_CMD_LIST.contains(command);
	}
}
