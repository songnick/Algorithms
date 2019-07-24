public class Utils{

	public static void exc(int[] data, int i, int j){
		if (data != null && data.length > 0 && data.length > i && data.length > j) {
			int tmp = data[i];
			data[i] = data[j];
			data[j] = tmp;
		}
	}
}