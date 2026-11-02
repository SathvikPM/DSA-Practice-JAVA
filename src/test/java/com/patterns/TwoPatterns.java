package com.patterns;

import java.util.*;

public class TwoPatterns {

   /* 167. Two Sum II - Input Array Is Sorted
    Input: numbers = [2,7,11,15], target = 9
    Output: [1,2]
    Explanation: The sum of 2 and 7 is 9. Therefore, index1 = 1, index2 = 2. We return [1, 2]*/
    public int[] twoSum(int[] numbers, int target) {
        int low=0;
        int high=numbers.length-1;
        int[] arr=new int[2];
        while(low<high){
            int sum=numbers[low]+numbers[high];
            if(sum==target){
                arr[0]=low+1;
                arr[1]=high+1;
                return arr;
            }else if(sum>target){
                high--;
            }else{
                low++;
            }
        }
        arr[0]=-1;
        arr[1]=-1;
        return arr;
    }

    /*Input: nums = [1,1,2]  //leetcode 26
    Output: 2, nums = [1,2,_]
    Explanation: Your function should return k = 2, with the first two elements of nums being 1 and 2 respectively.
    It does not matter what you leave beyond the returned k (hence they are underscores).*/

    public int removeDuplicates(int[] nums) {
        int i=0;
        for(int j=0;j<nums.length-1;j++){
            if(nums[j]!=nums[j+1]){
                nums[i+1]=nums[j+1];
                i++;
            }
        }
        return i+1;
    }


    /*We will use the integers 0, 1, and 2 to represent the color red, white, and blue, respectively.
    You must solve this problem without using the library's sort function.
    Example 1:
    Input: nums = [2,0,2,1,1,0]
    Output: [0,0,1,1,2,2]
    Explanation:
    The array has two 0s, two 1s, and two 2s. Sorting them in-place places all 0s first, then all 1s, then all 2s.*/
    public void sortColors(int[] arr) {  //Dutch National flag Algorithm
        int mid=0;
        int high=arr.length-1;
        int low=0;

        while(mid<=high){

            if(arr[mid]==2){
                int temp=arr[mid];
                arr[mid]=arr[high];
                arr[high]=temp;
                high--;
            }else if(arr[mid]==0){
                int temp=arr[low];
                arr[low]=arr[mid];
                arr[mid]=temp;
                mid++;
                low++;
            }else{

                mid++;
            }

        }



    }

   /* Given an integer array nums, move all 0's to the end of it while maintaining the relative order of the non-zero elements.
    Note that you must do this in-place without making a copy of the array.
    Example 1:
    Input: nums = [0,1,0,3,12]
    Output: [1,3,12,0,0]*/
    public void moveZeroes(int[] arr) {
        int zeroIndex=-1;
        for(int i=0;i<arr.length;i++ ){
            if(arr[i]==0){
                zeroIndex=i;
                break;
            }
        }
        if(zeroIndex==-1){
            return;
        }
        int i=zeroIndex;
        for(int j=zeroIndex+1;j<arr.length;j++){
            if(arr[j]!=0){
                int temp=arr[j];
                arr[j]=arr[i];
                arr[i]=temp;
                i++;
            }
        }
    }


    /*Given an integer array nums, return all the triplets [nums[i], nums[j], nums[k]] such that i != j, i != k, and j != k, and nums[i] + nums[j] + nums[k] == 0.
    Notice that the solution set must not contain duplicate triplets.
    Example 1:
    Input: nums = [-1,0,1,2,-1,-4]
    Output: [[-1,-1,2],[-1,0,1]]
    Explanation:
    nums[0] + nums[1] + nums[2] = (-1) + 0 + 1 = 0.
    nums[1] + nums[2] + nums[4] = 0 + 1 + (-1) = 0.
    nums[0] + nums[3] + nums[4] = (-1) + 2 + (-1) = 0.
    The distinct triplets are [-1,0,1] and [-1,-1,2].
    Notice that the order of the output and the order of the triplets does not matter.*/
    public List<List<Integer>> threeSum(int[] nums) {
        HashSet<List<Integer>> set=new HashSet<>();
        LinkedList<List<Integer>> temp=new LinkedList<>();
        for(int i=0;i<nums.length;i++){
            HashSet<Integer> seen=new HashSet<Integer>();
            for(int j=i+1;j<nums.length;j++){
                int third=-(nums[i]+nums[j]);
                if(seen.contains(third)){
                    LinkedList<Integer> list=new LinkedList<>();
                    list.add(nums[i]);
                    list.add(nums[j]);
                    list.add(third);
                    Collections.sort(list);
                    set.add(list);
                }
                seen.add(nums[j]);
            }
        }

        for(List<Integer> list:set){
            temp.add(list);
        }
        return temp;

    }


    public List<List<Integer>> threeSumOptimal(int[] nums) { //this is two pointer approch

        Arrays.sort(nums);

        List<List<Integer>> ans=new ArrayList<List<Integer>>();

        for(int i=0;i<nums.length-2;i++){
            if(i>0 && nums[i]==nums[i-1]){
                continue;
            }

            int j=i+1;
            int k=nums.length-1;
            while(j<k){
                int sum=nums[i]+nums[j]+nums[k];
                if(sum<0){
                    j++;
                }else if(sum>0){
                    k--;
                }else{
                    List<Integer> list=new ArrayList<Integer>();
                    list.add(nums[i]);
                    list.add(nums[j]);
                    list.add(nums[k]);
                    ans.add(list);
                    while(j<k && nums[j]==nums[j+1]){
                        j++;
                    }
                    while(j<k && nums[k]==nums[k-1]){
                        k--;
                    }
                    j++;
                    k--;
                }
            }
        }
        return ans;

    }

/*

    Input: height = [1,8,6,2,5,4,8,3,7]
    Output: 49
    Explanation: The above vertical lines are represented by array [1,8,6,2,5,4,8,3,7]. In this case, the max area of water (blue section) the container can contain is 49.
*/
    public int maxArea(int[] height) {
        int maxArea=0;
        int low=0;
        int high=height.length-1;

        while(low<=high){
            int minHeight=height[low] < height[high] ? height[low] : height[high];
            int length=high-low;
            int area=minHeight*length;
            if(area>maxArea){
                maxArea=area;
            }
            if(height[low]<height[high]){
                low++;
            }else{
                high--;
            }

        }
        return maxArea;

    }





}
