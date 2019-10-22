public class Search{
	public static void main(String[] args) {
		int[] data = {4, 2, 0, 1, 9, 5};
		System.out.println(" result: " + binarySearch(data, 0, data.length-1, 8));
	}

	/***二分查找，遍历形式**/
	public static boolean binarySearch(int[] data, int low, int high, int target){
		if (data == null || data.length == 0 || low >= high) {
			
			return false;
		}
		while(low <= high){
			//可以用位运算的方式进行优化
			int mid = low + (high-low)/2;
			if (data[mid] == target) {
				return true;
			}else if (data[mid] < target) {
				low = mid + 1;
			}else{
				high = mid - 1;
			}
		}
		return false;
	}

	/**二分查找，递归方式**/
	public static int binarySearch(int[] data, int low, int high, int target){


		return -1;
	}
}