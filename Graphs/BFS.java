import java.util.List;
import java.util.Queue;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Map;
import java.util.HashMap;

public class BFS {

    private static class Graph {

        private final Map<String, List<String>> adjList = new HashMap<>();

        public void addVertex(String vertex) {
            adjList.put(vertex, new ArrayList<>());
        }

        public void addEdge(String v1, String v2) {
            List<String> successors = adjList.get(v1);
            successors.add(v2);
        }

        //is there a path between begin and end vertices?
        public boolean bfs(String begin, String end) {
            List<String> visited = new ArrayList<>();
            Queue<String> searchQueue = new LinkedList<>();

            //start search from the begin vertex
            searchQueue.add(begin);

            while(!searchQueue.isEmpty()) {
                String current = searchQueue.remove();
                if (!visited.contains(current)) {
                    if (current.equals(end)) {
                        return true;
                    } else  {
                        searchQueue.addAll(getSuccessors(current));
                        visited.add(current);
                    }
                }
            }
            return false;
        }

        private List<String> getSuccessors(String current) {
            return adjList.get(current);
        }

    }

    /*
        Simple graph:

        A -> B -> C
        B -> D

     */
    public static void main(String[] args) {
        Graph graph = new Graph();
        graph.addVertex("A");
        graph.addVertex("B");
        graph.addVertex("C");
        graph.addVertex("D");

        graph.addEdge("A", "B");
        graph.addEdge("B", "C");
        graph.addEdge("B", "D");

        if (graph.bfs("A", "D")) {
            System.out.println("The path between A and D exists");
        } else {
            System.out.println("Tha path berween A and D doesn't exist");
        }
    }
}