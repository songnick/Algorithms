public class JumpFloorII{

	public static int jumpFloorII(int target){
		if (target <= 0) {
			return 0;
		}
		if (target == 1) {
			
			return 1;
		}

		return 2*jumpFloorII(target - 1);
	}

	public static void main(String[] args) {
		System.out.println(jumpFloorII(4));
	}

}