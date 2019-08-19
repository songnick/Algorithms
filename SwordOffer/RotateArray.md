- 问题描述
  把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。输入一个非递减排序的数组的一个旋转，输出旋转数组的最小元素。例如数组{3,4,5,1,2}为{1,2,3,4,5}的一个旋转，该数组的最小值为1。NOTE：给出的所有元素都大于0，若数组大小为0，请返回0。

- 分析思路
  分为多种情况：由于是非递减的，所以数组可能是分段递增的数组，也可能为分段递增、分段数据为常数；
  分段递增：使用两个指针，分别从数组的头部和尾部向中间逼近，采用二分法，寻找到中间位置，当两个相差值为1时，表示尾部的指针指向的位置就是要寻找的值；

- 代码实现

```java
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

```