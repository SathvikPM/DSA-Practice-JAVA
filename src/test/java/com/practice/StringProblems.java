package com.practice;

public class StringProblems {

    /*Write a function that reverses a string. The input string is given as an array of characters s.
    You must do this by modifying the input array in-place with O(1) extra memory.
    Example 1:
    Input: s = ["h","e","l","l","o"]
    Output: ["o","l","l","e","h"]*/
    public void reverseString(char[] s) {
        int low=0;
        int high=s.length-1;
        while(low<=high){
            char temp=s[low];
            s[low]=s[high];
            s[high]=temp;
            low++;
            high--;
        }
    }











    /*A phrase is a palindrome if, after converting all uppercase letters into lowercase letters and removing all non-alphanumeric characters, it reads the same forward and backward. Alphanumeric characters include letters and numbers.
    Given a string s, return true if it is a palindrome, or false otherwise.
            Example 1:
    Input: s = "A man, a plan, a canal: Panama"
    Output: true
    Explanation: "amanaplanacanalpanama" is a palindrome.*/

    public boolean isPalindrome(String s1) {  //brute force
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
        while(left<=right){
            int leftChar=s.charAt(left);
            int rightChar=s.charAt(right);
            if(leftChar!=rightChar){
                return false;
            }
            left++;
            right--;
        }
        return true;
    }



}
