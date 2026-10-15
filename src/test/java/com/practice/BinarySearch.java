package com.practice;

public class BinarySearch {

    /*Input: nums = [-1,0,3,5,9,12], target = 9
    Output: 4
    Explanation: 9 exists in nums and its index is 4*/
        public int search1(int[] nums, int target) {
            int low=0;
            int high=nums.length-1;
            while(low<=high){
                int mid=(low+high)/2;
                if(nums[mid]==target){
                    return mid;
                }else if(nums[mid]<target){
                    low=mid+1;
                }else{
                    high=mid-1;
                }
            }
            return -1;
        }

        //using recurion

        public int search(int[] nums, int target) {
            int res=binarySearch(nums,0,nums.length-1,target);
            return res;
        }
        public static int binarySearch(int[] arr,int low,int high,int target){
            if(low>high){
                return -1;
            }
            int mid=(low+high)/2;

            if(arr[mid]<target){
                return binarySearch(arr,mid+1,high,target);
            }else if(arr[mid]>target){
                return binarySearch(arr,low,mid-1,target);
            }
            return mid;
        }

    int lowerBound(int[] arr, int target) {
        // code here
        int low=0;
        int high=arr.length-1;
        int ans=arr.length;
        while(low<=high){
            int mid=(low+high)/2;
            if(arr[mid]>=target){
                ans=mid;
                high=mid-1;
            }else{
                low=mid+1;
            }
        }
        return ans;
    }

    int upperBound(int[] arr, int target) {
        // code here
        int low=0;
        int high=arr.length-1;
        int ans=arr.length;
        while(low<=high){
            int mid=(low+high)/2;
            if(arr[mid]>target){
                ans=mid;
                high=mid-1;
            }else{
                low=mid+1;
            }
        }
        return ans;
    }



}
