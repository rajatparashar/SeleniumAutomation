package qa.com.test;

public class ReverseWords {

	public static void main(String[] args) {
		String input = "This is my sentence";
		String output = "";
		String[] array = input.split(" ");
		for (int i = 0; i < array.length; i++) {
			output += " " + new StringBuffer(array[i]).reverse();
		}
		System.out.println(output.trim());
	}
}