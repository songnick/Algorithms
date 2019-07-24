public class InsertSort{
	public void sort(int[] data){
		for (int i = 1; i < data.length ; i++) {
			for (int j = i; j > 0; j--) {
				if (data[j] < data[j-1]) {
					Utils.exc(data, j, j-1);
				}
			}
		}
	}
	public static void main(String[] args){
		int[] data = {3, 5, 7, 2, 1, 9, 4};
		InsertSort is = new InsertSort();
		is.sort(data);
		String dataStr = "";
		for (int i = 0; i < data.length ; i++) {
			dataStr = dataStr + data[i] + ","; 
		}
		System.out.println(dataStr);
	}

}