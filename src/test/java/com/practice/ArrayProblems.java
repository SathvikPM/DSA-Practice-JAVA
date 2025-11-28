package com.practice;

import java.util.ArrayList;

public class ArrayProblems {


    /*
    Given an array arr[]. The task is to find the largest element and return it.

    Examples:

    Input: arr[] = [1, 8, 7, 56, 90]
    Output: 90
    Explanation: The largest element of the given array is 90.
     */
    public static int largest(int[] arr) {
        // code here
        int largest=arr[0];
        for(int i=1;i<arr.length;i++){
            if(arr[i]>largest){
                largest=arr[i];
            }
        }
        return largest;
    }




    /*
    Given an array of positive integers arr[], return the second largest element from the array. If the second largest element doesn't exist then return -1.

    Note: The second largest element should not be equal to the largest element.

    Examples:

    Input: arr[] = [12, 35, 1, 10, 34, 1]
    Output: 34
    Explanation: The largest element of the array is 35 and the second largest element is 34.
     */

    public int getSecondLargest(int[] arr) {
        // code here
        int largest=arr[0];
        int secondLargest=-1;
        for(int i=1;i<arr.length;i++){
            if(arr[i]>largest){
                secondLargest=largest;
                largest=arr[i];
            }else if(arr[i]>secondLargest && arr[i]!=largest){
                secondLargest=arr[i];
            }
        }
        return secondLargest;
    }




    /*
    Given an array, arr[] of integers, your task is to return the smallest and second smallest element in the array. If the smallest and second smallest do not exist, return -1.

    Examples:

    Input: arr[] = [2, 4, 3, 5, 6]
    Output: [2, 3]
    Explanation: 2 and 3 are respectively the smallest and second smallest elements in the array.
     */
    public ArrayList<Integer> minAnd2ndMin(int[] arr) {
        // code here
        ArrayList<Integer> list=new ArrayList<Integer>();
        int smallest=arr[0];
        int secondSmallest=Integer.MAX_VALUE;
        for(int i=1;i<arr.length;i++){
            if(arr[i]<smallest){
                secondSmallest=smallest;
                smallest=arr[i];
            }else if(arr[i]<secondSmallest && arr[i]!=smallest){
                secondSmallest=arr[i];
            }
        }
        if(secondSmallest==Integer.MAX_VALUE){
            list.add(-1);
        }else{
            list.add(smallest);
            list.add(secondSmallest);
        }
        return list;
    }


    /*
    iven an array arr[], check whether it is sorted in non-decreasing order. Return true if it is sorted otherwise false.

    Examples:

    Input: arr[] = [10, 20, 30, 40, 50]
    Output: true
    Explanation: The given array is sorted
     */
    public boolean isSorted(int[] arr) {
        // code here
        for(int i=1;i<arr.length;i++){
            if(arr[i-1]<=arr[i]){
                continue;
            }else{
                return false;
            }
        }
        return true;
    }

    /*
    You are given a sorted array arr[] containing positive integers.
     Your task is to remove all duplicate elements from this array such that each element appears only once.
    Return an array containing these distinct elements in the same order as they appeared.
     */
    ArrayList<Integer> removeDuplicates(int[] arr) {
        // code here
        ArrayList<Integer> list=new ArrayList<Integer>();
        int i=0;
        list.add(arr[i]);
        for(int j=1;j<arr.length;j++){
            if(arr[j]!=arr[i]){
                list.add(arr[j]);
                i=j;
            }
        }
        return list;
    }



}
