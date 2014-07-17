public class ArrayStack<T> implements BoundedStackInterface<T> {
	protected final int DEFCAP = 100; // default capacity
	protected T[] stack; // holds stack elements
	protected int topIndex = -1; // index of top element

	public ArrayStack() {
		stack = (T[]) new Object[DEFCAP];
	}

	public ArrayStack(int maxSize) {
		stack = (T[]) new Object[maxSize];
	}

	public void push(T element) {
		if (!isFull()) {
			topIndex++;
			stack[topIndex] = element;
		}
	}

	public void pop() {
		if (!isEmpty()) {
			stack[topIndex] = null;
			topIndex--;
		}
	}

	public boolean isEmpty() {
		return (topIndex == -1);
	}

	public boolean isFull() {
		return (topIndex == (stack.length - 1));
	}

	public int size() {// number of items in the stack
		return topIndex + 1;
	}

	public T top() {
		T topOfStack = null;
		if (!isEmpty())
			return topOfStack = stack[topIndex];
		else
			return topOfStack;
	}

}