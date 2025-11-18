package com.practice;

public class sortingAlgorithms1 {

    public static void main(String[] args) {
        int[] arr={2,4,5,7,8};
        selectionSort(arr);

    }

    /*
    Input: arr[] = [4, 1, 3, 9, 7]
    Output: [1, 3, 4, 7, 9]
    Explanation: Maintain sorted (in bold) and unsorted subarrays.
    Select 1. Array becomes 1 4 3 9 7.
     Select 3. Array becomes 1 3 4 9 7. Select 4. Array becomes 1 3 4 9 7. Select 7. Array becomes 1 3 4 7 9.
     Select 9. Array becomes 1 3 4 7 9.
     */

    static  void selectionSort(int[] arr) {
        // code here
        // code here
        for(int i=0;i<arr.length-1;i++){
            int mini=i;
            for(int j=i+1;j<arr.length;j++){
                if(arr[j]<arr[mini]){
                    mini=j;
                }
            }
            int temp=arr[i];
            arr[i]=arr[mini];
            arr[mini]=temp;
        }

    }
}
