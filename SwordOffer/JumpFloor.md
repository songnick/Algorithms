- 问题描述：
一只青蛙一次可以跳上1级台阶，也可以跳上2级。求该青蛙跳上一个n级的台阶总共有多少种跳法（先后次序不同算不同的结果）。

- 问题分析
主要的解决方法是使用了动态规划的思想，假设第i个阶梯有a种跳法，第i－1有b种跳法，那么i＋1有多少种跳法呢：
由于题目要求，一次只能跳1级台阶或者2级台阶，那么i＋1这个位置，要不从i－1位置跳上来，要不就是从i位置跳上来，所以对应的i＋1位置的跳法就是a＋b；
- 代码实现
```java
public class JumpFloor{

public static int jumpFloor(int target) {
            if(target == 1 || target == 2){
                return target;
            }
        int step1 = 1;
        int setp2 = 2;
        int finalStep = 0;
        for(int i = 3; i <= target; i++ ){
            finalStep = step1 + setp2;
            step1 = setp2;
            setp2 = finalStep;
        }
        return finalStep;
    }

	public static void main(String[] args) {
		System.out.println(jumpFloor(6));
	}
}
```