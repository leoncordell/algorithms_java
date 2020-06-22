package com.algorithm.stacks;

import java.util.EmptyStackException;

public class ThreeStackArray {
    int  stackCapacity ;
    int numberStacks = 3;


    int[] baseArray ;
    int[] sizes ;



    ThreeStackArray(int  stackSize,int  numberStacks){
        this.stackCapacity =  stackSize;          
        this.baseArray = new int[stackCapacity*numberStacks];
        this.sizes = new int[numberStacks];        
    }

    public static void main(String[] args) {

    }





    private  int indexOfTop(int  stackNum){
        int sizeStack = sizes[stackNum];
        int topPos = stackNum * stackCapacity + sizeStack -1;   //  eg  stack 0 ,size 2 -  pos  will   be 1

       return topPos;
    }

    private  boolean  isFull(int  stackNum){
        return sizes[stackNum] > stackCapacity;
    }

    private  boolean  isEmpty(int  stackNum){
        return sizes[stackNum] ==0;
    }


    public void push(int value , int stackNum){
        if(stackNum > 3 || stackNum<1){
            throw new IllegalArgumentException();
        }
        if(isFull(stackNum)){
            throw new StackFullException();
        }
        int top = indexOfTop(stackNum);
        sizes[stackNum]++;
        baseArray[++top] = value;
    }

    public int pop(int stackNum){
       if( sizes[stackNum] ==0){
           throw  new EmptyStackException();
       };
       int topIndex = indexOfTop(stackNum);
       int value = baseArray[topIndex];
       baseArray[topIndex] = 0;
       sizes[stackNum] --;
       return value;
    }


    public  int peek(int  stackNum){
        if( sizes[stackNum] ==0){
            throw  new EmptyStackException();
        };
        int topPos = indexOfTop(stackNum);
        return baseArray[topPos];
    };


}

class  StackFullException  extends   RuntimeException{

}