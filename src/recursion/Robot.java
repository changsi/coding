/**
 * 
 */
package recursion;

/**
 * @author changsi
 *
 */
public class Robot {
	
	public void findPath(int m, int n){
		Counter count = new Counter();
		path(m, n, count,"");
		System.out.println(count.a);
	}
	
	public void path(int left, int down, Counter count, String path){
		if(left==0 && down ==0){
			count.add();
			System.out.println(path);
			return;
		}
		
		if(left!=0){
			path(left -1, down, count, path+" left");
		}
		if(down != 0){
			path(left, down-1, count, path+" down");
		}
		return;
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Robot robot = new Robot();
		robot.findPath(5, 5);
	}

}
