package project;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;

//1caps, 1 small, 1 number, 1 special char, min 8 max 16
public class PasswordGenerator {
	public static void main(String[] args) {

		System.out.println(generate());

	}

	static String generate() {
		Random random = new Random();
		String capital = "QWERTYUIOPLKJHGFDSAZXCVBNM";
		String small = "qwertyuioplkjhgfdsazxcvbnm";
		String number = "0987654321";
		String symbols = "!@#$%^&*_=+-/.?<>)";
		int size = random.ints(8, 16).findAny().getAsInt();
		StringBuilder password = new StringBuilder();
		for (int i = 0; i < size; i++) {
			password.append(capital.charAt(random.nextInt(capital.length())))
					.append(small.charAt(random.nextInt(small.length())))
					.append(number.charAt(random.nextInt(number.length())))
					.append(symbols.charAt(random.nextInt(symbols.length())));

		}

		List<String> strings = Arrays.asList(password.substring(0, size).split(""));
		Collections.shuffle(strings);
		password = new StringBuilder(strings.size());
		for (int i = 0; i < strings.size(); i++) {
			password.append(strings.get(i));
		}
		return password.toString();
	}

}
