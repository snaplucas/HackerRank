package algorithms;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class Questao8 {

    @Test
    public void execute() {
        int n = geradorNumero(102, 512);
        Assert.assertEquals(n, 150122);
    }

    private int geradorNumero(int a, int b) {
        String c = C(String.valueOf(a).toCharArray(), String.valueOf(b).toCharArray());
        int cc = Integer.valueOf(c);
        return cc > 1000000 ? -1 : cc;
    }

    private String C(char[] a, char[] b) {
        List<Character> aList = new ArrayList<>();
        for (char aa : a) {
            aList.add(aa);
        }
        List<Character> bList = new ArrayList<>();
        for (char bb : b) {
            bList.add(bb);
        }
        return CC(1, "", aList, bList);
    }

    private String CC(int iter, String s, List<Character> a, List<Character> b) {
        if (a.isEmpty()) return s + charsToString(b);
        else if (b.isEmpty()) return s + charsToString(a);
        else if (iter % 2 != 0) return CC(2, s + a.get(0), a.subList(1, a.size()), b);
        else return CC(1, s + b.get(0), a, b.subList(1, b.size()));
    }

    private String charsToString(List<Character> chars) {
        StringBuilder result = new StringBuilder(chars.size());
        for (Character c : chars) {
            result.append(c);
        }
        return result.toString();
    }
}
