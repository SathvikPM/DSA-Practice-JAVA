package com.practice;

import java.util.ArrayList;

public class Hashing {

    public static void main(String[] args) {

        int[] arr = {1, 3, 4, 1, 2, 3, 4, 2, 1};
        countFrequency(arr);

        String lowercase = "banana";          // only lowercase
        countCharFrequencyLowercase(lowercase);

        String uppercase = "BANANA";          // only uppercase
        countCharFrequencyUppercase(uppercase);

        String mixed = "BanannaBanaabnnAnBBNN"; // mixed characters
        countCharFrequencyAll(mixed);

        String mixed2 = "BanannaBanaabnnAnBBNN"; // mixed characters
        countCharFrequencyAll2(mixed2);
    }

    // ---------------- INTEGER FREQUENCY ----------------
    private static void countFrequency(int[] arr) {

        int max = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (max < arr[i]) {
                max = arr[i];
            }
        }

        int[] hash = new int[max + 1];

        for (int i = 0; i < arr.length; i++) {
            hash[arr[i]]++;
        }

        for (int i = 0; i < hash.length; i++) {
            if (hash[i] > 0) {
                System.out.println(i + " " + hash[i]);
            }
        }
    }

    // ---------------- LOWERCASE CHAR FREQUENCY ----------------
    private static void countCharFrequencyLowercase(String s) {

        int[] hash = new int[26];

        for (int i = 0; i < s.length(); i++) {
            int index = s.charAt(i) - 'a';
            hash[index]++;
        }

        for (int i = 0; i < hash.length; i++) {
            if (hash[i] > 0) {
                System.out.println((char) ('a' + i) + " " + hash[i]);
            }
        }
    }

    // ---------------- UPPERCASE CHAR FREQUENCY ----------------
    private static void countCharFrequencyUppercase(String s) {

        int[] hash = new int[26];

        for (int i = 0; i < s.length(); i++) {
            int index = s.charAt(i) - 'A';
            hash[index]++;
        }

        for (int i = 0; i < hash.length; i++) {
            if (hash[i] > 0) {
                System.out.println((char) ('A' + i) + " " + hash[i]);
            }
        }
    }

    // ---------------- ALL CHAR (ASCII) FREQUENCY ----------------
    private static void countCharFrequencyAll(String s) {

        int[] hash = new int[256];

        for (int i = 0; i < s.length(); i++) {
            hash[s.charAt(i)]++;
        }

        for (int i = 0; i < hash.length; i++) {
            if (hash[i] > 0) {
                System.out.println((char) i + " " + hash[i]);
            }
        }
    }

    private static void countCharFrequencyAll2(String s) {

        int[] hash = new int[26];

       for(int i=0;i<s.length();i++){
           char c=s.charAt(i);
           if(c>='A'&&c<='Z'){
                 c=(char)(c+32);
                 int index=c-'a';
                 hash[index]++;
           }else{
               int index=c-'a';
               hash[index]++;
           }

       }
       for(int i=0;i<hash.length;i++){
           if(hash[i]>0){
               System.out.println((char)(i+'a')+" "+hash[i]);
           }
       }
    }
}
