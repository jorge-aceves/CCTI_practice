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
public class SetOfStacks {
    private ArrayList<Stack> stacks = new ArrayList<>();
    private int maxValue;
    public SetOfStacks(int maxValue){
        this.maxValue = maxValue;
        Stack<Integer> first = new Stack<>();
        stacks.add(first);
    }
    
    public void push(int value){
        if(stacks.get(stacks.size() - 1).size() == maxValue){
            Stack<Integer> s = new Stack<>();
            stacks.add(s);
        }
        stacks.get(stacks.size() - 1).push(value);
    }
    public int pop(){
        if(stacks.get(stacks.size() - 1).isEmpty()){
            stacks.remove(stacks.size() - 1);
        }
        return (int) stacks.get(stacks.size() - 1).pop();
    }
}
