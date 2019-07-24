public class BubbleSort{
	public void bubbleSort(int[] data){
		if (data != null && data.length > 0) {
			boolean doNotChange = true;
			for (int i = 0; i < data.length - 1 ; i++ ) {
				for (int j = 0; j < data.length - 1 -i ;  j++) {
					if (data[j] > data[j+1]) {
						Utils.exc(data, j, j+1);
						doNotChange = false;
					}
				}
				if (doNotChange) {
					break;
				}
			}
		}
	}

	public static void main(String[] args){
		int[] data = {2, 5, 1, 3, 6, 0};
		BubbleSort bs = new BubbleSort();
		bs.bubbleSort(data);
		for (int i = 0; i < data.length ; i++) {
			System.out.println(" data: " + data[i]);
		}
	}
}