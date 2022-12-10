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

	final static int ROPES = 10;
	
	public static void main(String[] args) throws IOException {	
		String path = ".\\src\\Day9\\data.txt";
		
		final String[] str = Files.readString(Path.of(path)).lines().toArray(String[]::new);

		List<Point> list = new ArrayList<>();
		for (int i=0; i<ROPES; i++) {
			list.add(new Point());
		}
				
		Set<String> set = new HashSet<>();
		set.add(list.get(ROPES-1).toString());
		
		for (String s : str) {
			String[] splt = s.split(" ");
			char c = splt[0].charAt(0);
			int d = Integer.parseInt(splt[1]);
	
			for (int i=0; i<d; i++) {
				moveHead(list, c);
				
				for (int k=1; k<ROPES; k++) {
					moveTail(list, k);
				}
				
				set.add(list.get(ROPES-1).toString());
			}
		}
		
		System.out.println(set.size());
	}
	
	
	public static void moveHead(List<Point> list, char c) {
		switch (c) {
			case 'U' -> list.get(0).move(list.get(0).x, list.get(0).y + 1);
			case 'D' -> list.get(0).move(list.get(0).x, list.get(0).y - 1);
			case 'L' -> list.get(0).move(list.get(0).x - 1, list.get(0).y);
			case 'R' -> list.get(0).move(list.get(0).x + 1, list.get(0).y);
			default -> System.out.println("Error!");
		}
	}
	
	public static void moveTail(List<Point> list, int i) {
		var p1 = list.get(i-1);
		var p2 = list.get(i);
		var dist = p1.distance(p2);
		
		if (dist < 1.42) { // not far than diag
			// do nothing
		} else if ((p1.x == p2.x) || (p1.y == p2.y)) {
            if (p1.x < p2.x) {
                --p2.x;
            } else if (p1.x > p2.x) {
                ++p2.x;
            } else if (p1.y < p2.y) {
                --p2.y;
            } else if (p1.y > p2.y) {
                ++p2.y;
            }
        } else {
            if (p1.x > p2.x && p1.y > p2.y) {
                ++p2.x;
                ++p2.y;
            } else if (p1.x > p2.x && p1.y < p2.y) {
                ++p2.x;
                --p2.y;
            } else if (p1.x < p2.x && p1.y > p2.y) {
                --p2.x;
                ++p2.y;
            } else if (p1.x < p2.x && p1.y < p2.y) {
                --p2.x;
                --p2.y;
            }
		}
	}
}