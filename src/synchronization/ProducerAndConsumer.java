
package synchronization;

/**
 * @author changsi
 * 
 */
public class ProducerAndConsumer {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SharedBuffer buffer = new SharedBuffer();
		Producer producer = new Producer(buffer);
		Consumer consumer = new Consumer(buffer);
		new Thread(producer).start();
		new Thread(consumer).start();
	}

}

class Producer implements Runnable {
	SharedBuffer buffer;

	public Producer(SharedBuffer buffer) {
		this.buffer = buffer;
	}

	public void run() {
		for (int i = 0; i < 20; i++) {
			try {
				buffer.add(i);
				System.out.println("produce  " + i);
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}

class Consumer implements Runnable {
	SharedBuffer buffer;

	public Consumer(SharedBuffer buffer) {
		this.buffer = buffer;
	}

	public void run() {
		for (int i = 0; i < 20; i++) {
			try {
				int result = buffer.remove();
				System.out.println("consume  " + result);
				Thread.sleep(2000);
			} catch (Exception e) {
				e.printStackTrace();
			}

		}
	}
}

class SharedBuffer {
	int[] array = new int[100];
	int index = 0;

	public synchronized void add(int numb) throws InterruptedException {
		while (index >= array.length) {
			wait();
		}
		array[index] = numb;
		index++;
		notifyAll();

	}

	public synchronized int remove() throws InterruptedException {
		while (index == 0) {
			wait();
		}
		index--;
		int result = array[index];
		notifyAll();
		return result;
	}
}
