
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
		static Node insertIter(Node root, int value) {
			Node newNode = new Node(value);
			
			Node current = root;
			Node parent = null;
			//traverse the root until null
			while(current != null) {
				parent = current;
				if(value > current.value) {
					current = current.right;
				}else {
					current = current.left;
				}
			}
			// parent is null means that there are no nodes in the tree
			if(parent == null) {
				parent = newNode;
			}
			// if the value is bigger than the parents go to the right
			else if(value > parent.value) {
				parent.right = newNode;
			// else insert into the left
			}else if(value < parent.value) {
				parent.left = newNode;
			}
			//return the inserted node
			return parent;
		}
		// this is just too ez now
		static Node findMinIter(Node root) {
			Node current = root;
			Node parent = null;
			
			while(current != null) {
				parent = current;
				current = current.left;
			}
			return parent;
			
		}
		
		static Node findMaxIter(Node root) {
			Node current = root;
			Node parent = null;
			
			while(current != null) {
				parent = current;
				current = current.right;
			}
			return parent;
			
		}
		
		static void deleteIter(Node root, int value) {
			    Node current = root;
			    while (current != null)
			    {
			    	 if (value > current.value)
				        {
				            if (current.right != null && current.right.value == value)
				            {
				            	current.right = null;
				                break;
				            }
				            current = current.right;
				    }
			    	else if (value < current.value)
			        {
			            if (current.left != null && current.left.value == value)
			            {
			            	current.left = null;
			                break;
			            }
			            current = current.left;
			        }
			        else
			        {
			        	root = null;
			            break;
			        }
			    }
			}
		
		//Did not have time to complete work school life excuses...
		static void findNextIter(Node root, int value) {
			
		}
		
	

	public static void main(String[] args) {
		BinarySearchTree BST = new BinarySearchTree();
		BST.root = insertIter(BST.root, 6); // initialize the root to a node with value 6
		//Insertions
		BST.insertIter(BST.root, 3);
		BST.insertIter(BST.root, 4);
		BST.insertIter(BST.root, 2);
		BST.insertIter(BST.root, 7);
		BST.insertIter(BST.root, 10);
		System.out.println(BST.findMinIter(BST.root).value); // prints 2
		System.out.println(BST.findMaxIter(BST.root).value); // prints 10
		//Deletes
		BST.deleteIter(BST.root, 10);
		BST.deleteIter(BST.root, 7);
		//New highest = 6 which is the root
		System.out.println(BST.findMaxIter(BST.root).value);
	}

}
