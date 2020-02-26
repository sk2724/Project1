
class BinarySearchTree{
		//each tree has a bunch of nodes
		static class Node{
			//value of the node
			int value;
			Node left;
			Node right;
			public Node(int value) {
				this.value = value;
				left = null;
				right = null;
			}
		}
		Node root;
		
		BinarySearchTree(){
			root = null;
		}
		static Node insertRec(Node root, int value) {
			//check if theres no nodes
			if(root == null) {
				//Make inserted value a new Node and return it
				root = new Node(value);
				return root;
			}else {
				/** Go down the tree and check if the value you want 
				 * 	to insert is bigger than the root to put it into the right
				 *  if its smaller put into the left. Recursively call insertRec
				 *  to keep going down the tree until it returns its class instance root.
				**/
				if(value > root.value) {
					root.right = insertRec(root.right, value);
				}else if(value < root.value) {
					root.left = insertRec(root.left, value);
				}
				return root;
			}
			
		}
		
		static Node findMinRec(Node root) {
			// this function can check the minimum of a whole tree or 
			// the minimum of a side of a tree
			//check if its empty
			if(root == null)
				return root;
			// if the left is empty that means that node is the smallest
			if(root.left == null) { 
				return root;
			}
			// else keep going left to find the smallest value until theres
			// no more going left.
				return findMinRec(root.left);
			
			
		}
		//Same as min function but keep going right to find the maximum value until you cant go right anymore
		static Node findMaxRec(Node root) {
			// this function can check the minimum of a whole tree or 
			// the minimum of a side of a tree
			//check if its empty
			if(root == null)
				return root;
			// if the left is empty that means that node is the smallest
			if(root.right == null) { 
				return root;
			}
			// else keep going left to find the smallest value until theres
			// no more going left.
				return findMaxRec(root.right);
			
			
		}
		
		static Node deleteRec(Node root, int value) {
			//check if tree is empty
			if(root ==null) {
				return root;
			}else {
			if(value > root.value) {
				root.right = deleteRec(root.right, value);
			}else if(value < root.value) {
				root.left = deleteRec(root.left, value);
				
			}else {
			//key is found	
			//Node with one child or no children edge case l or r or NULL	
			if(root.left == null) {
				return root.right;
			}else if(root.right == null) {
				return root.left;
			}
			//Node with two children	
			/**
			 * It is necessary to write a min value function traversal
			 * to find the successor to the node that will be deleted 
			 * that has two children and so I will be back here after 
			 * I write findMinRecursive.
			 */
			root.value = findMinRec(root.right).value;
			root.right = deleteRec(root.right, root.value);
		}
			}
			return root;
		}
		
		
		static Node findNext(Node root, int value) {
			//if its empty
			if(root == null) {
				return root;
			}
			//Edge case: the root of the tree is value you want to findnext for
			// find the key value im looking for then find the smallest value of the right subtree 
			if(root.value == value) {
				if(root.right != null) {
					return findMinRec(root.right);
				}
			}
			//edge case if the root value is bigger than the value provided, the next should be in the left subtree
			else if(root.value > value) {
				return findNext(root.left, value);
			//else the right subtree
			}else {
				return findNext(root.right, value);
			}
			// return null if nothing is bigger/next
			return null;
		}
		//Same as top function but will search for 
		static Node findPrev(Node root, int value) {
			//if its empty
		
			return null;
		}
	

	public static void main(String[] args) {
		BinarySearchTree BST = new BinarySearchTree();
		BST.root = insertRec(BST.root, 6); // initialize the root to a node with value 6
		//Insertions
		BST.insertRec(BST.root, 3);
		BST.insertRec(BST.root, 4);
		BST.insertRec(BST.root, 2);
		BST.insertRec(BST.root, 7);
		BST.insertRec(BST.root, 10);
		System.out.println("Value at the left of the left: " + BST.root.left.left.value);// prints 2
		System.out.println("findMinRec: " + BST.findMinRec(BST.root).value); //prints smallest value(2)
		System.out.println("findMaxRec: " + BST.findMaxRec(BST.root).value); //prints biggest value(10)
		System.out.println(BST.findNext(BST.root, 7).value); // returns 10 because 10 is next after 7 in the tree
		BST.deleteRec(BST.root, 2);
		System.out.println("findMinRec: " + BST.findMinRec(BST.root).value); //prints smallest value( now 3 since we deleted 2)
		//System.out.println(BST.root.left.left.value);
		// No longer prints 2 because it was deleted
		 
		
		System.out.println(BST.root.right.value); //prints 7
	}

}
