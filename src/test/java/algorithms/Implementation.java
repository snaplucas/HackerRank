package algorithms;

import org.junit.Test;

import java.util.*;
import java.util.Map.Entry;

public class Implementation {

    @Test
    public void gradingStudents() {
        int[] grades = {80, 96, 18, 73, 78, 60, 60, 15, 45, 15, 10, 5, 46, 87, 33, 60, 14, 71, 65, 2, 5, 97, 0};
        List<Integer> gradeList = new ArrayList<>();
        for (int grade : grades) {
            if (grade < 38) {
                gradeList.add(grade);
            } else {
                gradeList.add(some(grade));
            }
        }
        for (int grade : gradeList) {
            System.out.println(grade);
        }
    }

    private int some(int numero) {
        int numeroAux = numero;
        if (numero % 5 == 0) {
            return numero;
        }
        int count = 0;
        do {
            count++;
        } while (++numero % 5 != 0 && count < 3);
        return count < 3 ? numero : numeroAux;
    }

    @Test
    public void appleAndOrange() {
        int s = 7;
        int t = 11;
        int a = 5;
        int b = 15;
        int m = 3;
        int n = 2;
        int[] apple = new int[m];
        List<Integer> appleList = Arrays.asList(-2, 2, 1);

        for (int i = 0; i < m; i++) {
            apple[i] = appleList.get(i);
        }

        int[] orange = new int[n];
        List<Integer> orangeList = Arrays.asList(5, -6);
        for (int j = 0; j < n; j++) {
            orange[j] = orangeList.get(j);
        }

        int appleCount = 0;
        int orangeCount = 0;

        for (int appleFall : apple) {
            int place = a + appleFall;
            if (place >= s && place <= t) {
                appleCount++;
            }
        }
        for (int orangeFall : orange) {
            int place = b + orangeFall;
            if (place >= s && place <= t) {
                orangeCount++;
            }
        }

        System.out.println(appleCount);
        System.out.println(orangeCount);
    }

    @Test
    public void kangoroo() {
        int k1 = 0;
        int v1 = 3;
        int k2 = 4;
        int v2 = 2;

        boolean sucess = false;

        if (k2 > k1 && v2 > v1) {
            System.out.println("NO");
        } else {
            for (int i = 0; i < 10000; i++) {
                k1 += v1;
                k2 += v2;
                if (k1 == k2) {
                    sucess = true;
                    break;
                }
            }
            System.out.println(sucess ? "YES" : "NO");
        }
    }

    @Test
    public void betweenTwoSets() {
        int n = 3;
        int m = 2;
        List<Integer> setA = Arrays.asList(3, 9, 6);

        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = setA.get(i);
        }
        int[] b = new int[m];
        List<Integer> setB = Arrays.asList(36, 72);
        for (int j = 0; j < m; j++) {
            b[j] = setB.get(j);
        }

        int max = Arrays.stream(b).max().getAsInt();
        Set<Integer> set = new HashSet<>();

        boolean flag;

