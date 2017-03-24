package algorithms;

import org.junit.Test;

public class Challenges {

    @Test
    public void numberComplement() {

        try {
            int n = 100;

            double log2 = Math.log(n) / Math.log(2);
            int floor = (int) Math.floor(log2);
            int power = (int) Math.pow(2, floor + 1);
            int complement2 = (power - 1) - n;

            System.out.println(complement2);

        } catch (Exception io) {
            io.printStackTrace();
        }

    }

}

