class Solution {
       Map<String, PriorityQueue<String>> flights;
        LinkedList<String> path;
    public List<String> findItinerary(List<List<String>> tickets) {
        flights = new HashMap();
        path = new LinkedList();


        for(List<String> t : tickets){
            flights.putIfAbsent(t.get(0), new PriorityQueue<>());
            flights.get(t.get(0)).add(t.get(1));
        }
     
        dfs("JFK");
        return path;
    }
    private void dfs(String departure){
        PriorityQueue<String> arrivals = flights.get(departure);
        while(arrivals !=  null && !arrivals.isEmpty()){
            dfs(arrivals.poll());
        }
        path.addFirst(departure);
    }
}
