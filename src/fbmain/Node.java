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
public class Node {
    public Node next;
    public int data;
    
    public Node(int d){
        this.data = d;
    }
    public void appendToTail(int d){
        Node end = new Node(d);
        Node h = this;
        while(h.next != null){
            h = h.next;
        }
        h.next = end;
    }
}
