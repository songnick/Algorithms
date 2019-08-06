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