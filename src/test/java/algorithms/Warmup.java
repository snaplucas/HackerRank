package algorithms;

import org.junit.Test;

import java.util.Arrays;
import java.util.SortedSet;
import java.util.TreeSet;


public class Warmup {

    @Test
    public void staircase() {
        int n = 5;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                System.out.print(" ");
            }
            for (int k = 0; k <= i; k++) {
                System.out.print("#");
            }
            System.out.println();
        }
    }

    @Test
    public void minMaxSum() {
        long a = 5;
        long b = 4;
        long c = 3;
        long d = 2;
        long e = 1;

        long[] numeros = {a, b, c, d, e};

        numeros = Arrays.stream(numeros).sorted().toArray();
        long[] maiores = Arrays.copyOfRange(numeros, 1, numeros.length);
        long[] menores = Arrays.copyOfRange(numeros, 0, numeros.length - 1);
        System.out.print(Arrays.stream(menores).sum() + " " + Arrays.stream(maiores).sum());
    }

    @Test
    public void minMaxSum2() {
        long a = 5;
        long b = 4;
        long c = 3;
        long d = 2;
        long e = 1;

        long sum = a + b + c + d + e;
        SortedSet<Long> s = new TreeSet<>();
        s.add(sum - a);
        s.add(sum - b);
        s.add(sum - c);
        s.add(sum - d);
        s.add(sum - e);
        System.out.println(s.first() + " " + s.last());
    }

    @Test
    public void timeConversion() {
        System.out.println(timeConversion("12:45:54PM"));
        System.out.println(timeConversion("12:00:00AM"));
        System.out.println(timeConversion("12:00:00PM"));
        System.out.println(timeConversion("12:40:22AM"));
        System.out.println(timeConversion("06:40:03AM"));
    }

    private String timeConversion(String input) {
        String[] horasMinutos = input.split(":");

        int horas = Integer.valueOf(horasMinutos[0]);
        boolean posMidDay = input.charAt(8) == 'P';
        int novasHoras = 0;

        if (posMidDay && horas == 12 || !posMidDay && horas < 12) {
            novasHoras = horas;
        }
        if (posMidDay && horas < 12) {
            novasHoras = horas + 12;
        }
        if (!posMidDay && horas == 12) {
            novasHoras = 0;
        }
        horasMinutos[0] = novasHoras < 10 ? horasMinutos[0] = "0" + novasHoras : String.valueOf(novasHoras);
        String output = "";
        for (String aux : horasMinutos) {
            output += aux + ":";
        }
        return posMidDay ? output.replace("PM:", "") : output.replace("AM:", "");
    }

}
