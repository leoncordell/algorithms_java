package com.algorithm.stacks;

import java.util.EmptyStackException;
import java.util.Stack;

public class QueueUsingStacks<T> {

    Stack<Integer>  fifoStack = new Stack<>();

    Stack<Integer>  tempStack = new Stack<>();

    public  void add(int  data ){
        if(fifoStack.isEmpty()){
            fifoStack.push(data);
        }else{
            while(!fifoStack.empty()){
                tempStack.push(fifoStack.pop());
            }
            fifoStack.push(data);
            while(!tempStack.empty()){
                fifoStack.push(tempStack.pop());
            }
        }
    }

    public int remove(){
        if(fifoStack.isEmpty()) {
            throw new EmptyStackException();
        }
        return  fifoStack.pop();
    }

    public boolean isEmpty(){
        return fifoStack.isEmpty();
    }



    public static void main(String[] args) {
        QueueUsingStacks  myQueue = new QueueUsingStacks();
        myQueue.add(5);
        myQueue.add(8);
        myQueue.add(2);
        myQueue.add(9);

        while(!myQueue.isEmpty()){
            System.out.println(myQueue.remove());
        }


    }
}
