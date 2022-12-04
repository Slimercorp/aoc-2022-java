package Day4;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;

public class Part1 {

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
			
			//case range 1 included in range 2
			if (((d1 >= d3) && (d2 <= d4)) || ((d3 >= d1) && (d4 <= d2))) {
				counter++;
			}
		}
		
		System.out.println(counter);
	}
		

}