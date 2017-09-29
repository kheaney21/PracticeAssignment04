public class ArrayQueue implements Queue {

	private int head, tail;
	private Object[] arr;

	public ArrayQueue() {
		this.arr = new Object[10];
		this.head = 0;
		this.tail = 0;
	}

	public Object dequeue() {
		if(!empty()) {
			Object item = arr[head];
			head++;
			if (head >= arr.length) {
				head = 0;
			}
			return item;
		} else {
			return null;
		}
	}
	
	public void enqueue(Object item){
		if((tail + 1) % arr.length == head) {
			growQueue();
		}
		arr[tail] = item;
		tail++;
		if(tail >= arr.length) {
			tail = 0;
		}
	}
	
	public boolean empty() {
		if(head == tail) {
			return true;
		}
		return false;
	}
	
	public void growQueue() { //circular array
		//check if head is before tail
		//if not, then head to end and beginning to tail
		//then adjust head and tail 

		Object[] newArr = new Object[arr.length*2];
		if(head < tail) { //non circular array
			System.arraycopy(arr, 0, newArr, 0, arr.length);
			arr = newArr;
		} else { //circular array

			System.arraycopy(arr, head, newArr, 0, arr.length - head);
			System.arraycopy(arr, 0, newArr, (arr.length - head), tail);
			tail = (arr.length - head + tail); //
			head = 0;
			arr = newArr;
		}
	}
}