package com.algorithm.concurrency.collection;

import java.util.HashMap;
import java.util.Objects;
import java.util.Optional;

public class MyHashMap<Player> {

    HashMap<String,String> hm;
    int size;
    int capacity;
    double load;

    public MyHashMap(int capacity, double load) {
        this.capacity = capacity;
        this.load = load;
        int size = (int) (capacity*load);
        this.backing = new Node[size];
    }

    Node[] backing ;

    class Node<Player>{
        Node next ;
        Player data;

        public Node(Player data) {
            this.data = data;
        }
    }

    public void add(Player data){
        int hashValue = data.hashCode();
        // obtain bucketIndex
        int bucketIndex = hashValue % size;
        Node playerNode = backing[bucketIndex];
        Node newNode = new Node(data);
        Optional<Node> node = exists(newNode,data);
//        if(node.isEmpty()){
//            newNode.next=playerNode;
//            backing[bucketIndex] = newNode;
//        }else{
//            Node curr = node.get();
//            curr.data = newNode.data;
//        }
        //check found - replace
        newNode.next=playerNode;
        // add

    }

    

    public Optional<Node> exists(Node node, Player data){
         while(node!=null){
             if(node.data.equals(data)){
                 return Optional.of(node);
             }
         }
         return Optional.empty();
    }

    static private class  Player{
        String name;
        int age;


        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof Player)) {
                return false;
            }
            Player player = (Player) o;
            return age == player.age &&
                    Objects.equals(name, player.name);
        }

        @Override
        public int hashCode() {
            return Objects.hash(name, age);
        }
    }
    public void doStuff(){}

}
