/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fbmain;

import java.util.ArrayList;
import java.util.Stack;

/**
 *
 * @author jorgeaceves
 */
public class MyStack extends Stack<StackObject>{
    public int min(){
        if(this.isEmpty()) return Integer.MAX_VALUE;
        return this.peek().min;
    }
    public void push(int v){
      int m = Math.min(v, this.min());
      super.push(new StackObject(v, m));
    }
}
class StackObject {
    public int value;
    public int min;
    public StackObject(int val, int min){
        this.value = val;
        this.min = min;
    }
}
