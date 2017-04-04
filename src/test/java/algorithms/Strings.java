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
}
