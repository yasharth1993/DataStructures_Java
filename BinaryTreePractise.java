package com.Tree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class BinaryTreePractise {
	static Node root;
	public static void main(String[] args) {
		BinaryTreePractise tree = new BinaryTreePractise();
		  tree.root = new Node(1);
		  tree.root.left = new Node(12);
		  tree.root.right = new Node(9);
		  tree.root.left.left = new Node(5);
		  tree.root.left.right = new Node(6);
		  tree.root.right.left = new Node(8);
		  tree.root.right.right = new Node(10);
		  int num = getSumOfAllNodes(root);
		  System.out.println(num);
		  int numNodes = getNUmberOfNodes(root);
		  System.out.println(numNodes);
		  int leafNodes = getLeafNodes(root);
		  System.out.println(leafNodes);
		  System.out.println(getHeight(root));
		  printAtGivenLevel(root,3);
		  System.out.println();
		  levelOrderTraversalRecursion(root);
		  System.out.println();
		  levelOrderQueue(root);
		  System.out.println();
		  reverselevelOrderTraversalRecursion(root);
		  printReverseLevelStack(root);
		  System.out.println();
		  printLeftView(root);
		  System.out.println();
		  printRightView(root);
		  System.out.println();
		  PreOrderStack(root);
		  System.out.println();
		  Node n = mirrorTree(root);
		  levelOrderQueue(n);
		  System.out.println();
		  levelOfNode(root, 12);
	}
	
	public static int getSumOfAllNodes(Node root) {
		if(root == null) {
			return 0;
		}
		return root.data + getSumOfAllNodes(root.left) + getSumOfAllNodes(root.right); 
	}

	public static int getNUmberOfNodes(Node root) {
		if(root == null) {
			return 0;
		}
		return 1 + getNUmberOfNodes(root.left) + getNUmberOfNodes(root.right);	
	}
	
	public static int getLeafNodes(Node root) {
		if(root == null) {
			return 0;
		}
		if(root.left == null && root.right == null) {
			return 1;
		}
		return getLeafNodes(root.left) + getLeafNodes(root.right);
	}
	
	public static int getHeight(Node root) {
		if(root == null) {
			return 0;
		}
		return 1 + Math.max(getHeight(root.left), getHeight(root.right));
	}
	
	public static void printAtGivenLevel(Node root , int level) {
		if(root == null) {
			return;
		}
		if(level == 1) {
			System.out.print(root.data+" ");
		}
		printAtGivenLevel(root.left , level-1);
		printAtGivenLevel(root.right , level-1);
	}
	
	public static void levelOrderTraversalRecursion(Node root) {
		int height = getHeight(root);
		for(int i=1;i<=height;i++) {
			printAtGivenLevel(root, i);
		}
	}
	
	public static void levelOrderQueue(Node root) {
		if(root == null) {
			return;
		}
		Queue<Node> q = new LinkedList<Node>();
		q.add(root);
		while(!q.isEmpty()) {
			Node temp = q.remove();
			System.out.print(temp.data+" ");
			if(temp.left != null) {
				q.add(temp.left);
			}
			if(temp.right != null) {
				q.add(temp.right);
			}
		}
	}
	
	public static void reverselevelOrderTraversalRecursion(Node root) {
		int height = getHeight(root);
		for(int i=height;i>=1;i--) {
			printAtGivenLevel(root, i);
			System.out.println();
		}
	}
	
	public static void printReverseLevelStack(Node root) {
		if(root == null) {
			return;
		}
		Queue<Node> q = new LinkedList<Node>();
		q.add(root);
		Stack<Node> s = new Stack<Node>();
		while(!q.isEmpty()) {
			Node temp = q.remove();
			if(temp.right != null) {
				q.add(temp.right);
			}
			if(temp.left != null) {
				q.add(temp.left);
			}
			
			s.push(temp);
		}
		while(!s.isEmpty()) {
			System.out.print(s.pop().data+" ");
		}
	}
	
	
	public static void printLeftView(Node root) {
		int height = getHeight(root);
		printLeftViewUtil(root , 1);
		
	}
	static int max = 0;
	public static void printLeftViewUtil(Node root , int level) {
		if(root == null) {
			return;
		}
		if(level > max) {
			System.out.print(root.data+" ");
			max++;
		}
		printLeftViewUtil(root.left , level + 1);
		printLeftViewUtil(root.right , level + 1);
	}
	
	public static void printRightView(Node root) {
		printRightViewUtil(root , 1);
	}
	static int maxRight = 0;
	public static void printRightViewUtil(Node root , int level) {
		if(root == null) {
			return;
		}
		if(level > maxRight) {
			System.out.print(root.data+" ");
			maxRight++;
		}
		printRightViewUtil(root.right , level + 1);
		printRightViewUtil(root.left , level + 1);
	}
	
	public static void PreOrderStack(Node root) {
		if(root == null) {
			return;
		}
		Stack<Node> s = new Stack<Node>();
		s.push(root);
		while(!s.isEmpty()) {
			Node temp = s.pop();
			System.out.print(temp.data+" ");
			if(temp.right != null) {
				s.push(temp.right);
			}
			if(temp.left != null) {
				s.push(temp.left);
			}
		}
	}
	
	public static Node mirrorTree(Node root) {
		if(root == null) {
			return null;
		}
		Node temp = root.left;
		root.left = root.right;
		root.right = temp;
		mirrorTree(root.left);
		mirrorTree(root.right);
		
		return root;
	}
	
	public static int levelOfNode(Node root , int n) {
		levelOfNodeUtil(root , n , 1);
		return n;
	}
	
	public static void levelOfNodeUtil(Node root , int n , int level) {
		if(root == null) {
			return;
		}
		if(n == root.data) {
			System.out.println("Level of Node is :"+level);
		}
		levelOfNodeUtil(root.left , n , level+1);
		levelOfNodeUtil(root.right , n , level+1);
		//return level;
	}
	
}
