package com.practice;

public class Hashing {

    public static void main(String[] args) {
        int[] arr={1,3,4,1,2,3,4,2,1};
        countFrequency(arr);
    }

    private static void countFrequency(int[] arr) {

        int max=arr[0];
        for(int i=1;i<arr.length;i++){
            if(max<arr[i]){
                max=arr[i];
            }
        }

        int[] hash=new int[max+1];

        for(int i=0;i<arr.length;i++){
            int value=arr[i];
            hash[value]++;
        }

        for(int i=0;i<hash.length;i++){
            if(hash[i]>0){
                System.out.println(i+" "+hash[i]);
            }
        }




    }
}
