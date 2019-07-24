public class ShellSort{

	public void sort(int[] data){
		int N = data.length;
		int h = 1;
		while(h < N/3) h = 3*h + 1;
		while(h >= 1){
			for (int i = h ; i < N; i++ ) {
				for (int j = i ; j >= h; j= j-h) {
					if (data[j] < data[j-h]) {
						Utils.exc(data, j, j-h);
					}
				}
			}
			h = h/3;
		}
	}

	public static void main(String[] args){
		int[] data = {3, 5, 7, 2, 1, 9, 4};
		ShellSort ss = new ShellSort();
		ss.sort(data);
		String dataStr = "";
		for (int i = 0; i < data.length ; i++) {
			dataStr = dataStr + data[i] + ","; 
		}
		System.out.println(dataStr);
	}
}