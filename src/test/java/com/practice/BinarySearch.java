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

  /*  Given a sorted array of distinct integers and a target value, return the index if the target is found. If not, return the index where it would be if it were inserted in order.
    You must write an algorithm with O(log n) runtime complexity.
    Example 1:

    Input: nums = [1,3,5,6], target = 5
    Output: 2*/
  /*  Given a sorted array arr[] (following 0-based indexing) and a number target, find the lower bound of the target in this given array.

    The lower bound of a number is defined as the smallest index in the sorted array where the element is greater than or equal to the given number.
    If all the elements in the given array are smaller than the target, the lower bound will be the length of the array.*/

  /*  Input:  arr[] = [2, 3, 7, 10, 11, 11, 25], target = 9
    Output: 3
    Explanation: 3 is the smallest index in arr[] where element (arr[3] = 10) is greater than or equal to 9.*/
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

    /*Given a sorted array arr[] and a number target, the task is to find the upper bound of the target in this given array.
    The upper bound is the smallest index in the sorted array where the element is greater than the given target.
    If all the elements in the given array are smaller than or equal to the target, the upper bound will be the length of the array.
            Examples :
    Input: arr[] = [2, 3, 7, 10, 11, 11, 25], target = 9
    Output: 3
    Explanation: 3 is the smallest index in arr[], at which element (arr[3] = 10) is larger than 9.*/

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

   /* Given a sorted array arr[] and an integer x, find the index (0-based) of the largest element in arr[] that is less than or equal to x. This element is called the floor of x. If such an element does not exist, return -1.
    Note: In case of multiple occurrences of floor of x, return the index of the last occurrence.
    Examples
    Input: arr[] = [1, 2, 8, 10, 10, 12, 19], x = 5
    Output: 1
    Explanation: Largest number less than or equal to 5 is 2, whose index is 1.*/

    static int findFloor(int[] arr, int target) {
        // code here
        int low=0;
        int high=arr.length-1;

        int ans=-1;
        while(low<=high){
            int mid=(low+high)/2;
            if(arr[mid]<=target){
                ans=mid;
                low=mid+1;
            }else{
                high=mid-1;
            }
        }
        return ans;
    }

    /*Given a sorted array arr[] (which may contain duplicate elements) and an integer x, find the 0-based index of the first element greater than or equal to x. This element is called the ceil of x.
    If no such element exists, return -1.
    Note: If multiple occurrences of the ceil exist, return the index of its first occurrence.
    Examples:
    Input: arr[] = [1, 2, 8, 10, 11, 12, 19], x = 5
    Output: 2
    Explanation: Smallest number greater than 5 is 8, whose index is 2.*/
    public int findCeil(int[] arr, int target) {
        // code here
        int low=0;
        int high=arr.length-1;
        int ans=-1;
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



   /* 34. Find First and Last Position of Element in Sorted Array
    Example 1:

    Input: nums = [5,7,7,8,8,10], target = 8
    Output: [3,4]*/

    public int[] searchRange(int[] nums, int target) {
        int[] ans=new int[2];
        int si=firstOccurance(nums,target);
        if(si==-1){
            ans[0]=-1;
            ans[1]=-1;
            return ans;
        }
        int ei=lastOccurance(nums,target);
        ans[0]=si;
        ans[1]=ei;
        return ans;

    }

    public static int firstOccurance(int[] nums,int target){
        int low=0;
        int high=nums.length-1;
        int si=-1;
        while(low<=high){
            int mid=(low+high)/2;
            if(nums[mid]==target){
                si=mid;
                high=mid-1;
            }else if(nums[mid]>target){
                high=mid-1;
            }else{
                low=mid+1;
            }
        }
        return si;
    }
    public static int lastOccurance(int[] nums,int target){
        int ei=-1;
        int low=0;
        int high=nums.length-1;
        while(low<=high){
            int mid=(low+high)/2;
            if(nums[mid]==target){
                ei=mid;
                low=mid+1;
            }else if(nums[mid]>target){
                high=mid-1;
            }else{
                low=mid+1;
            }
        }
        return ei;
    }


    /*Given the array nums after the possible rotation and an integer target, return the index of target if it is in nums, or -1 if it is not in nums.
    You must write an algorithm with O(log n) runtime complexity.
    Example 1:
    Input: nums = [4,5,6,7,0,1,2], target = 0
    Output: 4*/
    public int searchRotatedArray(int[] nums, int target) {
        int low=0;
        int high=nums.length-1;

        while(low<=high){
            int mid=(low+high)/2;
            if(nums[mid]==target){
                return mid;
            }
            if(nums[low]<=nums[mid]){
                if(target>=nums[low] && target<=nums[mid]){
                    high=mid-1;
                }else{
                    low=mid+1;
                }
            }else{
                if(target>=nums[mid+1] && target<=nums[high]){
                    low=mid+1;
                }else{
                    high=mid-1;
                }
            }
        }
        return -1;

    }

    /*Given the array nums after the rotation and an integer target, return true if target is in nums, or false if it is not in nums.

    You must decrease the overall operation steps as much as possible.
            Example 1:

    Input: nums = [2,5,6,0,0,1,2], target = 0
    Output: true*/
    public boolean searchRotatedArray2(int[] nums, int target) {
        int low=0;
        int high=nums.length-1;

        while(low<=high){
            int mid=(low+high)/2;
            if(nums[mid]==target){
                return true;
            }

            if(nums[low]==nums[mid] ){
                low++;
                continue;
            }
            if( nums[high]==nums[mid]){
                high--;
                continue;
            }
            if(nums[low]<=nums[mid]){
                if(target>=nums[low] && target<=nums[mid]){
                    high=mid-1;
                }else{
                    low=mid+1;
                }
            }else{
                if(target>=nums[mid+1] && target<=nums[high]){
                    low=mid+1;
                }else{
                    high=mid-1;
                }
            }
        }
        return false;

    }





}
