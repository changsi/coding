/**
 * 
 */
package linklist;

import java.awt.List;

/**
 * @author changsi
 *
 */
public class LinkList{

	private LinkListNode head;
	
	public LinkList(){
		this.head = null;
	}

	public LinkListNode find(int value){
		LinkListNode temp_head = this.head;
		while(temp_head != null){
			if(temp_head.get_value() == value){
				return temp_head;
			}
			temp_head = temp_head.get_link();
		}
		return null;
	}
	
	public void remove_duplicate(){
		LinkListNode previous=this.head;
		LinkListNode current=head.link;
		LinkListNode runner= this.head;
		while(current !=null){
			while(runner!=current){
				if(runner.value == current.value){
					previous.link = current.link;
					current = current.link;
					runner = head;
					break;
				}
				runner = runner.link;
			}
			if(runner == current){
				previous = current;
				current = current.link;
				runner = this.head;
			}
		}
	}

	public void insert_at_front(int value){
		LinkListNode new_node = new LinkListNode(value);
		new_node.set_link(this.head);
		this.head = new_node;
	}
	
	public void insert_at_front(LinkListNode node){
		node.set_link(this.head);
		this.head = node;
	}

	public boolean delete_node(LinkListNode node){
		if(node == null){
			return false;
		}
		node.value = node.link.value;
		node.link = node.link.link;
		return true;
	}

	public void delete_list(){
		LinkListNode temp_head = this.head;
		while(temp_head != null){
			LinkListNode temp = temp_head;
			temp.set_link(null);
			temp_head = temp_head.get_link();
		}
		this.head = null;
	}
	
	public static LinkListNode add_link_list(LinkListNode list1, LinkListNode list2, int carrer){
		if(list1 == null && list2 == null){
			return null;
		}else{
			LinkListNode node = new LinkListNode(0, null);
			int value = carrer;
			if(list1 !=null){
				value = value + list1.value;
			}
			if(list2 !=null){
				value = value + list2.value;
			}
			node.value = value%10;
			node.link = add_link_list(list1==null? null: list1.link, list2 == null? null:list2.link, value>=10? 1:0);
			return node;
		}
		
	}
	
	public void print(){
		LinkListNode temp_head = this.head;
		while(temp_head != null){
			System.out.print(temp_head.get_value()+"  ");
			temp_head = temp_head.get_link();
		}
		System.out.println();
	}
	
	public static void main(String[] args){
		LinkList list1 = new LinkList();
		LinkList list2 = new LinkList();
		list1.insert_at_front(5);
		list1.insert_at_front(1);
		list1.insert_at_front(3);
		list2.insert_at_front(1);
		list2.insert_at_front(4);
		list2.insert_at_front(9);
		list2.insert_at_front(5);
		LinkListNode node =LinkList.add_link_list(list1.head, list2.head, 0);
		
		LinkListNode temp_head = node;
		while(temp_head != null){
			System.out.print(temp_head.get_value()+"  ");
			temp_head = temp_head.get_link();
		}
		System.out.println();
	}
	

}
