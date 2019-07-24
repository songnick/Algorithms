import java.util.Arrays;

public class HeapSortEx{

	private void sink(int[] data, int k, int size){
		while(2*k <= size){
			int j = 2*k;
			//检查两个子节点的大小关系；
			if (j < size && data[j] < data[j+1]) {
				j++;
			}
			//父节点大于子节点，退出循环；
			if (data[k] > data[j]) {
				break;
			}
			//交换父子节点，并检查下个节点；
			Utils.exc(data, k, j);
			System.out.println("N:" + N);
			k = j;
		}
	}

	public void sort(int[] data){
		int N = data.length-1;
		//从最底层的位置开始整理为最大堆
		for (int i = (N/2 - 1); i >= 0; i--) {
			sink(data, i, N);
		}
		System.out.println(Arrays.toString(data));
		while(N > 0){
			Utils.exc(data, 0, N--);
			if(N > 0){
				sink(data, 0, N);
			}
			System.out.println("SN:" + N);
		}
	}

	public static void main(String[] args) {
		int []arr = {3, 5, 7, 2, 1, 9, 4};
		HeapSortEx st = new HeapSortEx();
        st.sort(arr);
        System.out.println(Arrays.toString(arr));
	}

}