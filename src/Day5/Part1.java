package Day5;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class Part1 {

	public static void main(String[] args) throws IOException {	
		String path = ".\\src\\Day5\\data.txt";
		
		Stack<Character> stack1 = new Stack<>();
		stack1.push('S');
		stack1.push('L');
		stack1.push('W');

		Stack<Character> stack2 = new Stack<>();
		stack2.push('J');
		stack2.push('T');
		stack2.push('N');
		stack2.push('Q');
		
		Stack<Character> stack3 = new Stack<>();
		stack3.push('S');
		stack3.push('C');
		stack3.push('H');
		stack3.push('F');
		stack3.push('J');
		
		Stack<Character> stack4 = new Stack<>();
		stack4.push('T');
		stack4.push('R');
		stack4.push('M');
		stack4.push('W');
		stack4.push('N');
		stack4.push('G');
		stack4.push('B');
		
		Stack<Character> stack5 = new Stack<>();
		stack5.push('T');
		stack5.push('R');
		stack5.push('L');
		stack5.push('S');
		stack5.push('D');
		stack5.push('H');
		stack5.push('Q');
		stack5.push('B');
		
		Stack<Character> stack6 = new Stack<>();
		stack6.push('M');
		stack6.push('J');
		stack6.push('B');
		stack6.push('V');
		stack6.push('F');
		stack6.push('H');
		stack6.push('R');
		stack6.push('L');
		
		Stack<Character> stack7 = new Stack<>();
		stack7.push('D');
		stack7.push('W');
		stack7.push('R');
		stack7.push('N');
		stack7.push('J');
		stack7.push('M');
	
		Stack<Character> stack8 = new Stack<>();
		stack8.push('B');
		stack8.push('Z');
		stack8.push('T');
		stack8.push('F');
		stack8.push('H');
		stack8.push('N');
		stack8.push('D');
		stack8.push('J');
		
		Stack<Character> stack9 = new Stack<>();
		stack9.push('H');
		stack9.push('L');
		stack9.push('Q');
		stack9.push('N');
		stack9.push('B');
		stack9.push('F');
		stack9.push('T');
		
		List<Stack<Character>> list = new ArrayList<>();
				
		list.add(stack1);
		list.add(stack2);
		list.add(stack3);
		list.add(stack4);
		list.add(stack5);
		list.add(stack6);
		list.add(stack7);
		list.add(stack8);
		list.add(stack9);
		
		final String[] arr = Files.readString(Path.of(path)).lines().toArray(String[]::new);
		
		for (String s : arr) {
			String regexpr = "^move (\\d+) from (\\d) to (\\d)$";
			int k = Integer.parseInt(s.replaceAll(regexpr, "$1"));
			int from = Integer.parseInt(s.replaceAll(regexpr, "$2")) - 1;
			int to = Integer.parseInt(s.replaceAll(regexpr, "$3")) - 1;
			
			for (int i=0; i<k; i++) {
				Character temp = list.get(from).pop();
				list.get(to).push(temp);
			}
		}
		
		for (int i=0; i<9; i++) {
			System.out.print(list.get(i).pop());
		}
		
		//RLFNRTNFB
	}
		

}