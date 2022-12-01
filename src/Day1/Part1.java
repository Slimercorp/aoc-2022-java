package Day1;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class Part1 {

	public static void main(String[] args) throws IOException {	
		String path = ".\\src\\Day1\\data.txt";
		
		final String[] arr = Files.readString(Path.of(path)).split("\r\n\r\n");
		int max = Integer.MIN_VALUE;
		for (String str : arr) {
			String[] strSplitted = str.split("\r\n");
			int sum = 0;
			for (String str2 : strSplitted) {
				sum += Integer.parseInt(str2);
			}
			
			if (sum > max) {
				max = sum;
			}
		}

		System.out.println(max);
		
	}

}