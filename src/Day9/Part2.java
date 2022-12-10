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

public class Part2 {

	public static void main(String[] args) throws IOException {	
		String path = ".\\src\\Day9\\data.txt";
		
		final String[] str = Files.readString(Path.of(path)).lines().toArray(String[]::new);

		List<Point> list = new ArrayList<>();
		for (int i=0; i<10; i++) {
			list.add(new Point());
		}
				
		Set<String> set = new HashSet<>();
		set.add(list.get(9).toString());
		for (String s : str) {
			String[] splt = s.split(" ");
			char c = splt[0].charAt(0);
			int d = Integer.parseInt(splt[1]);
			
			for (int i=0; i<d; i++) {
				switch (c) {
					case 'U' -> list.get(0).move(list.get(0).x, list.get(0).y + 1);
					case 'D' -> list.get(0).move(list.get(0).x, list.get(0).y - 1);
					case 'L' -> list.get(0).move(list.get(0).x - 1, list.get(0).y);
					case 'R' -> list.get(0).move(list.get(0).x + 1, list.get(0).y);
					default -> System.out.println("Error!");
				}
				
				int diffX = 0;
				int diffY = 0;
				for (int j = 1; j<=9; j++) {
					if ((j == 1) && (list.get(0).distance(list.get(1)) > 1.5)) {
						Point prev = new Point(list.get(1));
						list.get(1).setLocation(list.get(0));
						switch (c) {
							case 'U' -> list.get(1).move(list.get(1).x, list.get(1).y - 1);
							case 'D' -> list.get(1).move(list.get(1).x, list.get(1).y + 1);
							case 'L' -> list.get(1).move(list.get(1).x + 1, list.get(1).y);
							case 'R' -> list.get(1).move(list.get(1).x - 1, list.get(1).y);
							default -> System.out.println("Error!");
						}
						
						diffX = list.get(1).x - prev.x;
						diffY = list.get(1).y - prev.y;
					}
					
					if (Math.abs(diffX) + Math.abs(diffY) >1 ) {
						if ((j != 1) && (list.get(j-1).distance(list.get(j)) > 1.5)) {
							list.get(j).move(list.get(j).x + diffX, list.get(j).y + diffY);
						}
					} else {
						list.get(j).setLocation(list.get(j-1));
						switch (c) {
							case 'U' -> list.get(j).move(list.get(j).x, list.get(j).y - 1);
							case 'D' -> list.get(j).move(list.get(j).x, list.get(j).y + 1);
							case 'L' -> list.get(j).move(list.get(j).x + 1, list.get(j).y);
							case 'R' -> list.get(j).move(list.get(j).x - 1, list.get(j).y);
							default -> System.out.println("Error!");
						}
					}
										
				}

				for (Point pt : list) {
					System.out.println(pt.toString());
				}
				System.out.println();

				
				set.add(list.get(9).toString());
			}
			

		}
		
		System.out.println(set.size());
	}
	
	
	

}