import java.util.*;

public class PrintListFromTailToHead{

	private ArrayList<ListNode> mTailToHeadList = new ArrayList<ListNode>();
	public ArrayList<ListNode> printListFromTailToHead(ListNode head){
		if (head != null) {
			if (head.next != null) {
				printListFromTailToHead(head.next);
			}
			mTailToHeadList.add(head);
		}
		return mTailToHeadList;
	}

	public static void main(String[] args) {
		PrintListFromTailToHead head = new PrintListFromTailToHead();
		ListNode node = ListNode.createSimpleList();
		ArrayList<ListNode> list = head.printListFromTailToHead(node);
		for (int j = 0; j < list.size(); j++) {
			System.out.println("node: " + list.get(j).val);
		}
	}
}