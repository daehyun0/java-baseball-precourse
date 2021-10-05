package baseball.utils;

import java.util.ArrayList;

import nextstep.utils.Randoms;

public class BaseballNumberGenerator {
	public ArrayList<String> generate() {
		ArrayList<String> generatedNumberList = new ArrayList<>();

		while (generatedNumberList.size() < 3) {
			String generatedNumber = pickNumberWithoutDuplication(generatedNumberList);
			generatedNumberList.add(generatedNumber);
		}

		return generatedNumberList;
	}

	private String pickNumberWithoutDuplication(ArrayList<String> generatedNumberList) {
		int startInclusive = 1, endInclusive = 9;
		String randomNumber = pickNumberInRangeToString(startInclusive, endInclusive);

		while (generatedNumberList.contains(randomNumber)) {
			randomNumber = pickNumberInRangeToString(startInclusive, endInclusive);
		}

		return randomNumber;
	}

	private String pickNumberInRangeToString(int startInclusive, int endInclusive) {
		return Integer.toString(Randoms.pickNumberInRange(startInclusive, endInclusive));
	}
}
