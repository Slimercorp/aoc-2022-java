package Day10;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Part1 {

	public static void main(String[] args) throws IOException {	
		String path = ".\\src\\Day10\\data.txt";
		
		final String[] str = Files.readString(Path.of(path)).lines().toArray(String[]::new);
		
		List<Integer> cycles = new ArrayList<>();
		cycles.add(1);
		cycles.add(1);
		for (String s : str) {
			Matcher noop = Pattern.compile("^noop$").matcher(s);
			Matcher addx = Pattern.compile("^addx (-?\\d+)$").matcher(s);
			
			int prevValue = cycles.get(cycles.size()-1);
			if (noop.find()) {
				cycles.add(prevValue);
			} else if (addx.find()) {
				cycles.add(prevValue);
				
				int value = Integer.parseInt(addx.group(1));
				cycles.add(prevValue + value);
			} else {
				System.out.println("Error!");
			}
		}
		
		int sum = 0;
		for (int i=0; i<cycles.size(); i++) {
			int strength = cycles.get(i) * i;
			
			if ((i == 20) || (i == 60) || (i == 100) || (i == 140) || (i == 180) || (i == 220)) {
				sum += strength;
			}
		}
		
		System.out.println(sum);
	}
	
	
	

}