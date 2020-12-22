package qa.com.test;

import java.util.HashSet;
import java.util.Set;

public class DuplicateChars {
	public static void main(String[] args) {
		String inputString = "Rajat Parashar";
		Set<Character> set = new HashSet<>();
		Set<Character> duplicateCharSet = new HashSet<>();
		for (int i = 0; i < inputString.length(); i++) {
			if (!set.add(inputString.charAt(i))) {
				duplicateCharSet.add(inputString.charAt(i));
			}
		}
		System.out.println(duplicateCharSet);
	}
}