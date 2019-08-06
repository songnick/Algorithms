

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