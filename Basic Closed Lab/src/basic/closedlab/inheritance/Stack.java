package basic.closedlab.inheritance;

import java.util.Arrays;

public class Stack {
	private int length = 10, pointer = 0, arr[] = new int[length];

	public void push(int element) {
		if (arr.length == length) {
			length *= 2;
			arr = Arrays.copyOf(arr, length);
		}
		arr[pointer++] = element;
	}

	public int pop() {
		if (pointer == 0)
			throw new IndexOutOfBoundsException();
		return arr[pointer--];
	}

	public int peek(int position) {
		if (position >= pointer)
			throw new IndexOutOfBoundsException();
		return arr[position];
	}

	public int size() {
		return pointer;
	}

	public static void main(String[] args) {
		Stack stack = new Stack();
		stack.push(1);
		stack.push(10);
		stack.push(0);

		for (int i = 0; i < stack.size(); i++)
			System.out.print(stack.peek(i) + " ");
		System.out.println();
		stack.pop();

		for (int i = 0; i < stack.size(); i++)
			System.out.print(stack.peek(i) + " ");
		System.out.println();
	}

}
