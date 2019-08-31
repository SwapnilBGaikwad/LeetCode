package com.github;

class DecodeString {
    private String decode(String s, int start, int end) {
        StringBuilder ret = new StringBuilder();
        int i = start;

        while (i <= end) {
            if (!Character.isDigit(s.charAt(i))) {
                ret.append(s.charAt(i));
                i++;
            } else {
                int rep = 0;
                int numStart = i;
                while (Character.isDigit(s.charAt(numStart))) {
                    rep = rep * 10 + Character.getNumericValue(s.charAt(numStart));
                    numStart++;
                }
                int startSub = numStart + 1;
                int count = 1;
                while (count > 0) {
                    if (s.charAt(startSub) == '[') count++;
                    if (s.charAt(startSub) == ']') count--;
                    startSub++;
                }

                String subS = decode(s, numStart + 1, startSub - 2);
                for (int x = 0; x < rep; x++) {
                    ret.append(subS);
                }
                i = startSub;
            }
        }
        return ret.toString();
    }


    String decodeString(String s) {
        return decode(s, 0, s.length() - 1);
    }
}