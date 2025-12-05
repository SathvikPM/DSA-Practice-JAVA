package com.practice;

import java.util.ArrayList;
import java.util.TreeSet;

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

    /*
    Given an integer array nums sorted in non-decreasing order,
     remove the duplicates in-place such that each unique element appears only once.
     The relative order of the elements should be kept the same.
     */
    public int removeDuplicatesAndReturnSize(int[] arr) {
        int i=0;
        for(int j=1;j<arr.length;j++){
            if(arr[i]!=arr[j]){
                arr[i+1]=arr[j];
                i++;
            }
        }
        return i+1;
    }

    /*
    Given an array arr[]. Rotate the array to the left (counter-clockwise direction) by d steps,
    where d is a positive integer. Do the mentioned change in the array in place.

     Note: Consider the array as circular.

    Examples :

    Input: arr[] = [1, 2, 3, 4, 5], d = 2
    Output: [3, 4, 5, 1, 2]
    Explanation: when rotated by 2 elements, it becomes 3 4 5 1 2
     */
    static void rotateArr(int arr[], int d) { //brute force

        if(d > arr.length){
            d = d % arr.length;
        }

        int[] temp = new int[d];

        for(int i = 0; i < d; i++){
            temp[i] = arr[i];
        }

        int j = 0;
        for(int i = d; i < arr.length; i++){
            arr[j] = arr[i];
            j++;
        }

        int k = 0;
        for(int i = j; i < arr.length; i++){
            arr[i] = temp[k];
            k++;
        }
    }



    //optimal
        public void rotate(int[] nums, int k) {
            if(nums.length < k){
                k = k % nums.length;
            }
            reverse(nums, 0, k - 1);
            reverse(nums, k, nums.length - 1);
            reverse(nums, 0, nums.length - 1);
        }

        public static void reverse(int[] nums, int i, int j){
            while(i < j){
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
                i++;
                j--;
            }
        }



        /*
        You are given an array arr[] of non-negative integers.
        You have to move all the zeros in the array to the right end while maintaining the relative order of the non-zero elements.
         The operation must be performed in place, meaning you should not use extra space for another array.

        Examples:

        Input: arr[] = [1, 2, 0, 4, 3, 0, 5, 0]
        Output: [1, 2, 4, 3, 5, 0, 0, 0]
        Explanation: There are three 0s that are moved to the end
         */
        public void moveZeroes1(int[] nums) { //brute
            int[] temp = new int[nums.length];
            int index = 0;

            for (int i = 0; i < nums.length; i++) {
                if (nums[i] != 0) {
                    temp[index++] = nums[i];
                }
            }

            for (int i = 0; i < nums.length; i++) {
                nums[i] = temp[i];
            }
        }

    void pushZerosToEnd(int[] arr) {  //better
        int i = -1;
        for (int j = 0; j < arr.length; j++) {
            if (arr[j] == 0) {
                i = j;
                break;
            }
        }
        if (i == -1) return;

        for (int j = i + 1; j < arr.length; j++) {
            if (arr[j] != 0) {
                int temp = arr[j];
                arr[j] = arr[i];
                arr[i] = temp;
                i++;
            }
        }
    }

    public void moveZeroes2(int[] arr) { //optimal
        int index = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != 0) {
                arr[index++] = arr[i];
            }
        }
        while (index < arr.length) {
            arr[index++] = 0;
        }
    }

    /*
    Given two sorted arrays a[] and b[], where each array may contain duplicate elements ,
     the task is to return the elements in the union of the two arrays in sorted order.
       Union of two arrays can be defined as the set containing distinct common elements that are present in either of the arrays.

        Examples:

        Input: a[] = [1, 2, 3, 4, 5], b[] = [1, 2, 3, 6, 7]
        Output: [1, 2, 3, 4, 5, 6, 7]
        Explanation: Distinct elements including both the arrays are: 1 2 3 4 5 6 7.
     */
    public static ArrayList<Integer> findUnion(int a[], int b[]) { //brute Forcr
        // code here
        ArrayList<Integer> list=new ArrayList<Integer>();
        TreeSet<Integer> set= new TreeSet<Integer>();
        for(int i=0;i<a.length;i++){
            set.add(a[i]);
        }
        for(int j=0;j<b.length;j++){
            set.add(b[j]);
        }
        for(int k:set){
            list.add(k);
        }
        return list;
    }

    public static ArrayList<Integer> findUnion2(int a[], int b[]) { //optimise
        // code here
        ArrayList<Integer> union=new ArrayList<Integer>();
        int i=0;
        int j=0;
        while(i<a.length && j<b.length){
            if(a[i]<b[j]){
                if(union.isEmpty()||union.get(union.size()-1)!=a[i]){
                    union.add(a[i]);
                }
                i++;
            }
            else if(a[i]>b[j]){
                if(union.isEmpty()||union.get(union.size()-1)!=b[j]){
                    union.add(b[j]);
                }
                j++;
            }
            else{
                if(union.isEmpty()||union.get(union.size()-1)!=b[j]){
                    union.add(b[j]);
                }
                i++;
                j++;
            }
        }
        while(i<a.length){
            if(union.get(union.size()-1)!=a[i]){
                union.add(a[i]);
            }
            i++;
        }
        while(j<b.length){
            if(union.get(union.size()-1)!=b[j]){
                union.add(b[j]);
            }
            j++;
        }
        return union;
    }








}
