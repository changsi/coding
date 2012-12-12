package recursion;

import java.util.Stack;

public class Hanoi {
	Tower[] towers;
	public Hanoi(int n){
		this.towers = new Tower[3];
		for(int i=0; i<3; i++){
			this.towers[i]= new Tower();
		}
		for(int i=n-1;i>=0;i--){
			this.towers[0].stack.push(i);
		}
	}
	
	public void move(){
		this.towers[0].move(towers[0].stack.size(), towers[2], towers[1]);
		
	}
	
	public void print(){
		for(int i=0;i<3;i++){
			Tower temp = towers[i];
			System.out.println("---------------tower "+i+"-----------------");
			while(!temp.stack.isEmpty()){
				System.out.println(temp.stack.pop());
			}
		}
		
	}
	
	public static void main(String argc[]){
		Hanoi hanoi = new Hanoi(7);
		hanoi.move();
		hanoi.print();
	}
}

class Tower{
	int index;
	Stack<Integer> stack = new Stack<Integer>();
	
	public void move(int n, Tower destination, Tower buffer){
		if(n>0){
			move(n-1, buffer, destination);
			destination.stack.push(this.stack.pop());
			buffer.move(n-1, destination, this);
		}
	}
}
