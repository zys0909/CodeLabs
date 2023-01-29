package com.leecode;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MainD {


    public static void main(String[] args) {
        String txt2 = "" +
                "";
        String txt3 = "晚安  大耗子";
        System.out.println(addFlower(txt2));

    }

    private static String addFlower(String str) {
        StringBuilder builder = new StringBuilder();
        for (char c : str.toCharArray()) {
            builder.append("\\u");
            if (c < 128) {
                builder.append("00").append(Integer.toHexString(c));
            } else {
                builder.append(Integer.toHexString(c)).append("\\ua670");
            }
        }
        return decode(builder.toString());
    }

    private static final Pattern pattern = Pattern.compile("(\\\\u(\\p{XDigit}{4}))");

    private static String decode(String unicodeStr) {
        Matcher matcher = pattern.matcher(unicodeStr);
        StringBuilder result = new StringBuilder();
        String s;
        while (matcher.find()) {
            s = matcher.group(2);
            System.out.println(s);
            // 16进制parse整形字符串
            try {
                result.append((char) Integer.parseInt(s, 16));
            } catch (NumberFormatException e) {
                //
            }
        }
        return result.toString();
    }
}
