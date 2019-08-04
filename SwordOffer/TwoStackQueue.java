import java.util.*;

public class TwoStackQueue{

	Stack<Integer> stack1 = new Stack<Integer>();
    Stack<Integer> stack2 = new Stack<Integer>();
    
    public void push(int node) {
        stack1.push(node); 
    }
    
    public int pop() {
        if(stack2.isEmpty()){
            while(!stack1.isEmpty()){
                stack2.push(stack1.pop());
            }      
        }
        if(stack2.isEmpty()){
            return Integer.MAX_VALUE;
        }
        
        return stack2.pop();
    }

	public static void main(String[] args) {
		TwoStackQueue test = new TwoStackQueue();
		test.push(1);
		test.push(2);
		test.push(3);
		int tmp = Integer.MAX_VALUE;
		while((tmp = test.pop()) != Integer.MAX_VALUE){
			System.out.println("value: " + tmp);
		}
	}
}