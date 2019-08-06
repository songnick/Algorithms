- 问题描述

  请实现一个函数，将一个字符串中的每个空格替换成“%20”。例如，当字符串为We Are Happy.则经过替换之后的字符串为We%20Are%20Happy。

- 思路分析

  主要思路分为：
  1.统计空格数量；
  2.对目前的字符数组进行扩容：主要就是根据空格数乘以2得到扩容的数量，这里主要是因为空格需要替换为％20，由于空格本身已经有一个占位，所以要增加两位；
  3.使用两个指针，一个指针从原始字符数组的末端开始，一个指针从扩容后的字符数组的末端开始；
  	如果第一个指针未遇到空格，直接将当前位置的移动到扩容字符的指针位置；
  	如果第一个指针遇到空格，从当前指针位置开始填充替换的％20；

- 代码实现
```java
public class ReplaceSpace{
	public static String replaceSpace(StringBuffer str) {
    	StringBuffer sb = str;
    	//判空保护
        if(sb == null || sb.length() <= 0){
            return sb.toString();
        }
        //获取需要扩容的大小
        int appendLength = 0;
        for (int i = 0; i < sb.length(); i++){
            char r = sb.charAt(i);
            if (r == ' '){
               appendLength++;
            }
        }
        int originalIndex = sb.length() - 1;
        int newLength = sb.length() + appendLength * 2;
        int newIndex = newLength - 1;
        //扩容
        sb.setLength(newLength);
        System.out.println(" append length: " + appendLength + " buffer length: " + sb.length() + " new length: " + newLength);
        //使用两个指针进行遍历，并对字符进行处理
        while (originalIndex >=0 && newIndex > originalIndex){
            char test = sb.charAt(originalIndex);
            if (test == ' '){
                sb.setCharAt(newIndex--, '0');
                sb.setCharAt(newIndex--, '2');
                sb.setCharAt(newIndex--, '%');
            }else {
                sb.setCharAt(newIndex--, sb.charAt(originalIndex));
            }
            originalIndex--;
        }
        return sb.toString();
    }
    //测试代码
	public static void main(String[] args) {
		System.out.println(replaceSpace(new StringBuffer("helloworld ")));
	}
}
```