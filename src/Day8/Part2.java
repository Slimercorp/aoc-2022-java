package Day8;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;
import java.util.TreeSet;

public class Part2 {

	final static int MAX_ROW = 99;
	final static int MAX_COL = 99;
	
	public static void main(String[] args) throws IOException {	
		String path = ".\\src\\Day8\\data.txt";
		
		final String[] str = Files.readString(Path.of(path)).lines().toArray(String[]::new);

		int[][] arr = new int[MAX_ROW][MAX_COL];
		
		int row = 0;
		for (String s : str) {
			int col = 0;
			for (char c : s.toCharArray()) {
				arr[row][col] = Integer.parseInt(String.valueOf(c));  
				col++;
			}
			
			row++;
		}
		
		int maxVis = 0;
		for (int i=0; i<MAX_ROW; i++) {
			for (int j=0; j<MAX_COL; j++) {
				int vis = getVisibleScore(arr, i, j);
				if (vis > maxVis) {
					maxVis = vis;
				}
				
			}
		}
				
		System.out.println(maxVis);
	}
	
	
	public static int getVisibleScore(int[][] arr, int row, int col) {
		final int value = arr[row][col];
		
		//up
		int counter1 = 0;
		for (int i = row-1; i >= 0; i--) {
			counter1++;
			if (arr[i][col] >= value) {
				break;
			}
		}
		
		// down
		int counter2 = 0;
		for (int i = row+1; i < MAX_COL; i++) {				
			counter2++;
			if (arr[i][col] >= value) {
				break;
			}
		}
		
		//right
		int counter3 = 0;;
		for (int j = col+1; j < MAX_ROW; j++) {
			counter3++;
			if (arr[row][j] >= value) {
				break;
			}
		}
		
		//left
		int counter4 = 0;
		for (int j = col-1; j >= 0; j--) {
			counter4++;
			if (arr[row][j] >= value) {
				break;
			}
		}
		
		
		return counter1 * counter2 * counter3 * counter4;
	}
		

}