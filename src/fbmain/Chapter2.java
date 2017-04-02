/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fbmain;

import java.util.*;

/**
 *
 * @author jorgeaceves
 */
public class Chapter2 {
    public Node deleteNode(Node n, int d){
        Node head = n;
        if(head == null) return head;
        
        if(head.data == d) return head.next;
        while(n.next != null){
            if(n.next.data == d){
                n.next = n.next.next;
                return head;
            }
            n = n.next;
        }
        return head;
    }
    public void printList(Node h){
        while(h != null){
            System.out.print(h.data);
            if(h.next != null) System.out.print("->");
            h = h.next;
        }
        System.out.println("");
    }
    public void removeDups(Node n){
        Node p = n;
        HashSet<Integer> hs = new HashSet<>();
        while(n != null){
            if(hs.contains(n.data)){
               p.next = n.next;
            } else {
               hs.add(n.data);
               p = n;
            }
            n = n.next;
        }
    }
    public Node kthToLast(Node n, int k){
        Node f = n;
        while(f != null && k > 0){
            f = f.next;
            k--;
        }
        if(f == null) return null;
        while(f.next != null){
            f = f.next;
            n = n.next;
        }
        return n;
    }
    public void eraseMiddleNode(Node n){
        Node p = n;
        n = n.next;
        p.data = n.data;
        p.next = n.next;
    }
    public Node partition(Node n, int value){
        if(n == null || n.next == null){
            return n;
        }
        
        Node head = n;
        Node p = n;
        n = n.next;
        while(n != null){
            if(n.data < value){
               p.next = n.next;
               n.next = head;
               head = n;
               n = p.next;
            } else {
              n = n.next;
              p = p.next;
            }
        }
        return head;
    }
    public Node sumLists(Node l1, Node l2){
        int sum = 0, value = 0, carry = 0;
        Node resultTail = null;
        Node resultHead = null;
        while(l1 != null || l2 != null || carry != 0){
            sum = carry;
            if(l1 != null){
              sum += l1.data;
              l1 = l1.next;
            }
            if(l2 != null){
              sum += l2.data;
              l2 = l2.next;
            }
            value = sum % 10;
            carry = sum > 9 ? 1 : 0;
            Node digit = new Node(value);
            if(resultHead == null){
                resultHead = digit;
            } else {
                resultTail.next = digit;
            }
            resultTail = digit;
        }
        return resultHead;
    }
    public int getNodeLength(Node n){
        int count = 0;
        while(n != null){
            n = n.next;
            count++;
        }
        return count;
    }
    public Node padWithZeroes(Node n, int zeroes){
        for(int x = 0; x < zeroes; x++){
            Node z = new Node(0);
            z.next = n;
            n = z;
        }
        return n;
    }
    public Node sumListsReverse(Node l1, Node l2){
        int l1Length = getNodeLength(l1);
        int l2Length = getNodeLength(l2);
        if(l1Length != l2Length){
            Node tmp = l1Length > l2Length ? l2 : l1;
            tmp = padWithZeroes(tmp, Math.abs(l1Length - l2Length));
            l1 = l1Length > l2Length ? l1 : tmp;
            l2 = l1Length > l2Length ? tmp : l2;
        }
        IntWrap wr = new IntWrap(0);
        Node s = sumListsReverse(l1, l2, wr);
        if(wr.value == 1){
            Node top = new Node(1);
            top.next = s;
            s = top;
        }
        return s;
    }
    public Node sumListsReverse(Node l1, Node l2, IntWrap carry){
        Node next = null;
        if(l1.next != null){
            next = sumListsReverse(l1.next, l2.next, carry);
        }
        int sum = l1.data + l2.data + carry.value;
        carry.value = sum > 9 ? 1 : 0;
        Node s = new Node(sum % 10);
        if(next != null){
            s.next = next;
        }
        return s;
    }
    public boolean isPalindrome(Node list){
        int listLength = getNodeLength(list);
        NodeResult res = recursePalindrome(list, listLength);
        return res.result;
    }
    public NodeResult recursePalindrome(Node list, int length){
        NodeResult res;
        if(length == 0){
            return new NodeResult(list, true);
        }
        if(length == 1){
            return new NodeResult(list.next, true);
        }
        res = recursePalindrome(list.next, length - 2);
        if(!res.result){
            return res;
        }
        res.result = list.data == res.n.data;
        res.n = res.n.next;
        return res;
    }
    public Node getTail(Node l){
        if(l == null) return null;
        while(l.next != null){
            l = l.next;
        }
        return l;
    }
    public Node advanceKNodes(Node n, int k){
        for(int x=0; x<k; x++){
            n = n.next;
        }
        return n;
    }
    public Node printKNodes(Node n, int k){
        for(int x=0; x<k; x++){
            System.out.print(n.data + " ");
            n = n.next;
        }
        System.out.println("");
        return n;
    }
    public Node listsIntersect(Node l1, Node l2){
        Node tail1 = getTail(l1);
        Node tail2 = getTail(l2);
        if(tail1 != tail2) return null;
        int length1 = getNodeLength(l1);
        int length2 = getNodeLength(l2);
        if(length1 != length2){
            if(length1 > length2){
              l1 = advanceKNodes(l1, length1 - length2); 
            } else {
              l2 = advanceKNodes(l2, length2 - length1);
            }
        }
        while(l1 != l2){
            l1 = l1.next;
            l2 = l2.next;
        }
        return l1;
    }
    public Node findLoopNode(Node n){
        if(n == null) return n;
        Node slow = n;
        Node fast = n;
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
            if(fast == slow) break;
        }
        if(fast == null || fast.next == null) return null;
        slow = n;
        while(fast != slow){
            slow = slow.next;
            fast = fast.next;
        }
        return slow;
    }
}
