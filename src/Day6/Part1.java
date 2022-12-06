package Day6;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;
import java.util.TreeSet;

public class Part1 {

	public static void main(String[] args) throws IOException {	
		String path = ".\\src\\Day6\\data.txt";
		
		final String str = Files.readString(Path.of(path));
		
		for (int i=0; i<str.length()-3; i++) {
			char one = str.charAt(i);
			char two = str.charAt(i+1);
			char three = str.charAt(i+2);
			char four = str.charAt(i+3);
			
			TreeSet<Character> set = new TreeSet<>();
			set.add(one);
			set.add(two);
			set.add(three);
			set.add(four);
			
			if (set.size() == 4) {
				System.out.println(i+4);
				break;
			}
		}
		
	}
		

}