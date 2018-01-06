import org.junit.Test;

import java.util.*;
import java.util.stream.Collectors;

public class CodingTest {

    @Test
    public void foo() {
        int[] myArray = new int[]{90, 10, 70, 30, 20};

//        System.out.println(minimumNumberOfTrips(100, myArray));
        System.out.println(minimumNumberOfTrips_2(90, myArray));

    }

    private List<Integer> greatestFlightRangeDrones(Integer numberOfRequiredDrones, List<Drone> drones, List<Integer> inMaintenanceDrones) {
        return drones.stream()
                .filter(x -> inMaintenanceDrones.stream().noneMatch(y -> y != x.id))
                .sorted(Comparator.comparing(Drone::getFlightRange).reversed())
                .limit(numberOfRequiredDrones)
                .map(y -> y.id).collect(Collectors.toList());
    }

    private static class Drone {
        private int id;
        private int flightRange;

        public Drone(int id, int flightRange) {
            this.id = id;
            this.flightRange = flightRange;
        }

        public int getId() {
            return id;
        }

        public int getFlightRange() {
            return flightRange;
        }
    }

    private int minimumNumberOfTrips_2(int tripMaxWeight, int[] packagesWeight) {
        List<Integer> lista = new ArrayList<>();
        for (int i : packagesWeight) {
            lista.add(i);
        }
        int trips = 0;

        lista.sort(Collections.reverseOrder());

        for (int i = 0; i < lista.size(); i++) {
            int item = lista.get(i);
            Optional<Integer> pack = lista.stream().filter(x -> x + item <= tripMaxWeight).findFirst();
            pack.ifPresent(lista::remove);
            trips++;
        }

        return trips;
    }

}
