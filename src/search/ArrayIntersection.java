/**
 * 
 */
package search;

import java.util.ArrayList;

/**
 * @author changsi
 *
 */
public class ArrayIntersection {
	
	public static ArrayList<Integer> find_intersection(int [][] arrays){
		int value=0;
		Integer [] pointer = new Integer [arrays.length];
		ArrayList<Integer> result = new ArrayList<Integer>();
		for(int i=0; i<pointer.length;i++){
			pointer[i]=new Integer(0);
		}
		int next = 0;
		while(pointer[0]<arrays[0].length){
			value = find_GEQ(arrays[0], pointer[0], value);
			for(int i=1; i<arrays.length && (next=find_GEQ(arrays[i], pointer[i], value))==value; i++);
			if(next == value){
				result.add(next);
				value = value +1;
			}
			else{
				if(next == -1){
					return result;
				}else{
					value = next;
				}
				
			}
			
		}
		return result;
		
		
	}
	
	private static int find_GEQ(int [] array, Integer index, int value){
		int next=-1;
		while(index<array.length ){
			if((next=array[index])>=value){
				return next;
			}
			index++;
		};
		if(index == array.length){
			return -1;
		}
		return next;
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int [][] arrays = new int [][]{{1,34,65,775,2323,77667,323236655},{34,65,775,67656,323232},{65,775,323232,7556425,323236655}};
		System.out.println(ArrayIntersection.find_intersection(arrays));
	}

}
