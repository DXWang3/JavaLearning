package Lab3.lab3;
public class DoubleChain {
	
	private DNode head;
	
	public DoubleChain(double val) {

		head = new DNode(val);
	}

	public DNode getFront() {

        while(head.prev != null) {
            head = head.prev;
        }
		return head;
	}

	/** Returns the last item in the DoubleChain. */		
	public DNode getBack() {

        head = this.getFront();
        DNode temp = head;

        while (temp.next != null){
           temp = temp.next;
        }
		return temp;
	}
	
	/** Adds D to the front of the DoubleChain. */	
	public void insertFront(double d) {

        head = this.getFront();
        head.prev = new DNode(null, d, head);
        head = head.prev;
	}
	
	/** Adds D to the back of the DoubleChain. */	
	public void insertBack(double d) {

        head = this.getFront();
        while (head.next != null) {
            head = head.next;
        }
        head.next = new DNode(head, d, null);
        head = this.getFront();
	}
	
	/** Removes the last item in the DoubleChain and returns it. 
	  * This is an extra challenge problem. */
	public DNode deleteBack() {

        head = this.getFront();
        DNode temp = head;
        if (temp.next == null) {
            DNode last = temp;
            temp.prev.next = null;
            return last;
        } else {
            while (temp.next.next != null){
                temp = temp.next;
            }
            DNode last = temp.next;
            temp.next = null;
            return last;
        }
	}
	
	/** Returns a string representation of the DoubleChain. 
	  * This is an extra challenge problem. */
	public String toString() {

        String list = "";
        head = this.getFront();
        while (head.next != null) {
            list = list.concat(head.val + ", ");
            head = head.next;
        }
        list = list.concat(Double.toString(head.val));
        return list;
	}

	public static class DNode {
		public DNode prev;
		public DNode next;
		public double val;
		
		private DNode(double val) {
			this(null, val, null);
		}
		
		private DNode(DNode prev, double val, DNode next) {
			this.prev = prev;
			this.val = val;
			this.next =next;
		}
	}
	
}
