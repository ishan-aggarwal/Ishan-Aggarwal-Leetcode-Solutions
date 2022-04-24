class UndergroundSystem {
    
    // Passenger model class
    // with startStation, endStation
    // startTime, endTime
    class Passenger {
        String start;
        String end;
        int t1;
        int t2;

       public Passenger(String start, int t1){
            this.start = start;
            this.t1 = t1;
        }

        public void checkout(String endStation, int t2){
            this.end = endStation;
            this.t2 = t2;
        }
    }

    class Route {
        int tripCount;
        long totalTime;
        
        public Route() {
            this.tripCount = 0;
            this.totalTime = 0L;
        }
        
        double getAverage(){
            return (double) totalTime/tripCount;
        }

        void addTrip(int travelDuration){
            this.totalTime += travelDuration;
            this.tripCount += 1;
        }
    }



    Map<Integer,Passenger> map1 = null;
    Map<String, Route> map2 = null;

    public UndergroundSystem() {
        map1 = new HashMap<>();
        map2 = new HashMap<>();
    }

    public void checkIn(int id, String stationName, int t) {
        if(!map1.containsKey(id)){
            Passenger newTraveller = new Passenger(stationName,t);
            this.map1.put(id, newTraveller);
        }
    }
    
    public void checkOut(int id, String stationName, int t) {
         if(map1.containsKey(id)){
             Passenger temp = map1.get(id);
             temp.checkout(stationName,t);
             String route = temp.start + "_" + temp.end;

             Route routeDetails = map2.getOrDefault(route, new Route());
             routeDetails.addTrip(temp.t2 - temp.t1);
             map2.put(route, routeDetails);
             map1.remove(id);
         }
    }
    
    public double getAverageTime(String startStation, String endStation) {
        Route routeDetails = map2.get(startStation + "_" + endStation);
        return routeDetails.getAverage();
    }

}

/**
 * Your UndergroundSystem object will be instantiated and called as such:
 * UndergroundSystem obj = new UndergroundSystem();
 * obj.checkIn(id,stationName,t);
 * obj.checkOut(id,stationName,t);
 * double param_3 = obj.getAverageTime(startStation,endStation);
 */