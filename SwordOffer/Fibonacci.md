- 问题描述

大家都知道斐波那契数列，现在要求输入一个整数n，请你输出斐波那契数列的第n项（从0开始，第0项为0）。
n<=39

- 解题思路

- 代码实现
```java
public class Fibonacci{
	public static int fibonacci(int n) {
        if(n <= 0){
            return 0;
        }
        if(n == 1){
            return 1;
        }
        int a = 0;
        int b = 1;
        int result = 0;
        for(int i = 2; i <= n; i++){
            result = a + b;
            a = b;
            b = result;
        }   
       return result;
    }

    public static void main(String[] args) {
    	System.out.println("value: " + fibonacci(6));
    }
}
```