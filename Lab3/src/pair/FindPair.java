package pair;

import java.util.Scanner;

public class FindPair {
	@SuppressWarnings("resource")
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		SearchTree bst = new SearchTree();
		System.out.println("Please eneter how many node you want to insert");
		int noOfNode = sc.nextInt();
		for (int i = 1; i <= noOfNode; i++) {
			System.out.println("Please enter value for node.");
			bst.insert(sc.nextInt());
		}
		System.out.println("Provided Binary Tree is Below.");
		bst.inOrderTraversal();
		System.out.println();
		System.out.println("Please enter sum value which you want to find pair");
		int sum = sc.nextInt();
		boolean isFound = bst.findPairForGivenSum(sum);
		if (!isFound) {
			System.out.println("For Given Sum " + sum + " nodes are not found.");
		}
	}
}
