package com.example.proj1;

public class Encode {
    public static String encode(String s) {
        String ini = "11110011";
        int cu = 0;
        int arr[] = new int[11110011];

        for (int i = 0; i < s.length(); i++) {
            // put the ascii value of each character in the array
            arr[i] = (int) s.charAt(i);
            cu++;
        }
        String res = "";

        // create another array
        int bin[] = new int[111];
        int idx = 0;

        // run a loop of the size of string
        for (int i1 = 0; i1 < cu; i1++) {
            int temp = arr[i1];// get the ascii value at position i1 from the first array
            for (int j = 0; j < cu; j++) bin[j] = 0;
            idx = 0;


            while (temp > 0) {
                // store the temp modulo of 2 in the 2nd array
                bin[idx++] = temp % 2;
                temp = temp / 2;
            }
            String dig = "";
            String temps;

            for (int j = 0; j < 7; j++) {


                temps = Integer.toString(bin[j]);
                dig = dig.concat(temps);
            }
            String revs = "";
           for (int j = dig.length() - 1; j >= 0; j--) {
                char ca = dig.charAt(j);
                revs = revs.concat(String.valueOf(ca));
            }
            res = res.concat(revs);
        }
        // add the extra string to the binary code
        res = ini.concat(res);
        return res;
    }
}



