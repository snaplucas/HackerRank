package algorithms;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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
}
