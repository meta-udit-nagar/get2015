public class TreeSort {
	

	private Tree createTree(int rollNo[]) {
		Tree tree= new Tree();	
		for (int i = 0; i < rollNo.length; i++) {

			tree.addNode(rollNo[i]);

		}
   return tree;
	}

	public int[] treeSort(int rollNo[]) {
		Tree tree=createTree(rollNo);
		int output[] = tree.inOrder(tree.getRoot());
		return output;
	}

}
