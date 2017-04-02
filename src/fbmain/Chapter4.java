/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fbmain;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 *
 * @author jorgeaceves
 */
public class Chapter4 {
    public enum State{
        Unvisited, Visited, Visiting;
    }
    public Graph generateGraph(){
        Graph g = new Graph();
        GraphNode[] nodes = new GraphNode[6];
        nodes[0] = new GraphNode("a", 3);
        nodes[1] = new GraphNode("b", 0);
        nodes[2] = new GraphNode("c", 1);
	nodes[3] = new GraphNode("d", 1);
	nodes[4] = new GraphNode("e", 1);
	nodes[5] = new GraphNode("f", 0);
        
        nodes[0].addAdjacent(nodes[1]);
        nodes[0].addAdjacent(nodes[2]);
        nodes[0].addAdjacent(nodes[3]);
        nodes[3].addAdjacent(nodes[4]);
        nodes[4].addAdjacent(nodes[5]);
        nodes[2].addAdjacent(nodes[0]);
        
        for(int i=0; i<6; i++){
            g.addNode(nodes[i]);
        }
        return g;
    }
    public boolean pathExists(Graph g, GraphNode start, GraphNode end){
        GraphNode[] nodes = g.getNodes();
        for(GraphNode node : nodes) {
            node.state = State.Unvisited;
        }
        LinkedList<GraphNode> q = new LinkedList<>();
        start.state = State.Visiting;
        q.add(start);
        GraphNode node;
        while(!q.isEmpty()){
            node = q.removeFirst();
            if(node != null){
                for(GraphNode adj : node.getAdjacent()){
                    if(adj == end) return true;
                    if(adj.state == State.Unvisited){
                        adj.state = State.Visiting;
                        q.add(adj);
                    }
                }
                node.state = State.Visited;
            }
        }
        return false;
    }
    public TreeNode generateBinaryTree(){
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(2);
        root.right = new TreeNode(7);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(3);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(10);
        return root;
    }
    public TreeNode generateTreeFromArray(ArrayList<Integer> array){
        return generateTreeFromArray(array, 0, array.size()-1);
    }
    public TreeNode generateTreeFromArray(ArrayList<Integer> array, int min, int max){
        if(min > max || max < min) return null;
        int point = (int) Math.ceil((double) (min + max) / 2);
        TreeNode root = new TreeNode(array.get(point));
        root.left = generateTreeFromArray(array, min, point-1);
        root.right = generateTreeFromArray(array, point+1, max);
        return root;
    }
    public ArrayList<ArrayList<TreeNode>> generateLevelTree(TreeNode root){
        ArrayList<ArrayList<TreeNode>> result = new ArrayList<>();
        if(root == null) return result;
        ArrayList<TreeNode> current = new ArrayList<>();
        current.add(root);
        while(!current.isEmpty()){
            result.add(current);
            ArrayList<TreeNode> parents = current;
            current = new ArrayList<>();
            for(TreeNode parent : parents){
                if(parent.left != null){
                    current.add(parent.left);
                }
                if(parent.right != null){
                    current.add(parent.right);
                }
            }
        }
        return result;
    }
    public int getHeight(TreeNode root){
        if(root == null) return -1;
        
        int leftHeight = getHeight(root.left);
        if(leftHeight == -2) return leftHeight;
        
        int rightHeight = getHeight(root.right);
        if(rightHeight == -2) return rightHeight;
        
        if(Math.abs(leftHeight - rightHeight) > 1){
            return -2;
        }
        return Math.max(leftHeight, rightHeight) + 1;
    }
    public boolean isBalanced(TreeNode root){
        return getHeight(root) != -2;
    }
    public boolean isBST(TreeNode root){
        if(root == null) return true;
        if(root.left != null){
            if(root.left.data > root.data) return false;
        }
        if(root.right != null){
            if(root.right.data <= root.data) return false;
        }
        return isBST(root.left) && isBST(root.right);
    }
    public void inOrderTraverse(TreeNode root){
        if(root == null) return;
        inOrderTraverse(root.left);
        System.out.print(root.data + " ");
        inOrderTraverse(root.right);
    }
    public void preOrderTraverse(TreeNode root){
        if(root == null) return;
        System.out.println(root.data + " ");
        preOrderTraverse(root.left);
        preOrderTraverse(root.right);
    }
}
