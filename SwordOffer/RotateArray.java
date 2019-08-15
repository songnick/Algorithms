public class RotateArray{

	public static int minNumberInRotateArray(int[] data){
		int size = data.length;
        if(size == 0){
            return 0;
        }//if
        int left = 0,right = size - 1;
        int mid = 0;
        // rotateArray[left] >= rotateArray[right] 确保旋转
        while(data[left] >= data[right]){
            // 分界点
            if(right - left == 1){
                mid = right;
                break;
            }//if
            mid = left + (right - left) / 2;
            // 无法确定中间元素是属于前面还是后面的递增子数组
            // 只能顺序查找
            if(data[left] == data[right] && data[left] == data[mid]){
                return minOder(data,left,right);
            }
            if(data[mid] >= data[left]){
                left = mid;
            }
            else{
                right = mid;
            }//else
        }//while
        return data[mid];
	}

	private static int minOder(int[] data, int left, int right){
		int result = data[left];
        for(int i = left + 1;i < right;++i){
            if(data[i] < result){
                result = data[i];
            }//if
        }//for
        return result;
	}

	public static void main(String[] args) {
		
	}

}