
/***
这个类主要是处理int类型相关的算法
*/

public class Int{
	public static void main(String[] args) {
		System.out.println(" result: " + numberOf1Between1AndNSolution(2));
	}


	/***剑指offer：统计1-n中含有1的个数**/
	public static int numberOf1Between1AndNSolution(int n) {
        int count = 0;
         while(n > 0){
             String str = String.valueOf(n);
             char[] cs = str.toCharArray();
             for(int i=0; i < cs.length; i++){
                 if(cs[i] == '1'){
                     count++;
                 }
             }
             n--;
         }
        return count;
    }
}