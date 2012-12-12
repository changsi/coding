/**
 * 
 */
package synchronization;

import java.util.concurrent.Semaphore;

/**
 * @author changsi
 * 
 */
public class ProducerAndConsumer_semaphor {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Semaphore full_lock = new Semaphore(0,true);
		Semaphore empty_lock = new Semaphore(100,true);
		Semaphore mutex_lock = new Semaphore(1,true);
		SharedBuffer2 buffer = new SharedBuffer2();
		Producer_Semaphor producer = new Producer_Semaphor(full_lock, empty_lock, mutex_lock, buffer);
		Consumer_Semaphore consumer = new Consumer_Semaphore(full_lock, empty_lock, mutex_lock, buffer);
		new Thread(producer).start();
		new Thread(consumer).start();
	}

}

class Producer_Semaphor implements Runnable{
	private Semaphore full_lock;
	private Semaphore empty_lock;
	private Semaphore mutex_lock;

	SharedBuffer2 buffer;

	public Producer_Semaphor(Semaphore full_lock, Semaphore empty_lock,
			Semaphore mutex_lock, SharedBuffer2 buffer) {
		this.full_lock = full_lock;
		this.empty_lock = empty_lock;
		this.mutex_lock = mutex_lock;
		this.buffer = buffer;
	}

	public void run() {
		try {
			
			for(int i=0;i<100;i++){
				this.empty_lock.acquire();
				this.mutex_lock.acquire();
				this.buffer.add(i);
				System.out.println("produce  "+i);
				this.mutex_lock.release();
				this.full_lock.release();
				Thread.sleep(1000);
			}
			
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}

class Consumer_Semaphore implements Runnable{
	private Semaphore full_lock;
	private Semaphore empty_lock;
	private Semaphore mutex_lock;

	SharedBuffer2 buffer;
	
	public Consumer_Semaphore(Semaphore full_lock, Semaphore empty_lock,
			Semaphore mutex_lock, SharedBuffer2 buffer){
		this.full_lock = full_lock;
		this.empty_lock = empty_lock;
		this.mutex_lock = mutex_lock;
		this.buffer = buffer;
	}
	
	public void run() {
		try {
			
			for(int i=0;i<100;i++){
				this.full_lock.acquire();
				this.mutex_lock.acquire();
				int result = this.buffer.remove();
				System.out.println("consume  "+result);
				this.mutex_lock.release();
				this.empty_lock.release();
				Thread.sleep(500);
			}
			
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}

class SharedBuffer2 {
	int[] buffer = new int[100];
	int index = 0;

	public void add(int numb) {
		this.buffer[this.index] = numb;
		this.index++;
	}

	public int remove() {
		this.index--;
		return this.buffer[this.index];
	}

}
