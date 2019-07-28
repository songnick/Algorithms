- 问题描述：
在一个二维数组当中，每行从左到右递增的顺序排列，每一列从上到下递增的顺序排列。完成一个函数，输入这样一个二维数组和一个整数，判断数组中是否包含该整数。
```java
public class SearchValueInArray{
    public static boolean find(int target, int [][] array) {
        boolean found = false;
        System.out.println(" size: " + array.length);
        if (array != null && array.length > 1){
            int row = 0;
            int cloum = array.length - 1;
            while (row < array.length && cloum >= 0){
                if (array[row][cloum] == target){
                    found = true;
                    break;
                }
                if (array[row][cloum] > target){
                    cloum--;
                }else {
                    row++;
                }
            }
        }

        return found;
    }
    public static void main(String[] args) {
        int[][] array = {{}};
        System.out.println("result: " + find(3, array));
    }
}
```