import java.util.ArrayList;

public class Linked{
	public static void main(String[] args) {
		// testMerge();
		// testLoop();
		// testfindKthToTail();
		testCopyComplexList();
	}

	public static void testMerge(){
		int[] data = {1, 2, 3, 4, 5, 6};
		int[] data1 = {2, 5, 7, 8};
		LinkedNode head = LinkedNode.build(data);
		LinkedNode head1 = LinkedNode.build(data1);
		head = mergeSortedNodeEx(head, head1);
		while(head != null){
			System.out.println("node: " + head.value);
			head = head.next;
		}
	}

	/**测试环形链表入口检测**/
	public static void testLoop(){
		LinkedNode ln1 = new LinkedNode(0);
		LinkedNode ln2 = new LinkedNode(1);
		LinkedNode ln3 = new LinkedNode(2);
		LinkedNode ln4 = new LinkedNode(3);
		LinkedNode ln5 = new LinkedNode(4);
		LinkedNode ln6 = new LinkedNode(5);
		ln1.next = ln2;
		ln2.next = ln3;
		ln3.next = ln4;
		ln4.next = ln5;
		ln5.next = ln6;
		ln6.next = ln3;
		LinkedNode result = entryListOfLoop(ln1);
		System.out.println(" loop result: " + result.value);
	}

	public static void testfindKthToTail(){
		int[] data = {1, 2, 3, 4, 5, 6};
		LinkedNode head = LinkedNode.build(data);
		LinkedNode result = findKthToTail(head, 2);
		LinkedNode result1 = findKthToTail(head, 7);
		if (result != null) {
			System.out.println(" result: " + result.value + " result1: " + result1);
		}
	}

	public static void testCopyComplexList(){
		int[] data = {1, 2, 3, 4, 5, 6};
		LinkedNode head = LinkedNode.build(data);
		head = copyComplexLinked(head);
		while(head != null){
			System.out.println("node: " + head.value);
			head = head.next;
		}
	}

	public static class LinkedNode{
		public int value;
		public LinkedNode next;
		public LinkedNode random;

		public LinkedNode(int value){
			this.value = value;
		}

		public LinkedNode(LinkedNode node){
			if (node != null) {
				this.value = node.value;
			}
		}

		public static LinkedNode build(int[] data){
			if (data == null || data.length == 0) {
				
				return null;
			}
			LinkedNode head = new LinkedNode(data[0]);
			LinkedNode indexNode = head;;

			for (int i=1; i<data.length; i++) {
				indexNode.next = new LinkedNode(data[i]);
				indexNode = indexNode.next;
			}
			return head;
		}

		public static LinkedNode buildCycler(int[] data, int cycleNode){

			return null;
		}
	}


	public static LinkedNode reverse(LinkedNode head){
		if (head != null) {
			LinkedNode pre = null;
			LinkedNode indexNode = head;
			while(indexNode != null){
				LinkedNode tmp = indexNode.next;
				indexNode.next = pre;
				pre = indexNode;
				indexNode = tmp;
			}
			return pre;
		}
		return head;
	}

	public static boolean hasNodeInCycler(LinkedNode head){

		return false;
	}


	/**合并两个有序链表，使用遍历方法**/
	public static LinkedNode mergeSortedNode(LinkedNode head1, LinkedNode head2){
		LinkedNode head = null;
		while(head1 != null && head2 != null){
			LinkedNode tmp = null;
			if (head2.value > head1.value) {
				tmp = head1;
				head1 = head1.next;
			}else{
				tmp = head2;
				head2 = head2.next;
			}
			//插入需要合并的节点
			insert(head, tmp);
		}
		while(head1 != null){
			insert(head, head1);
			head1 = head1.next;
		}

		while(head2 != null){
			insert(head, head2);
			head2 = head2.next;
		}
		return head;
	}

