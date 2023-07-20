package com.example.proj1;
import android.util.Log;

public class Decode {
    public static String decode(String s) {
        String invalid = "Invalid Code";
        String ini = "11110011";
        Boolean flag = true;
        for (int i = 0; i < 8; i++) {
            if (ini.charAt(i) != s.charAt(i)) {
                flag = false;
                break;
            }
        }

        String val = "";
        for (int i = 8; i < s.length(); i++) {
            char ch = s.charAt(i);
            val = val.concat(String.valueOf(ch));
        }
        int arr[][] = new int[11101][8];
        int ind1 = -1;
        int ind2 = 0;

        // run a loop of size of the encrypted code
        for (int i = 0; i < val.length(); i++) {
            if (i % 7 == 0) {
                ind1++;
                ind2 = 0;
                char ch = val.charAt(i);
                arr[ind1][ind2] = ch - '0';
                ind2++;
            } else {
                char ch = val.charAt(i);
                arr[ind1][ind2] = ch - '0';
                ind2++;
            }
        }
        int num[] = new int[11111];
        int nind = 0;
        int tem = 0;
        int cu = 0;
        for (int i = 0; i <= ind1; i++) {
            cu = 0;
            tem = 0;
            // converts binary to decimal and add them from each column and store in the array
            for (int j = 6; j >= 0; j--) {
                int tem1 = (int) Math.pow(2, cu);
                tem += (arr[i][j] * tem1);
                cu++;
            }
            num[nind++] = tem;
        }
        String ret = "";
        char ch;
        // convert the decimal ascii number to its char value and add them to form a decrypted
        for (int i = 0; i < nind; i++) {
            ch = (char) num[i];
            ret = ret.concat(String.valueOf(ch));
        }
        Log.e("dec", "text 11 - " + ret);

        // check if the encrypted code was generated for this algorithm
        if (val.length() % 7 == 0 && flag == true) {
            return ret;
        } else {
            return invalid;
        }
    }
}
