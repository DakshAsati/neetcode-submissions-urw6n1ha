

class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        int n = position.length;
        if (n == 0) return 0;

        Car[] cars = new Car[n];

        // Create Car objects with position and time to reach the target
        for (int i = 0; i < n; i++) {
            cars[i] = new Car(position[i], (double)(target - position[i]) / speed[i]);
        }

        // Sort cars by starting position in descending order
        Arrays.sort(cars, (a, b) -> b.pos - a.pos);

        int fleets = 1;
        double prevTime = cars[0].time;

        // Check for new fleets
        for (int i = 1; i < n; i++) {
            if (cars[i].time > prevTime) {
                fleets++;
                prevTime = cars[i].time;
            }
        }

        return fleets;
    }

    // Make Car a static inner class
    static class Car {
        int pos;
        double time;

        Car(int pos, double time) {
            this.pos = pos;
            this.time = time;
        }
    }
}
