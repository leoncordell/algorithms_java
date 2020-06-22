package com.algorithm.graph;

// Java code​​​​​​‌​​​‌​‌​​​​‌‌​‌​​​‌‌‌‌​‌‌ below
import java.util.*;
import java.io.*;
import java.nio.*;
import java.math.*;
import java.util.function.Function;

import static java.util.stream.Collectors.toList;
import static java.util.stream.Collectors.toMap;

public class FlightPath2 {

    public static void main(String[] args) {

        FlightPath2  fp2 = new FlightPath2();
        int c;
        //System.out.println(c);
        String input = "8 \n LON \n JPN  \n LON PAR 6 \n MAD LON 4\n PAR ROM 5 \n ROM JPN 3\n LON OMA 8 \n OMA  BOM 7 \n TUN FRA 7 \n BOM JPN 8";
        fp2.findRoutes(input);
    }

    public  String findRoutes(String input) {
        Scanner in = new Scanner(input);
        //in.useDelimiter(";");
        // Read the number of segments
        int N = in.nextInt();
        in.nextLine();
        // Read the origin
        String origin = in.nextLine().trim();
        // Read the destination
        String destination = in.nextLine().trim();
        // Create a List to store the segments
        List<Segment> segmentList = new ArrayList<Segment>();
        // Fill the segments list
        for (int i = 0; i < N; i++) {
            segmentList.add
                    (new Segment(in.nextLine().trim()));
        }
        // WRITE YOUR CODE HERE
        if (N == 0)
            return "0";

        //From start LON


        HashMap<String,Node> mapNodes = setNodes(segmentList,origin);
        Comparator<Node> comparator = (Node n,Node n2) -> n.getMinDistance().compareTo(n2.getMinDistance());
        TreeSet<Node> nodeSet = new TreeSet<>(comparator);

        Node x = mapNodes.get(origin);
        nodeSet.add(x);
        setNeighbourNodes(mapNodes,segmentList);
       // PriorityQueue<Node> priorityQueue = new PriorityQueue<>((Node n,Node n2) -> n.getMinDistance().compareTo(n2.getMinDistance()));
       // priorityQueue.addAll(nodes);

        while(!nodeSet.isEmpty()){
            Node nearestNode = nodeSet.first();
            setNextNodes(nearestNode,mapNodes,nodeSet);

            System.out.println(nearestNode.name);
            System.out.println(nearestNode.minDistance);
        }

        //System.out.println(segmentList);
        // To debug: System.err.println("Debug messages...");
        return printItinerary(mapNodes.get(destination));
    }

    private void setNextNodes(Node nearestNode, HashMap<String,Node> mapNodes,TreeSet<Node> setNodes) {
        for (Segment se : nearestNode.neighbours) {
            Node next = mapNodes.get(se.destination);
            next.setMinDistance(Math.min(next.minDistance,nearestNode.minDistance + se.length));
            setNodes.add(next);
        }
    }

    private void setNeighbourNodes(HashMap<String,Node> mapNodes, List<Segment> segmentList) {

        for (Segment segment : segmentList) {
            Node node = mapNodes.get(segment.origin);
            node.neighbours.add(segment);
        }


    }


    private HashMap<String,Node> setNodes(List<Segment> segmentList,String origin) {

        HashMap<String,Node> nodes = new HashMap<>();
        for (Segment segment : segmentList) {
            Node newNode = new Node(segment.origin);
            if(segment.origin==origin){
                newNode.setMinDistance(0);
            }
            nodes.put(newNode.name,newNode);
        }
        return  nodes;
    }


    // Utility method: returns the length of an itinerary
    // by adding up all the segments
    public static int getItineraryLength(List<Segment> segmentList) {
        int length = 0;
        for (Segment segment : segmentList) {
            length += segment.length;
        }
        return length;
    }

    public static String printItinerary(Node node) {
        StringBuffer  itinerary  = new StringBuffer();
        for (Segment segment : node.shortestPath) {
            itinerary.append(segment.toString());
        }
        return itinerary.toString();
    }


    class Node{
        String name;
        List<Segment> neighbours = new ArrayList<>();
        Integer minDistance =Integer.MAX_VALUE;
        List<Segment> shortestPath;


        Node(String name){
            this.name = name;
        }


        public Integer getMinDistance() {
            return minDistance;
        }

        public void setMinDistance(int i) {
            minDistance = i;
        }
    }


    // Inner class representing a Segment (lines 3 to N+3)
        class Segment {
        String origin;
        String destination;

        public String getDestination() {
            return destination;
        }

        public void setDestination(String destination) {
            this.destination = destination;
        }

        int length;

        public Segment(String input) {
            StringTokenizer st = new StringTokenizer(input);
            origin = st.nextToken();
            destination = st.nextToken();
            length = Integer.parseInt(st.nextToken());
        }

        public boolean equals(Object segment) {
            if (segment instanceof Segment) {
                Segment seg = (Segment) segment;
                return seg.origin.equals(origin) && seg.destination.equals(destination) && seg.length == length;
            }
            return false;
        }

        public String toString() {
            return origin + "->" + destination + " : " + length;
        }

        public int hashCode() {
            int hash = 1;
            hash = hash * 17 + origin.hashCode();
            hash = hash * 31 + destination.hashCode();
            hash = hash * 13 + length;
            return hash;
        }

    }
}