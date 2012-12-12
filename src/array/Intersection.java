/**
 * 
 */
package array;

import java.util.ArrayList;

/**
 * @author changsi
 *
 */
public class Intersection {
	
	public ArrayList<Integer> get_intersection(int [][] a){
		MyArray[] array= new MyArray[a.length];
		ArrayList<Integer> result = new ArrayList<Integer>();
		for(int i=0; i<a.length;i++){
			array[i]= new MyArray(a[i]);
		}
		int d=0;
		while(array[0].pointer<array[0].array.length){
			int value = array[0].nextGEQ(d);
			for(int i=1; (i<a.length) && ((d=array[i].nextGEQ(value))==value);i++);
			if(d==value){
				result.add(value);
				d=d+1;
			}
			else{
				if(d==Integer.MAX_VALUE){
					return result;
				}
			}
		}
		return result;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int [][] arrays = new int [][]{{1,34,65,775,2323,77667,323236655},{34,65,775,67656,323232},{65,775,323232,7556425,323236655}};
		Intersection intersection = new Intersection();
		System.out.println(intersection.get_intersection(arrays));
	}

}