        for (int i = 1; i < max + 1; i++) {
            flag = true;
            for (int anA : a) {
                if (!flag) continue;
                for (int aB : b) {
                    if (i % anA == 0 && aB % i == 0) {
                        set.add(i);
                    } else {
                        set.remove(i);
                        flag = false;
                        break;
                    }
                }
            }
        }
        System.out.println(set.size());
    }

    @Test
    public void divisibleSumPairs() {
        int n = 6;
        int k = 3;
        List<Integer> list = Arrays.asList(1, 3, 2, 6, 1, 2);
        int a[] = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = list.get(i);
        }

        int count = 0;

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if ((a[i] + a[j]) % k == 0) {
                    count++;
                }
            }
        }

        System.out.println(count);
    }

    @Test
    public void breakingTheRecords() {
        int n = 9;
        List<Integer> list = Arrays.asList(10, 5, 20, 20, 4, 5, 2, 25, 1);
        int[] score = new int[n];
        for (int score_i = 0; score_i < n; score_i++) {
            score[score_i] = list.get(score_i);
        }

        int highestCount = 0;
        int lowestCount = 0;

        int high = score[0];
        int low = score[0];

        for (int i = 0; i < n - 1; i++) {
            if (score[i + 1] > high) {
                high = score[i + 1];
                highestCount++;
            }
            if (score[i + 1] < low) {
                low = score[i + 1];
                lowestCount++;
            }
        }

        System.out.println(highestCount + " " + lowestCount);
    }

    @Test
    public void migratoryBirds() {
        int n = 6;
        List<Integer> list = Arrays.asList(1, 4, 4, 4, 5, 3);
        Integer[] types = new Integer[n];
        for (int types_i = 0; types_i < n; types_i++) {
            types[types_i] = list.get(types_i);
        }

        Map<Integer, Integer> map = new HashMap<>();
        for (int type : types) {
            Integer count = map.get(type);
            map.put(type, count != null ? ++count : 0);
        }

        Entry<Integer, Integer> entry = Collections.max(map.entrySet(), Comparator.comparing(Entry::getValue));
        System.out.println(entry.getKey());
    }

    @Test
    public void bonAppetit() {
        int n = 4;
        int k = 1;
        List<Integer> itemList = Arrays.asList(3, 10, 2, 9);
        int b = 12;

        int[] items = new int[n];
        for (int i = 0; i < n; i++) {
            items[i] = itemList.get(i);
        }

        int soma = Arrays.stream(items).sum();
        soma = soma - items[k];
        int diff = b - (soma / 2);
        System.out.println(diff == 0 ? "Bon Appetit" : diff);
    }

    @Test
    public void sockMerchant() {
        int n = 9;
        int c[] = new int[n];

        List<Integer> sockList = Arrays.asList(10, 20, 20, 10, 10, 30, 50, 10, 20);
        for (int i = 0; i < n; i++) {
            c[i] = sockList.get(i);
        }

        Map<Integer, Integer> map = new HashMap<>();
        int total = 0;
        for (int sock : c) {
            Integer count = map.get(sock);
            map.put(sock, count != null ? count + 1 : 1);
        }

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            total += entry.getValue() / 2;
        }
        System.out.println(total);
    }

    @Test
    public void drawingBook() {
        int n = 5;
        int p = 4;

        System.out.println(Math.min(p / 2, n / 2 - p / 2));
    }

    @Test
    public void countingValleys() {
        int n = 12;
        String s = "DDUUDDUDUUUD";

        int down = 0;
        int count = 0;
        boolean goingDown = false;

        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == 'D') {
                down++;
            } else {
                down--;
            }
            if (down > 0) {
                goingDown = true;
            }
            if (down == 0 && goingDown) {
                count++;
                goingDown = false;
            }
        }
        System.out.println(count);
    }

    @Test
    public void countingVallyesV2() {
        int n = 10;
        String s = "UDUUUDUDDD";

        int level = 0;
        int count = 0;

        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            if (level == -1 && c == 'U') {
                count++;
            }
            if (c == 'U') {
                level++;
            } else {
                level--;
            }
        }
        System.out.println(count);
    }

    @Test
    public void eletronicsShop() {
        int s = 10;
        int n = 2;
        int m = 3;

        List<Integer> keyboardList = Arrays.asList(3, 1);

        int[] keyboards = new int[n];
        for (int i = 0; i < n; i++) {
            keyboards[i] = keyboardList.get(i);
        }

        List<Integer> pendriveList = Arrays.asList(5, 2, 8);
        int[] pendrives = new int[m];
        for (int i = 0; i < m; i++) {
            pendrives[i] = pendriveList.get(i);
        }

        int spent = 0;
        for (int key : keyboards) {
            for (int pen : pendrives) {
                int total = key + pen;
                if (total > spent && total <= s) {
                    spent = total;
                }
            }
        }
        System.out.println(spent > 0 ? spent : "-1");
    }
}
