package com.algorithm.stacks;

import java.util.Stack;

public class StackWithMinimumElement {

    private static  class  StackElement{
        int data ;
        StackElement next;
        int min;

        public StackElement(int value) {
            this.data = value;
        }
    }

    StackElement  top;


    int  getMinimum(){
        return  top.min;
    }



    public  void push(int  value){
        StackElement  stackElement  = new StackElement(value);

        if(stackElement.data < top.min){
            stackElement.min = stackElement.data;
        }else{
            stackElement.min = top.min;
        }
        stackElement.next = top;
        top = stackElement;
    }



}
