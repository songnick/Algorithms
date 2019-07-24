public class MPowerN{

	public static int pow(int n, int m){
	    int sum = 1;
	    int tmp = m;
	    int count = 0;
	    while(n != 0){
	        if((n & 1) == 1){
	            sum *= tmp;
	            System.out.println("SumCount: " + count);
	        }
	        tmp *= tmp;
	        n = n >> 1;
	        System.out.println("count: " + count++);
	    }

	    return sum;
	}

	public static void main(String[] args) {
		System.out.println(" result: " + pow(8, 2));
	}
}