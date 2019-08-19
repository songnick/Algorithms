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