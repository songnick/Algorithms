public class QuickSort{

	public void sort(int[] data, int low, int high){
		if (low < high) {
			int s = partition(data, low, high);
			sort(data, low, s-1);
			sort(data, s+1, high);
		}
	}

	public int partition(int[] data, int low, int high){
		int i = low, j = high;
		int index = data[low];
		while(true){
			while(i < j && data[j] >= index){
				j--;
			}
			while(i < j && data[i] <= index){
				i++;
			}
			if (i >= j) {
				break;
			}
			if (i < j) {
				Utils.exc(data, i, j);
				i++;
				j--;
			}

		}
		int ts = data[j];
		data[j] = data[low];
		data[low] = ts;
		return j;
	}

	public static void main(String[] args){
		int[] data = {3, 5, 7, 2, 1, 9, 4};
		QuickSort qs = new QuickSort();
		qs.sort(data, 0, data.length -1);
		String dataStr = "";
		for (int i = 0; i < data.length ; i++) {
			dataStr = dataStr + data[i] + ","; 
		}
		System.out.println(dataStr);
	}

}