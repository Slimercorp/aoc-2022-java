package Day9;

import java.awt.Point;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.Stack;
import java.util.TreeSet;

public class Part1 {

	public static void main(String[] args) throws IOException {	
		String path = ".\\src\\Day9\\data.txt";
		
		final String[] str = Files.readString(Path.of(path)).lines().toArray(String[]::new);

		Point pointHead = new Point();
		Point pointTail = new Point();
		
		Set<String> set = new HashSet<>();
		set.add(pointTail.toString());
		System.out.println(pointTail.toString());
		for (String s : str) {
			String[] splt = s.split(" ");
			char c = splt[0].charAt(0);
			int d = Integer.parseInt(splt[1]);
			
			for (int i=0; i<d; i++) {
				switch (c) {
					case 'U' -> pointHead.move(pointHead.x, pointHead.y + 1);
					case 'D' -> pointHead.move(pointHead.x, pointHead.y - 1);
					case 'L' -> pointHead.move(pointHead.x - 1, pointHead.y);
					case 'R' -> pointHead.move(pointHead.x + 1, pointHead.y);
					default -> System.out.println("Error!");
				}
				
				if (pointHead.distance(pointTail) > 1.5) {
					pointTail.setLocation(pointHead);
					switch (c) {
						case 'U' -> pointTail.move(pointTail.x, pointTail.y - 1);
						case 'D' -> pointTail.move(pointTail.x, pointTail.y + 1);
						case 'L' -> pointTail.move(pointTail.x + 1, pointTail.y);
						case 'R' -> pointTail.move(pointTail.x - 1, pointTail.y);
						default -> System.out.println("Error!");
					}
				}
				
				System.out.println("Head " + pointHead.toString());
				System.out.println("Tail " + pointTail.toString());

				set.add(pointTail.toString());
			}
			
			System.out.println();
		}
		
		System.out.println(set.size());
	}
	
	
	

}