public class MergeSortedList{
	public static ListNode merge(ListNode list1,ListNode list2) {
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
           mergeHeader.next = Merge(list1, list2.next);
        }else{
           mergeHeader = list1;
           mergeHeader.next = Merge(list1.next, list2);
        }
        
        return mergeHeader;
    }

    public static void main(String[] args) {
    	
    }
}