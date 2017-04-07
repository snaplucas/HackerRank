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

}
