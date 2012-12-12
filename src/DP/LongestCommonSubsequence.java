/**
 * 
 */
package DP;

/**
 * @author changsi
 *
 */
public class LongestCommonSubsequence {
	
	public static String getLongestCommonSubsequence(String x, String y){
		DPNode[][] matrix = new DPNode[x.length()+1][y.length()+1];
		for(int i=0; i<matrix.length; i++){
			for(int j=0; j<matrix[i].length; j++){
				DPNode tmp = new DPNode();
				matrix[i][j] = tmp;
				if(i==0 || j==0){
					matrix[i][j].value = 0;
				}
			}
		}
		for(int i=1; i<matrix.length; i++){
			for(int j=1; j<matrix[i].length; j++){
				if(x.charAt(i-1)==y.charAt(j-1)){
					matrix[i][j].value = matrix[i-1][j-1].value+1;
					matrix[i][j].previous = matrix[i-1][j-1];
					matrix[i][j].c=x.charAt(i-1);
				}
				else{
					int max = max(matrix[i][j-1].value, matrix[i-1][j].value);
					matrix[i][j].value=max;
					if(max==matrix[i][j-1].value){
						matrix[i][j].previous = matrix[i][j-1];
					}else{
						matrix[i][j].previous = matrix[i-1][j];
					}
					
				}
			}
		}
		DPNode track = matrix[x.length()][y.length()];
		String result = "";
		while(track!=null){
			result =track.c + result;
			track = track.previous;
		}
		return result;
	}
	
	private static int max(int x, int y){
		if(x<y) return y;
		else return x;
	}
	
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(LongestCommonSubsequence.getLongestCommonSubsequence("abecgc", "agbec"));
	}

}
