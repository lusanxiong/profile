package com.job528.util;


public class ServletUtil {

    /**
     * @param args
     */

    public static String filter(String input) {
        if (!hasSpecialChars(input)) {
            return input;
        }
        StringBuffer filtered = new StringBuffer(input.length());
        char c;
        for (int i = 0; i < input.length(); i++) {
            c = input.charAt(i);
            switch (c) {
            case '<':
                filtered.append("&lt;");
                break;
            case '>':
                filtered.append("&gt;");
                break;
            case '"':
                filtered.append("&quot;");
                break;
            case '&':
                filtered.append("&amp;");
                break;
            default:
                filtered.append(c);
                /* falls through */
            }
        }
        return filtered.toString();
    }

    private static boolean hasSpecialChars(String input) {
        boolean flag = false;
        if ((null != input) && (0 < input.length())) {
            char c;
            for (int i = 0; i < input.length(); i++) {
                c = input.charAt(i);
                switch (c) {
                case '<':
                    flag = true;
                    break;
                case '>':
                    flag = true;
                    break;
                case '"':
                    flag = true;
                    break;
                case '&':
                    flag = true;
                    break;
                }
            }
        }
        return flag;
    }
}
