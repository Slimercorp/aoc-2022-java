package Day8;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;
import java.util.TreeSet;

public class Part1 {

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
		
		int counter = 0;
		for (int i=1; i<MAX_ROW-1; i++) {
			for (int j=1; j<MAX_COL-1; j++) {
				
				if  (isVisible(arr, i, j, arr[i][j])) {
					counter++;
				}
				
			}
		}
		
		int result = counter + MAX_ROW * 2 + MAX_COL * 2 - 4;
		
		System.out.println(result);
	}
	
	
	public static boolean isVisible(int[][] arr, int row, int col, int value) {
	
		//up
		int maxHgt = 0;
		for (int i = row-1; i >= 0; i--) {
			if (arr[i][col] > maxHgt) {
				maxHgt = arr[i][col];
			}
		}
		
		if (maxHgt < value) {
			return true;
		} 
		
		
		// down
		maxHgt = 0;
		for (int i = row+1; i < MAX_COL; i++) {		
			if (arr[i][col] > maxHgt) {
				maxHgt = arr[i][col];
			}
		}
		
		
		if (maxHgt < value) {
			return true;
		} 
		
		//right
		maxHgt = 0;
		for (int j = col+1; j < MAX_ROW; j++) {
			if (arr[row][j] > maxHgt) {
				maxHgt = arr[row][j];
			}
		}
		
		
		if (maxHgt < value) {
			return true;
		} 
		
		//left
		maxHgt = 0;
		for (int j = col-1; j >= 0; j--) {
			if (arr[row][j] > maxHgt) {
				maxHgt = arr[row][j];
			}
		}
		
		if (maxHgt < value) {
			return true;
		} 
		
		return false;
	}
		

}