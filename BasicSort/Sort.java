import java.util.ArrayList;

public class Test{
	public static void main(String[] args) {
		int[] data = {4, 2, 0, 1, 9, 5};
		int[] result = countSort(data);
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < result.length ; i++) {
			sb.append(result[i]).append(",");
		}
		System.out.println("result: " + sb.toString());
	}

		/**交换两个位置**/
	public static void swap(int[] data, int i, int j){
		int tmp = data[i];
		data[i] = data[j];
		data[j] = tmp;
	}

	/**冒泡排序**/
	public static void bubbleSort(int[] data){
		if (data != null && data.length > 1) {
			int length = data.length;
			boolean changed = false;
			//第一层循环主要是为了将最大的数防止的最后一位
			for (int i = 0; i < length ; i++) {
				//从第一位开始，两两相邻的两个比较，如果前面比后面到就进行交换，最后将最大的放置到最后的位置
				for (int j = 0; j < length-i-1; j++) {
					if (data[j] > data[j+1]) {
						swap(data, j, j+1);
						changed = true;
					}
					if (!changed) {
						break;
					}
				}
			}
		}
	}

	/**插入排序**/
	public static void insertSort(int[] data){
		if (data == null || data.length <= 1 ) {
			return ;
		}
		int length = data.length;
		for (int i=1; i<length; i++) {
			int index = data[i];
			int j = i - 1;
			for (; j>=0; j--) {
				if (data[j] > index) {
					swap(data, j+1, j);
				}else {
					break;
				}
			}
			data[j+1] = index;
		}
	}

	/**插入排序**/
	public static void insertSortEx(int[] data){
		if (data == null || data.length <= 1) {
			return ;
		}
		int length = data.length;
		for (int j=1; j<length; j++) {
			for (int i = j-1; i >= 0; i--) {
				if (data[i] > data[i+1]) {
					swap(data, i, i+1);
				}else {
					break;
				}
			}
		}
	}

	/**选择排序**/
	public static void selectSort(int[] data){
		if (data == null || data.length <= 1) {
			return ;
		}
		int length = data.length;
		for (int i=0; i<length; i++) {
			int min = i;
			for (int j=i+1; j<length; j++) {
				if (data[min] > data[j]) {
					min = j;
				}
			}
			swap(data, min, i);
		}
	}

	/**快速排序，该方法还存在一定的缺陷**/
	public static void quickSort(int[] data, int low, int high){
		if ((data == null || data.length <=1) || low >= high) {
			return ;
		}
		//int[] data = {4, 2, 5, 1, 0, 9}
		int i = low;
		int j = high;
		int pivot = data[(high+low)/2];
		while(i <= j){
			while(i < j && pivot > data[i]){
				i++;
			}
			while(i<j && data[j] > pivot){
				j--;
			}
			if (i < j) {
				swap(data, i, j);
				i++;
				j--;
			}else if(i == j){
				i++;
			}
		}
		quickSort(data, low, j);
		quickSort(data, i, high);
	}


	/**快速排序**/
	public static void quickSortEx(int[] data, int low, int high){
		if (data == null || data.length <=1 || low >= high) {
			return ;
		}

		int p = partitation(data, low, high);
		quickSortEx(data, low, p-1);
		quickSortEx(data, p+1, high);
	}

	private static int partitation(int[] data, int low, int high){
		if (data == null || data.length <= 1 || low >= high) {
			return 0;
		}
		int pivot = data[high];
		int i = low;
		int j = low;
		//int[] data = {4, 2, 5, 1, 0, 9}
		//9, 2, 5, 1, 0, 4;
		//i=0, high = 5;
		for (; j <= high-1; j++) {
			if (data[j] < pivot) {
				swap(data, i, j);
				++i;
			}
		}
		swap(data, i, high);
		return i;
	}

	private static int indexForBucket(int index, int min, int size){

		return (index - min)/size;
	}

	public static void bulkSort(int[] data){
		if (data == null || data.length <=1) {
			return ;
		}
		int max = data[0];
		int min = data[0];
		for (int i = 0; i<data.length; ++i) {
			if (data[i] > max) {
				max = data[i];
			}
			if (data[i] < min) {
				min = data[i];
			}
		}
		int bucketSize = max/10 - min/10 + 1;
		ArrayList<ArrayList<Integer>> bucket = new ArrayList<>();
		for (int j=0; j<bucketSize; j++) {
			bucket.add(new ArrayList<Integer>());
		}

		//填充到桶里面
		for (int i=0; i < data.length; i++) {
			int index = indexForBucket(data[i], min, 10);
			bucket.get(index).add(data[i]);
		}

		//对于每个桶排序
		ArrayList<Integer> bucketChild = null;
		int index = 0;
		for (int i=0; i < bucketSize; i++) {
			bucketChild = bucket.get(i);
			insertSortBucket(bucketChild);
			for (int k : bucketChild ) {
				data[index++] = k;
			}
		}
	}

	private static void insertSortBucket(ArrayList<Integer> bucket){
		int pivot = bucket.get(0);
		int size = bucket.size();
		for (int j=1; j < size; j++) {
			int tmp = bucket.get(j);
			int i=j-1;
			for (; i>=0; --i) {
				if (bucket.get(i) > tmp) {
					bucket.set(i+1, bucket.get(i));
				}
			}
			//1, 2, 3, 0;
			bucket.set(i+1, tmp);
		}
	}

	/**计数排序算法***/
	public static int[] countSort(int[] data){
		//确定计数数组的大小;
		int max = data[0];
		int min = data[0];
		for (int i=1; i<data.length; i++) {
			if (data[i] > max) {
				max = data[i];
			}
			if (data[i] < min) {
				min = data[i];
			}
		}
		int count = max - min + 1;
		//确定计数数组
		int[] countSort = new int[count];
		for (int j=0; j<data.length; j++) {
			countSort[(data[j]-min)]++;
		}
		//累计计数数组的位置数量
		for (int k=1; k<countSort.length; k++) {
			countSort[k] = countSort[k] + countSort[k-1];
		}
		//计算最终的结果
		int[] result = new int[data.length];
		for (int i = data.length-1; i>=0; i--) {
			result[--countSort[data[i]-min]] = data[i];
		}
		return result;
	}

	/**基数排序算法**/
	public static void radixSort(int[] data, int radix){
		
	}

}