package Day4;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;

public class Part2 {

	public static void main(String[] args) throws IOException {	
		String path = ".\\src\\Day4\\data.txt";
		
		final String[] arr = Files.readString(Path.of(path)).lines().toArray(String[]::new);
		
		int counter = 0;
		for (String s : arr) {
			String regexpr = "^(\\d{1,2})\\-(\\d{1,2}),(\\d{1,2})\\-(\\d{1,2})$";
			int d1 = Integer.parseInt(s.replaceAll(regexpr, "$1"));
			int d2 = Integer.parseInt(s.replaceAll(regexpr, "$2"));
			int d3 = Integer.parseInt(s.replaceAll(regexpr, "$3"));
			int d4 = Integer.parseInt(s.replaceAll(regexpr, "$4"));
			
			int maxValue = Math.max(d1, Math.max(d2, Math.max(d3, d4)));
			int[] arr2 = new int[maxValue+1];
			
			for (int i=d1; i<=d2; i++) {
				arr2[i] = arr2[i] + 1;
			}
			
			for (int i=d3; i<=d4; i++) {
				arr2[i] = arr2[i] + 1;
			}
			
			//case range 1 included in range 2
			if (Arrays.stream(arr2).filter((e) -> e > 1).count() > 0) {
				counter++;
			}
		}
		
		System.out.println(counter);
	}
		

}