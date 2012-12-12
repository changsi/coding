/**
 * 
 */
package linklist;

/**
 * @author changsi
 *
 */
public class LinkListNode {
	public int value;
	public LinkListNode link;
	
	public LinkListNode(int value){
		this.value = value;
		this.link = null;
	}
	
	public LinkListNode(int value, LinkListNode link){
		this.value = value;
		this.link = link;
	}
	
	public LinkListNode(){
		this.value = 0;
		this.link = null;
	}
	
	public int get_value(){
		return this.value;
	}
	
	public void set_value(int value){
		this.value = value;
	}
	
	public LinkListNode get_link(){
                return this.link;
        }
	
	public void set_link(LinkListNode link){
		this.link = link;
	}

}
