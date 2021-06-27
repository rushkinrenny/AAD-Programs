package GreedyApproach;

import java.util.PriorityQueue;
import java.util.Scanner;

public class HuffmanCodingClass {
    public static void main(String[] args) {
        Scanner scan=new Scanner(System.in);
        String message=scan.nextLine();
        System.out.println("Message: "+message);
        int messageSize=8*message.length(); //bits using when use ASCII code
        int compressedMessageSize=huffmanCoding(message);
        System.out.println("Message size(before compression): "+messageSize);
        System.out.println("Message size(after compression): "+compressedMessageSize);
        System.out.println("Bits save : "+(messageSize-compressedMessageSize));
    }
    static int huffmanCoding(String message){
        int compressedMessageSize=0;
        int []freq=new int[256];
        String []codes;
        for(int i=0;i<message.length();i++){
            freq[message.charAt(i)]++;
        }
        Node root;
        PriorityQueue<Node> pq=new PriorityQueue<Node>();
        for(int i=0;i<256;i++){
            if(freq[i]>0){
                char ch=(char) (i); //convert in character
                pq.add(new Node(ch,freq[i]));
            }
        }
        while (pq.size()!=1) {
            Node last = pq.remove();
             //System.out.println("last : "+(int)last.ch + " "+last.ch +" freq : "+last.count);
            Node secondLast = pq.remove();
            // System.out.println("SecondLast : "+(int)secondLast.ch + " "+secondLast.ch +" freq : "+secondLast.count);
            Node newNode = new Node(last, secondLast);
             // System.out.println("newNode : "+ (int)newNode.ch +" freq : "+newNode.count);
            pq.add(newNode);
        }
        root=pq.remove();
        codes=generateCodes(root);
        for(int i=0;i<256;i++){
            if(freq[i]>0){
                char ch=(char)(i);
                System.out.println(ch+": "+codes[i]);
                compressedMessageSize+=freq[i]*codes[i].length();
            }
        }
        return compressedMessageSize;
    }
    static String[] generateCodes(Node root){
        String[] codes=new String[256];
        printCode(root,codes,"");
        return codes;
    }
    static void printCode(Node node, String[] codes, String currentCode){
        if(node.left==null && node.right==null){
            codes[node.ch]=currentCode;
        }
        else{
            printCode(node.left,codes,currentCode+"0");
            printCode(node.right,codes,currentCode+"1");
        }
    }
    static class Node implements Comparable<Node>{
        char ch;
        Integer count;
        Node left,right;
        Node(char ch, int count){
            this.ch=ch;
            this.count=count;
        }
        Node(Node left, Node right){
            count=left.count+right.count;
            this.left=left;
            this.right=right;
        }

        @Override
        public int compareTo(Node o) {
            if (this.count==o.count)
                return this.ch-o.ch;
            return this.count.compareTo(o.count);
        }
    }
}
