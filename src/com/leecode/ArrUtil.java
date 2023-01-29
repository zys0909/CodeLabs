package com.leecode;

public class ArrUtil {


    public static int[] codePoints(String str){
        if (str == null || str.length() == 0){
            return null;
        }
        int length = str.length();
        int [] result = new int[length];
        for (int i = 0; i < length; i++) {
            result[i] = str.codePointAt(i);
        }
        return result;
    }

    public static String codeString(String str){
        if (str == null || str.length() == 0){
            return null;
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            if (sb.length() != 0){
                sb.append(",");
            }
            sb.append(Integer.toString(str.codePointAt(i),16));
        }
        String s = sb.toString();
        System.out.println(s);
        return s;
    }

    public static String join(char[] chars){
        if (chars == null){
            return "";
        }
        StringBuilder sb = new StringBuilder();
        for (char c : chars) {
            if (sb.length() != 0){
                sb.append(",");
            }
            sb.append(c);
        }
        return sb.toString();
    }

    public static String join(int [] ints){
        if (ints == null){
            return "";
        }
        StringBuilder sb = new StringBuilder();
        for (int c : ints) {
            if (sb.length() != 0){
                sb.append(",");
            }
            sb.append(c);
        }
        return sb.toString();
    }

    public static String join(String [] chars){
        if (chars == null){
            return "";
        }
        StringBuilder sb = new StringBuilder();
        for (String c : chars) {
            if (sb.length() != 0){
                sb.append(",");
            }
            sb.append(c);
        }
        return sb.toString();
    }
}
