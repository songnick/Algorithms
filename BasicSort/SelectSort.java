public class SelectSort{

	public void sort(int[] data){
		for (int i = 0; i < data.length ; i++) {
			int min = i;
			for (int j = i + 1; j < data.length ; j++) {
				if (data[j] < data[min]) {
					min = j;
				}
			}
			Utils.exc(data, i, min);
		}
	}

	public static void main(String[] args){
		int[] data = {3, 5, 7, 2, 1, 9, 4};
		SelectSort ss = new SelectSort();
		ss.sort(data);
		String dataStr = "";
		for (int i = 0; i < data.length ; i++) {
			dataStr = dataStr + data[i] + ","; 
		}
		System.out.println(dataStr);
	}
}