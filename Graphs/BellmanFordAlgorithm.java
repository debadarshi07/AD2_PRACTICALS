package Graphs;
import java.util.ArrayList;

public class BellmanFordAlgorithm {
	public static class Edge{
		int src;
		int dst;
		int weight;
		public Edge(int src,int dst,int weight) {
			this.src=src;
			this.dst=dst;
			this.weight=weight;
		}
	}
	public static void createGraph(ArrayList<Edge> graph[]) {
		for(int i=0;i<graph.length;i++) graph[i]=new ArrayList<Edge>();
		
		
		graph[0].add(new Edge(0,1,2));
		graph[0].add(new Edge(0,2,4));
		graph[1].add(new Edge(1,2,-1));
		graph[2].add(new Edge(2,4,-3));
		graph[3].add(new Edge(3,5,1));
		graph[4].add(new Edge(4,3,-2));
		graph[4].add(new Edge(4,5,5));
	}
	
	
//	public static class Pair implements Comparable<Pair>{
//		int node;
//		int dst;
//		public Pair(int node,int dst) {
//			this.node=node;
//			this.dst=dst;
//		}
//		@Override
//		public int compareTo(Pair p2) {
//			return this.dst-p2.dst;
//		}
//
//	}
	
	public static void bellmanFord(ArrayList<Edge> graph[],int vertices,int src) {
		int distance[]=new int[vertices];
		for(int i=0;i<vertices;i++) {
			if(i!=src) distance[i]=Integer.MAX_VALUE;
		}
		for(int k=0;k<vertices-1;k++) {
			for(int i=0;i<vertices;i++) {
				for(int j=0;j<graph[i].size();j++) {
					Edge e=graph[i].get(j);
					int u=e.src;
					int v=e.dst;
					
					if(distance[u]!=Integer.MAX_VALUE && distance[u]+e.weight<distance[v]) 
						distance[v]=distance[u]+e.weight;
				}
			}
		}
		for(int i=0;i<vertices;i++) {
			System.out.print(distance[i]+" ");
		}
		System.out.println();
	}
	@SuppressWarnings("unchecked")
	public static void main(String[] args) {

		int vertices=6;
		ArrayList<Edge> graph[]=new ArrayList[vertices];
		createGraph(graph);
		bellmanFord(graph,vertices,0);
	}
}