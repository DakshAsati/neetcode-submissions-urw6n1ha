class Solution {
    public int carFleet(int target, int[] position, int[] speed) {

        int n = position.length;
        if(n == 0) return 0;


        Car[] car = new Car[n];


        for(int i = 0; i < n; i++){
            car[i] = new Car(position[i], (double)(target - position[i]) / speed[i]);

        }

        Arrays.sort(car, (a,b) -> b.pos - a.pos);


        int fleets = 1;
        double prevTime = car[0].time;


        for(int i = 1; i< n; i++){
            if(car[i].time > prevTime){
                fleets++;
                prevTime = car[i].time;
            }
        }

        return fleets;
        
    }
    static class Car{
        int pos;
        double time;

        Car(int pos, double time){
            this.pos = pos;
            this.time = time;
        }
    }
}
