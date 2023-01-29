package com.leecode;


import java.util.*;

class Solution {
    private Queue<String> queue = new LinkedList<>();

    public static void main(String[] args) {
        System.out.println(strangePrinter("tbgtgb"));
        ;
    }

    public static int strangePrinter(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        Map<Character, Integer> map = new HashMap<>();
        int len = s.length();
        char[] src = s.toCharArray();
        char[] arr = new char[len];
        List<Character> tmp = new ArrayList<>();
        Character c;
        Character lastChar = null;
        int sum = 0;
        for (int i = 0; i < len; i++) {
            c = s.charAt(i);
            for (int j = i; j < len; j++) {
                if (tmp.contains(arr[j]) && s.charAt(j) == arr[j]) {
                    lastChar = arr[j];
                    continue;
                } else if (arr[j] != c && lastChar != c) {
                    sum++;
                }
                arr[j] = c;
                lastChar = c;
            }
            tmp.add(c);
            printArr(arr,sum);
            if (Arrays.equals(arr, src)) {
                return sum;
            }
        }
        return sum;
    }

    private static void printArr(char[] arr, int sum) {
        StringBuilder sb = new StringBuilder();
        for (Character ch : arr) {
            if (sb.length() != 0) {
                sb.append(",");
            }
            sb.append(ch);
        }
        sb.append(" ----- sum = ").append(sum);
        System.out.println(sb.toString());
    }
}