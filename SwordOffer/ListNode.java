public class ListNode{
	public int val;

	public ListNode next;

	public ListNode(int val){
		this.val = val;
	}

	public static ListNode createSimpleList(){
		ListNode head = new ListNode(0);
		ListNode tmp = head;
		for (int j = 1; j<5 ; j++) {
			tmp.next = new ListNode(j);
			tmp = tmp.next;
		}
		return head;
	}
}