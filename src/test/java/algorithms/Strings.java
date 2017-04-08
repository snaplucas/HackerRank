package algorithms;

import org.junit.Test;

public class Strings {

    @Test
    public void camelCase() {
        String s = "saveChangesInTheEditor";
        char[] charArray = s.toCharArray();
        int count = 0;
        for (char c : charArray) {
            if (Character.isUpperCase(c)) {
                count++;
            }
        }
        System.out.println(count + 1);
    }

    @Test
    public void camelCaseV2() {
        String s = "saveChangesInTheEditor";
        System.out.println(s.split("[A-Z]").length);
    }

    @Test
    public void superReducedString() {
        String teste = "aaabccddd";

        boolean stop;
        do {
            String aux = "";
            stop = true;
            int limit = teste.length();
            for (int i = 0; i < limit - 1; i++) {
                if (teste.charAt(i) == teste.charAt(i + 1)) {
                    teste = aux + teste.substring(i + 2, limit);
                    stop = false;
                    break;
                } else {
                    aux += teste.charAt(i);
                }
            }
        } while (!stop);

        System.out.println(!teste.isEmpty() ? teste : "Empty String");
    }

    @Test
    public void superReducedStringV2() {
        String s = "aaabccddd";

        for (int i = 0; i < s.length() - 1; i++) {
            if (s.charAt(i) == s.charAt(i + 1)) {
                s = s.replace(s.substring(i, i + 2), "");
                i = -1;
            }
        }
        System.out.println(!s.isEmpty() ? s : "Empty String");
    }

    @Test
    public void marsExploration() {
        String s = "SOSSPSSQSSOR";

        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            if (i % 2 == 0) {
                count = s.charAt(i) == 'S' ? count : count + 1;
            } else {
                count = s.charAt(i) == 'O' ? count : count + 1;
            }
            if (i == 2) {
                s = s.substring(i + 1, s.length());
                i = -1;
            }
        }
        System.out.println(count);
    }

}
