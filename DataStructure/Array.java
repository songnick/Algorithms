import java.util.ArrayList;
import java.util.HashMap;

public class Array{
	public static void main(String[] args) {
		
	}

	/**剑指offer：数组中有一个数字出现的次数超过数组长度的一半，请找出这个数字，如果不存在返回0***/
	public static int moreThanHalfNum(int[] array){
		if (array != null && array.length > 0) {
			if (array.length == 1) {
				return array[0];
			}
			HashMap<Integer, Integer> map = new HashMap<>();
			for (int i=0; i<array.length; i++) {
				int key = array[i];
				if (map.containsKey(key)) {
					int value = map.get(val);
					map.put(key, ++value);
					if (key > array.length/2) {
						return key;
					}
				}else{
					map.put(key, 1);
				}
			}
		}
		return 0;
	}

	/**剑指offer：顺时针打印矩阵***/
	public static ArrayList<Integer> printMatrix(int[][] array){
		ArrayList<Integer> list = new ArrayList<>();
		if (array == null || array.length == 0) {
			return list;
		}
		int rows = array.length;
		int cloumns = array[0].length;
		int start = 0;
		while(start*2 < rows && start*2 < cloumns){
			printMatrixInCircle(array, start, list);
			start++;
		}
		return list;
	}

	public static void printMatrixInCircle(int[][] array,int start, ArrayList<Integer> list){
		int rows = array.length;
		int cloumns = array[0].length;
		int endx = cloumns - 1 - start;
		int endY = rows - 1 - start;
		//从左到右
		for (int i=start; i <= endx; i++) {
			list.add(array[start][i]);
		}
		//从上到小
		if (endY > start) {
			for (int i = start+1; i <= endY ; i++) {
				list.add(array[i][endx]);
			}
		}
		//从右到左
		if (endx > start && endY > start) {
			for (int i = endx - 1; i >= start; i--) {
				list.add(array[endY][i]);
			}
		}
		//从下往上，至少三列两行
		if (endY > (start + 1) && endx > start) {
			for (int i = endY - 1; i >= start + 1; i--) {
				list.add(array[i][start]);
			}
		}
	}
}