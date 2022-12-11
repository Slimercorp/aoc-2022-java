package Day11;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.TreeSet;

public class Part2 {

	public static void main(String[] args) {	
		long digit = 3 * 17 * 2 * 19 * 11 * 5 * 13 * 7;
		
		List<Monkey> list = new ArrayList<>();
		
		// 0 monkey
		Queue<Item> queue = new LinkedList<>();
		queue.add(new Item(66));
		queue.add(new Item(71));
		queue.add(new Item(94));
		list.add(new Monkey(5, 3, 7, 4, (a, b) -> a * b, queue, digit, false));
		
		// 1 monkey
		queue = new LinkedList<>();
		queue.add(new Item(70));
		list.add(new Monkey(6, 17, 3, 0, (a, b) -> a + b, queue, digit, false));
		
		// 2 monkey
		queue = new LinkedList<>();
		queue.add(new Item(62));
		queue.add(new Item(68));
		queue.add(new Item(56));
		queue.add(new Item(65));
		queue.add(new Item(94));
		queue.add(new Item(78));
		list.add(new Monkey(5, 2, 3, 1, (a, b) -> a + b, queue, digit, false));
		
		// 3 monkey
		queue = new LinkedList<>();
		queue.add(new Item(89));
		queue.add(new Item(94));
		queue.add(new Item(94));
		queue.add(new Item(67));
		list.add(new Monkey(2, 19, 7, 0, (a, b) -> a + b, queue, digit, false));
		
		// 4 monkey
		queue = new LinkedList<>();
		queue.add(new Item(71));
		queue.add(new Item(61));
		queue.add(new Item(73));
		queue.add(new Item(65));
		queue.add(new Item(98));
		queue.add(new Item(98));
		queue.add(new Item(63));
		list.add(new Monkey(7, 11, 5, 6, (a, b) -> a * b, queue, digit, false));
		
		// 5 monkey
		queue = new LinkedList<>();
		queue.add(new Item(55));
		queue.add(new Item(62));
		queue.add(new Item(68));
		queue.add(new Item(61));
		queue.add(new Item(60));
		list.add(new Monkey(7, 5, 2, 1, (a, b) -> a + b, queue, digit, false));
		
		// 6 monkey
		queue = new LinkedList<>();
		queue.add(new Item(93));
		queue.add(new Item(91));
		queue.add(new Item(69));
		queue.add(new Item(64));
		queue.add(new Item(72));
		queue.add(new Item(89));
		queue.add(new Item(50));
		queue.add(new Item(71));
		list.add(new Monkey(1, 13, 5, 2, (a, b) -> a + b, queue, digit, false));
		
		// 7 monkey
		queue = new LinkedList<>();
		queue.add(new Item(76));
		queue.add(new Item(50));
		list.add(new Monkey(1, 7, 4, 6, (a, b) -> a * a, queue, digit, false));
		
		for (int i=1; i<=10000; i++) {
			for (Monkey monk : list) {
				for (Item item : monk.getQueue()) {
					int dest = monk.doIt(item);
					Queue<Item> queueDest = list.get(dest).getQueue();
					queueDest.add(item);
				}
				
				monk.getQueue().clear();
			}
		}
		
		TreeSet<Long> set = new TreeSet<>();
		for (Monkey monk : list) {
			set.add(monk.getCounter());
		}		
		
		System.out.println(set.pollLast() * set.pollLast());
	}
	
	
	

}