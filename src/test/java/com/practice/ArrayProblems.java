package com.practice;

import java.util.*;

public class ArrayProblems {

    public static void main(String[] args) {
        countSuprior();
    }


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

    /*
    Given a binary array nums, return the maximum number of consecutive 1's in the array.

    Example 1:

    Input: nums = [1,1,0,1,1,1]
    Output: 3
    Explanation: The first two digits or the last three digits are consecutive 1s. The maximum number of consecutive 1s is 3.
     */

        public int findMaxConsecutiveOnes(int[] arr) {
            int count = 0;
            int maxcount = 0;

            for (int i = 0; i < arr.length; i++) {
                if (arr[i] == 1) {
                    count++;
                    if (count > maxcount) {
                        maxcount = count;
                    }
                } else {
                    count = 0;
                }
            }
            return maxcount;
        }


    /*
    Given an array nums containing n distinct numbers in the range [0, n], return the only number in the range that is missing from the array.

    Example 1:
    Input: nums = [3,0,1]
    Output: 2
     */
        public int missingNumber(int[] nums) { //Brute force
            int n = nums.length;

            // check every number from 0 to n
            for (int i = 0; i <= n; i++) {
                boolean found = false;

                // search for i in the array
                for (int j = 0; j < nums.length; j++) {
                    if (nums[j] == i) {
                        found = true;
                        break;
                    }
                }

                // if i not found → missing number
                if (!found) {
                    return i;
                }
            }

            return -1; // technically unreachable
        }

    int missingNum(int arr[]) { //optimise  //another optimise is in XOR class
        // code here
        int n=arr.length+1;
        int sum1=n*(n+1)/2;
        int sum2=0;
        for(int i=0;i<arr.length;i++){
            sum2=arr[i]+sum2;
        }
        int missingNum=sum1-sum2;
        return missingNum;
    }

    /*
    intersection WITHOUT duplicates (Unique Intersection)

    Question Type:
    “Find the intersection of two sorted arrays.”

    What they expect:

    Only common elements

    No duplicates in the result

    Example:
    arr1 = [1, 2, 2, 3, 4]
    arr2 = [2, 2, 4, 6, 7]
    Output:
    👉 [2, 4]
     */
    ArrayList<Integer> intersectionWithoutDuplicates1(int[] a, int[] b) { //brute force
        ArrayList<Integer> list = new ArrayList<>();

        int[] used = new int[b.length];

        for (int i = 0; i < a.length; i++) {

            for (int j = 0; j < b.length; j++) {

                if (a[i] == b[j] && used[j] == 0) {

                    // prevent duplicates in result
                    if (list.isEmpty() || list.get(list.size() - 1) != a[i]) {
                        list.add(a[i]);
                    }

                    used[j] = 1;
                    break;
                }

                if (b[j] > a[i]) {
                    break;
                }
            }
        }

        return list;
    }

    public ArrayList<Integer> intersectionWithoutDuplicates2(int arr1[], int arr2[]) { //optimal

        ArrayList<Integer> output = new ArrayList<>();
        int i = 0, j = 0;

        while (i < arr1.length && j < arr2.length) {

            if (arr1[i] < arr2[j]) {
                i++;
            }
            else if (arr2[j] < arr1[i]) {
                j++;
            }
            else {
                // Both are equal → check for duplicates before adding
                if (output.isEmpty() || output.get(output.size() - 1) != arr1[i]) {
                    output.add(arr1[i]);
                }
                i++;
                j++;
            }
        }

        return output;
    }







    /*
    Intersection WITH duplicates (Intersection considering frequency)

    Question Type:
    “Find the intersection of two arrays, including duplicates.”
    OR
    “Find the intersection where each element appears as many times as it appears in both arrays.”

    What they expect:

    Common elements

    Include duplicates based on frequency

    Example:
    arr1 = [1, 2, 2, 3, 4]
    arr2 = [2, 2, 4, 6, 7]

    Output:
    👉 [2, 2, 4]
     */


