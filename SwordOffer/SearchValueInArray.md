- 问题描述：
在一个二维数组当中，每行从左到右递增的顺序排列，每一列从上到下递增的顺序排列。完成一个函数，输入这样一个二维数组和一个整数，判断数组中是否包含该整数。
```java
public static boolean containValueInMatrix(int[][] data,int rows, int cloums, int value){
        boolean found = false;

        if (data != null && data.length > 0){
            int row = 0;
            int cloum = cloums - 1;
            while (row < rows && cloum >= 0){
                if (data[row][cloum] == value){
                    found = true;
                    break;
                }
                if (data[row][cloum] > value){
                    cloum--;
                }else {
                    row++;
                }
            }
        }

        return found;
    }
```