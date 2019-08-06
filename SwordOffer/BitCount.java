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