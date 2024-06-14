package Graphs;
import java.util.*;

public class DepthFirstSearch {
	
	public static class Edge {
		int src,dist;
		Edge(int src,int dist){
			this.src=src;
			this.dist=dist;
		}
	}
	
	public static void createGraph(ArrayList<Edge> graph[]) {
		for(int i=0;i<graph.length;i++) {
			graph[i]=new ArrayList<Edge>();
		}
		
		graph[0].add(new Edge(0,1));
		graph[0].add(new Edge(0,2));

		graph[1].add(new Edge(1,0));
		graph[1].add(new Edge(1,3));

		graph[2].add(new Edge(2,0));
		graph[2].add(new Edge(2,4));

		graph[3].add(new Edge(3,1));
		graph[3].add(new Edge(3,4));
		graph[3].add(new Edge(3,5));

		graph[4].add(new Edge(4,2));
		graph[4].add(new Edge(4,3));
		graph[4].add(new Edge(4,5));

		graph[5].add(new Edge(5,3));
		graph[5].add(new Edge(5,4));
		graph[5].add(new Edge(5,6));
        
		graph[6].add(new Edge(6,5));
		
	}
	
	public static void DFSconnected(ArrayList<Edge> graph[],int current,boolean visited[]) {
		System.out.print(current+" ");
		visited[current]=true;
		
		for(int i=0;i<graph[current].size();i++) {
			Edge e=graph[current].get(i);
			
			if(!visited[e.dist]) 
				DFSconnected(graph,e.dist,visited);
		}
	}
	
	public static void DFS(ArrayList<Edge> graph[],int current,boolean visited[]) {
		System.out.print(current+" ");
		visited[current]=true;
		
		for(int i=0;i<graph[current].size();i++) {
			Edge e=graph[current].get(i);
			
			if(!visited[e.dist]) 
				DFS(graph,e.dist,visited);
		}
	}
	@SuppressWarnings("unchecked")
	public static void main(String[] args) {
		
		int vertices=7;
		
		ArrayList<Edge> graph[]=new ArrayList[vertices];
		createGraph(graph);
		
		boolean visited[]=new boolean[vertices];
		
		// Applicable for only connected graphs.
		DFSconnected(graph,0,visited);
		
		// Applicable for both connected and disconnected graphs.
		for(int i=0;i<vertices;i++) {
			if(!visited[i]) 
				DFS(graph,i,visited);
		}
	}
}