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