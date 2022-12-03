package Day3;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;

public class Part2 {

	public static void main(String[] args) throws IOException {	
		String path = ".\\src\\Day3\\data.txt";
		
		final String[] arr = Files.readString(Path.of(path)).lines().toArray(String[]::new);
		
		int sum = 0;
		for (int k=0; k < arr.length -2; k = k + 3) {
			String s1 = arr[k];
			String s2 = arr[k+1];
			String s3 = arr[k+2];
			char[] elf1 = s1.toCharArray();
			char[] elf2 = s2.toCharArray();
			char[] elf3 = s3.toCharArray();
			char finded = '0';
			for (int i=0; i<elf1.length; i++) {
				for (int j=0; j<elf2.length; j++) {
					for (int m=0; m<elf3.length; m++) {
						if ((elf1[i] == elf2[j]) && (elf1[i] == elf3[m]) && (elf2[j] == elf3[m])) {
							finded = elf1[i];
							break;
						}
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