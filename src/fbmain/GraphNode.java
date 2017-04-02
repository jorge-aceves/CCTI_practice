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
public class GraphNode {
    private GraphNode adjacent[];
    public int adjacentCount;
    private String vertex;
    public Chapter4.State state;
    public GraphNode(String vertex, int adjacentLength) {
        this.vertex = vertex;                
        adjacentCount = 0;        
        adjacent = new GraphNode[adjacentLength];
    }
    
    public void addAdjacent(GraphNode x) {
        if (adjacentCount < adjacent.length) {
            this.adjacent[adjacentCount] = x;
            adjacentCount++;
        } else {
            System.out.print("No more adjacent can be added");
        }
    }
    public GraphNode[] getAdjacent() {
        return adjacent;
    }
    public String getVertex() {
        return vertex;
    }
}
