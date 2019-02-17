import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.Map.Entry;
import java.util.HashMap;
import java.util.Set;

public class Dijkstra {

    private static class Graph {

        // { vertex -> { vertex : weight} }
        private final Map<String, Map<String, Integer>> adjList = new HashMap<>();

        public void addVertex(String vertex) {
            adjList.put(vertex, new HashMap<>());
        }

        public void addEdge(String v1, String v2, int weight) {
            Map<String, Integer> successors = adjList.get(v1);
            successors.put(v2, weight);
        }

        public Map<String, Integer> dijkstra(String startVertex) {
            Map<String, Integer> distances = initDistances();
            distances.put(startVertex, 0);
            List<String> processed = new ArrayList<>();

            String smallestNode = findSmallestNode(distances, processed);
            while (smallestNode != null) {
                int distance = distances.get(smallestNode);
                for (String node : getSuccessors(smallestNode)) {
                    int newDistance = distance + distances.get(node);
                    if (newDistance < distance) {
                        distances.put(node, newDistance);
                    }
                }
                processed.add(smallestNode);
                smallestNode = findSmallestNode(distances, processed);
            }
            return distances;
        }

        private Map<String, Integer> initDistances() {
            Map<String, Integer> distances = new HashMap<>();
            for (Map.Entry<String, Integer> entry : distances.entrySet()) {
                entry.setValue(Integer.MAX_VALUE);
            }

            return distances;
        }

        private String findSmallestNode(Map<String, Integer> distances, List<String> processed) {
            int smallestWeight = Integer.MAX_VALUE;
            String smallestNode = null;

            for (String vertex : distances.keySet()) {
                int weight = distances.get(vertex);
                if (!processed.contains(vertex) && weight < smallestWeight) {
                    smallestWeight = weight;
                    smallestNode = vertex;
                }
            }

            return smallestNode;
        }

        public Set<String> getSuccessors(String current) {
            return adjList.get(current).keySet();
        }
    }

    /*
        Simple graph:

        A (2)-> B (8)-> C
        B (3)-> D (1)-> C

        The shortest way will be: A -> B -> D (6)
     */
    public static void main(String[] args) {
        Graph graph = new Graph();
        graph.addVertex("A");
        graph.addVertex("B");
        graph.addVertex("C");
        graph.addVertex("D");

        graph.addEdge("A", "B", 2);
        graph.addEdge("B", "C", 8);
        graph.addEdge("B", "D", 1);
        graph.addEdge("D", "C", 1);

        Map<String, Integer> distances = graph.dijkstra("A");
        System.out.println(distances);
    }

}