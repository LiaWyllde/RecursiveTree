package model;

public class Tree <T extends Comparable<T>> {
	
	Node<T> root = null;
	
	public Node<T> getRoot() {
		return this.root;
	}
	
	public void callAdd(T e) {
	// makes a node with the element to be removed
		var added = new Node<T>(e);
		if (this.root == null) {
			this.root = added;
		} else {
			var compare = this.root;
			add(added, compare);
		}
	}
	
	private void add(Node<T> added, Node<T> compare) {
	// get the node to be added and one to compare, starting from the root	
	  
	// compares the root element to the new element
	 
		if (compare.getElement().compareTo(added.getElement()) >= 0) {
		// if the root is bigger, the node needs to go to the left
			
			if (compare.getLesser() == null) {
				compare.setLesser(added);
			} else {
				compare = compare.getLesser();
				add(added, compare);
			}
			
		// if the left is empty, set the node as lesser 
		// else, compare the added to the node in the position
			
		} else {
		// here we treat the cases where the node is greater than root
			
			if (compare.getGreater() == null) {
				compare.setGreater(added);
			} else {
				compare = compare.getGreater();
				add(added, compare);
			}
			
		// if the right is empty, set the node as greater
		// else, compare the added to the node in the position
			
		}
	}
	
	public void PreOrdem(Node<T> root) {
		if (root != null) {
			System.out.print(root.getElement().toString() + " ");
			PreOrdem(root.getLesser());
			PreOrdem(root.getGreater());
			
			// receives a node, shows its element
			// sends the left of the node as a node for the function
			// sends the right of the node as a node for the function
		}
	}
	
	private Node<T> min(Node<T> no) {
	//return the min value in the right
		
		var min = no;
		while (min.getLesser() != null) {
			min = min.getLesser();
		}
		return min;
	}
	
	public Node<T> remove(T element, Node<T> isHere) {
		
		/*
		 * the recursive remove function runs the tree and comes back 
		 * rebuilding it The recursive remove function runs the tree and rebuilds it
		 * redirecting the father's pointers to the new node 
		 */
		
		
		if (isHere == null) {
			return isHere;
		}
		
		// when the isHere is null it means that is no more nodes in tree to find 
		// or it just means that is no one node in the tree, in the first try 
		
		if (isHere.getElement().compareTo(element) > 0) {
		// if the current isHere (isHere) is greater than element, left	
		
			isHere.setLesser(remove(element, isHere.getLesser()));
			
		/*	
		 *  sets the left as the return of the remove passing the left (e)
		 *  when recursion is returning this line rebuild the tree set the returns
		 */
			
		} else if (isHere.getElement().compareTo(element) < 0) {
		// if the current root (isHere) is lesser than element, right (e)
			
			isHere.setGreater(remove(element, isHere.getGreater()));

		} else {
		// when this conditional is accomplished it means that the node was found
		// here occurs the tests to know the type of the node (leaf, two sons or one son)  
			
			if (isHere.getGreater() == null && isHere.getLesser() == null) {
			// it's a leaf node? then return null as the pointer of his fathers
				
				return null;
			
			/*
			 * when this part is called, the recursive return sets the pointers
			 * like in the lines below
			 * isHere.set-Comparative-(remove(element, isHere.get-Comparative-()));
			 */
			
			} else if (isHere.getLesser() == null) {
				return isHere.getGreater();
			/*
			 * if this node is not a leaf and the left is empty it means the 
			 * right have to be returned 
			 */
				
			} else if (isHere.getGreater() == null) {
				return isHere.getLesser();
			
			/*
			 * if this node is not a leaf and the right is empty it means the 
			 * left have to be returned 
			 */
			
			} else {
				
			// this last statement tests the node that has 2 sons 
				
				var substitute = this.min(isHere.getGreater());
				
				isHere.setElement(substitute.getElement());
				isHere.setGreater(remove(substitute.getElement(), isHere.getGreater()));
				
			// substitute receives the return of min sending the right node of the isHere  
			
			/*
			 * instead of removing the whole node the function replaces his element
			 * with the element of the substitute, and calls the remove to remove the  
			 * substitute from the old position on the tree
			 */
				
			}
		} 
		return isHere;
	}
}
