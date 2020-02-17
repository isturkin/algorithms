public class BinarySearchTree {

	private Node root;

public Node getRoot() {
	return root;
}


public boolean find(int value) {
	Node current = root;
	while(current != null) {
		if (value == current.value) {
			return true;
		} else if(value < current.value) {
			current = current.left;
		} else {
			current = current.right;
		}
	}

	return false;
}

public void add(int value) {
	Node newNode = new Node(value, null, null);
	if (root == null) {
		root = newNode;
		return;
	}

	Node current = root;
	Node parent = null;

	while(true) {
		parent = current;
		if (value < current.value) {
			current = current.left;
			if (current == null) {
				parent.left = newNode;
				return;
			}
		} else {
			current = current.right;
			if (current == null) {
				parent.right = newNode;
				return;
			}
		}
	}
}

public void directOrder(Node root) {
	if (root == null) 
		return;
	
	System.out.println(root.value);
	directOrder(root.left);
	directOrder(root.right);
}

public void symmetricOrder(Node root) {
	if (root == null)
		return;

	symmetricOrder(root.left);
	System.out.println(root.value);
	symmetricOrder(root.right);
}

public void reversedOrder(Node root) {
	if (root == null)
		return;
	
	reversedOrder(root.left);
	reversedOrder(root.right);
	System.out.println(root.value);
}

public static void main(String[] args) {
	BinarySearchTree tree = new BinarySearchTree();
	tree.add(10);
	tree.add(7);
	tree.add(15);
	tree.add(5);

	System.out.println("=====Print tree in direct order=====");
	tree.directOrder(tree.getRoot());

	System.out.println("=====Print tree in symmetric order==");
	tree.symmetricOrder(tree.getRoot());

	System.out.println("=====Print tree in reversed order===");
	tree.reversedOrder(tree.getRoot());
}



private static class Node {

	int value;
	Node left;
	Node right;

	public Node(int value, Node left, Node right) {
		this.value=value;
		this.left=left;
		this.right=right;
	}
}
}
