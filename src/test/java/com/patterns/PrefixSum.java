package com.patterns;

import java.util.HashMap;

public class PrefixSum {


    /*Given an array arr[] containing integers and an integer k, your task is to find the length of the longest subarray where the sum of its elements is equal to the given value k. If there is no subarray with sum equal to k, return 0.

    Examples:

    Input: arr[] = [10, 5, 2, 7, 1, -10], k = 15
    Output: 6
    Explanation: Subarrays with sum = 15 are [5, 2, 7, 1], [10, 5] and [10, 5, 2, 7, 1, -10]. The length of the longest subarray with a sum of 15 is 6.
*/
    
    public int longestSubarray(int[] arr, int k) {
        // code here
        HashMap<Integer,Integer> map=new HashMap<Integer,Integer>();
        int sum=0;
        int maxLength=0;

        for(int i=0;i<arr.length;i++){

            sum=sum+arr[i];

            if(sum==k){
                maxLength=i+1;
            }else{
                if(map.containsKey(sum-k)){
                    int index=map.get(sum-k);
                    int length=i-index;
                    if(length>maxLength){
                        maxLength=length;
                    }
                }
            }

            if(!map.containsKey(sum)){
                map.put(sum,i);
            }





        }
        return maxLength;

    }

    /*Given an integer array nums, return an array answer such that answer[i] is equal to the product of all the elements of nums except nums[i].
    The product of any prefix or suffix of nums is guaranteed to fit in a 32-bit integer.
    You must write an algorithm that runs in O(n) time and without using the division operation.
    Example 1:
    Input: nums = [1,2,3,4]
    Output: [24,12,8,6]
    Example 2:
    Input: nums = [-1,1,0,-3,3]
    Output: [0,0,9,0,0]*/

    public int[] productExceptSelf(int[] nums) { //not exactly PrefixSum...it users Prefix Product + Suffix Product
        int n=nums.length;
        int[] res=new int[n];
        res[0]=1;

        for(int i=1;i<n;i++){
            res[i]=res[i-1]*nums[i-1];
        }
        int rightProd=1;
        for(int i=n-1;i>=0;i--){
            res[i]= res[i]*rightProd;
            rightProd=rightProd*nums[i];
        }
        return res;
    }

   /* Given an unsorted array arr[] of integers, find the number of subarrays whose sum exactly equal to a given number k.

    Examples:

    Input: arr[] = [10, 2, -2, -20, 10], k = -10
    Output: 3
    Explanation: Subarrays: arr[0...3], arr[1...4], arr[3...4] have sum exactly equal to -10.*/


    public int cntSubarrays(int[] arr, int k) {
        // code here

        HashMap<Integer,Integer> map=new HashMap<Integer,Integer>();
        int count=0;
        map.put(0,1);
        int prefixSum=0;
        for(int i=0;i<arr.length;i++){
            prefixSum=prefixSum+arr[i];

            if(map.containsKey(prefixSum-k)){
                count=count+map.get(prefixSum-k);
            }

            if(map.containsKey(prefixSum)){
                map.put(prefixSum,map.get(prefixSum)+1);
            }else{
                map.put(prefixSum,1);
            }
        }
        return count;

    }

    /*Input: nums = [23,2,4,6,7], k = 6
    Output: true
    Explanation: [2, 4] is a continuous subarray of size 2 whose elements sum up to 6.*/
    public boolean checkSubarraySum(int[] nums, int k) {
        int n=nums.length;
        int prefixSum=0;
        HashMap<Integer,Integer> map=new HashMap<Integer,Integer>();
        map.put(0,-1);
        for(int i=0;i<n;i++){
            prefixSum=prefixSum+nums[i];
            int rem=prefixSum%k;
            if(map.containsKey(rem))
            {
                int length=i-map.get(rem);
                if(length>=2){
                    return true;
                }
            }else{
                map.put(rem,i);
            }
        }
        return false;
    }

    /*Given an integer array nums and an integer k, return the number of non-empty subarrays that have a sum divisible by k.
    A subarray is a contiguous part of an array.
        Example 1:
    Input: nums = [4,5,0,-2,-3,1], k = 5
    Output: 7
    Explanation: There are 7 subarrays with a sum divisible by k = 5:
            [4, 5, 0, -2, -3, 1], [5], [5, 0], [5, 0, -2, -3], [0], [0, -2, -3], [-2, -3]*/


    public int subarraysDivByK(int[] nums, int k) {

        int count=0;
        int prefixSum=0;
        HashMap<Integer,Integer> map=new HashMap<Integer,Integer>();
        map.put(0,1);

        for(int i=0;i<nums.length;i++){
            prefixSum=prefixSum+nums[i];
            int rem=prefixSum%k;
            if(rem<0){
                rem=rem+k;
            }
            if(map.containsKey(rem)){
                int value=map.get(rem);
                count=count+value;
            }
            map.put(rem,map.getOrDefault(rem,0)+1);
        }
        return count;




    }
}
