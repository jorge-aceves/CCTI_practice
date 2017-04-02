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
public class Chapter3 {
    public void testMinStack(){
        MyStack n = new MyStack();
        n.push(5);
        n.push(10);
        System.out.println(n.peek().value);
        System.out.println(n.min());
        System.out.println(n.pop().value);
        System.out.println(n.peek().value);
    }
}
