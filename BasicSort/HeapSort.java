/***
*
*二叉堆的定义：任何节点的i，他的父节点是i/2，右节点是2i，左节点时2i＋1；
*/
import java.util.Arrays;

public class HeapSort{

	public static void sort(int[] data){
		int length = data.length;
		for (int i = length >> 2 - 1; i >= 0; i--) {
			adjustHeap(data, i, length);
		}
		//
		for (int j = length -1; j >= 0; j--) {
			Utils.exc(data, j, 0);
			adjustHeap(data, 0, j);
		}
	}

	public static void adjustHeap(int[] data, int parentIndex, int length){
		int tmp = data[parentIndex];
		for (int k = 2*parentIndex + 1; k < length ; k =2*k + 1) {
			if (k+1 < length && data[k] < data[k+1]) {
				k++;
			}
			if (data[k] > tmp) {
				data[parentIndex] = data[k];
				parentIndex = k;
			}else {
				break;
			}
		}
		data[parentIndex] = tmp;
	}

	public static void main(String[] args) {
		int []arr = {3, 5, 3, 0, 8, 6, 1, 5, 8, 6, 2, 4, 9, 4, 7, 0, 1, 8, 9, 7, 3, 1, 2, 5, 9, 7, 4, 0, 2, 6};
        sort(arr);
        System.out.println(Arrays.toString(arr));
	}
}