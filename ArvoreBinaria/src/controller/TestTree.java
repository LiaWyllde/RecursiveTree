package controller;
import model.Tree;

public class TestTree {

	public void testTree() {
	
		Tree tree = new Tree();
		
		tree.callAdd(200);
		tree.callAdd(150);
		tree.callAdd(130);
		tree.callAdd(180);
		tree.callAdd(310);
		tree.callAdd(170);
		tree.callAdd(220);
		tree.callAdd(210);
		tree.callAdd(320);
		tree.callAdd(100);
		tree.callAdd(240);
		tree.callAdd(320);
		tree.callAdd(90);
		tree.callAdd(110);
		tree.callAdd(160);
		
		tree.PreOrdem(tree.getRoot());
		
		tree.remove(150, tree.getRoot());
		
		System.out.println("Remove");
		
		tree.PreOrdem(tree.getRoot());
		
	}
}
