/**
 * 
 */
package synchronization;

/**
 * @author changsi
 *
 */
public class ConcurrentPrint {
	
	
	
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PrintTask task = new PrintTask();
		new Thread(task).start();
		new Thread(task).start();
		new Thread(task).start();
		new Thread(task).start();
		new Thread(task).start();
		
		

	}

}

class PrintTask implements Runnable{
	
	int num = 0;
	
	Object object = new Object();
	
	public void run(){
		synchronized(this.object){
			try{
				for(int i=0;i<100;i++){
					System.out.println(Thread.currentThread().getName()+"   "+i);
					Thread.sleep(1000);
				}
				
			}catch(Exception e){
				e.printStackTrace();
			}
		}
		
		
	}
}
