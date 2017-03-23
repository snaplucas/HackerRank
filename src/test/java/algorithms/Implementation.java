package algorithms;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class Implementation {

    @Test
    public void gradingStudents() {
        int[] grades = {80,96,18,73,78,60,60,15,45,15,10,5,46,87,33,60,14,71,65,2,5,97,0};
        List<Integer> gradeList = new ArrayList<>();
        for (int grade : grades) {
            if (grade < 38) {
                gradeList.add(grade);
            } else {
                gradeList.add(some(grade));
            }
        }
        for(int grade : gradeList){
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
}
