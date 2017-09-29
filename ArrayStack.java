public class ArrayStack implements Stack {

	private int top = 0;
	private Object[] arr;
	
	public ArrayStack() {
		this.arr = new Object[10];
		this.top = top;
	}

	public void push(Object item) {
		if (top == arr.length) {
			growStack();
		}
		if (top < arr.length) {
			arr[top] = item;
			top++;
		}
	}
	
	public Object pop() {
		if (!empty()) {
			top--;
			return arr[top];
		}
		return null;
	}
	
	public Object peek() {
		if(!empty()) {
			return arr[top - 1];
		}
		return null;
	}
	
	public boolean empty() {
		if (top == 0) {
			return true;
		}
		return false;
	}
	
	public void growStack() {
		Object[] newArr = new Object[arr.length*2];
		System.arraycopy(arr, 0, newArr, 0, arr.length);
		arr = newArr;
	}
}