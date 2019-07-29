public class SearchValueInArray{
	public static boolean find(int target, int [][] array) {
        boolean found = false;
        System.out.println(" size: " + array.length);
        if (array != null && array.length > 1){
            int row = 0;
            int cloum = array.length - 1;
            while (row < array.length && cloum >= 0){
                if (array[row][cloum] == target){
                    found = true;
                    break;
                }
                if (array[row][cloum] > target){
                    cloum--;
                }else {
                    row++;
                }
            }
        }

        return found;
    }
    public static void main(String[] args) {
    	int[][] array = {{}};
    	System.out.println("result: " + find(3, array));
    }
}