package  com.algorithm.map;

import java.util.HashMap;

public  class MyHashMap{


    public static void main(String[] args) {
        HashMap<Integer,Integer> testMap = new HashMap<>();

        System.out.println("size " + testMap.size()   );

    }

    public MyHashMap(int   initialSize) {
        this.capacity = initialSize;
        bucketsArray = new Element[this.capacity];
    }

    int capacity;

    double loadCapacity = 0.75;

    Element[] bucketsArray;



    private class Element {
        int data;
        Element next;

        public Element(int data) {

            this.data = data;
        }
    }


    public void addElement(){
         HashMap hashMap;


    }

    private boolean atLoadCapacity(){
        double bucketUse=0;
        for (Element ele : bucketsArray
             ) {
            if(ele != null){
                bucketUse++;
            }
        }
        return bucketUse/capacity > loadCapacity;
    }

    private void  reIndexHashMap(){
        capacity = capacity * 2;

        //Read all buckets into  temporaryArray



    }



}
