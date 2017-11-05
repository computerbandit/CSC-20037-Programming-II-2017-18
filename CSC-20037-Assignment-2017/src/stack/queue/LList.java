/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stack.queue;

/**
 *
 * @author w4f21
 */
public interface LList {

    Node pop();

    void push(int val);

    Node peek();

    Node atIndex(int index);
    
    int find(int val);
    
    boolean isEmpty();

    int size();
    
    void print();
    
    
}
