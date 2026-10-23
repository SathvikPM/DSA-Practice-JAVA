package com.patterns;

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


}
