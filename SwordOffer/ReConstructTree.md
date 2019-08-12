- 问题描述：  
  输入某二叉树的前序遍历和中序遍历的结果，请重建出该二叉树。假设输入的前序遍历和中序遍历的结果中都不含重复的数字。例如输入前序遍历序列{1,2,4,7,3,5,6,8}和中序遍历序列{4,7,2,1,5,3,8,6}，则重建二叉树并返回。

- 问题分析：  
  1.前序遍历第一位为根节点，中序遍历找到根节点所在位置，那么在中序遍历中根节点之前的为左子树；  
  2.根据1中找到的左子树的长度，在前序遍历中找到左子树的前序遍历数组，然后同样使用第一步找到左子树的根节点；  
  3.递归寻找并重建二叉树；

- 代码实现：
```java
public class ReConstructTree{
	public static TreeNode reConstruct(int[] preOrder, int[] midOrder){
		if (preOrder == null || preOrder == null) {
			return null;
		}
		return reConstruct(preOrder, 0, preOrder.length - 1, midOrder, 0, midOrder.length - 1);
	}

	public static TreeNode reConstruct(int[] preOrder,int startPreOrder, int endPreOrder, int[] midOrder, int startMidOrder, int endMidOrder){
		System.out.println("start pre order: " + startPreOrder + " end pre order: " + endPreOrder);
		int rootValue = preOrder[startPreOrder];
		TreeNode root = new TreeNode(rootValue);
		root.mLeft = root.mRight = null;
		if (startPreOrder == endPreOrder) {
			if (startPreOrder == endPreOrder && preOrder[startPreOrder] == midOrder[startMidOrder]) {
			
			return root;
			}else{

			}
		}
		int midOrderRoot = startMidOrder;
		//找到中序遍历中，根节点的位置
		while(midOrderRoot < midOrder.length && midOrder[midOrderRoot] != rootValue){
			midOrderRoot++;
		}
		//确定根节点左子树的大小
		int leftLength = midOrderRoot - startMidOrder;
		//前序遍历左子树的位置
		int leftPreOder = startPreOrder + leftLength;
		if (leftLength > 0) {
			root.mLeft = reConstruct(preOrder, startPreOrder + 1, leftPreOder, midOrder, startMidOrder, midOrderRoot - 1);
		}
		if (leftLength < endPreOrder - startPreOrder) {
			root.mRight = reConstruct(preOrder, leftPreOder + 1, endPreOrder, midOrder, midOrderRoot+1, endMidOrder);
		}
		return root;
	}
	
	public static void main(String[] args) {
		// int[] preOrder = {1,2,3,4,5,6,7}, midOrder = {3,2,4,1,6,5,7};
		int[] preOrder = {1,2,3,4}, midOrder = {1,2,3,4};
		TreeNode root = reConstruct(preOrder, midOrder);
		TreeNode.midTrace(root);
	}

}
```