/**
 * 
 */
package histogram;

import java.util.Stack;

/**
 * @author changsi
 *
 */
public class Histogram {
	
	public static int getMaximumRectangle(int[] heights){
		int max = 0;
		if(heights.length == 0){
			return 0;
		}
		if(heights.length == 1){
			return heights[0];
		}
		Stack<Record> stack = new Stack<Record>();
		for(int i=0; i<heights.length; i++){
			
			if(!stack.empty()){
				Record temp = stack.peek();
				if(temp.height< heights[i]){
					stack.push(new Record(i,heights[i]));
					continue;
				}
				if(temp.height==heights[i]){
					continue;
				}
				while(heights[i]<temp.height && !stack.empty()){
					temp = stack.pop();
					if(max<getArea(temp.start,i,temp.height)){
						max = getArea(temp.start,i,temp.height);
					}
				}
			}
			
			stack.push(new Record(i, heights[i]));
		}
		return max;
	}
	
	private static int getArea(int start, int end, int height){
		return (end-start)*height;
	}
		
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] heights = {0,0};
		System.out.println(getMaximumRectangle(heights));
	}

}


class Record {
	public int start;
	public int height;
	
	public Record(int start, int height){
		this.start = start;
		this.height = height;
	}
}