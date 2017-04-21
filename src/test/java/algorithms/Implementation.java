package algorithms;

import org.junit.Test;

import java.math.BigInteger;
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

        int[] apple = {-2, 2, 1};
        int[] orange = {5, -6};

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

        int[] a = {3, 9, 6};
        int[] b = {36, 72};

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
        int a[] = {1, 3, 2, 6, 1, 2};
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
        int[] score = {10, 5, 20, 20, 4, 5, 2, 25, 1};

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
        Integer[] types = {1, 4, 4, 4, 5, 3};

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
        int k = 1;
        int b = 12;

        int[] items = {3, 10, 2, 9};

        int soma = Arrays.stream(items).sum();
        soma = soma - items[k];
        int diff = b - (soma / 2);
        System.out.println(diff == 0 ? "Bon Appetit" : diff);
    }

    @Test
    public void sockMerchant() {
        int c[] = {10, 20, 20, 10, 10, 30, 50, 10, 20};

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

        int[] keyboards = {3, 1};
        int[] pendrives = {5, 2, 8};

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

    @Test
    public void catsAndAMouse() {
        int q = 3;

        List<Integer> arrayX = Arrays.asList(1, 1, 2);
        List<Integer> arrayY = Arrays.asList(2, 3, 1);
        List<Integer> arrayZ = Arrays.asList(3, 2, 3);

        for (int a0 = 0; a0 < q; a0++) {
            int x = arrayX.get(a0);
            int y = arrayY.get(a0);
            int z = arrayZ.get(a0);

            String winner;
            int catA = Math.abs(z - x);
            int catB = Math.abs(z - y);
            if (catA == catB) {
                winner = "Mouse C";
            } else {
                winner = catA < catB ? "Cat A" : "Cat B";
            }
            System.out.println(winner);
        }
    }

    @Test
    public void pickingNumbers() {
        int n = 6;
        int[] a = {4, 6, 5, 3, 3, 1};
        int[] array = new int[100];

        for (int i = 0; i < n; i++) {
            array[a[i]]++;
        }
        int max = 0, temp;
        for (int i = 0; i < 99; i++) {
            temp = array[i] + array[i + 1];
            max = temp > max ? temp : max;
        }

        System.out.println(max);
    }

    @Test
    public void birthdayChocolate() {
        int[] s = {2, 5, 1, 3, 4, 4, 3, 5, 1, 1, 2, 1, 4, 1, 3, 3, 4, 2, 1};
        int d = 18;
        int m = 7;

        int result = getWays(s, d, m);
        System.out.println(result);
    }

    private int getWays(int[] squares, int d, int m) {
        int count = 0;
        for (int i = 0; i < squares.length; i++) {
            int sum = squares[i];
            for (int j = i + 1; j < i + m; j++) {
                if (j < squares.length) {
                    sum += squares[j];
                }
            }
            count = sum == d ? ++count : count;
        }
        return count;
    }

    @Test
    public void utopianTree() {
        int[] ciclos = {0, 1, 4};
        for (int c : ciclos) {
            int altura = 1;
            for (int i = 0; i < c; i++) {
                altura = i % 2 == 0 ? altura * 2 : altura + 1;
            }
            System.out.println(altura);
        }
    }

    @Test
    public void theHurdleRace() {
        int k = 4;
        int[] hurdles = {1, 6, 3, 5, 2};
        int count = 0;
        for (int h : hurdles) {
            while (h > k) {
                count++;
                k++;
            }
        }
        System.out.println(count);
    }

    @Test
    public void designerPdfViewer() {
        int[] heights = {6, 5, 7, 3, 6, 7, 3, 4, 4, 2, 3, 7, 1, 3, 7, 4, 6, 1, 2, 4, 3, 3, 1, 1, 3, 5};
        String word = "zbkkfhwplj";
        int max = 0;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            int temp = (int) c - 97;
            max = heights[temp] > max ? heights[temp] : max;
        }
        System.out.println(max * word.length());
    }

    @Test
    public void angryProfessor() {
        int k = 2;
        int a[] = {0, -1, 2, 1};

        System.out.println(Arrays.stream(a).filter(b -> b < 0).count() > k ? "YES" : "NO");
    }

    @Test
    public void beautifulDaysAtTheMovies() {
        int i = 20;
        int k = 23;
        int j = 6;

        int count = 0;

        for (int data = i; data <= k; data++) {
            int reverse = reverse(data);
            count = (data - reverse) % j == 0 ? count + 1 : count;
        }

        System.out.println(count);
    }

    private int reverse(int x) {
        int rev = 0;
        while (x != 0) {
            rev = rev * 10 + x % 10;
            x = x / 10;
        }

        return rev;
    }

    @Test
    public void viralAdvertising() {
        int n = 4;
        int count = 5;
        int total = 0;

        for (int i = 0; i < n; i++) {
            int like = count / 2;
            total += like;
            count = like * 3;
        }

        System.out.println(total);
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

    @Test
    public void circulaArrayRotation() {
        int n = 3;
        int[] a = {1, 2, 3};
        int k = 2;
        if (k != n) k = k % n;

        List<Integer> initialList = new ArrayList<>();
        for (int i : a) {
            initialList.add(i);
        }

        List<Integer> head = initialList.subList(initialList.size() - k, initialList.size());
        List<Integer> tail = initialList.subList(0, initialList.size() - k);
        List<Integer> list = new ArrayList<>();
        list.addAll(head);
        list.addAll(tail);
        System.out.println(list);
    }

    @Test
    public void equalizeTheArray() {
        int[] n = {3, 3, 2, 1, 3};

        Map<Integer, Integer> map = new HashMap<>();
        for (int i : n) {
            Integer count = map.get(i);
            map.put(i, count != null ? count + 1 : 1);
        }
        Entry<Integer, Integer> entry = Collections.max(map.entrySet(), Comparator.comparing(Entry::getValue));
        System.out.println(n.length - entry.getValue());
    }

    @Test
    public void repeatedString() {
        String s = "gfcaaaecbg";
        int n = 547602;
        int count = 0;

        for (char c : s.toCharArray()) {
            if (c != 'a') count++;
        }
        if (count == s.length()) {
            System.out.println(0);
        } else {
            long repeticoes = n / s.length();
            long restante = n - (s.length() * repeticoes);
            int resto = 0;
            for (int i = 0; i < restante; i++) {
                if (s.charAt(i) != 'a') {
                    resto++;
                }
            }
            System.out.println(n - (count * repeticoes) - resto);
        }
    }

    @Test
    public void repeatedStringV2() {
        String s = "gfcaaaecbg";
        int n = 547602;

        char ch[] = s.toCharArray();
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            if (ch[i] == 'a') {
                count++;
            }
        }
        int cnt = 0;
        for (int i = 0; i < n % s.length(); i++) {
            if (ch[i] == 'a') {
                cnt++;
            }
        }
        System.out.println(n / s.length() * count + cnt);
    }

    @Test
    public void sherlockAndSquares() {
        Scanner s = new Scanner(System.in);
        int t = s.nextInt();
        while (t-- > 0) {
            int a = s.nextInt();
            int b = s.nextInt();
            System.out.println((int) ((Math.floor(Math.sqrt(b)) - Math.ceil(Math.sqrt(a)) + 1)));
        }
    }

    @Test
    public void jumpingOnTheCloudsV1() {
        int n = 10;
        int[] c = {0, 0, 1, 0, 0, 0, 0, 1, 0, 0};
        int count = 0;

        for (int i = 0; i < n - 1; i++) {
            if (c[i] == 0) i++;
            count++;
        }
        System.out.println(count);
    }

}
