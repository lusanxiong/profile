package com.job528.util;

import java.util.Random;

/**
 */
public class PWDFunction {
    public PWDFunction() {
    }

    public static String encode(String sMess) {
        String s = "";
        String sTmp = "";
        Random Rd = new Random();
        Rd.setSeed(0);
        int i = sMess.length();
        if ("".equals(sMess.trim())) { 
             
            return null;
        } else if (250 < i) {
            
            return null;
        }
        while (0 < i) {
            sTmp = Integer.toString((i % 4 + 'a'));
            if (2 < sTmp.length()) {
                sTmp = sTmp.substring(0, 2);
            }
            s += sTmp;
            i -= 3;
        }
        s += (randomEnd() + sMess);
        String s1 = "";
        char cTmp;
        for (int k = 0; k < s.length(); k++) {
            cTmp = (char) (Rd.nextInt(25) + 'a');//  
             
            s1 += Character.toString(s.charAt(k)) + cTmp;  
        }
        s1 = fz(s1);
        return s1;
    }

    public static String decrypt(String sMess) { // 瑙ｅ瘑鏂规硶
        int iLen = sMess.length();
        String s = "";
        String[] s1 = { "io", "kjl", "jhi", "m,", "uy", "rw", "qw", "zx", "jk", "ki" };
        if ("".equals(sMess.trim())) {
           
            return null;
        } else if (250 < sMess.length()) {
            
            return null;
        } else {
            sMess = fz(sMess);
            for (int i = 0; i < sMess.length() - 1; i += 2) { // step is 2
                s += sMess.substring(i, i + 1);
            }
            int j = 0, k;
            for (k = 0; 10 > k; k++) {
                j = s.indexOf(s1[k]);
                if (0 <= j)
                    break;
            }
            iLen = s1[k].length();
            s = s.substring(j + iLen, s.length());
            return s;
        }

    }

    private static String randomEnd() {
        int i = 0;
        String[] sRandom = { "io", "kjl", "jhi", "m,", "uy", "rw", "qw", "zx", "jk", "ki" };
        Random Rd = new Random();
        i = Rd.nextInt(10); 
        return sRandom[i];
    }

    private static String fzChar(char cMess) {
        int i = 0;
        String s = "";
        if ('a' <= cMess && 'z' >= cMess) {
            i = cMess - 'a';
            i = 25 - i;
            s = Character.toString((char) (i + 'a'));// 
        } else if ('A' <= cMess && 'Z' >= cMess) {
            i = cMess - 'A';
            i = 25 - i;
            s = Character.toString((char) (i + 'A'));//  
        } else if ('0' <= cMess && '9' >= cMess) {
            i = cMess - '0';
            i = 9 - i;
            s = Character.toString((char) (i + '0'));// 
        } else {
            s = Character.toString(cMess);
        }
        return s;
    }

    private static String fz(String sMess) {
        String s = "";
        for (int i = 0; i < sMess.length(); i++) {
            s += fzChar(sMess.charAt(i));
        }
        return s;
    }
}
