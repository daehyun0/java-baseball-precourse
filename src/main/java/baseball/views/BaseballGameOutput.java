package baseball.views;

public class BaseballGameOutput {
	private final static String MSG_INPUT_NUMBER = "숫자를 입력해주세요 : ";

	public void showMsgLn(String msg) {
		System.out.println(msg);
	}

	public void showMsg(String msg) {
		System.out.print(msg);
	}

	public void showInputNumberMsg() {
		showMsg(MSG_INPUT_NUMBER);
	}
}
