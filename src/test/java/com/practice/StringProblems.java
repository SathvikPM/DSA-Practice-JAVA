package com.practice;

import java.util.HashMap;
import java.util.Map;

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

    public boolean isPalindrome1(String s) { //optimal
        int left=0;
        int right=s.length()-1;
        while(left<=right){
            char leftChar=s.charAt(left);
            char rightChar=s.charAt(right);
            if(!isCharOrDegit(leftChar)){
                left++;
            }else if(!isCharOrDegit(rightChar)){
                right--;
            }else{
                if(Character.toLowerCase(leftChar)!=Character.toLowerCase(rightChar)){
                    return false;
                }
                left++;
                right--;
            }

        }
        return true;


    }

    public boolean isCharOrDegit(char c){
        if((c>='a' && c<='z')
                || (c>='A' && c<='Z')
                || (c>='0' && c<='9')
        ){
            return true;
        }
        return false;
    }



   /* Given a string s, return true if the s can be palindrome after deleting at most one character from it.
            Example 1:
    Input: s = "aba"
    Output: true*/

    public boolean validPalindrome(String s) {

        int left=0;
        int right=s.length()-1;

        while(left<=right){
            if(s.charAt(left)!=s.charAt(right)){
                return isPalindrome(s,left+1,right) || isPalindrome(s,left,right-1);
            }
            left++;
            right--;
        }
        return true;

    }

    public static boolean isPalindrome(String s,int left,int right){
        while(left<right){
            if(s.charAt(left)!=s.charAt(right)){
                return false;
            }
            left++;
            right--;
        }
        return true;
    }



    /*Given a string s, return the longest palindromic substring in s.
    Example 1:
    Input: s = "babad"
    Output: "bab"
    Explanation: "aba" is also a valid answer.
            Example 2:

    Input: s = "cbbd"
    Output: "bb"
*/
    public String longestPalindrome1(String s) {  //bruteforce
        for(int size=s.length();size>=1;size--){
            for(int i=0;i<=s.length()-size;i++){
                String s1="";
                for(int j=i;j<i+size;j++){
                    s1=s1+s.charAt(j);
                }
                if(isPalindrome(s1)){
                    return s1;
                }
            }
        }
        return "";
    }

    public boolean isPalindrome2(String s1){
        int left=0;
        int right=s1.length()-1;

        while(left<=right){
            if(s1.charAt(left)!=s1.charAt(right)){
                return false;
            }
            left++;
            right--;
        }
        return true;
    }




    public String longestPalindrome(String s) { //better
        int si=0;
        int ei=0;
        int max=0;
        for(int i=0;i<s.length();i++){
            Map<String, Integer> map1=expand(s,i,i+1);
            Map<String, Integer> map2=expand(s,i,i);
            if(map1.get("length")>max){
                max=map1.get("length");
                si=map1.get("si");
                ei=map1.get("ei");
            }
            if(map2.get("length")>max){
                max=map2.get("length");
                si=map2.get("si");
                ei=map2.get("ei");
            }
        }
        return s.substring(si,ei+1);
    }
    public static Map<String,Integer> expand(String s,int left,int right){
        HashMap<String,Integer> map=new HashMap<String,Integer>();
        while(left>=0 && right<s.length() && s.charAt(left)==s.charAt(right)){
            left--;
            right++;
        }
        int length = right - left - 1;
        int si=left+1;
        int ei=right-1;
        map.put("length",length);
        map.put("si",si);
        map.put("ei",ei);
        return map;
    }


}
