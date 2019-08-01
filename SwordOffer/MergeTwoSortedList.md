- 问题描述
输入两个单调递增的链表，输出两个链表合成后的链表，当然我们需要合成后的链表满足单调不减规则。

- 问题分析
这里使用两个方法处理这个问题：
	1.使用递归方法
	2.使用遍历方法

- 代码实现
	1.递归方法如下：
```java
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
```
	2.遍历方法如下：
```java
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
                list2 = list2.next;
            }else{
                if (newHead == null) {
                    newHead = list1;
                    tmpNode = newHead;
                }else{
                    tmpNode.next = list1;
                    tmpNode = list1;
                }
                list1 = list1.next;
            }
            
        }
         while(list1 != null){
                tmpNode.next = list1;
                tmpNode = list1;
                list1 = list1.next;
            }
            while(list2 != null){
                tmpNode.next = list2;
                tmpNode = list2;
                list2 = list2.next;
            }
        return newHead;
    }
```