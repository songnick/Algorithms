public class ReOrderArray{

	public static void reOrderArray(int [] array) {
        int preIndex = 0;
        int lastIndex = array.length-1;
        while(preIndex < lastIndex){
            while((array[preIndex]%2)!=0){
                preIndex++;
            }
            while((array[lastIndex]%2)==0){
                lastIndex--;
            }
            int tmp = array[preIndex];
            array[preIndex] = array[lastIndex];
            array[lastIndex] = tmp;
            preIndex++;
            lastIndex--;
        }
    }

    public static void main(String[] args) {
    	int[] data = {1,2,3,4,5,6,7};
    	reOrderArray(data);
    	String res = "";
    	for (int j = 0; j < data.length ;j++ ) {
    		res = res + data[j] + ",";
    	}
    	System.out.println(res);
    }
}