	/**合并有序链表：使用递归方法**/
	public static LinkedNode mergeSortedNodeEx(LinkedNode head1, LinkedNode head2){
		if (head1 == null) {
			return head2;
		}
		if (head2 == null) {
			return head1;
		}
		int value1 = head1.value;
		int value2 = head2.value;
		LinkedNode head = null;
		if (value1 > value2) {
			head = head2;
			head.next = mergeSortedNodeEx(head1, head2.next);
		}else{
			head = head1;
			head.next = mergeSortedNodeEx(head1.next, head2);
		}
		return head;
	}

	/**从链表尾部打印到头部**/
	public static void printTailToHead(LinkedNode head){
		if (head != null) {
			printTailToHead(head.next);
			System.out.println("value: " + head.value);
		}
	}

	/**找到链表的倒数第K个节点**/
	public static LinkedNode findKthToTail(LinkedNode head, int k){
		if (head != null && k > 0) {
			int n = 0;
			LinkedNode kNode = head;
			LinkedNode indexNode = head;
			while(indexNode.next != null){
				if (n == k-1) {
					kNode = kNode.next;
				}else{
					n++;
				}
				indexNode = indexNode.next;
			}
			//边界条件需要注意:删除的范围超过了链表的大小
			System.out.println(" K: " + kNode.value);
			if (n < k-1) {
				
				return null;
			}
			return kNode;
		}
		return null;
	}

	 public static LinkedNode findKthToTailEx(LinkedNode head,int k) {
        if(head != null && k > 0){
            LinkedNode pKNode = head;
            LinkedNode nKNode = head;
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

	/**删除链表的第K个节点**/
	public static LinkedNode deleteKthNodeToTail(LinkedNode head, int k){
		if (head != null && k > 0) {
			LinkedNode index = head;
			LinkedNode preDelete = head;
			int n = 0;
			while(index.next != null){
				if (n == k) {
					preDelete = preDelete.next;
				}else{
					++n;
				}
				index = index.next;
			}
			if (n < k) {
				return null;
			}
			if (preDelete != null && preDelete.next != null) {
				preDelete.next = preDelete.next.next;
			}
			return head;
		}
		return null;
	}

	/**寻找环形链表的入口**/
	public static LinkedNode entryListOfLoop(LinkedNode head){
		if (head != null && head.next != null) {
			LinkedNode slow = head.next;
			LinkedNode fast = head.next.next;
			//确认是否是环形链表，使用快慢指针
			while(slow != fast){
				if (fast != null && fast.next != null) {
					slow = slow.next;
					fast = fast.next.next;
				}else{
					break;
				}
			}
			//找出环形链表的入口
			fast = head;
			while(slow != fast){
				slow = slow.next;
				fast = fast.next;
			}
			return fast;
		}
		return null;
	}

	public static LinkedNode copyComplexLinked(LinkedNode head){
		if (head != null && head.next != null) {
			LinkedNode copyIndex = head;
			LinkedNode node = head;
			System.out.println(" start copy");
			//复制链表
			while(node != null){
				LinkedNode newNode = new LinkedNode(node);
				newNode.next = node.next;
				node.next = newNode;
				node = newNode.next;
			}
			System.out.println(" end copy");
			//将随机链表链接起来
			node = head;
			while(node != null && node.next != null){
				if (node.random != null) {
					node.next.random = node.random.next;
				}
				node = node.next.next;
			}
			System.out.println(" link random end");
			//将链表从大的链表中拎出来
			LinkedNode copyHead = head.next;
			copyIndex = copyHead;
			if (copyIndex != null) {
				node = copyIndex.next;
			}
			while(node != null && node.next != null){
				copyIndex.next = node.next;
				copyIndex = copyIndex.next;
				if (copyIndex != null) {
					node = copyIndex.next;
				}
			}
			System.out.println(" all end");
			return copyHead;
		}
		return null;
	}


	public static void insert(LinkedNode head, LinkedNode appendNode){
		if (head == null) {
			head = appendNode;
		}else{
			LinkedNode indexNode = head;
			while(indexNode != null){
				if (indexNode.next != null) {
					indexNode = indexNode.next;
				}else{
					indexNode.next = appendNode;
				}
			}
		}
	}
}




