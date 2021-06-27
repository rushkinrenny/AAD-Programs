package GreedyApproach;

import java.lang.reflect.Array;
import java.util.Arrays;

class Item implements Comparable<Item>{
    int wt,val;
    Item(int w,int v){
        this.wt=w;
        this.val=v;
    }
    @Override
    public int compareTo(Item i) {
        return this.wt*i.val-this.val*i.wt ;
    }
}
public class FractionalKnapsack {
    static double fracKnapsack(Item []arr, int n, int W){
        Arrays.sort(arr);
        double res=0.0;
        for(int i=0;i<arr.length ;i++){
            if(arr[i].wt<=W){
                res+=arr[i].val;
                W-=arr[i].wt;
            }
            else{
                res+=arr[i].val*((double)W/(double) arr[i].wt);
                break;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Item [] arr={new Item(10,60),
                new Item(40,40),
                new Item(20,100),
                new Item(30,120),};
        int n=4,W=50;
        System.out.println("Max value : "+fracKnapsack(arr,n,W));

    }
}
