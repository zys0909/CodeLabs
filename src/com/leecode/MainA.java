package com.leecode;



import java.util.LinkedHashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MainA {
    private static final Pattern Regex_Emoji = Pattern.compile(
            "(?:[\uD83C\uDF00-\uD83E\uDDFF]\u200D?[\u2600-\u26FF]?\uFE0F?" +
                    "|[\uD83E\uDD00-\uD83E\uDDFF]" +
                    "|[\uD83D\uDE00-\uD83D\uDE4F]" +
                    "|[\uD83D\uDE80-\uD83D\uDEFF]" +
                    "|[\u2600-\u26FF]\uFE0F?" +
                    "|[\u2700-\u27BF]\uFE0F?" +
                    "|\u24C2\uFE0F?" +
                    "|[\uD83C\uDDE6-\uD83C\uDDFF]{1,2}" +
                    "|[\uD83C\uDD70\uD83C\uDD71\uD83C\uDD7E\uD83C\uDD7F\uD83C\uDD8E\uD83C\uDD91-\uD83C\uDD9A]\uFE0F?" +
                    "|[\u0023\u002A\u0030-\u0039]\uFE0F?\u20E3" +
                    "|[\u2194-\u2199\u21A9-\u21AA]\uFE0F?" +
                    "|[\u2B05-\u2B07\u2B1B\u2B1C\u2B50\u2B55]\uFE0F?" +
                    "|[\u2934\u2935]\uFE0F?" +
                    "|[\u3030\u303D]\uFE0F?" +
                    "|[\u3297\u3299]\uFE0F?" +
                    "|[\uD83C\uDE01\uD83C\uDE02\uD83C\uDE1A\uD83C\uDE2F\uD83C\uDE32-\uD83C\uDE3A\uD83C\uDE50\uD83C\uDE51]\uFE0F?" +
                    "|[\u203C\u2049]\uFE0F?" +
                    "|[\u25AA\u25AB\u25B6\u25C0\u25FB-\u25FE]\uFE0F?" +
                    "|[\u00A9\u00AE]\uFE0F?" +
                    "|[\u2122\u2139]\uFE0F?" +
                    "|\uD83C\uDC04\uFE0F?" +
                    "|\uD83C\uDCCF\uFE0F?" +
                    "|[\u231A\u231B\u2328\u23CF\u23E9-\u23F3\u23F8-\u23FA]\uFE0F?)");

    public static String nameFormat(String str, int maxLen) {
        Matcher matcher = Regex_Emoji.matcher(str);
        int start, end;
        Map<Integer, Integer> map = new LinkedHashMap<>();
        boolean flag = matcher.find();
        while (flag) {
            start = matcher.start();
            end = matcher.end();
            System.out.println("start : " + start + ",end : " + end);
            map.put(start, end);
            flag = matcher.find(end);
        }
        int length = str.length();
        int count = 0, endIndex = 0, i = 0;
        while (i < length) {
            if (map.containsKey(i)) {
                //Emoji表情算2个位置
                count += 2;
                if (endIndex == 0 && count >= maxLen) {
                    //保证Emoji表情不被拆分
                    endIndex = i - 1;
                }
                i = map.get(i);
            } else {
                char c = str.charAt(i);
                if (c < 128) {
                    //ASCII 算一个位置
                    count += 1;
                } else {
                    //非ASCII 算两个位置
                    count += 2;
                }
                if (endIndex == 0 && count >= maxLen) {
                    endIndex = i;
                }
                i++;
            }

        }
        if (count <= maxLen) {
            return str;
        } else {
            return str.substring(0, endIndex + 1) + "...";
        }
    }

    public static void main(String[] args) throws Exception {
        String s8 = String.valueOf(nameChar2);
//        ArrUtil.codeString(new String(nameChar2));
        System.out.println(s8);
        ArrUtil.codeString(s8);
        System.out.println(nameFormat(s8, 16));
    }

    private static final String name1 = "一二三四五\\uuD83C\\uDFF4\\u200D\\u2620\\uFE0F";

    private static final char[] nameChar = {'\u2620', '\uFE0F', '一', '二', '三', '四', '五', '\uD83C', '\uDFF4', '\u200D', '\u2620', '\uFE0F'};
    private static final char[] nameChar1 = {/*'\u2620', '\uFE0F',*/ '随', '便', '看', '看', '-', '欧', '耶', '\uD83C', '\uDFF4', '\u200D', '\u2620', '\uFE0F'};
    private static final char[] nameChar2 = {'随', '便', '看', '看', '-', '欧', '耶','耶','耶' ,'\uD83D', '\uDE07'};

}