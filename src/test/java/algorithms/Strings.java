package algorithms;

import org.junit.Test;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

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

    @Test
    public void twoCharacters() {
        String s = "txnbvnzdvasknhlmcpkbxdvofimsvqbvkswlkrchohwuplfujvlwpxtlcix" + "pajjpaskrnjneelqdbxtiyeianqjqaikbukpicrwpnjvfpzolcredzmfaznnzd";

        Set<Character> characters = new HashSet<>();
        for (int i = 0; i < s.length(); i++)
            characters.add(s.charAt(i));

        List<Character> list = characters.stream().collect(Collectors.toList());

        int maxString = 0;

        for (int i = 0; i < list.size(); i++)
            for (int j = i + 1; j <= list.size() - 1; j++) {
                char c1 = list.get(i);
                char c2 = list.get(j);
                String aux = "";
                for (char c : s.toCharArray())
                    if (c == c1 || c == c2) aux += c;
                maxString = checkString(aux) ? aux.length() > maxString ? aux.length() : maxString : maxString;
            }

        System.out.println(maxString);
    }

    private boolean checkString(String s) {
        for (int i = 0; i < s.length() - 1; i++) {
            if (s.charAt(i) == s.charAt(i + 1)) {
                return false;
            }
        }
        return true;
    }

    @Test
    public void pangran() {
        String s = "We promptly judged antique ivory buckles for the next prize";
        s = s.toLowerCase();

        Set<Character> characters = new HashSet<>();
        for (char c : s.toCharArray()) {
            characters.add(c);
        }
        System.out.println(characters.size() == 27 ? "pangram" : "not pangram");
    }

    @Test
    public void funnyString() {
        String s = "ivvkx";
        String r = new StringBuilder(s).reverse().toString();

        int n = s.length();
        boolean funny = true;
        for (int i = 1; i < n - 1; i++) {
            int a = s.charAt(i) - s.charAt(i - 1);
            int b = r.charAt(i) - r.charAt(i - 1);
            if (Math.abs(a) != Math.abs(b)) {
                funny = false;
                break;
            }
        }
        System.out.println(funny ? "Funny" : "Not Funny");
    }

    @Test
    public void alternatingCharacters() {
        String s = "AAABBB";
        int count = 0;

        for (int i = 0; i < s.length() - 1; i++) {
            if (s.charAt(i) == s.charAt(i + 1)) count++;
        }
        System.out.println(count);
    }

    @Test
    public void caesarCipher() {
        String s = "lcfd";
        int k = 98;

        StringBuilder buf = new StringBuilder(s.length());

        for (char c : s.toCharArray()) {
            if (c >= 'a' && c <= 'z') {
                c = (char) ((((c - 'a') + k) % 26) + 'a');
            } else {
                c = (char) ((((c - 'A') + k) % 26) + 'A');
            }
            buf.append(c);
        }
        System.out.println(buf.toString());
    }

}
