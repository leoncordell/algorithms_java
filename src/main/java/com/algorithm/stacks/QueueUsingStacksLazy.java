package com.algorithm.stacks;

import java.util.EmptyStackException;
import java.util.Stack;

public class QueueUsingStacksLazy<T> {

    Stack<Integer>  fifoStack = new Stack<>();

    Stack<Integer>  lifoStack = new Stack<>();

    public  void add(int  data ){
       lifoStack.push(data);
    }


    public   int  peek(){
        shiftStacks();
        return  fifoStack.peek();

    }


    public int remove(){
        shiftStacks();
        if(fifoStack.isEmpty()) {
            throw new EmptyStackException();
        }
        return  fifoStack.pop();
    }

    // Elements  from lifoStack to fifoStack
    private  void  shiftStacks(){
        if(fifoStack.empty()) {
            while (!lifoStack.empty()) {
                fifoStack.push(lifoStack.pop());
            }
        }
    }


    public boolean isEmpty(){
        return fifoStack.isEmpty();
    }



    public static void main(String[] args) {
        QueueUsingStacksLazy myQueue = new QueueUsingStacksLazy();
        myQueue.add(5);
        myQueue.add(8);
        myQueue.add(2);
        myQueue.add(9);

        while(!myQueue.isEmpty()){
            System.out.println(myQueue.remove());
        }


    }
}
