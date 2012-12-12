/**
 * 
 */
package test;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/**
 * @author changsi
 * 
 */
public class ClosestFriends {

	ArrayList<PriorityQueue<QueueNode>> queue;
	ArrayList<FriendNode> nodes;
	//HashMap<Integer, Integer> map;

	public ClosestFriends() {
		this.queue = new ArrayList<PriorityQueue<QueueNode>>();
		this.nodes = new ArrayList<FriendNode>();
		//this.map = new HashMap<Integer, Integer>();
	}

	public void read(String file) {
		String thisLine;
		try {
			BufferedReader br = new BufferedReader(new FileReader(file));
			while ((thisLine = br.readLine()) != null) {
				StringTokenizer token = new StringTokenizer(thisLine.trim(),
						" ");
				int id = Integer.parseInt(token.nextToken().trim());
				double x = Double.parseDouble(token.nextToken().trim());
				double y = Double.parseDouble(token.nextToken().trim());
				nodes.add(new FriendNode(id, x, y));
				queue.add(new PriorityQueue<QueueNode>());
				//map.put(id, this.nodes.size() - 1);
				for (int i = 0; i < this.nodes.size() - 1; i++) {
					double distance = Math.pow((x - this.nodes.get(i).x), 2)
							+ Math.pow((y - this.nodes.get(i).y), 2);
					PriorityQueue<QueueNode> temp1 = queue.get(i);
					if (temp1.size() < 3) {
						temp1.add(new QueueNode(this.nodes.size() - 1, distance));
					} else {
						if (temp1.peek().value > distance) {
							temp1.remove();
							temp1.add(new QueueNode(this.nodes.size() - 1,
									distance));
						}
					}
					PriorityQueue<QueueNode> temp2 = queue.get(this.queue
							.size() - 1);
					if (temp2.size() < 3) {
						temp2.add(new QueueNode(i, distance));
					} else {
						if (temp2.peek().value > distance) {
							temp2.remove();
							temp2.add(new QueueNode(i, distance));
						}
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void getTopThreeClosestFriends() {
		for (int i = 0; i < this.nodes.size(); i++) {
			System.out.print(this.nodes.get(i).id + ":");
			for (int j = 0; j < 3; j++) {
				System.out.print(this.nodes.get(((QueueNode) this.queue.get(i)
						.remove()).id).id + " ");
			}
			System.out.println();
		}
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ClosestFriends friends = new ClosestFriends();
		friends.read(args[0]);
		friends.getTopThreeClosestFriends();
	}

}
