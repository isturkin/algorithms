import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;

public class DFS {

	private static class Graph {

		private final Map<String, List<String>> adjList = new HashMap<>();

		public void addVertex(String v) {
			adjList.putIfAbsent(v, new ArrayList<>());
		}

		public void addEdge(String v1, String v2) {
			List<String> successors = adjList.get(v1);
			successors.add(v2);
		}

		public void dfsRecursive(String node) {
			List<String> visited = new ArrayList<>();
			dfsRecursive(visited, node);
		}

		private void dfsRecursive(List<String> visited, String node) {
			System.out.println("Vertex: " + node);
			visited.add(node);
			for (String adjNode : adjList.get(node)) {
				if (!visited.contains(adjNode)) {
					dfsRecursive(visited, adjNode);
				}
			}
		}
	}

	public static void main(String[] args) {
		Graph graph = new Graph();
		graph.addVertex("A");
		graph.addVertex("B");
		graph.addVertex("C");
		graph.addVertex("D");
		graph.addVertex("E");
		graph.addVertex("F");

		graph.addEdge("A", "F");
		graph.addEdge("A", "B");
		graph.addEdge("F", "C");
		graph.addEdge("F", "D");
		graph.addEdge("C", "E");

		graph.dfsRecursive("A");
	}
}
		
			
