package Day3;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;

public class Part1 {

	public static void main(String[] args) throws IOException {	
		String path = ".\\src\\Day3\\data.txt";
		
		final String[] arr = Files.readString(Path.of(path)).lines().toArray(String[]::new);
		
		int sum = 0;
		for (String s : arr) {
			int indexMiddle = s.length() / 2;
			char[] part1 = s.substring(0, indexMiddle).toCharArray();
			char[] part2 = s.substring(indexMiddle, s.length()).toCharArray();
			char finded = '0';
			for (int i=0; i<indexMiddle; i++) {
				for (int j=0; j<indexMiddle; j++) {
					if (part1[i] == part2[j]) {
						finded = part1[i];
						break;
					}
				}
			}
			
			if (finded == '0') {
				continue;
			}
			
			int priority = 0;
			if (finded > 91) { //little
				priority = finded - 96;
			} else {
				priority = finded - 38;
			}
			
			sum += priority;
		}
		
		System.out.println(sum);
		
	}

}