- 问题描述
输入一个链表，按链表值从尾到头的顺序返回一个ArrayList。

- 解题思路
主要的思想就是使用递归调用，从最后一个节点添加到ArrayList

- 代码实现

```java
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
```