package baseball.utils;

import java.util.List;
import java.util.function.Predicate;

public class ListUtils {
	public static boolean some(List<String> list, Predicate<String> handler) {
		boolean result = false;
		for (int i = 0; i < list.size(); ++i) {
			String string = list.get(i);
			result = result || handler.test(string);
			i = result ? list.size() : i;
		}

		return result;
	}
}
