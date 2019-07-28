- 问题描述：
输入一个整数数组，实现一个函数来调整该数组中数字的顺序，使得所有的奇数位于数组的前半部分，所有的偶数位于数组的后半部分，并保证奇数和奇数，偶数和偶数之间的相对位置不变。

－ 解题思路：
1.设置两个index变量，记录偶数位置和奇数位置；
2.遍历数组找到第一个偶数位置，然后从该位置找到第一个奇数位置；
3.使用临时变量存放该奇数值，将从偶数值的位置统一向奇数的位置右移一位；
4.将奇数值赋值给偶数位；

－ 代码实现
```java
public class Solution {
    public void reOrderArray(int [] array) {
        int oddIndex = 0;
        int evenIndex = 0;
        int len = array.length;
        while(oddIndex < len){
            while(oddIndex < len && (array[oddIndex] % 2) != 0){
                oddIndex++;
            }
            evenIndex = oddIndex+1;
            while(evenIndex < len && (array[evenIndex] % 2) == 0 ){
                evenIndex++;
            }
            if(evenIndex < len){
                int tmp = array[evenIndex];
                for(int j = evenIndex - 1; j >= oddIndex; j--){
                    array[j+1] = array[j];
                }
                array[oddIndex++] = tmp;
            }else{
                break;
            }
        }
    }  
}
```
