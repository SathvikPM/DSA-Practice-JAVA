package com.practice;

public class sortingAlgorithms1 {

    public static void main(String[] args) {
        int[] arr={2,4,5,7,8};
        selectionSort(arr);
        bubbleSort(arr);

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

    /*
    Given an array, arr[]. Sort the array using bubble sort algorithm.
    Examples :

    Input: arr[] = [4, 1, 3, 9, 7]
    Output: [1, 3, 4, 7, 9]
    Explanation: After Sorting the array in ascending order of their values is [1, 3, 4, 7, 9].
     */
    static void bubbleSort(int[] arr) {
        // code here
            // code here
            for(int i=0;i<arr.length-1;i++){
                int swap=0;
                for(int j=0;j<arr.length-i-1;j++){
                    if(arr[j]>arr[j+1]){
                        swap++;
                        int temp=arr[j];
                        arr[j]=arr[j+1];
                        arr[j+1]=temp;
                    }
                }
                if(swap==0){
                    return;
                }
        }
    }
    static void insertionSort(int arr[]) {
        for(int i=0;i<arr.length;i++){
            int j=i;
            while(j>0 && arr[j-1]>arr[j]){
                int temp=arr[j];
                arr[j]=arr[j-1];
                arr[j-1]=temp;
                j--;
            }
        }
    }

    /*
    Given an array arr[], its starting position l and its ending position r. Sort the array using the merge sort algorithm.

    Examples:

    Input: arr[] = [4, 1, 3, 9, 7]
    Output: [1, 3, 4, 7, 9]
    Explanation: We get the sorted array after using merge sort
     */


        void mergeSort(int arr[], int l, int r) {
            // code here
            if(l>=r){
                return;
            }
            int mid=(l+r)/2;
            mergeSort(arr,l,mid);
            mergeSort(arr,mid+1,r);
            merge(arr,l,mid,r);

        }
        public static void merge(int[] arr, int l, int mid, int r){

            int size=r-l+1;
            int temp[]=new int[size];
            int i=l;
            int j=mid+1;
            int k=0;
            while(i<=mid && j<=r){
                if(arr[i]<=arr[j]){
                    temp[k]=arr[i];
                    k++;
                    i++;
                }else{
                    temp[k]=arr[j];
                    k++;
                    j++;
                }
            }

            while(i<=mid){
                temp[k]=arr[i];
                k++;
                i++;
            }
            while(j<=r){
                temp[k]=arr[j];
                k++;
                j++;
            }
            for(int x=0;x<temp.length;x++){
                arr[l+x]=temp[x];
            }


        }

}
