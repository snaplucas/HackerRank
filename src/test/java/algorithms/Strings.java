package algorithms;

import org.junit.Test;

import java.math.BigInteger;
import java.util.*;
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
    public void findDigits() {
        int n = 1012;
        int count = 0;

        List<Integer> list = digits(n);
        for (int number : list) {
            if (number != 0) count = n % number == 0 ? count + 1 : count;
        }
        System.out.println(count);
    }

    private static List<Integer> digits(int i) {
        List<Integer> digits = new ArrayList<>();
        while (i > 0) {
            digits.add(i % 10);
            i /= 10;
        }
        return digits;
    }

    @Test
    public void extraLongFactorials() {
        System.out.println(factorial(25));

    }

    private BigInteger factorial(int n) {
        if (n == 0) return BigInteger.valueOf(1);
        else return BigInteger.valueOf(n).multiply(factorial(n - 1));
    }

    @Test
    public void saveThePrisoner() {
        int prisoners = 499999999;
        int sweets = 999999997;
        int first = 2;

        int sweetsToFirst = prisoners - first;
        sweets = sweets - sweetsToFirst;

        while (sweets > prisoners) {
            sweets = sweets - prisoners;
        }
        int last = sweets < 0 ? Math.abs(sweets) : sweets - 1;
        System.out.println(last == 0 ? prisoners : last);
    }

    @Test
    public void sequenceEquation() {
        int[] n = {2, 3, 1};
        List<Integer> list = Arrays.asList(2, 3, 1);

        for (int i = 1; i <= n.length; i++) {
            int value = list.indexOf(i);
            System.out.println(list.indexOf(value + 1) + 1);
        }
    }

    @Test
    public void jumpingOntheClouds() {
        int E = 100;
        int n = 8;
        int k = 2;
        int[] c = {0, 0, 1, 0, 0, 1, 1, 0};

        int start = 0;
        do {
            start += k;
            E = c[start == n ? 0 : start] == 0 ? E - 1 : E - 3;
        } while (start < n);

        System.out.println(E);
    }

}
