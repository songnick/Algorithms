- 问题描述：  
  输入一个链表，输出该链表中倒数第k个结点。

- 问题分析：  
  1.使用两个标志位，开始时分别指向链表的头；  
  2.开始第一个标志位开始遍历到第k个位置；  
  3.第一个标志位和第二个标志位同时开始遍历，当第一个标志位遍历到最后的时候，第二个标志位达到的位置就是需要的位置；  
  说明：第一个时从k位置开始遍历，那么走到最后的位置需要走：length－k；  
  index ＝ length － k；

- 代码实现
```java
public class FindKthToTail{

	public static ListNode findKthToTail(ListNode head, int k){
		if(head != null && k > 0){
            ListNode pKNode = head;
            ListNode nKNode = head;
            for(int i = 0; i < k -1; i++){
                if(pKNode.next != null){
                    pKNode = pKNode.next;
                }else{
                    return null;
                }
            }
            while(pKNode.next != null){
                pKNode = pKNode.next;
                nKNode = nKNode.next;
            }
            return nKNode;
        }
        return null;
	}
	public static void main(String[] args) {
		ListNode result = findKthToTail(ListNode.createSimpleList(), 3);
		while(result != null){
			System.out.println(result.val);
			result = result.next;
		}
	}

}
```