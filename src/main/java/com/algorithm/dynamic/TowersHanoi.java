package com.algorithm.dynamic;

import java.util.Stack;

public class TowersHanoi {

    public static void main(String[] args) {
        homeTower.push(12);
        homeTower.push(7);
        homeTower.push(4);

        moveDisks(3, homeTower, targetTower, bufferTower);

        while (!targetTower.isEmpty()) {
            System.out.println(targetTower.pop());
        }
    }

    static Stack<Integer> homeTower = new Stack<>();

    static Stack<Integer> bufferTower = new Stack<>();
    static Stack<Integer> targetTower = new Stack<>();


    static void addElement(int ele, Stack<Integer> target) {
        if (!target.empty() && ele >= target.peek()) {
            System.out.println("Not added");
            return;
        } else {
            target.push(ele);
        }
    }

    static void moveTopTo(Stack<Integer> from, Stack<Integer> to) {
        if (from == homeTower) {
            System.out.print("From Home -");
        } else if (from == targetTower) {
            System.out.print("From Target -");
        } else if (from == bufferTower) {
            System.out.print("From Buffer -");
        }
        if (to == homeTower) {
            System.out.println("To Home -");
        } else if (to == targetTower) {
            System.out.println("To Target -");
        } else if (to == bufferTower) {
            System.out.println("To Buffer -");
        }


        Integer top = from.pop();
        addElement(top, to);
    }


    static public void moveDisks(int n, Stack<Integer> src, Stack<Integer> destination, Stack<Integer> buffer) {
        if (n > 0) {
            moveDisks(n - 1, src, buffer, destination);      // move  n-1 from src  to buffer   with destination as buffer
            moveTopTo(src, destination);                         // from src to dest
            moveDisks(n - 1, buffer, destination, src);       // move  n-1 from buffer to destination using  home  as buffer
        }
    }


}
