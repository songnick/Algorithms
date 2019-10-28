
import java.util.Stack;

public class StackQueue{
	public static void main(String[] args) {
		
	}

	public static int caculate(String cs){
		if (cs != null && "".equals(cs)) {
			char[] chars = cs.toCharArray();
			Stack<String> data = new Stack<>();
			Stack<String> magic = new Stack<>();
			for (int i = 0 ; i < chars.length; i++) {
				String s = "" + chars[i];
				boolean isMagic = "+".equals(s) || "-".equals(s) || "*".equals(s) || "/".equals(s);
				if (isMagic) {
					magic.push(s);
				}else{
					data.push(s);
				}
			}
		}
		return 0;
	}

}