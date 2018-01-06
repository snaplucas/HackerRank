import org.junit.Test;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class CodingTest {

    @Test
    public void foo() {
        int[] myArray = new int[]{80, 10, 90, 20};

        System.out.println(minimumNumberOfTrips(100, myArray));
        System.out.println(minimumNumberOfTrips_2(100, myArray));
    }

    private List<Integer> greatestFlightRangeDrones(Integer numberOfRequiredDrones, List<Drone> drones, List<Integer> inMaintenanceDrones) {
        return drones.stream() //
                .filter(x -> inMaintenanceDrones.stream().noneMatch(y -> y != x.id)) //
                .sorted(Comparator.comparing(Drone::getFlightRange).reversed()) //
                .limit(numberOfRequiredDrones) //
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

    private int minimumNumberOfTrips(int tripMaxWeight, int[] packagesWeight) {
        Arrays.sort(packagesWeight);

        int trips = 0;
        int packages = 0;
        int weight = 0;

        for (int i = packagesWeight.length; i > 0; i--) {
            weight += packagesWeight[i - 1];
            packages++;
            if (weight > tripMaxWeight || packages > 1) {
                trips++;
                weight = 0;
                packages = 0;
            }
        }
        if (weight > 0) {
            trips++;
        }

        return trips;
    }

    private int minimumNumberOfTrips_2(int tripMaxWeight, int[] packagesWeight) {
        List<Integer> lista = Arrays.stream(packagesWeight).boxed().collect(Collectors.toList());
        int trips = 0;

        for (int i = 0; i < lista.size(); i++) {
            int item = lista.get(i);
            List<Integer> packs = lista.stream().filter(x -> x + item <= tripMaxWeight).collect(Collectors.toList());
            Optional<Integer> max = packs.stream().reduce(Integer::max);
            max.ifPresent(lista::remove);
            trips++;
        }
        return trips;
    }

}
