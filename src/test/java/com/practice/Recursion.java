package com.practice;

public class Recursion {
    static  int count=1;

    public static void main(String[] args) {
//        printNumbers(5);
//        printNumbers2(5);
//        printNumbers3(5); //backtracking
        int arr[]={1,2,3,4,5};
        int n=5;
        reverse2(arr,n);
        for(int i=0;i<=arr.length-1;i++){
            System.out.print(arr[i]+" ");
        }
    }
    public static void printNumbers(int n){
        if(count>n){
            System.out.println("finished method 1");
            count=1;
           return;
        }
        System.out.println(count);
        count++;
        printNumbers(n);
    }
    public  static  void printNumbers2(int n){
        if(n==0){
            System.out.println("finished method 2");
            return;
        }
        System.out.println(count);
        count++;
        printNumbers2(n-1);
    }
    public static void printNumbers3(int n){
        if(n==0){
            System.out.println("Stated printing of backtracking method");
            return;
        }
        printNumbers3(n-1);
        System.out.println(n);//prints while returning
    }

    //Print from N to 1 by using recursion
    void printNos(int N) {
        // code here
        if(N==0){
            return;
        }
        System.out.print(N+" ");
        printNos(N-1);
    }

    /*
    Given an integer N, return the sum of first N natural numbers. Try to solve this using recursion.
    Input : N = 4
    Output : 10
    Explanation : first four natural numbers are 1, 2, 3, 4.
    Sum is 1 + 2 + 3 + 4 => 10.
     */
    int sum=0;
    public int NnumbersSum(int N) {
        //your code goes here
        if(N==0){
            return sum;
        }
        NnumbersSum(N-1);
        sum=sum+N;
        return sum;
    }

    /*
    Function to calculate factorial of a number.
    Given the non-negative integers n , compute the factorial of a given number.
    Note: Factorial of n is defined as n * (n -1) * (n - 2) * ... * 1, for n = 0, factorial is 1.
     */
    int fact=1;
    int factorial(int n) {
        // code here
        if(n==0){
            return fact;
        }
        factorial(n-1);
        fact=fact*n;
        return fact;
    }

    /*
    Input: n=5, arr = [1,2,3,4,5]
    Output: [5,4,3,2,1]
     Explanation: The reverse of the array [1,2,3,4,5] is [5,4,3,2,1]
     */


   //using 2 pointer
        public static void  reverse(int[] arr, int n) {

            reverseArray(arr,0,arr.length-1);
        }
        public static void reverseArray(int arr[],int left,int right){
            if(left>=right){
                return;
            }
            swap(arr,left,right);
            reverseArray(arr,left+1,right-1);

        }
        public static void swap(int[] arr,int left,int right){
            int temp=arr[left];
            arr[left]=arr[right];
            arr[right]=temp;

        }


        //by using single pointer
        public static void  reverse2(int[] arr, int n) {

            reverseArray2(arr,0,n);
        }

        public static  void reverseArray2(int[] arr,int i,int n){
            if(i>=n/2){
                return;
            }
            swap(arr,i,n-i-1);
            reverseArray2(arr,i+1,n);
        }



        /*
        A phrase is a palindrome if, after converting all uppercase letters into lowercase letters and removing all non-alphanumeric characters, it reads the same forward and backward. Alphanumeric characters include letters and numbers.

        Given a string s, return true if it is a palindrome, or false otherwise.

        Example 1:
        Input: s = "A man, a plan, a canal: Panama"
        Output: true
        Explanation: "amanaplanacanalpanama" is a palindrome.
        Example 2:

        Input: s = "race a car"
        Output: false
        Explanation: "raceacar" is not a palindrome.
         */

    public boolean isPalindrome(String s1) {
        String s="";
        for(int i=0;i<s1.length();i++){
            char c=s1.charAt(i);
            if(c>='A' && c<='Z'){
                s=s+(char)(c+32);
            }
            if ((c >= 'a' && c <= 'z') || (c >= '0' && c <= '9')) {
                s = s + c;
            }
        }

        if(isPalindrom(s,0,s.length()-1)){
            return true;
        }
        return false;

    }
    public static boolean isPalindrom(String s,int left,int right){
        if(left>=right){
            return true;
        }
        if(s.charAt(left)!=s.charAt(right)){
            return  false;
        }
        return isPalindrom(s,left+1,right-1);


    }


    /*
    Given a number n, return an array containing the first n Fibonacci numbers.

    Note: The first two numbers of the series are 0 and 1.(without recursion)
     */

    public static int[] fibonacciNumbers(int n) {
        // Your code here

        // int arr[]=new int[n];
        // int first=0;
        // int second=1;
        // int next=0;
        // for(int i=0;i<n;i++){
        //     arr[i]=first;
        //     next=first+second;
        //     first=second;
        //     second=next;
        // }
        // return arr;

        //by using recurrion

        int arr[]=new int[n];
        for(int i=0;i<=arr.length-1;i++){
            arr[i]=fibo(i);
        }
        return arr;

    }
    public static int fibo(int n){
        if(n<=1){
            return n;
        }
        int last=fibo(n-1);
        int secondLast=fibo(n-2);
        return last+secondLast;
    }










}
