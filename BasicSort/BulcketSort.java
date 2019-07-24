import java.util.Arrays;

public class BulcketSort{

	public void sort(int[] data){
		int max = data[0];
		for (int i = 1; i < data.length; i++) {
			max = max > data[i] ? max:data[i];
		}
		int[] sortData = new int[max+1];
		for (int j = 0; j < data.length ; j++) {
			sortData[data[j]]++;
		}
		int j = 0;
		for (int k = 0; k < sortData.length; k++) {
			if (sortData[k] >= 1) {
				System.out.println(k + ",");
				data[j++] = k; 
			}
		}
	}

	public void sort(int[] data, int bulcketSize){
		
	}


	public static void main(String[] args) {
		int []arr = {3, 5, 7, 2, 1, 9, 4};
		BulcketSort st = new BulcketSort();
        st.sort(arr);
        System.out.println(Arrays.toString(arr));
	}
}