    public ArrayList<Integer> intersectionWithDuplicates1(int arr1[], int arr2[]) { //brute force

        ArrayList<Integer> result = new ArrayList<>();
        boolean used[] = new boolean[arr2.length];  // to mark matched elements

        for (int i = 0; i < arr1.length; i++) {

            for (int j = 0; j < arr2.length; j++) {

                // if elements match AND arr2[j] is not already used
                if (arr1[i] == arr2[j] && !used[j]) {
                    result.add(arr1[i]);
                    used[j] = true;   // mark arr2 element as used
                    break;            // move to next element of arr1
                }
            }
        }
        return result;
    }
    public ArrayList<Integer> intersectionWithDuplicates2(int arr1[], int arr2[]) { //optimal

        ArrayList<Integer> output = new ArrayList<>();
        int i = 0;
        int j = 0;

        while (i < arr1.length && j < arr2.length) {

            if (arr1[i] < arr2[j]) {
                i++;
            }
            else if (arr2[j] < arr1[i]) {
                j++;
            }
            else {
                // elements match → add directly (including duplicates)
                output.add(arr1[i]);
                i++;
                j++;
            }
        }
        return output;
    }

    /*
    Given a non-empty array of integers nums, every element appears twice except for one. Find that single one.
    You must implement a solution with a linear runtime complexity and use only constant extra space.
    Example 1:
    Input: nums = [2,2,1]
    Output: 1
     */
    public int singleNumber(int[] nums) { //Brute force
        for(int i=0;i<nums.length;i++){
            int num=nums[i];
            int count=0;
            for(int j=0;j<nums.length;j++){
                if(num==nums[j]){
                    count++;
                }
            }
            if(count==1){
                return num;
            }
        }
        return -1;
    }

    public int singleNumber2(int[] nums) { //Better works for single number
        int max=nums[0];
        for(int i=0;i<nums.length;i++){
            if(nums[i]>max){
                max=nums[i];
            }
        }
        int[] hash=new int[max+1];

        for(int i=0;i<nums.length;i++){
            hash[nums[i]]=hash[nums[i]]+1;
        }

        for(int i=0;i<hash.length;i++){
            if(hash[i]==1){
                return i;
            }
        }
        return -1;
    }


    public int singleNumber3(int[] nums) {  //Better
        HashMap<Integer,Integer> map=new HashMap<Integer,Integer>();
        for(int i=0;i<nums.length;i++){
            map.put(nums[i],map.getOrDefault(nums[i],0)+1);
        }

        for(int key:map.keySet()){
            if(map.get(key)==1){
                return key;
            }
        }
        return -1;


    }

    //optimise in XOR class


    /*
    Given an array arr[] of positive integers which may contain duplicate elements, return the frequency of each distinct element.

    Examples:

    Input: arr[] = [1, 2, 2, 3, 3, 5]
    Output: [[1, 1], [2, 2], [3, 2], [5, 1]]
    Explaiantion: Here element 1 and 5 occur 1 times, 2 and 3 occur 2 times.
     */

    public ArrayList<ArrayList<Integer>> countFreq1(int[] arr) {  //optimised for small datasets
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();

        int max = 0;
        for (int x : arr) {
            max = Math.max(max, x);
        }

        int hash[] = new int[max + 1];

        for (int i = 0; i < arr.length; i++) {
            hash[arr[i]]++;  //hash[arr[i]]=hash[i]+1;
        }

        for (int i = 0; i < hash.length; i++) {
            if (hash[i] > 0) {
                ArrayList<Integer> count = new ArrayList<>(); // NEW LIST EVERY TIME
                count.add(i);
                count.add(hash[i]);
                res.add(count);
            }
        }

        return res;
    }


    public ArrayList<ArrayList<Integer>> countFreq(int[] arr) { //optimised for large dataset
        // code here
        ArrayList<ArrayList<Integer>> count=new ArrayList<ArrayList<Integer>>();
        TreeMap<Integer,Integer> map=new TreeMap<Integer,Integer>();
        for(int i=0;i<arr.length;i++){
            map.put(arr[i],map.getOrDefault(arr[i],0)+1);
        }

        for(int key: map.keySet()){
            ArrayList<Integer> list=new ArrayList<Integer>();
            list.add(key);
            list.add(map.get(key));
            count.add(list);
        }

        return count;

    }

    public static void countSuprior(){
        Scanner scan=new Scanner(System.in);
        int n=scan.nextInt();
        int arr[]=new int[n];
        for (int i=0;i<n;i++){
            arr[i]=scan.nextInt();
        }

        int supCount=0;
        for(int i=0;i<arr.length-1;i++){
            int count=0;
//            int max=arr[i];
            for(int j=i+1;j<arr.length;j++){
                if(arr[j]>arr[i]){
                    count++;
                }
            }
            if(count==0){
                supCount++;
            }
        }
        System.out.print(supCount+1);
    }
















}
