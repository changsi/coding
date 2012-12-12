/**
 * 
 */
package DP;

/**
 * @author changsi
 *
 */
public class MoneyChanges {
	
	int total;
	DPNode[] track;
	int [] denomination = {1, 3, 5 , 10, 25};
	
	public MoneyChanges(int total){
		this.total = total;
		this.track = new DPNode[total+1];
		this.track[0] = new DPNode(0,null);
	}
	
	public int get_changes(){
		for(int i=1; i<=this.total;i++){
			this.track[i] = new DPNode();
			for(int j=0; j<this.denomination.length;j++){
				int min=Integer.MAX_VALUE;
				if(i>=this.denomination[j]){
					if((i-this.denomination[j])>=0){
						int temp = this.track[i-this.denomination[j]].value+1;
						if(temp<min){
							min = temp;
							this.track[i].value = min;
							this.track[i].index = j;
							this.track[i].previous = this.track[i-this.denomination[j]];
						}
					}
				}
			}
		}
		DPNode temp = this.track[this.total];
		while(temp.previous!=null){
			System.out.print(this.denomination[temp.index]+"  ");
			temp = temp.previous;
		}
		System.out.println();
		return this.track[this.total].value;
	}
	
	public int min(int a, int b){
		return a>b ? b:a;
	}
	
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MoneyChanges m = new MoneyChanges(98);
		System.out.println(m.get_changes());
	}

}
