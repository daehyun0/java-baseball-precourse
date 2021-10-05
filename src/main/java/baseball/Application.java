package baseball;

import baseball.utils.BaseballNumberGenerator;

public class Application {
    public static void main(String[] args) {
        BaseballNumberGenerator baseballNumberGenerator = new BaseballNumberGenerator();

        BaseballGame baseballGame = new BaseballGame(baseballNumberGenerator);
        baseballGame.play();
    }
}
