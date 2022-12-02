package Day2;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class Part2 {

	public static void main(String[] args) throws IOException {	
		String path = ".\\src\\Day2\\data.txt";
		
		final String[] arr = Files.readString(Path.of(path)).lines().toArray(String[]::new);
		
		int score = 0;
		for (String str : arr) {
			int localScore = 0;
			char he = str.charAt(0);
			char me = str.charAt(2);
			
			switch(me) {
				case 'X' -> localScore = localScore + 0;
				case 'Y' -> localScore = localScore + 3;
				case 'Z' -> localScore = localScore + 6;
				default -> System.out.println("Error!");
			}
			
			switch(he) {
			case ('A'):
				if (me == 'X') {
					localScore = localScore + 3;
				} else if (me == 'Y') {
					localScore = localScore + 1;
				} else {
					localScore = localScore + 2;
				}
				break;
			case ('B'):
				if (me == 'Y') {
					localScore = localScore + 2;
				} else if (me == 'Z') {
					localScore = localScore + 3;
				} else {
					localScore = localScore + 1;
				}
				break;
			case ('C'):
				if (me == 'Z') {
					localScore = localScore + 1;
				} else if (me == 'X') {
					localScore = localScore + 2;
				} else {
					localScore = localScore + 3;
				}
				break;
			default:
				System.out.println("Error!");
			}
			
			score += localScore;
		}
		
		System.out.println(score);

		
	}

}