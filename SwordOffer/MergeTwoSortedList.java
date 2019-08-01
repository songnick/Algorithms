public class MergeTwoSortedList{
	public static ListNode mergeRecursion(ListNode list1,ListNode list2) {
        if(list1 == null){
            return list2;
        }
        if(list2 == null){
            return list1;
        }
        int index1 = list1.val;
        int index2 = list2.val;
        ListNode mergeHeader = null;
        if(index1 > index2){
           mergeHeader = list2;
           mergeHeader.next = mergeRecursion(list1, list2.next);
        }else{
           mergeHeader = list1;
           mergeHeader.next = mergeRecursion(list1.next, list2);
        }
        
        return mergeHeader;
    }


    public static ListNode mergeErgodic(ListNode list1, ListNode list2){
        if (list1 == null) {
            
            return list2;
        }
        if (list2 == null) {
            return list1;
        }
        ListNode newHead = null;
        ListNode tmpNode = null;
        while(list1 != null && list2 != null){
            int value1 = list1.val;
            int value2 = list2.val;
            if (value1 > value2) {
                if (newHead == null) {
                    newHead = list2;
                    tmpNode = newHead;
                }else{
                    tmpNode.next = list2;
                    tmpNode = list2;
                }
            }else{
                if (newHead == null) {
                    newHead = list1;
                    tmpNode = newHead;
                }else{
                    tmpNode.next = list1;
                    tmpNode = list1;
                }
            }

            while(list1 != null){
                tmpNode.next = list1;
                tmpNode = list1;
            }
            while(list2 != null){
                tmpNode.next = list2;
                tmpNode = list2;
            }
            
        }
        return newHead;
    }

    public static void main(String[] args) {
    	ListNode list1 = ListNode.createRevertList();
        ListNode list2 = ListNode.createSimpleList();
        ListNode newHead = mergeErgodic(list1, list2);
        while(newHead != null){
            System.out.println("newHead Value: " + newHead.val);
            newHead = newHead.next;
        }
    }
}