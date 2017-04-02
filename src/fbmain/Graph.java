/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fbmain;

/**
 *
 * @author jorgeaceves
 */
public class Graph {
	public static int MAX_VERTICES = 6;
	private GraphNode vertices[];
	public int count;
	public Graph() {
		vertices = new GraphNode[MAX_VERTICES];
		count = 0;
        }
	
    public void addNode(GraphNode x) {
		if (count < vertices.length) {
			vertices[count] = x;
			count++;
		} else {
			System.out.print("Graph full");
		}
    }
    
    public GraphNode[] getNodes() {
        return vertices;
    }
}
