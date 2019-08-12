public class ReConstructTree{


	public static TreeNode reConstruct(int[] preOrder, int[] midOrder){
		if (preOrder == null || preOrder == null) {
			return null;
		}
		return reConstruct(preOrder, 0, preOrder.length - 1, midOrder, 0, midOrder.length - 1);
	}

	public static TreeNode reConstruct(int[] preOrder,int startPreOrder, int endPreOrder, int[] midOrder, int startMidOrder, int endMidOrder){
		
		int rootValue = preOrder[startPreOrder];
		TreeNode root = new TreeNode(rootValue);
		root.mLeft = root.mRight = null;
		if (preOrder.length == midOrder.length && preOrder[startPreOrder] == midOrder[startMidOrder]) {
			
			return root;
		}

		int midOrderRoot = startMidOrder;

		while(midOrderRoot < midOrder.length && midOrder[midOrderRoot] != rootValue){
			midOrderRoot++;
		}

		int leftLength = midOrderRoot - startMidOrder;
		int leftPreOder = startPreOrder + midOrderRoot;
		if (leftLength > 0) {
			root.mLeft = reConstruct(preOrder, startPreOrder + 1, leftPreOder, midOrder, startMidOrder, midOrderRoot - 1);
		}
		if (leftLength < endPreOrder - startPreOrder) {
			root.mRight = reConstruct(preOrder, leftPreOder + 1, endPreOrder, midOrder, midOrderRoot+1, endMidOrder);
		}
	}

	public static void main(String[] args) {
		
	}

}