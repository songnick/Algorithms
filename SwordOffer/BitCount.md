- 问题描述
  输入一个整数，输出该数二进制表示中1的个数。其中负数用补码表示。
- 问题分析
  这里主要是用了位运算的相关知识，n & (n-1)运算主要是将最后一位的1剔除，这样不断的循环就可以统计到1占用的数量了

- 代码实现
```java
public class BitCount{
	public static int bitCount(int n){
		int count = 0;
		while(n != 0){
			n = n & (n-1);
			count++;
		}
		return count;
	}

	public static void main(String[] args) {
		System.out.println(bitCount(1) + " vv: " + bitCount(3));
	}
}
```