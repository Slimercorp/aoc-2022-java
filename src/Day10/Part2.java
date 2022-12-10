package Day10;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Part2 {

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
		
		char[][] monitor = new char[6][40];
		
		for (int i=0; i<6; i++) {
			for (int j=0; j<40; j++) {
				int cycleIndex = 40 * i + j + 1;
				boolean drawing = 	cycles.get(cycleIndex) -1 == j
									|| cycles.get(cycleIndex) == j
									|| cycles.get(cycleIndex) + 1 == j;
				
				if (drawing) {
					monitor[i][j] = '#';
				} else {
					monitor[i][j] = '.';
				}
				
				System.out.print(monitor[i][j]);
			}
			
			System.out.println();
		}
	}
	
	
	

}