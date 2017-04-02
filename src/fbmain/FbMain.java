/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fbmain;

import java.util.ArrayList;

/**
 *
 * @author jorgeaceves
 */
public class FbMain {

    public static void main(String[] args) {
        //Chapter1 test = new Chapter1();
        /*String[] tests = {"perm", "permuttioan", "noitatumrpe", "permtationu"};
        for(String word : tests){
            System.out.println("permutation " + word + " " + test.question2("permutation", word));
        }*/
       /* System.out.println("Test String" + " " + String.valueOf(test.question3("Test String  ".toCharArray(), "Test String".length())));
        System.out.println("String" + " " + String.valueOf(test.question3("String".toCharArray(), "String".length())));
        System.out.println("Test String  " + " " + String.valueOf(test.question3("Test String        ".toCharArray(), "Test String  ".length())));*/
        //System.out.println("isReplaceable " + test.question5("word","wored"));
        //System.out.println("Compression " + test.question6("abc"));
        
        /*
        Chapter2 test = new Chapter2();
        Node head = new Node(3);
        //head.appendToTail(0);
        head.appendToTail(6);
        head.appendToTail(3);*/
        /*head.appendToTail(7);
        head.appendToTail(3);
        head.appendToTail(2);
        head.appendToTail(1);
        head.appendToTail(5);
        */
        /*Node l1 = new Node(5);
        l1.next = head;
        Node l2 = new Node(3);
        Node h = l2;
        l2.next = new Node(6);
        l2 = l2.next;
        l2.next = head;
        l2 = h;
        test.printList(l1);
        test.printList(l2);
        System.out.println(test.listsIntersect(l1, l2).data);*/
        //System.out.println(test.isPalindrome(head));
        
        //Node sum = new Node(5);
        //sum.appendToTail(0);
        //sum.appendToTail(9);
        //test.printList(sum);

        //Node summed = test.sumListsReverse(head, sum);
        //test.printList(sum);
        //Node get = test.kthToLast(head, 2);
        //test.eraseMiddleNode(get);
        //head = test.partition(head, 10);
        //test.printList(head);
        //head = test.deleteNode(head, 10);
        //test.removeDups(head);
        //Node get = test.kthToLast(head, 7);
        //System.out.println(get.data);
         /*
        Node loop = new Node(5);
        Node loopHead = loop;
        int[] values = {1,3,7};
        for(int i : values){
            loop.next = new Node(i);
            loop = loop.next;
        }
        Node circle = loop;
        int[] values2 = {4,6,8,10,12,,16};
        for(int i : values2){
            loop.next = new Node(i);
            loop = loop.next;
        }
        loop.next = circle;
        test.printKNodes(loopHead, 12);
        System.out.println("Node with loop " + test.findLoopNode(loopHead).data);*/
         
        /*Chapter3 test = new Chapter3();
        test.testMinStack();*/
        
        Chapter4 test = new Chapter4();
        /*Graph testGraph  = test.generateGraph();
        GraphNode n[] = testGraph.getNodes();
        GraphNode start = n[2];
        GraphNode end = n[5];
        System.out.println(test.pathExists(testGraph, start, end));*/
        /*TreeNode r = test.generateBinaryTree();
        test.inOrderTraverse(r);
        System.out.println("");*/
        ArrayList<Integer> t = new ArrayList<>();
        t.add(1);
        t.add(3);
        t.add(5);
        t.add(7);
        t.add(9);
        t.add(11);
        t.add(13);
        t.add(15);
        //test.preOrderTraverse(test.generateTreeFromArray(t));
        //test.inOrderTraverse(test.generateTreeFromArray(t));
        TreeNode root = test.generateTreeFromArray(t);
        root.left.left.left = new TreeNode(11);
        //test.inOrderTraverse(root);
        /*ArrayList<ArrayList<TreeNode>> ar = test.generateLevelTree(root);
        int level = 0;
        for(ArrayList<TreeNode> a : ar){
            System.out.println("Printing level " + level++);
            for(TreeNode n : a){
                System.out.print(n.data + " ");
            }
            System.out.println("");
        }*/
        //System.out.println(test.isBalanced(root));
        System.out.println(test.isBST(root));
        permutation("abcde");
    }

public static void permutation(String str) { 
    permutation("", str); 
}

private static void permutation(String prefix, String str) {
    int n = str.length();
    if (n == 0) System.out.println(prefix);
    else {
        for (int i = 0; i < n; i++)
            permutation(prefix + str.charAt(i), str.substring(0, i) + str.substring(i+1, n));
    }
}
}
