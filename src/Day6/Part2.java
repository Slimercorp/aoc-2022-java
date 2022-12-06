package Day6;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;
import java.util.TreeSet;

public class Part2 {

	public static void main(String[] args) throws IOException {	
		String path = ".\\src\\Day6\\data.txt";
		
		final String str = Files.readString(Path.of(path));
		
		for (int i=0; i<str.length()-14; i++) {		
			TreeSet<Character> set = new TreeSet<>();
			for (int j=0; j<14; j++) {
				set.add(str.charAt(i+j));
			}
			
			if (set.size() == 14) {
				System.out.println(i+14);
				break;
			}
		}
		
	}
		

}