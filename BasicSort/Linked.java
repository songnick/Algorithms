public class Linked{
	public static void main(String[] args) {
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

	public static class LinkedNode{
		public int value;
		public LinkedNode next;

		public LinkedNode(int value){
			this.value = value;
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




