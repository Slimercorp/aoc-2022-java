package Day1;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Collections;
import java.util.Set;
import java.util.TreeSet;

public class Part2 {

	public static void main(String[] args) throws IOException {	
		String path = ".\\src\\Day1\\data.txt";
		
		final String[] arr = Files.readString(Path.of(path)).split("\r\n\r\n");
		int max = Integer.MIN_VALUE;
		TreeSet<Integer> callories = new TreeSet<>();
		for (String str : arr) {
			String[] strSplitted = str.split("\r\n");
			int sum = 0;
			for (String str2 : strSplitted) {
				sum += Integer.parseInt(str2);
			}
			
			callories.add(sum);
		}
		
		System.out.println(callories.descendingSet().stream().limit(3).reduce((sum, a) -> sum += a).get());
		
	}

}