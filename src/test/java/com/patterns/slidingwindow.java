package com.patterns;

public class slidingwindow {


  /*  Given an array of integers arr[]  and a number k. Return the maximum sum of a subarray of size k.
    Note: A subarray is a contiguous part of any given array.
    Examples:
    Input: arr[] = [100, 200, 300, 400], k = 2
    Output: 700
    Explanation: arr2 + arr3 = 700, which is maximum.*/  //brute force- generating all subarray using nested for loop
    public int maxSubarraySum(int[] arr, int k) { //optimal
        // Code here
        int maxWindowSum=0;
        int windowSum=0;

        for(int i=0;i<k;i++){
            windowSum=windowSum+arr[i];
        }
        maxWindowSum=windowSum;

        for(int i=k;i<arr.length;i++){
            windowSum=windowSum+arr[i]-arr[i-k];
            if(maxWindowSum<windowSum){
                maxWindowSum=windowSum;
            }
        }
        return maxWindowSum;
    }

  /*  Given a binary array nums, return the maximum number of consecutive 1's in the array.
    Example 1:
    Input: nums = [1,1,0,1,1,1]
    Output: 3
    Explanation: The first two digits or the last three digits are consecutive 1s. The maximum number of consecutive 1s is 3.*/
    public int findMaxConsecutiveOnes(int[] nums) {
        int count=0;
        int maxCount=0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]==1){
                count++;
            }else{
                if(count>maxCount){
                    maxCount=count;
                }
                count=0;
            }
        }
        if(count>maxCount){
            maxCount=count;
        }

        return maxCount;
    }


    /*Given a binary array nums and an integer k, return the maximum number of
        consecutive 1's in the array if you can flip at most k 0's.
            Example 1:
    Input: nums = [1,1,1,0,0,0,1,1,1,1,0], k = 2
    Output: 6
    Explanation: [1,1,1,0,0,1,1,1,1,1,1]
    Bolded numbers were flipped from 0 to 1. The longest subarray is underlined.*/
    public int longestOnes(int[] nums, int k) {  //brute force- considering the question as
                                                 //longest subarray with at most k zeros
        int max=0;
        for(int i=0;i<nums.length;i++){
            int zeros=0;
            for(int j=i;j<nums.length;j++){
                if(nums[j]==0){
                    zeros++;
                }
                if(zeros<=k){
                    int length=j-i+1;
                    if(max<length){
                        max=length;
                    }
                }else{
                    break;
                }
            }
        }
        return max;
    }

    public int longestOnes2(int[] nums, int k) { //optimised
        int left=0;
        int zeros=0;
        int maxLength=0;
        for(int right=0;right<nums.length;right++){
            if(nums[right]==0){
                zeros++;
            }
            while(zeros>k){
                if(nums[left]==0){
                    zeros--;
                }
                left++;
            }
            int length=right-left+1;
            if(length>maxLength){
                maxLength=length;
            }
        }
        return maxLength;
    }



   /* You are given an array of integers nums and an integer k.
    Return the number of contiguous subarrays where the product of all the elements in the subarray is strictly less than k.
        Example 1:
    Input: nums = [10,5,2,6], k = 100
    Output: 8
    Explanation: The 8 subarrays that have product less than 100 are:
            [10], [5], [2], [6], [10, 5], [5, 2], [2, 6], [5, 2, 6]
    Note that [10, 5, 2] is not included as the product of 100 is not strictly less than k.*/
    public int numSubarrayProductLessThanK(int[] nums, int k) {  //brute force
        int count=0;
        for(int i=0;i<nums.length;i++){
            int prod=1;
            for(int j=i;j<nums.length;j++){
                prod=prod*nums[j];
                if(prod<k){
                    count++;
                }else{
                    break;
                }
            }
        }
        return count;
    }
}
