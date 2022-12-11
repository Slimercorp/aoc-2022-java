package Day11;

import java.util.Queue;

public class Monkey {
	private int coefOperation;
	private int testDigit;
	private int throwNumberTrue;
	private int throwNumberFalse;
	private Operation operation;
	private Queue<Item> queue;
	private long counter;
	private long digit;
	private boolean defaultWorry;
	
	public Monkey(int coefOperation, int testDigit, int throwNumberTrue, int throwNumberFalse, Operation operation, Queue<Item> queue, long digit, boolean typeOfWorry) {
		this.coefOperation = coefOperation;
		this.testDigit = testDigit;
		this.throwNumberTrue = throwNumberTrue;
		this.throwNumberFalse = throwNumberFalse;
		this.operation = operation;
		this.queue = queue;
		this.counter = 0L;
		this.digit = digit;
		this.defaultWorry = typeOfWorry;
	}
	
	public int doIt(Item item) {
		counter++;
		long newWorryLevel = operation.doOperation(item.getWorryLevel(), coefOperation);
		if (defaultWorry) {
			newWorryLevel = newWorryLevel / 3;
		} else {
			newWorryLevel = newWorryLevel % digit;

		}
		item.setWorryLevel(newWorryLevel);
		
		if ((newWorryLevel % testDigit) == 0) {
			return throwNumberTrue;
		} else {
			return throwNumberFalse;
		}
	}
	
	public Queue<Item> getQueue() {
		return queue;
	}

	public long getCounter() {
		return counter;
	}
	
	
	
	
	
	
}
