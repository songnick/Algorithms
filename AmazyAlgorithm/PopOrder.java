import java.util.*;

public class PopOrder{

	public static boolean isPopOrder(int[] pushA, int[] popA){
		Stack<Integer> stack = new Stack<Integer>();
        if(pushA != null && popA != null){
            if(pushA.length == 0){
                return false;
            }
            int pushIndex = 0;
            int popIndex = 0;
            while(pushIndex < pushA.length){
                stack.push(pushA[pushIndex++]);
                while(popIndex < popA.length && stack.peek() == popA[popIndex]){
                    stack.pop();
                    popIndex++;
                }
            }
        }
        return stack.isEmpty();
	}

	public static void main(String[] args) {
		int[] push = {1,2,3,4,5};
		int[] pop = {4,5,3,2,1};
		System.out.println(" is pop order: " + isPopOrder(push, pop));
	}

}