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


    public int singleNumber3(int[] nums) {  //Better but fails for
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



    /*Given an array of integers arr[]  and a number k. Return the maximum sum of a subarray of size k.

    Note: A subarray is a contiguous part of any given array.

    Examples:

    Input: arr[] = [100, 200, 300, 400], k = 2
    Output: 700
    Explanation: arr2 + arr3 = 700, which is maximum.*/
    public int maxSubarraySum1(int[] arr, int k) {

        int mSum = Integer.MIN_VALUE;

        // Starting point of subarray
        for(int i = 0; i <= arr.length - k; i++) {

            int sum = 0;

            // Calculate sum of k elements
            for(int j = i; j < i + k; j++) {
                sum += arr[j];
            }

            // Update maximum sum
            if(sum > mSum) {
                mSum = sum;
            }
        }

        return mSum;
    }

//sliding window
    public int maxSubarraySum2(int[] arr, int k) {

        int wSum = 0;

        // First window
        for(int i = 0; i < k; i++) {
            wSum += arr[i];
        }

        int mSum = wSum;

        // Sliding window
        for(int j = k; j < arr.length; j++) {
            wSum = wSum + arr[j] - arr[j-k];

            if(wSum > mSum) {
                mSum = wSum;
            }
        }

        return mSum;
    }



    /*
      Given an array arr[] containing integers and an integer k, your task is to find the
       length of the longest subarray where the sum of its elements is equal to the given value k.
        If there is no subarray with sum equal to k, return 0.
    Examples:

    Input: arr[] = [10, 5, 2, 7, 1, -10], k = 15
    Output: 6
    Explanation: Subarrays with sum = 15 are [5, 2, 7, 1], [10, 5] and [10, 5, 2, 7, 1, -10].
    The length of the longest subarray with a sum of 15 is 6

      */

    public int longestSubarray(int[] arr, int k) { //brute force O(n*n*n)
        // code here
        int maxSum=Integer.MIN_VALUE;
        int maxSize=0;
        int size;
        for(size=1;size<=arr.length;size++){
            for(int i=0;i<=arr.length-size;i++){
                int sum=0;
                for(int j=i;j<i+size;j++){
                    sum=sum+arr[j];
                }
                if(sum==k){
                    if(size>maxSize){
                        maxSize=size;
                    }
                }
            }
        }
        return maxSize;
    }

    public int longestSubarray2(int[] arr, int k) { //brute force  O(n*n)
        // code here
        int size=0;
        int maxSize=0;
        for(int i=0;i<=arr.length;i++){
            int sum=0;
            for(int j=i;j<arr.length;j++){
                sum=sum+arr[j];
                size=j-i+1;
                if(sum==k){
                    if(maxSize<size){
                        maxSize=size;
                    }
                }
            }

        }

        return maxSize;
    }

    //better  2 ponter (sliding window)


        public int longestSubarray3(int[] arr, int k) { //optimised
            // code here
            int sum=0;
            int length=0;
            int maxlength=0;
            HashMap<Integer,Integer> map=new HashMap<Integer,Integer>();


            for(int i=0;i<arr.length;i++)
            {
                sum=sum+arr[i];
                if(sum==k)
                {
                    maxlength=i+1;
                }
                if(!map.containsKey(sum))
                {
                    map.put(sum,i);
                }
                if(map.containsKey(sum-k))
                {
                    length=i-map.get(sum-k);
                    if(maxlength<length)
                    {
                        maxlength=length;
                    }
                }

            }
            return maxlength;

        }

    /*Input: arr[] = [0, -1, 2, -3, 1], target = -2
    Output: true
    Explanation: There is a pair (1, -3) with the sum equal to given target, 1 + (-3) = -2.
*/
    boolean twoSum(int arr[], int target) {
        // code here

        Arrays.sort(arr);
        int i=0;
        int j=arr.length-1;

        while(i<j){
            int sum=arr[i]+arr[j];
            if(sum==target){
                return true;
            }
            if(sum<target){
                i++;
            }else if(sum>target){
                j--;
            }
        }
        return false;
    }

   /* Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.

    You may assume that each input would have exactly one solution, and you may not use the same element twice.

    You can return the answer in any order.

    Input: nums = [2,7,11,15], target = 9
    Output: [0,1]
    Explanation: Because nums[0] + nums[1] == 9, we return [0, 1].*/


    public int[] twoSum2(int[] arr, int target) { //brute force
        int result[]=new int[2];
        for(int i=0;i<arr.length-1;i++){
            for(int j=i+1;j<arr.length;j++){
                int sum=arr[i]+arr[j];
                if(sum==target){
                    result[0]=i;
                    result[1]=j;
                }
            }
        }
        return result;
    }

        public int[] twoSum3(int[] arr, int target) { //optimal
            HashMap<Integer,Integer> map=new HashMap<Integer,Integer>();
            int[] result=new int[2];
            for(int i=0;i<arr.length;i++){
                if(map.containsKey(target-arr[i])){
                    result[0]=map.get(target-arr[i]);
                    result[1]=i;
                    return result;
                }else{
                    map.put(arr[i],i);
                }
            }
            result[0]=-1;
            result[1]=-1;
            return result;
        }

    /*Given an array nums with n objects colored red, white, or blue, sort them in-place so that objects of the same color are adjacent, with the colors in the order red, white, and blue.

    We will use the integers 0, 1, and 2 to represent the color red, white, and blue, respectively.

    You must solve this problem without using the library's sort function.



    Example 1:

    Input: nums = [2,0,2,1,1,0]
    Output: [0,0,1,1,2,2]
    Example 2:

    Input: nums = [2,0,1]
    Output: [0,1,2]*/
    public void sortColors(int[] arr) { //brute force
        int zeroCount=0;
        int oneCount=0;
        int twoCount=0;

        for(int i=0;i<arr.length;i++){
            if(arr[i]==0){
                zeroCount++;
            }
            if(arr[i]==1){
                oneCount++;
            }
            if(arr[i]==2){
                twoCount++;
            }

        }

        for(int i=0;i<zeroCount;i++){
            arr[i]=0;
        }
        for(int i=zeroCount;i<zeroCount+oneCount;i++){
            arr[i]=1;
        }
        for(int i=zeroCount+oneCount;i<arr.length;i++){
            arr[i]=2;
        }

    }

   /* Given an array nums of size n, return the majority element.

    The majority element is the element that appears more than ⌊n / 2⌋ times. You may assume that the majority element always exists in the array.
        Example 1:
    Input: nums = [3,2,3]
    Output: 3*/
    //brute force=using inner for loops
    //beter =using hashmap
   //optimal
    public int majorityElement(int[] arr) {
        int count=0;
        int el=0;
        for(int i=0;i<arr.length;i++){
            if(count==0){
                el=arr[i];
                count=1;
            }
            else if(arr[i]==el){
                count++;
            }else{
                count--;
            }

        }
        if(count==0){
            return -1;
        }
        return el;
    }


/*
53. Maximum Subarray

    Given an integer array nums, find the subarray with the largest sum, and return its sum.
    Example 1:
    Input: nums = [-2,1,-3,4,-1,2,1,-5,4]
    Output: 6
    Explanation: The subarray [4,-1,2,1] has the largest sum 6.
*/

//    Brute
        public int maxSubArray1(int[] arr) {
            int maxSum=Integer.MIN_VALUE;
            for(int size=1;size<=arr.length;size++){
                for(int i=0;i<=arr.length-size;i++){
                    int sum=0;
                    for(int j=i;j<i+size;j++){
                        sum=sum+arr[j];
                    }
                    if(sum>maxSum){
                        maxSum=sum;
                    }
                }
            }
            return maxSum;
        }

//    Better
        public int maxSubArray2(int[] arr) {
            int maxSum=Integer.MIN_VALUE;
            for(int i=0;i<arr.length;i++){
                int sum=0;
                for(int j=i;j<arr.length;j++){
                    sum=sum+arr[j];
                    if(sum>maxSum){
                        maxSum=sum;
                    }
                }
            }
            return maxSum;

        }


    //optimal
        public int maxSubArray3(int[] arr) {
            int maxSum=Integer.MIN_VALUE;
            int sum=0;
            for(int i=0;i<arr.length;i++){
                sum=sum+arr[i];
                if(sum>maxSum){
                    maxSum=sum;
                }
                if(sum<0){
                    sum=0;
                }

            }
            return maxSum;

        }
    /*    121. Best Time to Buy and Sell Stock
    You are given an array prices where prices[i] is the price of a given stock on the ith day.
    You want to maximize your profit by choosing a single day to buy one stock and choosing a different day in the future to sell that stock.
    Return the maximum profit you can achieve from this transaction. If you cannot achieve any profit, return 0
    Example 1:
    Input: prices = [7,1,5,3,6,4]
    Output: 5
    Explanation: Buy on day 2 (price = 1) and sell on day 5 (price = 6), profit = 6-1 = 5.
    Note that buying on day 2 and selling on day 1 is not allowed because you must buy before you sell*/

        //brute force
        public int maxProfit2(int[] prices) {
            int maxProfit=0;
            for(int i=prices.length-1;i>=1;i--){
                int profit=0;
                for(int j=i-1;j>=0;j--){
                    profit=prices[i]-prices[j];
                    if(maxProfit<profit){
                        maxProfit=profit;
                    }
                }
            }
            return maxProfit;
        }

        //optimal
    public int maxProfit1(int[] prices) {
        int profit=0;
        int mini=prices[0];
        for(int i=1;i<prices.length;i++){
            int cost=prices[i]-mini;
            if(cost>profit){
                profit=cost;
            }
            if(mini>prices[i]){
                mini=prices[i];
            }

        }
        return profit;

    }


   /* You are given a 0-indexed integer array nums of even length consisting of an equal number of positive and negative integers.
    You should return the array of nums such that the array follows the given conditions:
    Every consecutive pair of integers have opposite signs.
    For all integers with the same sign, the order in which they were present in nums is preserved.
    The rearranged array begins with a positive integer.
    Return the modified array after rearranging the elements to satisfy the aforementioned conditions.
            Example 1:
    Input: nums = [3,1,-2,-5,2,-4]
    Output: [3,-2,1,-5,2,-4]
    Explanation:
    The positive integers in nums are [3,1,2]. The negative integers are [-2,-5,-4].
    The only possible way to rearrange them such that they satisfy all conditions is [3,-2,1,-5,2,-4].
    Other ways such as [1,-2,2,-5,3,-4], [3,1,2,-2,-5,-4], [-2,3,-5,1,-4,2] are incorrect because they do not satisfy one or more conditions.
*/
    //brute force
    public int[] rearrangeArray1(int[] nums) {

        int pos[]=new int[nums.length/2];
        int pi=0;
        int neg[]=new int[nums.length/2];
        int ni=0;
        int res[]=new int[nums.length];
        for(int i=0;i<nums.length;i++){
            if(nums[i]>0){
                pos[pi]=nums[i];
                pi++;
            }else{
                neg[ni]=nums[i];
                ni++;
            }
        }
        for(int i=0;i<pos.length;i++){
            res[i*2]=pos[i];
            res[i*2+1]=neg[i];

        }
        return   res;
    }

    public int[] rearrangeArray2(int[] nums) {
        int posIndex=0;
        int negIndex=1;
        int res[]=new int[nums.length];
        for(int i=0;i<nums.length;i++){
            if(nums[i]>0){
                res[posIndex]=nums[i];
                posIndex=posIndex+2;
            }else{
                res[negIndex]=nums[i];
                negIndex=negIndex+2;
            }
        }
        return res;
    }

    //varity 2 for rearrange
  /*  pos != neg
    Input: arr[] = [-5, -2, 5, 2, 4, 7, 1, 8, 0, -8]
    Output: [5, -5, 2, -2, 4, -8, 7, 1, 8, 0]
    Explanation : The positive numbers are [5, 2, 4, 7, 1, 8, 0]
    and the negative integers are [-5,-2,-8]. According to the given conditions
    we will start from the positive integer 5 and then -5 and so on. After reaching -8
    there are no negative elements left, so according to the given rule,
    we will add the remaining elements (in this case positive elements are remaining) as it in by maintaining the relative order.
*/

    void rearrange(ArrayList<Integer> arr) {
        LinkedList<Integer> pos = new LinkedList<>();
        LinkedList<Integer> neg = new LinkedList<>();

        for(int i = 0; i < arr.size(); i++) {
            if(arr.get(i) >= 0) {
                pos.add(arr.get(i));
            } else {
                neg.add(arr.get(i));
            }
        }

        if(pos.size() > neg.size()) {

            for(int i = 0; i < neg.size(); i++) {
                arr.set(2 * i, pos.get(i));
                arr.set(2 * i + 1, neg.get(i));
            }

            int index = neg.size() * 2;

            for(int i = neg.size(); i < pos.size(); i++) {
                arr.set(index, pos.get(i));
                index++;
            }

        } else {

            for(int i = 0; i < pos.size(); i++) {
                arr.set(2 * i, pos.get(i));
                arr.set(2 * i + 1, neg.get(i));
            }

            int index = pos.size() * 2;

            for(int i = pos.size(); i < neg.size(); i++) {
                arr.set(index, neg.get(i));
                index++;
            }
        }
    }

    /*Array Leaders
    You are given an array arr of positive integers. Your task is to find
    all the leaders in the array. An element is considered a leader if
    it is greater than or equal to all elements to its right. The rightmost element is always a leader.
        Examples:
    Input: arr = [16, 17, 4, 3, 5, 2]
    Output: [17, 5, 2]
    Explanation: Note that there is nothing greater on the right side of 17, 5 and, 2.*/

    //brute force
    static ArrayList<Integer> leaders1(int arr[]) {
        // code here

        ArrayList<Integer> list=new ArrayList<Integer>();

        for(int i=0;i<arr.length;i++){

            boolean leader=true;
            for(int j=i+1;j<arr.length;j++){
                if(arr[j]>arr[i]){
                    leader=false;
                    break;
                }

            }
            if(leader==true){
                list.add(arr[i]);
            }

        }

        return list;



    }

   //optimal
    static ArrayList<Integer> leaders2(int arr[]) {
        // code here
        ArrayList<Integer> list=new ArrayList<Integer>();
        int max=Integer.MIN_VALUE;
        for(int i=arr.length-1;i>=0;i--){
            if(arr[i]>=max){
                list.add(arr[i]);
                max=arr[i];
            }
        }
        int i=0;
        int j=list.size()-1;
        // Collections.reverse(ans);
        while(i<=j){
            int temp=list.get(i);
            list.set(i,list.get(j));
            list.set(j,temp);
            i++;
            j--;
        }
        return list;
    }

   /* Given an array arr[] of non-negative integers. Find the length of the longest sub-sequence
    such that elements in the subsequence are consecutive integers, the consecutive numbers can be in any order.
        Examples:
    Input: arr[] = [2, 6, 1, 9, 4, 5, 3]
    Output: 6
    Explanation: The consecutive numbers here are 1, 2, 3, 4, 5, 6. These 6 numbers form the longest consecutive subsquence.*/

    //brute
    public int longestConsecutive(int[] arr) {
        // code here
        int longest=1;
        for(int i=0;i<arr.length;i++){
            int x=arr[i];
            int count=0;
            while(linearSearch(arr,x)==true){
                count++;
                x=x+1;
            }
            if(count>longest){
                longest=count;
            }
        }
        return longest;

    }
    public static boolean linearSearch(int[] arr,int x){

        for(int i=0;i<arr.length;i++){


            if(arr[i]==x){
                return true;
            }
        }
        return false;


    }

    //better

    public int longestConsecutive2(int[] arr) {
        // code here

        Arrays.sort(arr);
        int count=1;
        int longest=1;


        for(int i=0;i<arr.length-1;i++){
            if(arr[i+1]-arr[i]==1){
                count++;
            }else if(arr[i+1]==arr[i]){
                continue;
            }else{
                if(longest<count){
                    longest=count;

                }
                count=1;
            }
        }
        // If the last consecutive sequence reaches the end of the array
        if(longest<count){
            longest=count;
        }

        return longest;

    }
 //optimal

  /*  Store all elements in a HashSet so we can check whether an element exists in O(1) average time.
    Check if the previous consecutive element (e - 1) exists. If it does not exist, e is the starting element of a sequence.
    Count consecutive elements using e + 1, e + 2, etc., and update longest with the maximum sequence length.*/
    public int longestConsecutive3(int[] arr) {
        // code here

        HashSet<Integer> set=new HashSet();

        for(int i=0;i<arr.length;i++){
            set.add(arr[i]);
        }
        int count=1;
        int longest=1;
        for(int e:set){

            if(!set.contains(e-1)){
                count=1;
                int x=e;
                while(set.contains(x+1)){
                    count++;
                    x=x+1;
                }

            }
            if(count>longest){
                longest=count;
            }
        }
        return longest;


    }

































}
