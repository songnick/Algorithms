- 问题描述：
  输入某二叉树的前序遍历和中序遍历的结果，请重建出该二叉树。假设输入的前序遍历和中序遍历的结果中都不含重复的数字。例如输入前序遍历序列{1,2,4,7,3,5,6,8}和中序遍历序列{4,7,2,1,5,3,8,6}，则重建二叉树并返回。

- 问题分析：


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

		while(midOrderRoot < midOrder.length && midOrder[midOrderRoot] != rootValue){
			midOrderRoot++;
		}
		int leftLength = midOrderRoot - startMidOrder;
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