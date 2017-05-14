package algorithms;

import org.junit.Test;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class BitManipulation {

    @Test
    public void lonelyInteger() {
        int[] a = {0, 0, 1, 2, 1,};

        Map<Integer, Integer> map = new HashMap<>();
        for (int i : a) {
            Integer count = map.get(i);
            map.put(i, count != null ? count + 1 : 1);
        }
        System.out.println(map.entrySet().stream().filter(b -> b.getValue() == 1).map(Map.Entry::getKey).findFirst().orElse(null));
    }

    @Test
    public void lonelyIntegerV2() {
        int[] a = {0, 0, 1, 2, 1,};

        Set<Integer> numbers = new HashSet<>();
        for (int number : a) {
            if (numbers.contains(number)) {
                numbers.remove(number);
            } else {
                numbers.add(number);
            }
        }
        System.out.println(numbers.iterator().next());
    }
}
