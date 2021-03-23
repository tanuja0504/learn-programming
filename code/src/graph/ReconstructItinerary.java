package graph;

import java.util.*;

public class ReconstructItinerary {
    public static List<String> findItinerary(List<List<String>> tickets) {
        Map<String, PriorityQueue<String>> graph = new HashMap<>();

        for (int i = 0; i < tickets.size(); i++) {
            String source = tickets.get(i).get(0);
            String destination = tickets.get(i).get(1);
            if (!graph.containsKey(source)) {
                PriorityQueue<String> temp = new PriorityQueue<>();
                graph.put(source, temp);
            }
            graph.get(source).add(destination);
        }
        System.out.println(graph);
        LinkedList<String> temp = new LinkedList<>();
        dfsHelper("JFK", graph, temp);
        return temp;
    }

    public static void dfsHelper(String s, Map<String, PriorityQueue<String>> graph, LinkedList<String> temp) {
        PriorityQueue<String> t = graph.get(s);
        while (t != null && !t.isEmpty()) {
            dfsHelper(t.poll(), graph, temp);
        }
        temp.addFirst(s);
    }

    public static void main(String[] args) {
        List<List<String>> tickets = new ArrayList<>();
        List<String> one = new ArrayList<>();
        one.add("JFK");
        one.add("KUL");
        List<String> two = new ArrayList<>();
        two.add("JFK");
        two.add("NRT");
        List<String> three = new ArrayList<>();
        three.add("NRT");
        three.add("JFK");
        /*List<String> four=new ArrayList<>();
        four.add("ATL");
        four.add("JFK");
        List<String> five=new ArrayList<>();
        five.add("ATL");
        five.add("SFO");*/
        tickets.add(one);
        tickets.add(two);
        tickets.add(three);
        //tickets.add(four);
        //tickets.add(five);
        System.out.println(findItinerary(tickets));
    }
}
